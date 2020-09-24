package atlas.event.aggregation.handlers;

import atlas.event.aggregation.exception.EventAggregateException;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MasterHandlerTest
{
    MasterHandler task = new MasterHandler();
    String url = "https://www.google.com";
    Properties properties = new Properties();

    @Test
    void sendHttpGetRestRequestAsString()
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
    void sendHttpGetRestRequestAsStream()
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
    void testSendHttpGetRestRequestAsString()
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
    void testSendHttpGetRestRequestAsStream()
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