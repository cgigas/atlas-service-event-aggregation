/*
 *  ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */
package atlas.event.aggregation.handlers;

import atlas.event.aggregation.constants.EventAggregationConstants;
import atlas.event.aggregation.data.model.ssaevent.*;
import atlas.event.aggregation.data.model.ssaeventsat.SsaEventSatellite;
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

@Component("eventDetailHandler")
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

    public Object processEventDetail(DataFetchingEnvironment environment)
    {
        SsaEventDetail eventDetail = null;
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        url += "/eventDetail/" + environment.getArgument("id");

        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            try
            {
                JSONObject json = (JSONObject) new JSONParser().parse(resultRequestedData);
                Map<String, Object> map = (Map)json.get("eventDetail");

                eventDetail = (SsaEventDetail) eventDetailParser.fromJson(map);
                if (eventDetail != null)
                {
                    eventDetail.setParentEvent((SsaEvent) eventParser.fromJson((Map) map.get("parentEvent")));
                    eventDetail.setLaunch((SsaLaunch) launchParser.fromJson((Map) map.get("launch")));

                    List<ObservationSatMedley> satMedleyList = (List) observationSatMedleyParser.fromJson((JSONArray) map.get("observationSatMedleyArray"));
                    eventDetail.getObservationSatMedleyArray().addAll(satMedleyList);
                }
            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }
        }

        return eventDetail;
    }

    public SsaEvent processUpdateEventStatus(DataFetchingEnvironment environment)
    {
        SsaEvent event = new SsaEvent();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        String eventStatus = environment.getArgument("eventStatus");
        url += "/updateEventStatus/" + id + "/" + eventStatus;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (SsaEvent) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public SsaEvent processEventById(DataFetchingEnvironment environment)
    {
        SsaEvent event = new SsaEvent();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        url += "/eventById/" + id;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (SsaEvent) eventParser.fromJsonString(resultRequestedData);

        return event;

    }

    public SsaEvent processDeleteSdaEvent(DataFetchingEnvironment environment)
    {
        SsaEvent event = new SsaEvent();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        url += "/deleteSdaEvent/" + id;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (SsaEvent) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public SsaEventSatellite processPromoteEventSatellite(DataFetchingEnvironment environment)
    {
        SsaEventSatellite eventSat = new SsaEventSatellite();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/promoteEventSatellite/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            eventSat = (SsaEventSatellite) eventSatelliteParser.fromJsonString(resultRequestedData);
        }

        return eventSat;

    }

    public SsaEvent processReleaseSatelliteFromEvent(DataFetchingEnvironment environment)
    {
        SsaEvent event = new SsaEvent();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/releaseSatelliteFromEvent/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        event = (SsaEvent) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public SsaEventSatellite processAddSatelliteToEvent(DataFetchingEnvironment environment)
    {
        SsaEventSatellite eventSat = new SsaEventSatellite();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/addSatelliteToEvent/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            eventSat = (SsaEventSatellite) eventSatelliteParser.fromJsonString(resultRequestedData);
        }

        return eventSat;
    }

    public SsaEvent processCloseSdaEvent(DataFetchingEnvironment environment)
    {
        SsaEvent event = new SsaEvent();

        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String id = environment.getArgument("id");
        OffsetDateTime endDate = environment.getArgument("endDate");
        url += "/closeSdaEvent/" + id + "/" + endDate;

        String resultRequestedData = sendHttpGetRestRequestAsString(url);
        event = (SsaEvent) eventParser.fromJsonString(resultRequestedData);

        return event;
    }

    public List<SsaEvent> processEventsByTimePeriodAndType(DataFetchingEnvironment environment)
    {
        List<SsaEvent> datalist = null;
        SsaEvent eventResult = null;
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
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
                    SsaEvent event = new SsaEvent();
                    Map<String, String> map = (Map) it.next();
                    event.setId(map.get("id"));
                    event.setClassificationMarking(map.get("classification"));
                    event.setEventName(map.get("typename"));
                    event.setStartDt(OffsetDateTime.now());
                    event.setEndDt(OffsetDateTime.now());
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