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
package atlas.event.aggregation.handlers;

import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class EventDataHandlerTest
{
    @Mock
    EventDataHandler task = mock(EventDataHandler.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    @Test(expected = NullPointerException.class)
    public void processUpdateEventStatus()
    {
        task.processUpdateEventStatus(environment);
    }

    @Test(expected = NullPointerException.class)
    public void processEventById()
    {
        task.processEventById(environment);
    }

    @Test(expected = NullPointerException.class)
    public void processDeleteSdaEvent()
    {
        task.processDeleteSdaEvent(environment);
    }

    @Test(expected = NullPointerException.class)
    public void processPromoteEventSatellite()
    {
        task.processPromoteEventSatellite(environment);
    }

    @Test(expected = NullPointerException.class)
    public void processReleaseSatelliteFromEvent()
    {
        task.processReleaseSatelliteFromEvent(environment);
    }

    @Test(expected = NullPointerException.class)
    public void processAddSatelliteToEvent()
    {
        task.processAddSatelliteToEvent(environment);
    }

    @Test(expected = NullPointerException.class)
    public void processCloseSdaEvent()
    {
        task.processCloseSdaEvent(environment);
    }

    @Test//(expected = EventAggregateException.class)
    public void processEventsByTimePeriodAndType()
    {
        assertNotNull(task.processEventsByTimePeriodAndType(environment));
    }
}