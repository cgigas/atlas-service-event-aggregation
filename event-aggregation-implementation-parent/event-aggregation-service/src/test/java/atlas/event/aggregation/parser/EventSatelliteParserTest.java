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

import atlas.event.aggregation.data.model.ssaevent.EventType;
import atlas.event.aggregation.exception.EventAggregateException;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class EventSatelliteParserTest
{
    EventSatelliteParser task = new EventSatelliteParser();
    Object fromJson = new JSONObject();
    Object badObj = null;

    @Test
    public void testToJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test(expected = EventAggregateException.class)
    public void testFromJsonString()
    {
        assertNull(task.fromJsonString(""));
        task.fromJsonString("SsaEventSatellite");
    }

    @Test
    public void testFromJson()
    {
        assertNull(task.fromJson(badObj));
    }

    @Test(expected = ClassCastException.class)
    public void testFromJsonMap()
    {
        Map<String, Object> MAP = null;
        assertNull(task.fromJson(MAP));

        MAP = new HashMap<>();
        MAP.put("event", EventType.MANEUVER);

        Map<String, Object> finalMAP = MAP;
        task.fromJson(finalMAP);
    }
}