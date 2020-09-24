package atlas.event.aggregation.parser;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import atlas.event.aggregation.data.model.ssaevent.Event;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventSatelliteParserTest
{
    EventSatelliteParser task = new EventSatelliteParser();
    Object fromJson = new JSONObject();
    String json = "{\"SsaEventSatellite\":\"map\"}";
    Map<String, Object> map = new HashMap<>();

    @Test
    void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test
    void fromJsonString()
    {
        task.fromJsonString(json);
    }

    @Test
    void fromJson()
    {
        task.fromJson(fromJson);
    }

    @Test
    void testFromJson()
    {
        task.fromJson(map);
    }
}