/*
 * ******************************************************************************
 *  WARNING: EXPORT CONTROLLED - EAR
 *  THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *  GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *  REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *  FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *  VIOLATION OF FEDERAL LAW.
 * ******************************************************************************
 *  Unlimited Government Rights
 *  WARNING: Do Not Use On A Privately Funded Program Without Permission.
 * ******************************************************************************
 *  CLASSIFICATION:   Unclassified
 *
 *  LIMITATIONS:      None
 * ******************************************************************************
 */
package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.base.DigitalBase;
import atlas.event.aggregation.config.DataServiceConfiguration;
import atlas.event.aggregation.data.paging.PageableBuilder;
import atlas.event.aggregation.data.paging.elements.Order;
import atlas.event.aggregation.data.paging.elements.PageInfo;
import atlas.event.aggregation.exception.EventAggregateException;
import atlas.event.aggregation.server.exception.EventAggregationQueryException;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * This is the base class for SatelliteQuery Datafetchers. It centralizes the handling of exceptions and adding standard information to the error extensions map.
 */
@Slf4j
public abstract class AbstractDataDispatch<T> extends DigitalBase implements DataFetcher<DataFetcherResult<T>>, IDigitalDataDispatch, IDataFetcher
{

    private static final String QUERY_SOURCE_TYPE = "queryParentType";
    private static final String QUERY_ARGUMENTS = "queryArguments";
    private static final String QUERY_TYPE = "queryType";
    private static final Object SUBOBJECT_QUERY_TYPE = "subObjectQuery";
    private static final Object ROOT_QUERY_TYPE = "rootQuery";
    protected static final String ID_ARG = "id";
    protected Integer maxPageSize = 1000;

    // derived classes can set a localContext object which will be passed to child query fetchers.
    // Our convention is that the localContext keys are class simple names, and the objects are class instances, or arrays of instances.
    // See https://www.graphql-java.com/blog/deep-dive-data-fetcher-results/
    protected Map<String, Object> localContext;

    protected RuntimeWiringTypeCollector collector;


    @PostConstruct
    public void initializeRuntimeTypeInformation()
    {
        if (this.collector != null)
        {
            this.collector.addTypeWiring(this.provideRuntimeTypeWiring());
        }
    }


    /*
        public Object processRequest(DataFetchingEnvironment environment) throws EventAggregateException
        {
            return processRequest(getRequestPath(environment), environment);
        }

        public Object processRequest(String path, DataFetchingEnvironment environment) throws EventAggregateException
        {
            Object result = null;
            IDigitalHandler handler = null;
            if (StringUtils.isNotBlank(path))
            {
                handler = getBusinessHandlerByPath(path);
            }
            else
            {
                throw new EventAggregateException("Path is required");
            }

            if (handler != null)
            {
                result = handler.processRequest(environment);
            }
            else
            {
                throw new EventAggregateException("No registered handler for path: " + path);
            }
            SsaEvent event = (SsaEvent) result;
            result = Lists.newArrayList(event);
            return result;
        }
    */

    @Override
    public DataFetcherResult<T> get(DataFetchingEnvironment environment) throws Exception
    {
        Object returnValue = null;
        LocalDateTime start = LocalDateTime.now();
        try
        {
            // if the environment local context is set, cast it to our local var.
            // This will also propagate it to child queries, unless derived classes override it.
            if (environment.getLocalContext() instanceof Map)
            {
                this.localContext = environment.getLocalContext();
            }

            // Do the main work of the fetcher. This could throw an unanticipated error, or a SatelliteQueryException (probably an info or warning message)
            returnValue = performFetch(environment);
            DataFetcherResult<T> result = (DataFetcherResult<T>) DataFetcherResult.newResult()
                .data(returnValue)
                .localContext(localContext)
                .build();
            // We don't want our localContext variable to persist to the next use of this fetcher, so clear it here
            // check this - we just undid whatever was done in performFetch()
            localContext = null;
            LocalDateTime end = LocalDateTime.now();
            System.out.println("Total Time: " + (end.getNano() - start.getNano()));
            return result;
        }
        catch (EventAggregationQueryException e)
        {
            return buildWarningResult(environment, returnValue, e);
        }
        catch (EventAggregateException eae)
        {
            return buildErrorResult(environment, returnValue, eae);
        }
        catch (RuntimeException e)
        {
            return buildErrorResult(environment, returnValue, e);
        }
    }

