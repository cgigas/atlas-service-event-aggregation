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

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ConfigParserTest
{
    ConfigParser task = new ConfigParser();
    JSONObject fromJson = new JSONObject();
    String json = "{\"random\":\"value\"}";
    Map<String, Object> map = new HashMap<>();

    @Test(expected = StackOverflowError.class)
    public void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test
    public void fromJsonString()
    {
        assertNotNull(task.fromJsonString(json));
    }

    @Test
    public void fromJson()
    {
        JSONObject jsonObj = new JSONObject();
        assertNull(task.fromJson(jsonObj));
    }

    @Test
    public void testFromJson()
    {
        assertNotNull(task.fromJson(map));
    }

    @Test
    public void fromGraphqlClient()
    {
        assertNull(task.fromGraphqlClient(fromJson));
    }

    @Test
    public void toGraphqlClient()
    {
        assertNull(task.toGraphqlClient(fromJson, true));
    }
}