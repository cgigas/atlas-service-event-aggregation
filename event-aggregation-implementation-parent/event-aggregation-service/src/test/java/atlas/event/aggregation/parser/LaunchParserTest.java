package atlas.event.aggregation.parser;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LaunchParserTest
{
    LaunchParser task = new LaunchParser();
    Object fromJson = new JSONObject();
    String json = "";
    Map<String, Object> map = new HashMap<>();

    @Test
    void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test
    void fromJsonString()
    {
        assertNull(task.fromJsonString(json));
    }

    @Test
    void fromJson()
    {
        assertNull(task.fromJson(fromJson));
    }

    @Test
    void testFromJson()
    {
        assertNotNull(task.fromJson(map));
    }
}