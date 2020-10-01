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

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;

interface IDigitalDataDispatch
{
    default String sendHttpGetRestRequestAsString(String url)
    {
        String responseString = "response";
        return responseString;
    }

    default InputStream sendHttpGetRestRequestAsStream(String url)
    {
        InputStream responseStream = null;
        return responseStream;
    }

    default String sendHttpGetRestRequestAsString(String url, Properties properties)
    {
        String responseString = "response";
        return responseString;
    }

    default InputStream sendHttpGetRestRequestAsStream(String url, Properties properties)
    {
        InputStream responseStream = null;

        return responseStream;
    }
}

public class IDigitalDataDispatchTest
{
    IDigitalDataDispatch dispatch = spy(IDigitalDataDispatch.class);
    Properties properties = new Properties();

    @Test
    public void test()
    {
        assertNotNull(dispatch.sendHttpGetRestRequestAsString("url"));
        assertNull(dispatch.sendHttpGetRestRequestAsStream("url"));
        assertNotNull(dispatch.sendHttpGetRestRequestAsString("url", properties));
        assertNull(dispatch.sendHttpGetRestRequestAsStream("url", properties));
    }
}