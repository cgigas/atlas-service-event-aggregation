package atlas.event.aggregation.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

class EventParserTest
{
    EventParser task = new EventParser();
    Object fromJson = new JSONObject();
    String json = "{\"event\":\"satellite\"}";
    Map<String, Object> map = new HashMap<>();

    @Test
    void toJSONString()
    {
        task.toJSONString(fromJson);
    }

    @Test
    void fromJsonString()
    {
        task.fromJsonString(json);
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