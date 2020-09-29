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

import atlas.event.aggregation.exception.EventAggregateException;
import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class EventDataHandlerTest
{
    @Mock
    EventDataHandler task = mock(EventDataHandler.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class);

    @Test
    void processUpdateEventStatus()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processUpdateEventStatus(environment);
        });
    }

    @Test
    void processEventById()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processEventById(environment);
        });
    }

    @Test
    void processDeleteSdaEvent()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processDeleteSdaEvent(environment);
        });
    }

    @Test
    void processPromoteEventSatellite()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processPromoteEventSatellite(environment);
        });
    }

    @Test
    void processReleaseSatelliteFromEvent()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processReleaseSatelliteFromEvent(environment);
        });
    }

    @Test
    void processAddSatelliteToEvent()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processAddSatelliteToEvent(environment);
        });
    }

    @Test
    void processCloseSdaEvent()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processCloseSdaEvent(environment);
        });
    }

    @Test
    void processEventsByTimePeriodAndType()
    {
        assertThrows(EventAggregateException.class, () ->
        {
            task.processEventsByTimePeriodAndType(environment);
        });
    }
}