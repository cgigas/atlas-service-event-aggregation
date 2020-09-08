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
import atlas.event.aggregation.exception.EventAggregateException;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("eventDetailHandler")
public class EventDataHandler extends MasterHandler
{
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

                eventDetail = new SsaEventDetail();
                eventDetail.setId((String)map.get("id"));
                eventDetail.setState((String)map.get("state"));
                eventDetail.setClassification((String)map.get("classification"));
                eventDetail.setType((String)map.get("type"));
                eventDetail.setName((String)map.get("name"));
                eventDetail.setStartDate(OffsetDateTime.now());
                eventDetail.setEndDate(OffsetDateTime.now());
                eventDetail.setCatalogObjectCount((Long)map.get("catalogObjectCount"));
                eventDetail.setAnalystObjects((Long)map.get("analystObjects"));
                eventDetail.setCandidateObjectCount((Long)map.get("candidateObjectCount"));
                eventDetail.setPromotableObjectCount((Long)map.get("promotableObjectCount"));
                eventDetail.setTypeName((String)map.get("typeName"));
                Map<String, Object> parentEventMap = (Map)map.get("parentEvent");
                SsaEvent event = new SsaEvent();
                event.setId(parentEventMap.get("id"));
                event.setEventName((String)parentEventMap.get("eventName"));
                eventDetail.setParentEvent(event);
                SsaLaunch launch = new SsaLaunch();
                Map<String, Object> launchMap = (Map)map.get("launch");
                launch.setId((String)launchMap.get("id"));
                launch.setLaunchTimeStamp(OffsetDateTime.now());
                launch.setLaunchSite((String)launchMap.get("launchSite"));
                launch.setLaunchCountry((String)launchMap.get("launchCountry"));
                launch.setTypeName((String)launchMap.get("typeName"));
                eventDetail.setLaunch(launch);

                JSONArray array = (JSONArray) map.get("observationSatMedleyArray");
                Iterator it = array.iterator();
                while (it.hasNext())
                {
                    Map<String, Object> itemMap = (Map) it.next();
                    ObservationSatMedley medley = new ObservationSatMedley();
                    medley.setId((String) itemMap.get("id"));
                    medley.setSatelliteId((String) itemMap.get("satelliteId"));
                    medley.setObservationId((String) itemMap.get("observationId"));
                    medley.setClassification((String) itemMap.get("classification"));
                    medley.setPromotable((Long) itemMap.get("isPromotable"));
                    medley.setCataloged((Long) itemMap.get("isCataloged"));
                    medley.setAnalyst((Long) itemMap.get("isAnalyst"));
                    medley.setCandidate((Long) itemMap.get("isCandidate"));
                    medley.setSatNo((Long) itemMap.get("satno"));
                    medley.setUcn((Long) itemMap.get("ucn"));
                    medley.setCommonName((String) itemMap.get("commonName"));
                    medley.setGroup((String) itemMap.get("group"));
                    medley.setType((String) itemMap.get("type"));
                    medley.setRadarCrossSection((Float) map.get("radarCrossSection"));
                    medley.setEpoch(OffsetDateTime.now());
                    medley.setResult((String) itemMap.get("result"));
                    medley.setPeriod((Double) itemMap.get("period"));
                    medley.setInclination((Double) itemMap.get("inclination"));
                    medley.setApogee((Long) itemMap.get("apogee"));
                    medley.setPerigee((Long) itemMap.get("perigee"));
                    medley.setEccentricity((Double) itemMap.get("eccentricity"));
                    medley.setTypeName((String) itemMap.get("typeName"));

                    eventDetail.getObservationSatMedleyArray().add(medley);
                }
            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }
        }

        return eventDetail;
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
                    event.setState(map.get("state"));
                    event.setClassificationMarking(map.get("classification"));
                    event.setEventType(SsaEventType.valueOf(map.get("type")));
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