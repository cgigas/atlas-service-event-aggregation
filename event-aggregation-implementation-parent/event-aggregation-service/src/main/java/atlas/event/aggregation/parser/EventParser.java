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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.event.EventStatus;
import atlas.event.aggregation.data.model.event.EventType;
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
        Event event = null;
        if (json instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject) json;
            Map<String, Object> map = (Map)jsonObject.get("event");
            event = (Event) fromJson(map);
        }
        return event;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        return null;
    }

    public Object fromGraphqlClient(Object graphql)
    {
        Event event = new Event();
        if (graphql instanceof atlas.ssaevent.crud.graphql.Event)
        {
            atlas.ssaevent.crud.graphql.Event clientEvent = (atlas.ssaevent.crud.graphql.Event) graphql;
            event.setEventUuid(clientEvent.getEventUuid());
            event.setClassificationMarking(clientEvent.getClassificationMarking());
            event.setPredecessorEventUuid(clientEvent.getPredecessorEventUuid());
            event.setEventType(EventType.valueOf(clientEvent.getType().name()));
            event.setEventName(clientEvent.getName());
            event.setEventStatus(EventStatus.valueOf(clientEvent.getStatus().name()));
            event.setStartDate(clientEvent.getStartDt());
            event.setEndDate(clientEvent.getEndDt());
            event.setDescription(clientEvent.getDescription());
            event.setInternalNotes(clientEvent.getInternalNotes());
            event.setEventPostingId(clientEvent.getEventPostingId());
            if (clientEvent.getEventData() != null)
            {
                for (atlas.ssaevent.crud.graphql.EventData clientEventData: clientEvent.getEventData())
                {
//                    event.getEventDataList().add((EventData) eventDataParser.fromGraphqlClient(clientEventData));
                }
            }
            event.setCreateDate(clientEvent.getCreateDate());
            event.setCreateOrigin(clientEvent.getCreateOrigin());
            event.setUpdateDate(clientEvent.getUpdateDate());
            event.setUpdateOrigin(clientEvent.getUpdateOrigin());


        }

        return event;
    }

    public Object toGraphqlClient(Object model)
    {
        return null;
    }
}