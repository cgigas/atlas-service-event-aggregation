package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseMaintenanceParameterTest
{
    @Test
    public void values()
    {
        assertEquals(9, BaseMaintenanceParameter.values().length);
    }
}