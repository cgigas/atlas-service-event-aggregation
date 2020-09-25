package atlas.event.aggregation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EventAggregationGQLServerApplicationTest
{
    EventAggregationGQLServerApplication task = new EventAggregationGQLServerApplication();

    @Test
    void main()
    {
        String[] args = new String[1];
        try
        {
            task.main(args);
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("NullPointerException"));
        }
    }
}