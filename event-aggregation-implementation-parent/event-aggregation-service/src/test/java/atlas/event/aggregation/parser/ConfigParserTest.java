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