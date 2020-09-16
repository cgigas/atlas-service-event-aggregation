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
import atlas.event.aggregation.data.model.ssaeventdata.EventTypeSummary;
import atlas.event.aggregation.exception.EventAggregateException;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("eventTypeSummaryHandler")
public class EventTypeSummaryHandler extends MasterHandler
{
    public List<EventTypeSummary> processRequest(DataFetchingEnvironment environment)
    {
        List<EventTypeSummary> datalist = null;
        String startTime = environment.getArgument("");
        String endTime = environment.getArgument("");
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        url += "/eventTypeSummariesByTimePeriod";

        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            datalist = new ArrayList<>();
            try
            {
                JSONObject json = (JSONObject) new JSONParser().parse(resultRequestedData);
                JSONArray array = (JSONArray) json.get("eventTypeSummariesByTimePeriod");
                Iterator it = array.iterator();
                while (it.hasNext())
                {
                    Map<String, String> map = (Map) it.next();
                    EventTypeSummary summary = new EventTypeSummary();
                    summary.setId(map.get("id"));
                    summary.setType(map.get("type"));
                    summary.setPlanned(Integer.valueOf(map.get("planned")));
                    summary.setActive(Integer.valueOf(map.get("active")));
                    summary.setTypeName(map.get("typename"));
                    datalist.add(summary);
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