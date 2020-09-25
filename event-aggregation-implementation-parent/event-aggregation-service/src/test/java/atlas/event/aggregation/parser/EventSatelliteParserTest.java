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
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testFromJsonString()
    {
        assertNull(task.fromJsonString(""));

        try
        {
            task.fromJsonString("SsaEventSatellite");
        }
        catch (EventAggregateException e)
        {
            assertTrue(e.toString().contains("Unexpected character"));
        }
    }

    @Test
    public void testFromJson()
    {
        assertNull(task.fromJson(badObj));
    }

    @Test
    public void testFromJsonMap()
    {
        Map<String, Object> map = null;
        assertNull(task.fromJson(map));

        try
        {
            map = new HashMap<>();
            map.put("event", EventType.MANEUVER);
            task.fromJson(map);
        }
        catch (ClassCastException e)
        {
        }
    }

}