    protected DataFetcherResult<T> buildErrorResult(DataFetchingEnvironment environment, Object returnValue, RuntimeException e)
    {
        //log.error("An unexpected error occurred while fetching data.", e);
        GraphQLError error = GraphqlErrorBuilder.newError(environment)
            .errorType(ErrorType.DataFetchingException)
            .message(e.getMessage())
            .build();
        DataFetcherResult<T> errorResult = (DataFetcherResult<T>) DataFetcherResult.newResult()
            .data(returnValue)
            .localContext(localContext)
            .error(error)
            .build();
        localContext = null;
        return errorResult;
    }

    protected DataFetcherResult<T> buildWarningResult(DataFetchingEnvironment environment, Object returnValue, EventAggregationQueryException e)
    {
        //log.info("A warning occurred while fetching data.", e);
        Map<String, Object> ext = getExtensions(environment);
        if (e.getExtensions() != null)
        {
            ext.putAll(e.getExtensions());
        }

        GraphQLError error = GraphqlErrorBuilder.newError(environment)
            .errorType(ErrorType.DataFetchingException)
            .extensions(ext)
            .message(e.getMessage())
            .build();
        DataFetcherResult<T> warningResult = (DataFetcherResult<T>) DataFetcherResult.newResult()
            .data(returnValue)
            .localContext(localContext)
            .error(error)
            .build();
        localContext = null;
        return warningResult;
    }

    protected Map<String, Object> getExtensions(DataFetchingEnvironment environment)
    {
        Map<String, Object> ext = Maps.newHashMap();
        // Consider adding more query context (root field/source definition, return type, etc.
        if (environment.getArguments() != null && !environment.getArguments().isEmpty())
        {
            ext.put(QUERY_ARGUMENTS, environment.getArguments());
        }

        if (environment.getSource() != null)
        {
            ext.put(QUERY_TYPE, SUBOBJECT_QUERY_TYPE);
            ext.put(QUERY_SOURCE_TYPE, environment.getSource().getClass().getSimpleName());
        }
        else
        {
            ext.put(QUERY_TYPE, ROOT_QUERY_TYPE);
        }
        return ext;
    }

    // Derived classes must implement this to accomplish the main work of the class.
    // performFetch should populate returnValue field if successful.
    // The localContext map is also available for derived classes to use to pass prefetched objects to subsequent data fetchers
    // performFetch will be retried if an exception is thrown by REST clients
    //    @Retryable(value = {RestClientException.class, ResourceAccessException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000, maxDelay = 5000))
    protected abstract Object performFetch(DataFetchingEnvironment environment);

    protected abstract Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring();

    protected void addToLocalContext(String key, java.io.Serializable value)
    {
        if (localContext == null)
        {
            this.localContext = Maps.newHashMap();
        }
        this.localContext.put(key, value);
    }

    protected Pageable getPageRequestArgument(DataFetchingEnvironment environment, String argumentName)
    {
        return PageableBuilder.from(environment.getArgument(argumentName));
    }

    PageInfo getPageInfoArgument(DataFetchingEnvironment dataFetchingEnvironment)
    {
        PageInfo pageInfo = new PageInfo();
        Pageable pageable = null;
        //getPageRequestArgument(dataFetchingEnvironment, "pageInfo");
        if (pageable != null)
        {
            pageInfo.setPage(pageable.getPageNumber());
            pageInfo.setSize(pageable.getPageSize());
            // convert Spring domain Sort to crud sort
//            if (pageable.getSort() != Sort.unsorted())
//            {
            List<Order> orders = Lists.newArrayList();
//                for (Order order : pageable.getSort().toList())
//                {
            //orders.add(Order.builder().withProperty(order.getProperty()).withDirection(order.isAscending() ? Direction.ASC : Direction.DESC).build());
//                }
//                Sort crudSort = null;//Sort.builder().withOrders(orders).build();
//                pageInfo.setSort(crudSort);
//            }
        }
        else
        {
            // default pageInfo
            pageInfo.setPage(0);
            pageInfo.setSize(maxPageSize);
        }
        return pageInfo;
    }

    protected DataServiceConfiguration getClientServiceLookup()
    {
        DataServiceConfiguration dataServiceConfiguration = null;
        Object o = locateService("clientServiceLookup");
        if (o != null)
        {
            if (o instanceof  DataServiceConfiguration)
            {
                dataServiceConfiguration = (DataServiceConfiguration) o;
            }
        }
        return dataServiceConfiguration;
    }
}