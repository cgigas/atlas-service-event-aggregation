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

import atlas.event.aggregation.data.access.accessor.exception.DataAccessorException;
import atlas.event.aggregation.data.datafetcher.util.GraphqlUtility;
import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.eventdata.EventData;
import atlas.event.aggregation.data.model.eventdata.EventTypeSummary;
import atlas.event.aggregation.parser.event.EventDataParser;
import atlas.event.aggregation.parser.event.EventParser;
import atlas.event.aggregation.parser.event.EventTypeSummaryParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import atlas.ssaevent.crud.graphql.*;
import com.google.common.collect.Lists;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.*;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("prod")
public class EventDataDispatch extends AbstractDataDispatch<List<Event>>
{
    private final GraphqlUtility graphqlUtility;
    @Autowired
    private EventParser eventParser;
    @Autowired
    private EventDataParser eventDataParser;
    @Autowired
    private EventTypeSummaryParser eventTypeSummaryParser;

    public EventDataDispatch(RuntimeWiringTypeCollector collector, GraphqlUtility graphqlUtility)
    {
        this.graphqlUtility = graphqlUtility;
        this.collector = collector;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceQuery")
                .dataFetcher("eventById", this)
                .dataFetcher("eventSummaries", this)
                .dataFetcher("eventTypeSummariesByTimePeriod", this)
                .dataFetcher("eventData", this)
                .dataFetcher("deleteEvent", this)
                .dataFetcher("eventsByTimePeriodAndType", this));
        builders.add(newTypeWiring("MPEServiceMutation")
                .dataFetcher("closeEvent", this)
                .dataFetcher("deleteEvent", this)
                .dataFetcher("updateEventType", this)
                .dataFetcher("updateEventStatus", this)
                .dataFetcher("updateEvent", this)
                .dataFetcher("createEvent", this));
        return builders;
    }

    @Override
    protected Object performFetch(DataFetchingEnvironment environment)
    {
        String path = getRequestPath(environment);
        Object result = null;
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                case "/eventById":
                    result = processEventByID(environment);
                    break;
                case "updateEvent":
                    result = processUpdateEvent(environment);
                    break;
                case "/deleteEvent":
                    result = processDeleteEvent(environment);
                    break;
                case "/eventTypeSummariesByTimePeriod":
                    result = processEventTypeSummariesByTimePeriod(environment);
                    break;
                case "/getEventTypes":
                    result = null;
                    break;
                case "/eventsByTimePeriodAndType":
                    result = null;
                    break;
                case "/eventData":
                    result = processEventData(environment);
                    break;
                case "/createEvent":
                    result = processCreateEvent(environment);
                    break;
                case "/updateEventStatus":
                    result = processUpdateEventStatus(environment);
                    break;
                case "/closeEvent":
                    result = processCloseEvent(environment);
                    break;
            }
        }

        return result;
    }

    private Event processUpdateEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();

        return event;
    }

    private EventData processEventData(DataFetchingEnvironment environment)
    {
        EventData eventData = new EventData();
        EventCrudQueryExecutor eventCrudQueryExecutor;

        if (environment != null)
        {
            eventCrudQueryExecutor = getClientServiceLookup().getEventCrudQueryExecutor();
            if (eventCrudQueryExecutor != null)
            {
                String eventDataUuid = environment.getArgument("eventDataUuid");
                try
                {
                    StringBuffer queryString = new StringBuffer();
                    atlas.ssaevent.crud.graphql.EventData clientEventData = eventCrudQueryExecutor.eventData(queryString.toString(), eventDataUuid);

                    eventData = (EventData) eventDataParser.fromGraphqlClient(clientEventData);
                }
                catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                {
                    throw new DataAccessorException(e);
                }
            }
        }

        return eventData;
    }

    Event processEventByID(DataFetchingEnvironment environment)
    {
        EventCrudQueryExecutor eventCrudQueryExecutor = null;
        Event event = new Event();
        if (environment != null)
        {
            eventCrudQueryExecutor = getClientServiceLookup().getEventCrudQueryExecutor();
            if (eventCrudQueryExecutor != null)
            {
                String id = environment.getArgument("eventUuid");
                try
                {
                    StringBuffer queryString = new StringBuffer();
                    queryString.append("{eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData {eventDataUuid classificationMarking eventUuid name uri type createDate createOrigin\n");
                    queryString.append(" updateDate\n");
                    queryString.append(" updateOrigin\n");
                    queryString.append(" version\n");
                    queryString.append("}\n");
                    queryString.append(" createDate\n");
                    queryString.append(" createOrigin\n");
                    queryString.append(" updateDate\n");
                    queryString.append(" updateOrigin\n");
                    queryString.append(" version\n");
                    queryString.append("}\n");
                    atlas.ssaevent.crud.graphql.Event crudEvent = eventCrudQueryExecutor.event(queryString.toString(), id);

                    event = (Event) eventParser.fromGraphqlClient(crudEvent);
                }
                catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                {
                    throw new DataAccessorException(e);
                }
            }
        }

        return event;
    }

    Event processCloseEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        EventCrudMutationExecutor eventCrudMutationExecutor;
        EventCrudQueryExecutor eventCrudQueryExecutor;
        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            eventCrudQueryExecutor = getClientServiceLookup().getEventCrudQueryExecutor();
            String eventUuid = environment.getArgument("eventUuid");
            OffsetDateTime endDate = environment.getArgument("endDate");
            try
            {
                StringBuffer queryString = new StringBuffer();
                queryString.append("{eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData {eventDataUuid classificationMarking eventUuid name uri type createDate createOrigin\n");
                queryString.append(" updateDate\n");
                queryString.append(" updateOrigin\n");
                queryString.append(" version\n");
                queryString.append("}\n");
                queryString.append(" createDate\n");
                queryString.append(" createOrigin\n");
                queryString.append(" updateDate\n");
                queryString.append(" updateOrigin\n");
                queryString.append(" version\n");
                queryString.append("}\n");
                atlas.ssaevent.crud.graphql.Event clientEvent = eventCrudQueryExecutor.event(queryString.toString(), eventUuid);
                if (clientEvent != null)
                {
                    clientEvent.setStatus(atlas.ssaevent.crud.graphql.EventStatus.CLOSED);
                    clientEvent.setEndDt(endDate);

                    atlas.ssaevent.crud.graphql.EventInput clientEventInput = (atlas.ssaevent.crud.graphql.EventInput) eventParser.toGraphqlClient(clientEvent, Boolean.TRUE);
                    clientEvent = eventCrudMutationExecutor.updateEvent(queryString.toString(), eventUuid, clientEventInput);
                    event = (Event) eventParser.fromGraphqlClient(clientEvent);
                }
            }
            catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
            {
                log.error(e.toString());
                throw new DataAccessorException(e);
            }
        }
        return event;
    }

    Event processDeleteEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        EventCrudMutationExecutor eventCrudMutationExecutor;
        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            String eventUuid = environment.getArgument("eventUuid");
            try
            {
                StringBuffer queryString = new StringBuffer();
                queryString.append("{eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData {eventDataUuid classificationMarking eventUuid name uri type createDate createOrigin\n");
                queryString.append(" updateDate\n");
                queryString.append(" updateOrigin\n");
                queryString.append(" version\n");
                queryString.append("}\n");
                queryString.append(" createDate\n");
                queryString.append(" createOrigin\n");
                queryString.append(" updateDate\n");
                queryString.append(" updateOrigin\n");
                queryString.append(" version\n");
                queryString.append("}\n");
                atlas.ssaevent.crud.graphql.Event clientEventDeleteResult = eventCrudMutationExecutor.deleteEvent(queryString.toString(), eventUuid);
                event = (Event) eventParser.fromGraphqlClient(clientEventDeleteResult);
            }
            catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
            {
                log.error(e.toString());
                throw new DataAccessorException(e);
            }
        }
        return event;
    }

    Event processUpdateEventStatus(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        EventCrudMutationExecutor eventCrudMutationExecutor;
        EventCrudQueryExecutor eventCrudQueryExecutor;
        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            eventCrudQueryExecutor = getClientServiceLookup().getEventCrudQueryExecutor();
            String eventUuid = environment.getArgument("eventUuid");
            atlas.ssaevent.crud.graphql.EventStatus eventStatus = environment.getArgument("eventStatus");
            try
            {
                StringBuffer queryString = new StringBuffer();
                queryString.append("{eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData {eventDataUuid classificationMarking eventUuid name uri type createDate createOrigin\n");
                queryString.append(" updateDate\n");
                queryString.append(" updateOrigin\n");
                queryString.append(" version\n");
                queryString.append("}\n");
                queryString.append(" createDate\n");
                queryString.append(" createOrigin\n");
                queryString.append(" updateDate\n");
                queryString.append(" updateOrigin\n");
                queryString.append(" version\n");
                queryString.append("}\n");
                atlas.ssaevent.crud.graphql.Event clientEvent = eventCrudQueryExecutor.event(queryString.toString(), eventUuid);
                if (clientEvent != null)
                {
                    clientEvent.setStatus(eventStatus);

                    atlas.ssaevent.crud.graphql.EventInput clientEventInput = (atlas.ssaevent.crud.graphql.EventInput) eventParser.toGraphqlClient(clientEvent, Boolean.TRUE);
                    clientEvent = eventCrudMutationExecutor.updateEvent(queryString.toString(), eventUuid, clientEventInput);
                    event = (Event) eventParser.fromGraphqlClient(clientEvent);
                }
            }
            catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
            {
                log.error(e.toString());
                throw new DataAccessorException(e);
            }
        }
        return event;
    }

    Event processCreateEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        EventCrudMutationExecutor eventCrudMutationExecutor = null;

        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            Map<String, Object> eventData = environment.getArgument("eventData");
            if (eventData != null)
            {
                atlas.ssaevent.crud.graphql.EventInput clientEvent = (atlas.ssaevent.crud.graphql.EventInput) eventParser.toGraphqlClient(eventData, Boolean.TRUE);
                atlas.ssaevent.crud.graphql.EventDataInput clientEventData = null;

                // check for Client Data
                if (eventData.containsKey("eventData"))
                {
                    clientEventData = (atlas.ssaevent.crud.graphql.EventDataInput) eventDataParser.toGraphqlClient(eventData.get("eventData"), Boolean.TRUE);
                    try
                    {
                        StringBuffer queryString = new StringBuffer();
                        queryString.append("{eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData {eventDataUuid classificationMarking eventUuid name uri type createDate createOrigin\n");
                        queryString.append(" updateDate\n");
                        queryString.append(" updateOrigin\n");
                        queryString.append(" version\n");
                        queryString.append("}\n");
                        queryString.append(" createDate\n");
                        queryString.append(" createOrigin\n");
                        queryString.append(" updateDate\n");
                        queryString.append(" updateOrigin\n");
                        queryString.append(" version\n");
                        queryString.append("}\n");
                        atlas.ssaevent.crud.graphql.Event clientEventCreateResult = eventCrudMutationExecutor.createEvent(queryString.toString(), clientEvent, clientEventData);
                        event = (Event) eventParser.fromGraphqlClient(clientEventCreateResult);
                    }
                    catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                    {
                        e.printStackTrace();
                        throw new DataAccessorException(e);
                    }
                }
            }
        }

        return event;
    }

    public EventTypeSummary processEventTypeSummariesByTimePeriod(DataFetchingEnvironment environment)
    {
        EventTypeSummary eventTypeSummary = new EventTypeSummary();
        EventCrudQueryExecutor eventCrudQueryExecutor = getClientServiceLookup().getEventCrudQueryExecutor();
        if (environment != null)
        {
            Map<String, Object> timePeriodMap = environment.getArgument("timePeriod");
            Map<String, Object> pageRequestMap = environment.getArgument("pageRequest");
            atlas.ssaevent.crud.graphql.PageInfo eventCrudPageInfo = (atlas.ssaevent.crud.graphql.PageInfo) eventParser.toPageInfo(pageRequestMap);

            PropertyPredicate startDateGE = PropertyPredicate.builder().withProperty("startDt").withOperator(PredicateOperator.GE).withValue("1970-10-15T17:36:17.788Z").build();
            AndPredicate and = AndPredicate.builder().withPropertyPredicates(Arrays.asList(startDateGE)).build();
            CriteriaQuery cq = CriteriaQuery.builder().withAndPredicate(and).build();
/*            CriteriaQuery cq = CriteriaQuery.builder().withAndPredicate(
                    AndPredicate.builder().withPropertyPredicates(
                            Arrays.asList(
                                    PropertyPredicate.builder().withProperty("startDt").withOperator(PredicateOperator.GE).withValue(
                                            "1970-10-15T17:36:17.788Z").build(),
                                    PropertyPredicate.builder().withProperty("startDt").withOperator(PredicateOperator.LE).withValue("2020-10-15T17:36:17.788Z").build())).build()).build();
*/
            String s = cq.toString();
            try
            {
                Object o = eventCrudQueryExecutor.eventPageByCriteria("",  cq, eventCrudPageInfo);
                System.out.println("SDFSDF");
            }
            catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
            {
                e.printStackTrace();
                throw new DataAccessorException(e);
            }

            System.getProperty("");
        }

        return eventTypeSummary;
    }

    public static void main(String[] args) throws Exception
    {
        EventCrudQueryExecutor eventCrudQueryExecutor = new EventCrudQueryExecutor("http://172.30.211.106:9210/ssaevent-crud/graphql");
        atlas.ssaevent.crud.graphql.PageInfo pageInfo = new PageInfo();
        Sort sort = new Sort();
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setProperty("startDt");
        order.setDirection(Direction.ASC);
        orderList.add(order);
        sort.setOrders(orderList);
       pageInfo.setSort(sort);
        pageInfo.setSize(1000);
        pageInfo.setPage(0);


/*        atlas.satellite.crud.graphql.PageInfo pageInfoSat = new atlas.satellite.crud.graphql.PageInfo();
        atlas.satellite.crud.graphql.Sort sortSat = new atlas.satellite.crud.graphql.Sort();
        List<atlas.satellite.crud.graphql.Order> orderListSat = new ArrayList<>();
        atlas.satellite.crud.graphql.Order orderSat = new atlas.satellite.crud.graphql.Order();
        orderSat.setProperty("satelliteUuid");
        orderSat.setDirection(atlas.satellite.crud.graphql.Direction.ASC);
        orderListSat.add(orderSat);
        sortSat.setOrders(orderListSat);
        pageInfoSat.setSort(sortSat);
        pageInfoSat.setSize(1000);
        pageInfoSat.setPage(0);
*/


/*        atlas.satellite.crud.graphql.PropertyPredicate startDate = atlas.satellite.crud.graphql.PropertyPredicate.builder().withProperty("catalogDate").withOperator(atlas.satellite.crud.graphql.PredicateOperator.GE).withValue("1970-10-15T17:36:17.788Z").build();
        atlas.satellite.crud.graphql.CriteriaQuery cqSat = atlas.satellite.crud.graphql.CriteriaQuery.builder().withPropertyPredicate(startDate).build();
        String resultSat = "{number totalElements totalPages content }";
        SatelliteCrudQueryExecutor satelliteCrudQueryExecutor = new SatelliteCrudQueryExecutor("http://172.30.211.106:9205/satellite-crud/graphql");*/



        PropertyPredicate startDateGE = PropertyPredicate.builder().withProperty("startDt").withOperator(PredicateOperator.GE).withValue("1970-10-15T17:36:17.788Z").build();
        AndPredicate and = AndPredicate.builder().withPropertyPredicates(Arrays.asList(startDateGE)).build();
        CriteriaQuery cq = CriteriaQuery.builder().withPropertyPredicate(startDateGE).build();
        System.out.println(cq.toString());
        String result = "{number totalElements totalPages content {eventUuid name startDt endDt }}";
        try
        {
//          SatellitePage satResult = satelliteCrudQueryExecutor.satellitePageByCriteria(resultSat, csqSat, pageInfoSat);
//          List<Satellite> datalist = satResult.getContent();
//            System.out.println("SDFSDF");
            EventPage eventPage = eventCrudQueryExecutor.eventPageByCriteria(result, cq, pageInfo);
            List<atlas.ssaevent.crud.graphql.Event> eventList = eventPage.getContent();
            if (eventList != null)
            {
                for (atlas.ssaevent.crud.graphql.Event item: eventList)
                {
                    System.out.println(item.getEventUuid());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}