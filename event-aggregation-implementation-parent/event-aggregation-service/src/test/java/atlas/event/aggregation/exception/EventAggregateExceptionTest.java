package atlas.event.aggregation.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EventAggregateExceptionTest
{
    String message = "message";
    Exception e = new IllegalArgumentException();

    @Test
    public void test()
    {
        EventAggregateException task = new EventAggregateException(message);
        assertNotNull(task);
        EventAggregateException task2 = new EventAggregateException(e);
        assertNotNull(task2);
        EventAggregateException task3 = new EventAggregateException(message, e);
        assertNotNull(task3);
    }
}