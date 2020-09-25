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

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import atlas.event.aggregation.data.model.ssaevent.Event;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventSatelliteParserTest
{
    EventSatelliteParser task = new EventSatelliteParser();
    Object fromJson = new JSONObject();
    String json = "{\"SsaEventSatellite\":\"map\"}";
    Map<String, Object> map = new HashMap<>();

    @Test
    void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test
    void testFromJson()
    {
        map.put("\"SsaEventSatellite\"",null);
        task.fromJson(map);
        task.fromJson(fromJson);
        task.fromJsonString(json);
    }
}