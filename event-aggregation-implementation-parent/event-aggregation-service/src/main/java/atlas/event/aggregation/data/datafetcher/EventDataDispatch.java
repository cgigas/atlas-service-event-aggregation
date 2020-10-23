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

import atlas.event.aggregation.constants.EventAggregationConstants;
import atlas.event.aggregation.data.access.accessor.exception.DataAccessorException;
import atlas.event.aggregation.data.datafetcher.util.GraphqlUtility;
import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.eventdata.EventData;
import atlas.event.aggregation.data.model.eventdata.EventTypeSummary;
import atlas.event.aggregation.parser.event.EventDataParser;
import atlas.event.aggregation.parser.event.EventParser;
import atlas.event.aggregation.parser.event.EventTypeSummaryParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import atlas.ssaevent.crud.graphql.EventCrudMutationExecutor;
import atlas.ssaevent.crud.graphql.EventCrudQueryExecutor;
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
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
                    result = processCreateEvent(environment);s
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
        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            String eventUuid = environment.getArgument("id");
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
                atlas.ssaevent.crud.graphql.Event clientEventCloseResult = eventCrudMutationExecutor.deleteEvent(queryString.toString(), eventUuid);
                event = (Event) eventParser.fromGraphqlClient(clientEventCloseResult);
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
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        String eventStatus = environment.getArgument("eventStatus");
        url += "/updateEventStatus/" + id + "/" + eventStatus;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

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
        if (environment != null)
        {
            Map<String, Object> timePeriodMap = environment.getArgument("timePeriod");
            Map<String, Object> pageRequestMap = environment.getArgument("pageRequest");
            atlas.ssaevent.crud.graphql.PageInfo eventCrudPageInfo = (atlas.ssaevent.crud.graphql.PageInfo) eventParser.toPageInfo(pageRequestMap);
            System.getProperty("");
        }

        return eventTypeSummary;
    }
}