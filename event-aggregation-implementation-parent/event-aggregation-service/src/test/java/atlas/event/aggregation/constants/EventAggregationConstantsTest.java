package atlas.event.aggregation.constants;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventAggregationConstantsTest
{
    @Test
    public void test()
    {
        EventAggregationConstants task = new EventAggregationConstants();
        assertNotNull(task);
    }
}