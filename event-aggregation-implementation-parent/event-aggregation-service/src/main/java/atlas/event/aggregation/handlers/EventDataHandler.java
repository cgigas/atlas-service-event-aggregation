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
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.data.model.ssaevent.SsaEventStatus;
import atlas.event.aggregation.data.model.ssaevent.SsaEventType;
import atlas.event.aggregation.exception.EventAggregateException;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import java.time.OffsetDateTime;
import java.util.Iterator;
import java.util.Map;

@Component("eventDetailHandler")
public class EventDataHandler extends MasterHandler implements IDigitalHandler
{
    @Override
    public Object processRequest(DataFetchingEnvironment environment)
    {
        SsaEvent eventResult = null;
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        url += "/eventDetail/" + environment.getArgument("id");

        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            try
            {
                JSONObject json = (JSONObject) new JSONParser().parse(resultRequestedData);
                JSONArray ja = (JSONArray) json.get("eventDetail");
                Iterator it = ja.iterator();
                while (it.hasNext())
                {
                    Map<String, String> map = (Map)it.next();
                    String eventUuid = map.get("ssaEventUuid");
                    String marking = map.get("classificationMarking");
                    String ssaPreEvent = map.get("ssaPredecessorEventUuid");
                    String eventType = map.get("eventType");
                    String eventName = map.get("eventName");
                    String eventStatus = map.get("eventStatus");
                    String startDate = map.get("startDt");
                    String endDate = map.get("endDt");
                    String eventDesc = map.get("eventDesc");
                    Boolean bigBoard = Boolean.TRUE;
                    String notes = map.get("internalNotes");
                    String postingId = map.get("eventPostingId");
                    SsaEvent event = new SsaEvent();
                    event.setId(eventUuid);
                    event.setClassificationMarking(marking);
                    event.setSsaPredecessorEventUuid(ssaPreEvent);
                    event.setEventType(SsaEventType.valueOf(eventType));
                    event.setEventStatus(SsaEventStatus.valueOf(eventStatus));
                    event.setEventName(eventName);
                    event.setStartDt(OffsetDateTime.now());
                    event.setEndDt(OffsetDateTime.now());
                    event.setEventDesc(eventDesc);
                    event.setBigBoardFlag(bigBoard);
                    event.setInternalNotes(notes);
                    event.setEventPostingId(postingId);

                    eventResult = event;
                }

            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }
        }

        return eventResult;
    }
}
