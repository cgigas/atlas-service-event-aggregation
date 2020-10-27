/*
 * ******************************************************************************
 *  WARNING: EXPORT CONTROLLED - EAR
 *  THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *  GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *  REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *  FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *  VIOLATION OF FEDERAL LAW.
 * ******************************************************************************
 *  Unlimited Government Rights
 *  WARNING: Do Not Use On A Privately Funded Program Without Permission.
 * ******************************************************************************
 *  CLASSIFICATION:   Unclassified
 *
 *  LIMITATIONS:      None
 * ******************************************************************************
 */
package atlas.event.aggregation.server.exception;

import com.google.common.collect.Maps;
import graphql.ErrorType;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventAggregationQueryExceptionTest
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
    public void getLocations()
    {
        assertTrue(task4.getLocations().isEmpty());
        assertTrue(task5.getLocations().isEmpty());
    }

    @Test
    public void getErrorType()
    {
        assertEquals(ErrorType.DataFetchingException, task.getErrorType());
    }

    @Test
    public void setExtensions()
    {
        Map<String, Object> extension = Maps.newHashMap();
        extension.put("exceptionType=WARNING", null);
        task3.setExtensions(extension);
        assertEquals("{exceptionType=WARNING=null}", task3.getExtensions().toString());
    }

    @Test
    public void getCode()
    {
        assertEquals(EventAggregationExceptionCodes.WARNING, task2.getCode());
    }
}