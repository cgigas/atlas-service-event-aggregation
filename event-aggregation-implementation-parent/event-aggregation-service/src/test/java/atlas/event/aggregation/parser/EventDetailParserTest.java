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

import atlas.event.aggregation.exception.EventAggregateException;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EventDetailParserTest
{
    EventDetailParser task = new EventDetailParser();
    Object fromJson = new JSONObject();
    String json = "{\"eventDetail\":\"detail\"}";
    Map<String, Object> map = new HashMap<>();

    @Test
    public void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test(expected = NullPointerException.class)
    public void fromJsonString()
    {
        assertNotNull(task.fromJsonString(json));
    }

    @Test(expected = EventAggregateException.class)
    public void fromJsonStringBad()
    {
        task.fromJsonString("");
    }

    @Test(expected = NullPointerException.class)
    public void fromJson()
    {
        assertNotNull(task.fromJson(fromJson));
    }

    @Test
    public void testFromJson()
    {
        map.put("type", "DOCK");
        map.put("name", "name");
        map.put("startDate", OffsetDateTime.now());
        map.put("endDate", OffsetDateTime.now());
        map.put("catalogObjectCount", 3L);
        map.put("analystObjects", 4L);
        map.put("candidateObjectCount", 5L);
        map.put("promotableObjectCount", 6L);
        map.put("typeName", "type");
        assertNotNull(task.fromJson(map));
    }

    @Test
    public void testGraphqlClient()
    {
        assertNull(task.fromGraphqlClient(new Object()));
        assertNull(task.toGraphqlClient(new Object(), true));
    }
}