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

    public EventDataDispatch(RuntimeWiringTypeCollector collector)
    {
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
        String path = getRequestPath(environment);
        Object result = null;
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                case "/eventById":
                    result = eventDataHandler.processEventById(environment);
                    break;
                case "/eventTypeSummariesByTimePeriod":
                    result = eventTypeSummaryHandler.processRequest(environment);
                    break;
                case "/getEventTypes":
                    result = getEventTypeHandler.processRequest(environment);
                    break;
                case "/eventsByTimePeriodAndType":
                    result = eventDataHandler.processEventsByTimePeriodAndType(environment);
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
        Event event = new Event();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        String eventStatus = environment.getArgument("eventStatus");
        url += "/createEvent/" + id + "/" + eventStatus;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }
}