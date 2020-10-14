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
import atlas.event.aggregation.data.model.ssaeventsat.EventSatellite;
import atlas.event.aggregation.exception.EventAggregateException;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("eventSatelliteParser")
public class EventSatelliteParser implements IParser
{
    @Autowired
    private EventParser eventParser;

    @Override
    public String toJSONString(Object fromJson)
    {
        return null;
    }

    @Override
    public Object fromJsonString(String json)
    {
        EventSatellite eventSatellite = null;

        if (StringUtils.isNotBlank(json))
        {
            try
            {
                JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
                eventSatellite = (EventSatellite) fromJson((Map) jsonObject.get("SsaEventSatellite"));
            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }
        }

        return eventSatellite;
    }

    @Override
    public Object fromJson(Object json)
    {
        EventSatellite eventSatellite = null;
        if (json != null)
        {
            JSONObject jsonObject = (JSONObject) json;
            Map<String, Object> map = (Map) jsonObject.get("SsaEventSatellite");
            eventSatellite = (EventSatellite) fromJson(map);
        }

        return eventSatellite;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        EventSatellite eventSatellite = null;
        if (map != null)
        {
            eventSatellite = new EventSatellite();
            eventSatellite.setEventSatUuid(getItemAsString("eventSatUuid", map));
            eventSatellite.setSatelliteUuid(getItemAsString("satelliteUuid", map));
            eventSatellite.setRelationship(getItemAsLong("relationship", map));
            eventSatellite.setUcn(getItemAsLong("ucn", map));
            eventSatellite.setEvent((Event) eventParser.fromJson((Map) map.get("event")));
        }

        return eventSatellite;
    }

    @Override
    public Object fromGraphqlClient(Object graphql)
    {
        return null;
    }

    @Override
    public Object toGraphqlClient(Object model)
    {
        return null;
    }
}