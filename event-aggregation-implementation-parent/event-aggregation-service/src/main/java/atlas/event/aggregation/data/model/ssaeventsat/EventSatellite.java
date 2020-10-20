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
package atlas.event.aggregation.data.model.ssaeventsat;

import atlas.event.aggregation.data.model.Audited;
import atlas.event.aggregation.data.model.GqlSchemaCommon;
import atlas.event.aggregation.data.model.event.Event;

import java.io.Serializable;

public class EventSatellite extends Audited implements Serializable, GqlSchemaCommon
{
    private String eventSatUuid;
    private String satelliteUuid;
    private Event event;
    private Relationship relationship;
    private Long ucn;

    public String getEventSatUuid()
    {
        return eventSatUuid;
    }

    public void setEventSatUuid(String eventSatUuid)
    {
        this.eventSatUuid = eventSatUuid;
    }

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public Event getEvent()
    {
        return event;
    }

    public void setEvent(Event ssaEvent)
    {
        this.event = ssaEvent;
    }

    public Relationship getRelationship()
    {
        return relationship;
    }

    public void setRelationship(Relationship relationship)
    {
        this.relationship = relationship;
    }

    public Long getUcn()
    {
        return ucn;
    }

    public void setUcn(Long ucn)
    {
        this.ucn = ucn;
    }

    @Override
    public Object getId()
    {
        return null;
    }

    @Override
    public void setId(Object o)
    {

    }
}
