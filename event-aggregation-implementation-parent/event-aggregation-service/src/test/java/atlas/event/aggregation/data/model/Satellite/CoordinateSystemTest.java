package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateSystemTest
{
    @Test
    public void values()
    {
        assertEquals(2, CoordinateSystem.values().length);
    }
}