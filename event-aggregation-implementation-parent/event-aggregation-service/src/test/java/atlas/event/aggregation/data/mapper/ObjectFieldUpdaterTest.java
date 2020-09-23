package atlas.event.aggregation.data.mapper;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectFieldUpdaterTest
{
    ObjectFieldUpdater task = new ObjectFieldUpdater();
    Object target = new Object();
    Map<String, Object> fieldMap = new HashMap<>();

    @Test
    void updateFields()
    {
        fieldMap.put("id", "id");
        task.updateFields(target, fieldMap);
        fieldMap.put("user.country", "US");
        assertNotNull(task.updateFields(target, fieldMap));
    }
}