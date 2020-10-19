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
package atlas.event.aggregation.parser.event;

import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.event.EventStatus;
import atlas.event.aggregation.data.model.event.EventType;
import atlas.event.aggregation.data.model.eventdata.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("eventParser")
public class EventParser extends EventMasterParser
{

    @Autowired
    private EventDataParser eventDataParser;


    @Override
    public Object fromGraphqlClient(Object graphql)
    {
        Event event = new Event();
        if (graphql instanceof atlas.ssaevent.crud.graphql.Event)
        {
            atlas.ssaevent.crud.graphql.Event clientEvent = (atlas.ssaevent.crud.graphql.Event) graphql;
            event.setEventUuid(clientEvent.getEventUuid());
            event.setClassificationMarking(clientEvent.getClassificationMarking());
            event.setPredecessorEventUuid(clientEvent.getPredecessorEventUuid());
            event.setEventType(EventType.valueOf(clientEvent.getType().name()));
            event.setEventName(clientEvent.getName());
            event.setEventStatus(EventStatus.valueOf(clientEvent.getStatus().name()));
            event.setStartDate(clientEvent.getStartDt());
            event.setEndDate(clientEvent.getEndDt());
            event.setDescription(clientEvent.getDescription());
            event.setInternalNotes(clientEvent.getInternalNotes());
            event.setEventPostingId(clientEvent.getEventPostingId());
            if (clientEvent.getEventData() != null)
            {
                for (atlas.ssaevent.crud.graphql.EventData clientEventData: clientEvent.getEventData())
                {
                    event.getEventData().add((EventData) eventDataParser.fromGraphqlClient(clientEventData));
                }
            }
            event.setCreateDate(clientEvent.getCreateDate());
            event.setCreateOrigin(clientEvent.getCreateOrigin());
            event.setUpdateDate(clientEvent.getUpdateDate());
            event.setUpdateOrigin(clientEvent.getUpdateOrigin());


        }

        return event;
    }

    public Object toGraphqlClient(Object model, Boolean inputMode)
    {
        Object resultItem = null;
        if (model instanceof Map)
        {
            if (inputMode)
            {
                atlas.ssaevent.crud.graphql.EventInput clientEvent = new atlas.ssaevent.crud.graphql.EventInput();
                Map<String, Object> eventMap = (Map) model;
                clientEvent.setClassificationMarking(getItemAsString("classificationMarking", eventMap));
                clientEvent.setPredecessorEventUuid(getItemAsString("predecessorEventUuid", eventMap));
                clientEvent.setType(atlas.ssaevent.crud.graphql.EventType.valueOf(getItemAsString("eventType", eventMap)));
                clientEvent.setName(getItemAsString("eventName", eventMap));
                clientEvent.setStatus(atlas.ssaevent.crud.graphql.EventStatus.valueOf(getItemAsString("eventStatus", eventMap)));
                clientEvent.setStartDt(getItemAsOffSetDate("startDate", eventMap));
                clientEvent.setEndDt(getItemAsOffSetDate("endDate", eventMap));
                clientEvent.setDescription(getItemAsString("eventDesc", eventMap));
                clientEvent.setInternalNotes(getItemAsString("internalNotes", eventMap));
                clientEvent.setEventPostingId(getItemAsString("eventPostingId", eventMap));
                clientEvent.setVersion(getItemAsLong("version", eventMap));

                resultItem = clientEvent;
            }
            else
            {
                atlas.ssaevent.crud.graphql.Event clientEvent = new atlas.ssaevent.crud.graphql.Event();
                Map<String, Object> eventMap = (Map) model;
                clientEvent.setEventUuid(getItemAsString("eventUuid", eventMap));
                clientEvent.setClassificationMarking(getItemAsString("classificationMarking", eventMap));
                clientEvent.setPredecessorEventUuid(getItemAsString("predecessorEventUuid", eventMap));
                clientEvent.setType(atlas.ssaevent.crud.graphql.EventType.valueOf(getItemAsString("eventType", eventMap)));
                clientEvent.setName(getItemAsString("eventName", eventMap));
                clientEvent.setStatus(atlas.ssaevent.crud.graphql.EventStatus.valueOf(getItemAsString("eventStatus", eventMap)));
                clientEvent.setStartDt(getItemAsOffSetDate("startDate", eventMap));
                clientEvent.setEndDt(getItemAsOffSetDate("endDate", eventMap));
                clientEvent.setDescription(getItemAsString("eventDesc", eventMap));
                clientEvent.setInternalNotes(getItemAsString("internalNotes", eventMap));
                clientEvent.setEventPostingId(getItemAsString("eventPostingId", eventMap));
                clientEvent.setCreateDate(getItemAsOffSetDate("createDate", eventMap));
                clientEvent.setCreateOrigin(getItemAsString("createOrgin", eventMap));
                clientEvent.setUpdateDate(getItemAsOffSetDate("updateDate", eventMap));
                clientEvent.setUpdateOrigin(getItemAsString("updateOrgin", eventMap));
                clientEvent.setVersion(getItemAsLong("version", eventMap));

                Map<String, Object> eventDataMap = (Map) eventMap.get("eventData");

                if (eventDataMap != null)
                {
                    atlas.ssaevent.crud.graphql.EventData clientEventDataSubItem = (atlas.ssaevent.crud.graphql.EventData)eventDataParser.toGraphqlClient(eventDataMap, inputMode);
                    List<atlas.ssaevent.crud.graphql.EventData> clientEventDataList = new ArrayList<>();
                    clientEventDataList.add(clientEventDataSubItem);
                    clientEvent.setEventData(clientEventDataList);
                }

                resultItem = clientEvent;
            }
        }

        return resultItem;
    }
}