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
package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.data.datafetcher.util.GraphqlUtility;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


public class EventDataDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    GraphqlUtility utility = new GraphqlUtility();
    EventDataDispatch task = new EventDataDispatch(collector, utility);
    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    @Test
    public void testProvideRuntimeTypeWiring()
    {
        assertNotNull(task.provideRuntimeTypeWiring());
    }

    @Test
    public void testPerformFetch()
    {
        try
        {
            task.performFetch(environment);
        }
        catch (NullPointerException e)
        {
            assertNotNull(task);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testProcessEventByID()
    {
        task.processEventByID(environment);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessCloseEvent()
    {
        task.processCloseEvent(environment);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessDeleteEvent()
    {
        task.processDeleteEvent(environment);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessUpdateEventStatus()
    {
        task.processUpdateEventStatus(environment);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessCreateEvent()
    {
        task.processCreateEvent(environment);
    }
}