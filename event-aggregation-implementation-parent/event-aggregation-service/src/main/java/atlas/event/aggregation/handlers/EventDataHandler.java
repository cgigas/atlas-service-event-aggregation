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
package atlas.event.aggregation.handlers;

import atlas.event.aggregation.data.model.event.*;
import atlas.event.aggregation.data.model.ssaeventsat.EventSatellite;
import atlas.event.aggregation.exception.EventAggregateException;
import atlas.event.aggregation.parser.*;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("eventDataHandler")
public class EventDataHandler extends MasterHandler
{
    @Autowired
    private EventParser eventParser;
    @Autowired
    private EventDetailParser eventDetailParser;
    @Autowired
    private LaunchParser launchParser;
    @Autowired
    ObservationSatMedleyParser observationSatMedleyParser;
    @Autowired
    private EventSatelliteParser eventSatelliteParser;

    public Event processUpdateEventStatus(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String id = environment.getArgument("id");
        String eventStatus = environment.getArgument("eventStatus");
        url += "/updateEventStatus/" + id + "/" + eventStatus;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public Event processEventById(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String id = environment.getArgument("id");
        url += "/eventById/" + id;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;

    }

    public Event processDeleteSdaEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String id = environment.getArgument("id");
        url += "/deleteSdaEvent/" + id;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public EventSatellite processPromoteEventSatellite(DataFetchingEnvironment environment)
    {
        EventSatellite eventSat = new EventSatellite();
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/promoteEventSatellite/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            eventSat = (EventSatellite) eventSatelliteParser.fromJsonString(resultRequestedData);
        }

        return eventSat;

    }

    public Event processReleaseSatelliteFromEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/releaseSatelliteFromEvent/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public EventSatellite processAddSatelliteToEvent(DataFetchingEnvironment environment)
    {
        EventSatellite eventSat = new EventSatellite();
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/addSatelliteToEvent/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            eventSat = (EventSatellite) eventSatelliteParser.fromJsonString(resultRequestedData);
        }

        return eventSat;
    }

    public Event processCloseSdaEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();

        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        String id = environment.getArgument("id");
        OffsetDateTime endDate = environment.getArgument("endDate");
        url += "/closeSdaEvent/" + id + "/" + endDate;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public List<Event> processEventsByTimePeriodAndType(DataFetchingEnvironment environment)
    {
        List<Event> datalist = null;
        Event eventResult = null;
        //String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String url = "http://localhost:8080/event-aggregation";
        url += "/eventsByTimePeriodAndType/abc/123/456";

        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            datalist = new ArrayList<>();
            try
            {
                JSONObject json = (JSONObject) new JSONParser().parse(resultRequestedData);
                JSONArray ja = (JSONArray) json.get("eventsByTimePeriodAndType");
                Iterator it = ja.iterator();
                while (it.hasNext())
                {
                    Event event = new Event();
                    Map<String, String> map = (Map) it.next();
                    event.setEventUuid(map.get("id"));
                    event.setEventStatus(EventStatus.valueOf(map.get("state")));
                    event.setClassificationMarking(map.get("classification"));
                    event.setEventName(map.get("name"));
                    event.setEventState(EventState.ACTIVE);
                    event.setEventStatus(EventStatus.valueOf(map.get("eventStatus")));
                    event.setStartDate(OffsetDateTime.now());
                    event.setEndDate(OffsetDateTime.now());
                    datalist.add(event);
                }

            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }

        }
        return datalist;
    }
}