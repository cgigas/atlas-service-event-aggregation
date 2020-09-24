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
    String json = "{\"event\":\"3\"}";
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
        task.fromJson(json);
    }

    @Test
    void testFromJson()
    {
        task.fromJson(map);
    }
}