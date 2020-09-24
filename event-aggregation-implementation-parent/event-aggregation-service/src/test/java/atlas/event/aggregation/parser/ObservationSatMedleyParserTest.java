package atlas.event.aggregation.parser;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ObservationSatMedleyParserTest
{
    ObservationSatMedleyParser task = new ObservationSatMedleyParser();
    JSONArray fromJson = new JSONArray();
    String json = "";
    Map<String, Object> map = new HashMap<>();
    Object Map;

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
        fromJson.add(0, Map);
        assertNotNull(task.fromJson(fromJson));
    }

    @Test
    void testFromJson()
    {
        assertNotNull(task.fromJson(map));
    }
}