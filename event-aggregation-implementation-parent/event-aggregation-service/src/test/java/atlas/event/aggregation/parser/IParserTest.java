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
import org.junit.Test;
import org.mockito.Mockito;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class IParserTest
{
    IParser spy = Mockito.spy(IParser.class);
    JSONObject jsonObject = new JSONObject();
    String jsonString = "{\"random\":\"value\"}";
    Map<String, Object> map = new HashMap<>();
    Object graphql = new Object();

    @Test
    public void toJSONString()
    {
        assertNull(spy.toJSONString(jsonObject));
    }

    @Test
    public void fromJsonString()
    {
        assertNull(spy.fromJsonString(jsonString));
        assertNull(spy.fromJson(jsonObject));
        assertNull(spy.fromJson(map));
    }

    @Test
    public void fromGraphqlClient()
    {
        assertNull(spy.fromGraphqlClient(graphql));
    }

    @Test
    public void toGraphqlClient()
    {
        assertNull(spy.toGraphqlClient(graphql, true));
    }

    @Test
    public void getItemAsOffSetDate()
    {
        map.put("now", OffsetDateTime.now());
        assertNotNull(spy.getItemAsOffSetDate("now", map));
    }

    @Test
    public void getItemAsDouble()
    {
        map.put("8.0", 8.0);
        assertNotNull(spy.getItemAsDouble("8.0", map));
    }

    @Test
    public void getItemAsInteger()
    {
        jsonObject.put("7", 7);
        assertNotNull(spy.getItemAsInteger("7", jsonObject));
    }

    @Test
    public void getItemAsLong()
    {
        map.put("6L", 6L);
        assertNotNull(spy.getItemAsLong("6L", map));
    }

    @Test
    public void testGetItemAsString()
    {
        map.put("string", "string");
        assertNotNull(spy.getItemAsString("string", map));
    }
}