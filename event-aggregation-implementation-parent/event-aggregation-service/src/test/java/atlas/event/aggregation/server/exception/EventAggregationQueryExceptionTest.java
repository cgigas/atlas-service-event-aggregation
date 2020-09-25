package atlas.event.aggregation.server.exception;

import com.google.common.collect.Maps;
import graphql.ErrorType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EventAggregationQueryExceptionTest
{
    String EXCEPTION_TYPE = "exceptionType";
    Map<String, Object> extensions = null;
    EventAggregationExceptionCodes code = EventAggregationExceptionCodes.WARNING;
    Throwable cause = new IllegalArgumentException();
    EventAggregationQueryException task = new EventAggregationQueryException(EXCEPTION_TYPE);
    EventAggregationQueryException task2 = new EventAggregationQueryException(EXCEPTION_TYPE, code);
    EventAggregationQueryException task3 = new EventAggregationQueryException(EXCEPTION_TYPE, extensions);
    EventAggregationQueryException task4 = new EventAggregationQueryException(EXCEPTION_TYPE, code, extensions);
    EventAggregationQueryException task5 = new EventAggregationQueryException(EXCEPTION_TYPE, cause, extensions);

    @Test
    void getLocations()
    {
        assertTrue(task4.getLocations().isEmpty());
        assertTrue(task5.getLocations().isEmpty());
    }

    @Test
    void getErrorType()
    {
        assertEquals(ErrorType.DataFetchingException, task.getErrorType());
    }

    @Test
    void setExtensions()
    {
        Map<String, Object> extension = Maps.newHashMap();
        extension.put("exceptionType=WARNING", null);
        task3.setExtensions(extension);
        assertEquals("{exceptionType=WARNING=null}", task3.getExtensions().toString());
    }

    @Test
    void getCode()
    {
        assertEquals(EventAggregationExceptionCodes.WARNING, task2.getCode());
    }
}