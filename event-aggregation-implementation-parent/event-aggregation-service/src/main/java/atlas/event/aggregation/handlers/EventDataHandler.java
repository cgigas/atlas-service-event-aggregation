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
import atlas.event.aggregation.constants.EventAggregationConstants;
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.exception.EventAggregateException;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component("eventDetailHandler")
public class EventDataHandler extends DigitalBase implements IDigitalHandler
{
    @Override
    public List processRequest(DataFetchingEnvironment environment)
    {
        List<SsaEvent> datalist = null;
        HttpClient httpClient = HttpClients.createDefault();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        url += "/eventDetail/" + environment.getArgument("id");

        HttpGet httpGetRequest = new HttpGet(url);
        try
        {
            HttpResponse httpResponse = httpClient.execute(httpGetRequest);
            HttpEntity entity = httpResponse.getEntity();
            InputStream entityOutStream = null;

            try
            {
                entityOutStream = entity.getContent();
                System.out.println(IOUtils.toString(entityOutStream));
            }
            catch (IOException ioe)
            {
                IOUtils.closeQuietly(entityOutStream);
            }
        }
        catch (IOException ioe)
        {
            throw new EventAggregateException(ioe);
        }


        return datalist;
    }
}
