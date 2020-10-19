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
package atlas.event.aggregation.parser.event;

import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.ssaeventsat.EventSatellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EventSatelliteParser extends EventMasterParser
{
    @Autowired
    private EventParser eventParser;

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
    public Object toGraphqlClient(Object model, Boolean inputMode)
    {
        return null;
    }
}