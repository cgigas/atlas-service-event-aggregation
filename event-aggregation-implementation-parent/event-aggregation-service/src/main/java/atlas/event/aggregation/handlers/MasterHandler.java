/*
 *  ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */
package atlas.event.aggregation.handlers;

import atlas.event.aggregation.base.DigitalBase;
import atlas.event.aggregation.exception.EventAggregateException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MasterHandler extends DigitalBase
{
    HttpClient httpClient = null;

    @PostConstruct
    private void init()
    {
        httpClient = HttpClients.createDefault();
    }

    public String sendHttpGetRestRequestAsString(String url)
    {
        String responseString = null;
        if (StringUtils.isNotBlank(url))
        {
            try
            {
                responseString = IOUtils.toString(sendHttpGetRestRequestAsStream(url));
            }
            catch (IOException ioe)
            {
                throw new EventAggregateException(ioe);
            }
        }

        return responseString;
    }

    public InputStream sendHttpGetRestRequestAsStream(String url)
    {
        InputStream responseStream = null;
        if (StringUtils.isNotBlank(url))
        {
            try
            {
                HttpGet httpGetRequest = new HttpGet(url);
                HttpResponse httpResponse = httpClient.execute(httpGetRequest);
                HttpEntity entity = httpResponse.getEntity();
                try
                {
                    responseStream = entity.getContent();
                }
                catch (IOException ioe)
                {
                    throw new EventAggregateException(ioe);
                }
            }
            catch (IOException ioe)
            {
                throw new EventAggregateException(ioe);
            }
        }

        return responseStream;
    }

    public String sendHttpGetRestRequestAsString(String url, Properties properties)
    {
        String responseString = null;

        return responseString;
    }

    public InputStream sendHttpGetRestRequestAsStream(String url, Properties properties)
    {
        InputStream responseStream = null;

        return responseStream;
    }
}