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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.model.ssaevent.EventDetail;
import atlas.event.aggregation.exception.EventAggregateException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("eventDetailParser")
public class EventDetailParser implements IParser
{
    @Override
    public String toJSONString(Object fromJson)
    {
        return null;
    }

    @Override
    public Object fromJsonString(String json)
    {
        Object result = null;
        try
        {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
            result = fromJson(jsonObject);
        }
        catch (ParseException pe)
        {
            throw new EventAggregateException(pe);
        }

        return result;

    }

    @Override
    public Object fromJson(Object json)
    {
        EventDetail eventDetail = new EventDetail();
        JSONObject jsonObject = (JSONObject) json;
        Map<String, Object> map = (Map) jsonObject.get("eventDetail");
        eventDetail = (EventDetail) fromJson(map);

        return eventDetail;
    }

    public Object fromJson(Map<String, Object> map)
    {
        EventDetail eventDetail = new EventDetail();
        eventDetail.setId(getItemAsString("id", map));
        eventDetail.setState(getItemAsString("state", map));
        eventDetail.setClassification(getItemAsString("classification", map));
        eventDetail.setType(getItemAsLong("type", map));
        eventDetail.setName(getItemAsString("name", map));
        eventDetail.setStartDate(getItemAsOffSetDate("startDt", map));
        eventDetail.setEndDate(getItemAsOffSetDate("endDt", map));
        eventDetail.setCatalogObjectCount(getItemAsLong("catalogObjectCount", map));
        eventDetail.setAnalystObjects(getItemAsLong("analystObjects", map));
        eventDetail.setCandidateObjectCount(getItemAsLong("candidateObjectCount", map));
        eventDetail.setPromotableObjectCount(getItemAsLong("promotableObjectCount", map));
        eventDetail.setTypeName(getItemAsString("typeName", map));

        return eventDetail;
    }
}
