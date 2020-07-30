/*
 * ****************************************************************************
 *    WARNING: EXPORT CONTROLLED - EAR
 *    THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *    GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *    REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *    FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *    VIOLATION OF FEDERAL LAW.
 *   ******************************************************************************
 *    Unlimited Government Rights
 *    WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *   ******************************************************************************
 *    CLASSIFICATION:   Unclassified
 *
 *    LIMITATIONS:      None
 *   ******************************************************************************
 *
 */

package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.server.exception.EventAggregationQueryException;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Maps;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;

/**
 * This is the base class for SatelliteQuery Datafetchers. It centralizes the handling of exceptions and adding standard information to the error extensions map.
 */
@Slf4j
public abstract class AbstractDataFetcher<T> implements DataFetcher<DataFetcherResult<T>>
{

    private static final String QUERY_SOURCE_TYPE = "queryParentType";
    private static final String QUERY_ARGUMENTS = "queryArguments";
    private static final String QUERY_TYPE = "queryType";
    private static final Object SUBOBJECT_QUERY_TYPE = "subObjectQuery";
    private static final Object ROOT_QUERY_TYPE = "rootQuery";


    // Derived classes should instantiate and populate this object.
    // This allows this class to return a default, or partially populated result.
    protected T returnValue = null;

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


    @Override
    public DataFetcherResult<T> get(DataFetchingEnvironment environment) throws Exception
    {
        try
        {
            // if the environment local context is set, cast it to our local var.
            // This will also propagate it to child queries, unless derived classes override it.
            if (environment.getLocalContext() instanceof Map)
            {
                this.localContext = environment.getLocalContext();
            }

            // Do the main work of the fetcher. This could throw an unanticipated error, or a SatelliteQueryException (probably an info or warning message)
            performFetch(environment);
            DataFetcherResult<T> result = (DataFetcherResult<T>) DataFetcherResult.newResult()
                .data(returnValue)
                .localContext(localContext)
                .build();
            // We don't want our localContext variable to persist to the next use of this fetcher, so clear it here
            // check this - we just undid whatever was done in performFetch()
            localContext = null;
            return result;
        }
        catch (EventAggregationQueryException e)
        {
            return buildWarningResult(environment, e);
        }
        catch (RuntimeException e)
        {
            return buildErrorResult(environment, e);
        }
    }

    protected DataFetcherResult<T> buildErrorResult(DataFetchingEnvironment environment, RuntimeException e)
    {
        log.error("An unexpected error occurred while fetching data.", e);
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

    protected DataFetcherResult<T> buildWarningResult(DataFetchingEnvironment environment, EventAggregationQueryException e)
    {
        log.info("An warning occurred while fetching data.", e);
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
    protected abstract void performFetch(DataFetchingEnvironment environment);

    protected abstract Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring();

    protected void addToLocalContext(String key, java.io.Serializable value)
    {
        if (localContext == null)
        {
            this.localContext = Maps.newHashMap();
        }
        this.localContext.put(key, value);
    }
}
