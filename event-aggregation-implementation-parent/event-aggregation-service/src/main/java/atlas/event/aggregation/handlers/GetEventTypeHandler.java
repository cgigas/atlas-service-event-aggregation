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

import atlas.event.aggregation.constants.EventAggregationConstants;
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.exception.EventAggregateException;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("getEventTypeHandler")
public class GetEventTypeHandler extends MasterHandler
{
    public Object processRequest(DataFetchingEnvironment environment)
    {
        List<SsaEvent> datalist = new ArrayList<>();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        url += "/getEventTypes";

        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            try
            {
                JSONObject json = (JSONObject) new JSONParser().parse(resultRequestedData);
                JSONArray array = (JSONArray) json.get("eventTypes");
                Object[] items = array.toArray();

                if (items != null)
                {
                    for (Object item: items)
                    {
                        SsaEvent event = new SsaEvent();
                        datalist.add(event);
                    }
                }

            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }
        }

        return datalist;
    }
}