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