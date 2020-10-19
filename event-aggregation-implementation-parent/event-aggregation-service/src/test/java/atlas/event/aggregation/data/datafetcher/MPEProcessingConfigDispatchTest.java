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

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class MPEProcessingConfigDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    MPEProcessingConfigDispatch task = new MPEProcessingConfigDispatch(collector);
    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    @Test
    public void provideRuntimeTypeWiring()
    {
        assertNotNull(task.provideRuntimeTypeWiring());
    }

    @Test(expected = NullPointerException.class)
    public void performFetch()
    {
        assertNotNull(task.performFetch(environment));
    }
}