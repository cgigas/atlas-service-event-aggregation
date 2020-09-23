package atlas.event.aggregation.data.access.accessor.exception;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DataAccessorExceptionTest
{
    String message = "message";
    Throwable cause = new Throwable();

    @Test
    public void test()
    {
        DataAccessorException task = new DataAccessorException();
        DataAccessorException task2 = new DataAccessorException(message);
        DataAccessorException task3 = new DataAccessorException(cause);
        DataAccessorException task4 = new DataAccessorException(message,cause);
        DataAccessorException task5 = new DataAccessorException(message,cause,true,true);

        assertNotNull(task);
        assertNotNull(task2);
        assertNotNull(task3);
        assertNotNull(task4);
        assertNotNull(task5);
    }
}