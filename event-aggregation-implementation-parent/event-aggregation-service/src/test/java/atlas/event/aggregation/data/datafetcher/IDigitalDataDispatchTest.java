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

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class IDigitalDataDispatchTest
{
    @Mock
    IDigitalDataDispatch task = mock(IDigitalDataDispatch.class);
    String url = "http://localhost:8080";

    @Test
    void testSendHttpGetRestRequestAsString()
    {
        String responseString = null;
        when(task.sendHttpGetRestRequestAsString(anyString())).thenReturn(responseString);
        task.sendHttpGetRestRequestAsString(url);
        assertNull(responseString);
    }

    @Test
    void testSendHttpGetRestRequestAsStream()
    {
        InputStream responseStream = null;
        when(task.sendHttpGetRestRequestAsStream(anyString())).thenReturn(responseStream);
        task.sendHttpGetRestRequestAsStream(url);
        assertNull(responseStream);
    }
}