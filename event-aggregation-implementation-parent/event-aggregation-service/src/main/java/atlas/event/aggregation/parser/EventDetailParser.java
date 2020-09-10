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

import atlas.event.aggregation.data.model.ssaevent.SsaEventDetail;
import atlas.event.aggregation.exception.EventAggregateException;
import atlas.event.aggregation.util.JSonUtil;
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
        SsaEventDetail eventDetail = new SsaEventDetail();
        JSONObject jsonObject = (JSONObject) json;
        Map<String, Object> map = (Map) jsonObject.get("eventDetail");
        eventDetail = (SsaEventDetail) fromJson(map);

        return eventDetail;
    }

    public Object fromJson(Map<String, Object> map)
    {
        SsaEventDetail eventDetail = new SsaEventDetail();
        eventDetail.setId(JSonUtil.getItemAsString("id", map));
        eventDetail.setState(JSonUtil.getItemAsString("state", map));
        eventDetail.setClassification(JSonUtil.getItemAsString("classification", map));
        eventDetail.setType(JSonUtil.getItemAsLong("type", map));
        eventDetail.setName(JSonUtil.getItemAsString("name", map));
        eventDetail.setStartDate(JSonUtil.getItemAsOffSetDate("startDt", map));
        eventDetail.setEndDate(JSonUtil.getItemAsOffSetDate("endDt", map));
        eventDetail.setCatalogObjectCount(JSonUtil.getItemAsLong("catalogObjectCount", map));
        eventDetail.setAnalystObjects(JSonUtil.getItemAsLong("analystObjects", map));
        eventDetail.setCandidateObjectCount(JSonUtil.getItemAsLong("candidateObjectCount", map));
        eventDetail.setPromotableObjectCount(JSonUtil.getItemAsLong("promotableObjectCount", map));
        eventDetail.setTypeName(JSonUtil.getItemAsString("typeName", map));

        return eventDetail;
    }
}
