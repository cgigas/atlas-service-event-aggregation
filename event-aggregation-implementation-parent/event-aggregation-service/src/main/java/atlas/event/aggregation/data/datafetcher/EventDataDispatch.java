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
import atlas.event.aggregation.handlers.EventDataHandler;
import atlas.event.aggregation.handlers.EventTypeSummaryHandler;
import atlas.event.aggregation.handlers.GetEventTypeHandler;
import atlas.event.aggregation.parser.EventParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import atlas.notes.crud.graphql.NotesCrudMutationExecutor;
import atlas.sensor.crud.graphql.SensorCrudMutationExecutor;
import atlas.ssaevent.crud.graphql.EventCrudMutationExecutor;
import atlas.ssaevent.crud.graphql.EventCrudQueryExecutor;
import com.google.common.collect.Lists;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.client.request.QueryField;
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
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("dev")
public class EventDataDispatch extends AbstractDataDispatch<List<Event>>
{
    private final GraphqlUtility graphqlUtility;
    @Autowired
    private EventParser eventParser;
    @Autowired
    EventTypeSummaryHandler eventTypeSummaryHandler;
    @Autowired
    EventDataHandler eventDataHandler;
    @Autowired
    GetEventTypeHandler getEventTypeHandler;
    private EventCrudMutationExecutor eventCrudMutationExecutor;
    private EventCrudQueryExecutor eventCrudQueryExecutor;

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
        // extract query
        //String partialQueryString = graphqlUtility.graphqlPartialQueryStringFromField(environment.getMergedField().getSingleField());

        String path = getRequestPath(environment);
        Object result = null;
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                case "/eventById":
                    result = processEventByID(environment);
                    break;
                case "/eventTypeSummariesByTimePeriod":
                    result = null;
                    break;
                case "/getEventTypes":
                    result = null;
                    break;
                case "/eventsByTimePeriodAndType":
                    result = null;
                    break;
                case "/createEvent":
                    result = processCreateEvent(environment);
                    break;
                case "/updateEventStatus":
                    result = processUpdateEventStatus(environment);
                    break;
                case "/deleteEvent":
                    result = processDeleteEvent(environment);
                    break;
                case "/closeEvent":
                    result = processCloseEvent(environment);
                    break;
            }
        }

        return result;
    }

    private Event processEventByID(DataFetchingEnvironment environment)
    {
        EventCrudQueryExecutor eventCrudQueryExecutor = null;
        Event event = new Event();
        if (environment != null)
        {
            eventCrudQueryExecutor = getClientServiceLookup().getEventCrudQueryExecutor();
            if (eventCrudQueryExecutor != null)
            {
                String id = environment.getArgument("id");
                try
                {
                    StringBuffer queryString = new StringBuffer();
                    queryString.append("{eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData {eventDataUuid classificationMarking eventUuid name uri type supplementalData createDate createOrigin\n");
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
                }
                catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                {
                    throw new DataAccessorException(e);
                }
            }
        }

        return event;
    }

    private Event processCloseEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        NotesCrudMutationExecutor notes = getClientServiceLookup().getNotesCrudMutationExecutor();
        EventCrudQueryExecutor eventClientQuery = getClientServiceLookup().getEventCrudQueryExecutor();
        EventCrudMutationExecutor eventClientMutation = getClientServiceLookup().getEventCrudMutationExecutor();
        SensorCrudMutationExecutor sensorClientMutation = getClientServiceLookup().getSensorCrudMutationExecutor();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        OffsetDateTime endDate = environment.getArgument("endDate");
        url += "/closeSdaEvent/" + id + "/" + endDate;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    private Event processDeleteEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        url += "/deleteSdaEvent/" + id;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    private Event processUpdateEventStatus(DataFetchingEnvironment environment)
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

    private Event processCreateEvent(DataFetchingEnvironment environment)
    {
        EventCrudMutationExecutor eventCrudMutationExecutor = null;

        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
        }
        Map<String, Object> eventData = environment.getArgument("eventData");
        if (eventData != null)
        {
/*            Map<String, Object> eventDataMap = (Map)eventData.get("eventData");
            String eventUuid = getItemAsString("eventUuid", eventDataMap);
            String classMarking = getItemAsString("classificationMarking", eventDataMap);
            String preEventUuid = getItemAsString("predecessorEventUuid", eventDataMap);
            String eventType = getItemAsString("eventType", eventDataMap);
            String eventName = getItemAsString("eventName", eventDataMap);
            String eventStatus = getItemAsString("eventStatus", eventDataMap);
            String eventState = getItemAsString("eventState", eventDataMap);
            OffsetDateTime startDate = getItemAsOffSetDate("startDate", eventDataMap);
            OffsetDateTime endDate = getItemAsOffSetDate("endDate", eventDataMap);
            String description = getItemAsString("eventDesc", eventDataMap);
            String internalNotes = getItemAsString("internalNotes", eventDataMap);
            String eventPostingId = getItemAsString("eventPostingId", eventDataMap);
            OffsetDateTime createDate = getItemAsOffSetDate("createDate", eventDataMap);
            String createOrgin = getItemAsString("createOrgin", eventDataMap);
            OffsetDateTime updateDate = getItemAsOffSetDate("updateDate", eventDataMap);
            String updateOrgin = getItemAsString("updateOrgin", eventDataMap);
            Long version = getItemAsLong("version", eventDataMap);

 */
        }

        Event event = new Event();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        String eventStatus = environment.getArgument("eventStatus");
        url += "/createEvent/" + id + "/" + eventStatus;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public static void main(String args[])
    {
        EventCrudQueryExecutor eventCrudQueryExecutor = null;
        eventCrudQueryExecutor = new EventCrudQueryExecutor("http://172.30.211.106:9210/ssaevent-crud/graphql");

        System.out.println("Done");
    }
}