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
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetEventTypeHandlerTest
{
    @Mock
    GetEventTypeHandler task = mock(GetEventTypeHandler.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class);

    @Mock
    MasterHandler handler = mock(MasterHandler.class, Mockito.CALLS_REAL_METHODS);

    @Test(expected = EventAggregateException.class)
    public void processRequest()
    {
        when(handler.sendHttpGetRestRequestAsString(anyString())).thenReturn("event");
        task.processRequest(environment);
    }
}