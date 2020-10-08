package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtmosphericModelTest
{
    @Test
    public void values()
    {
        assertEquals(8, AtmosphericModel.values().length);
    }
}