package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssociationStatusTest
{
    @Test
    public void values()
    {
        assertEquals(5, AssociationStatus.values().length);
    }
}