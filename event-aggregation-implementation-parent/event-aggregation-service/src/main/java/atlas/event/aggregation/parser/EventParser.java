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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.exception.EventAggregateException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component("eventParser")
public class EventParser implements IParser
{
    @Override
    public String toJSONString(Object fromJson)
    {
        return toJSONString(fromJson);
    }

    @Override
    public Object fromJsonString(String json)
    {
        Object result = null;
        try
        {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
            result = fromJson((Map) jsonObject.get("event"));
        }
        catch (ParseException pe)
        {
            throw new EventAggregateException(pe);
        }

        return result;
    }



    @Override
    public Object fromJson(Object json)
    {
        SsaEvent event = null;
        if (json instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject) json;
            Map<String, Object> map = (Map)jsonObject.get("event");
            event = (SsaEvent) fromJson(map);
        }
        return event;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        SsaEvent event = new SsaEvent();
        event.setId(getItemAsString("eventUuid", map));
        event.setClassificationMarking(getItemAsString("classification", map));
        event.setSsaPredecessorEventUuid(getItemAsString("predecessorEventUuid", map));
        event.setEventType(getItemAsLong("type", map));
        event.setEventName(getItemAsString("eventName", map));
        event.setEventStatus(getItemAsLong("status", map));
        event.setStartDt(getItemAsOffSetDate("startDate", map));
        event.setEndDt(getItemAsOffSetDate("endDate", map));
        event.setEventDesc(getItemAsString("description", map));
        event.setInternalNotes(getItemAsString("internalNotes", map));
        event.setEventPostingId(getItemAsString("postingId", map));

        return event;
    }
}