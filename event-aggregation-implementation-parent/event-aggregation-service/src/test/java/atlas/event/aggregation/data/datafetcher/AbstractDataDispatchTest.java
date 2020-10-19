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

import atlas.event.aggregation.server.exception.EventAggregationQueryException;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

import static java.lang.System.getProperty;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class AbstractDataDispatchTest
{
    AbstractDataDispatch dispatch = spy(AbstractDataDispatch.class);

    Map<String, Object> localContext;
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    @Test
    public void initializeRuntimeTypeInformation()
    {
        dispatch.initializeRuntimeTypeInformation();
    }

    @Test
    public void get() throws Exception
    {
        dispatch.get(environment);
    }

    @Test(expected = NullPointerException.class)
    public void buildErrorResult() throws Exception
    {
        dispatch.get(null);
    }

    @Test(expected = NullPointerException.class)
    public void buildWarningResult()
    {
        EventAggregationQueryException e = mock(EventAggregationQueryException.class);
        dispatch.buildWarningResult(environment, new Object(), e);
    }

    @Test
    public void getExtensions()
    {
        assertNotNull(dispatch.getExtensions(environment));
    }

    @Test
    public void performFetch()
    {
        assertNull(dispatch.performFetch(environment));
    }

    @Test
    public void provideRuntimeTypeWiring()
    {
        assertNotNull(dispatch.provideRuntimeTypeWiring());
    }

    @Test
    public void addToLocalContext()
    {
        dispatch.addToLocalContext("user.country", getProperty("user.country"));
    }

    @Test
    public void getPageRequestArgument()
    {
        dispatch.getPageRequestArgument(environment, "");
    }

    @Test(expected = NullPointerException.class)
    public void getClientServiceLookup()
    {
        dispatch.getClientServiceLookup();
    }
}