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

import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class AbstractDataDispatchTest
{
    @Mock
    AbstractDataDispatch task = mock(AbstractDataDispatch.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    @Test
    public void initializeRuntimeTypeInformation()
    {
        task.initializeRuntimeTypeInformation();
    }

    @Test
    public void get() throws Exception
    {
        task.get(environment);
    }

    @Test
    public void getExtensions()
    {
        task.getExtensions(environment);
    }

    @Test
    public void performFetch()
    {
        task.performFetch(environment);
    }

    @Test
    public void provideRuntimeTypeWiring()
    {
        task.provideRuntimeTypeWiring();
    }

    @Test
    public void addToLocalContext()
    {
        task.addToLocalContext("user.country", "US");
    }

    @Test
    public void getPageRequestArgument()
    {
        task.getPageRequestArgument(environment, "US");
    }
}