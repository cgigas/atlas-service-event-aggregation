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
import graphql.schema.idl.TypeRuntimeWiring;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collection;

import static org.mockito.Mockito.mock;

public class AbstractDataDispatchTest
{
    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    AbstractDataDispatch abstractDataDispatch;

    @Before
    public void setUp()
    {
        abstractDataDispatch = new AbstractDataDispatch()
        {
            @Override
            protected Object performFetch(DataFetchingEnvironment environment)
            {
                return null;
            }

            @Override
            protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
            {
                return null;
            }
        };
    }

    @Test
    public void initializeRuntimeTypeInformation()
    {
        abstractDataDispatch.initializeRuntimeTypeInformation();
    }

    @Test
    public void get() throws Exception
    {
        abstractDataDispatch.get(environment);
    }

    @Test
    public void getExtensions()
    {
        abstractDataDispatch.getExtensions(environment);
    }

    @Test
    public void performFetch()
    {
        abstractDataDispatch.performFetch(environment);
    }

    @Test
    public void provideRuntimeTypeWiring()
    {
        abstractDataDispatch.provideRuntimeTypeWiring();
    }

    @Test
    public void addToLocalContext()
    {
        abstractDataDispatch.addToLocalContext("user.country", "US");
    }

    @Test
    public void getPageRequestArgument()
    {
        abstractDataDispatch.getPageRequestArgument(environment, "US");
    }
}