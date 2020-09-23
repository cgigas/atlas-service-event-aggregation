package atlas.event.aggregation.cache;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DigitalCacheTest
{
    DigitalCache task = new DigitalCache();
    String key = "user.country";
    String value = "US";
    Map<String, String> businessHandlerMap = new HashMap<>();
    Map<String, String> externalServiceUrlMap = new HashMap<>();

    @Test
    public void addBusinessHandler()
    {
        task.addBusinessHandler(key, value);
        assertEquals(value, task.getBusinessHandler(key));
    }

    @Test
    public void addExternalServiceUrl()
    {
        task.addExternalServiceUrl(key, value);
        assertEquals(value, task.getExternalServiceUrl(key));
    }

    @Test
    void setBusinessHandlerMap()
    {
        task.setBusinessHandlerMap(businessHandlerMap);
        assertEquals(businessHandlerMap, task.getBusinessHandlerMap());
    }

    @Test
    void setExternalServiceUrlMap()
    {
        task.setExternalServiceUrlMap(externalServiceUrlMap);
        assertEquals(externalServiceUrlMap, task.getExternalServiceUrlMap());
    }
}