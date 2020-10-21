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
import atlas.event.aggregation.data.model.ssaeventsat.EventSatellite;
import atlas.event.aggregation.data.model.ssaeventsat.Relationship;
import atlas.ssaevent.crud.graphql.EventRelationship;
import atlas.ssaevent.crud.graphql.EventSatInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EventSatelliteParser extends EventMasterParser
{
    @Autowired
    private EventParser eventParser;


    @Override
    public Object fromGraphqlClient(Object graphql)
    {
        EventSatellite eventSatellite = null;
        if ((graphql != null) && (graphql instanceof atlas.ssaevent.crud.graphql.EventSat))
        {
            eventSatellite = new EventSatellite();
            atlas.ssaevent.crud.graphql.EventSat crudEventSat = (atlas.ssaevent.crud.graphql.EventSat) graphql;
            eventSatellite.setEventSatUuid(crudEventSat.getEventSatUuid());
            eventSatellite.setSatelliteUuid(crudEventSat.getSatelliteUuid());
            eventSatellite.setUcn(crudEventSat.getUcn().longValue());
            eventSatellite.setRelationship(Relationship.valueOf(crudEventSat.getRelationship().name()));
            eventSatellite.setVersion(crudEventSat.getVersion());
            if (crudEventSat.getEvent() != null)
            {
                eventSatellite.setEvent((Event) eventParser.fromGraphqlClient(crudEventSat.getEvent()));
            }
        }
        return eventSatellite;
    }

    @Override
    public Object toGraphqlClient(Object model, Boolean inputMode)
    {
        EventSatInput crudEventSat = new EventSatInput();

        if ((model != null) && (model instanceof Map))
        {
            Map<String, Object> eventSatMap = (Map) model;
            crudEventSat.setSatelliteUuid(getItemAsString("satelliteUuid", eventSatMap));
            crudEventSat.setEventUuid(getItemAsString("eventUuid", eventSatMap));
            crudEventSat.setRelationship(EventRelationship.valueOf(getItemAsString("relationship", eventSatMap)));
            crudEventSat.setUcn(getItemAsInteger("ucn", eventSatMap));
            crudEventSat.setVersion(getItemAsLong("version", eventSatMap));
        }

        return crudEventSat;
    }

    private Relationship findRelationship(Integer relationshipNumber)
    {
        Relationship relationship = null;
        if (relationshipNumber != null)
        {
            switch (relationshipNumber)
            {
                case 0:
                    relationship = Relationship.PARENT;
                    break;
                case 1:
                    relationship = Relationship.CHILD;
                    break;
                case 2:
                    relationship = Relationship.ACTOR;
                    break;
                case 3:
                    relationship = Relationship.TARGET;
                    break;
                case 4:
                    relationship = Relationship.PRIMARY;
                    break;
                case 5:
                    relationship = Relationship.SECONDARY;
                    break;
            }
        }

        return relationship;
    }
}