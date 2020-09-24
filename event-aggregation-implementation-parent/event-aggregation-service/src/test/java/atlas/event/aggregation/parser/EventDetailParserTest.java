package atlas.event.aggregation.parser;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class EventDetailParserTest
{
    EventDetailParser task = new EventDetailParser();
    Object fromJson = new JSONObject();
    String json = "{\"eventDetail\":\"detail\"}";
    Map<String, Object> map = new HashMap<>();

    @Test
    void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test
    void fromJsonString()
    {
        assertNotNull(task.fromJsonString(json));
    }

    @Test
    void fromJson()
    {
        assertNotNull(task.fromJson(fromJson));
    }

    @Test
    void testFromJson()
    {
        assertNotNull(task.fromJson(map));
    }
}