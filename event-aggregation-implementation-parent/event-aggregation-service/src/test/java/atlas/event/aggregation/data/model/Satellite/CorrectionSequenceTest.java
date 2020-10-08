package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CorrectionSequenceTest
{
    @Test
    public void values()
    {
        assertEquals(3, CorrectionSequence.values().length);
    }
}