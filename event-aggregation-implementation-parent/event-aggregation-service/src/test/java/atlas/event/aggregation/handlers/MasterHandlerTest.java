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
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class MasterHandlerTest
{
    MasterHandler task = new MasterHandler();
    String url = "https://www.google.com";
    Properties properties = new Properties();

    @Test
    public void sendHttpGetRestRequestAsString()
    {
        try
        {
            task.sendHttpGetRestRequestAsString(url);
        }
        catch (Exception e)
        {
            assertEquals(javax.net.ssl.SSLHandshakeException.class, e);
        }
    }

    @Test
    public void sendHttpGetRestRequestAsStream()
    {
        try
        {
            task.sendHttpGetRestRequestAsStream(url);
        }
        catch (Exception e)
        {
            assertEquals(EventAggregateException.class, e);
        }
    }

    @Test
    public void testSendHttpGetRestRequestAsString()
    {
        try
        {
            task.sendHttpGetRestRequestAsString(url, properties);
        }
        catch (Exception e)
        {
            assertEquals(java.net.UnknownHostException.class, e);
        }
    }

    @Test
    public void testSendHttpGetRestRequestAsStream()
    {
        try
        {
            task.sendHttpGetRestRequestAsStream(url, properties);
        }
        catch (Exception e)
        {
            assertEquals(java.net.UnknownHostException.class, e);
        }
    }
}