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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.model.eventdata.EventData;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component("eventDataParser")
public class EventDataParser implements IParser
{
    @Override
    public String toJSONString(Object fromJson)
    {
        return null;
    }

    @Override
    public Object fromJsonString(String json)
    {
        return null;
    }

    @Override
    public Object fromJson(Object json)
    {
        return null;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        return null;
    }

    @Override
    public Object fromGraphqlClient(Object graphql)
    {
        EventData eventData = new EventData();

        if (graphql instanceof atlas.ssaevent.crud.graphql.EventData)
        {
            atlas.ssaevent.crud.graphql.EventData eventDataClient = (atlas.ssaevent.crud.graphql.EventData) graphql;
            eventData.setEventDataUuid(eventDataClient.getEventDataUuid());
            eventData.setClassificationMarking(eventDataClient.getClassificationMarking());
            eventData.setEventUuid(eventDataClient.getEventUuid());
            eventData.setName(eventDataClient.getName());
            eventData.setUri(eventDataClient.getUri());
            eventData.setType(eventDataClient.getType());
            eventData.setSupplementalData(eventDataClient.getSupplementalData());
            eventData.setCreateDate(eventDataClient.getCreateDate());
            eventData.setCreateOrigin(eventDataClient.getCreateOrigin());
            eventData.setUpdateDate(eventDataClient.getUpdateDate());
            eventData.setUpdateOrigin(eventDataClient.getUpdateOrigin());
        }

        return eventData;
    }

    @Override
    public Object toGraphqlClient(Object model, Boolean inputMode)
    {
        Object resultItem = null;
        if (model != null)
        {
            Map<String, Object> map = (Map) model;
            if (inputMode)
            {
                atlas.ssaevent.crud.graphql.EventDataInput clientEventDataInput = new atlas.ssaevent.crud.graphql.EventDataInput();
                clientEventDataInput.setClassificationMarking(getItemAsString("classficiationMarking", map));
                clientEventDataInput.setEventUuid(getItemAsString("eventUuid", map));
                clientEventDataInput.setName(getItemAsString("name", map));
                clientEventDataInput.setUri(getItemAsString("uri", map));
                clientEventDataInput.setType(getItemAsString("type", map));

                resultItem = clientEventDataInput;
            }
            else
            {
                atlas.ssaevent.crud.graphql.EventData clientEventData = new atlas.ssaevent.crud.graphql.EventData();
                clientEventData.setEventDataUuid(getItemAsString("eventDataUuid", map));
                clientEventData.setClassificationMarking(getItemAsString("classficiationMarking", map));
                clientEventData.setEventUuid(getItemAsString("eventUuid", map));
                clientEventData.setName(getItemAsString("name", map));
                clientEventData.setUri(getItemAsString("uri", map));
                clientEventData.setType(getItemAsString("type", map));
                clientEventData.setCreateDate(getItemAsOffSetDate("createDate", map));
                clientEventData.setCreateOrigin(getItemAsString("createOrgin", map));
                clientEventData.setUpdateDate(getItemAsOffSetDate("updateDate", map));
                clientEventData.setUpdateOrigin(getItemAsString("updateOrgin", map));

                resultItem = clientEventData;
            }
        }

        return resultItem;
    }
}
