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

import atlas.event.aggregation.data.model.event.Event;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class EventSatelliteTest
{
    EventSatellite task = new EventSatellite();
    String eventSatUuid = "event sat uuid";
    String satelliteUuid = "sat uuid";
    Event ssaEvent = new Event();
    Relationship relationship = Relationship.ACTOR;
    Long ucn = 3L;
    Object o = new Object();

    @Test
    public void setEventSatUuid()
    {
        task.setEventSatUuid(eventSatUuid);
        assertEquals(eventSatUuid, task.getEventSatUuid());
    }

    @Test
    public void setSatelliteUuid()
    {
        task.setSatelliteUuid(satelliteUuid);
        assertEquals(satelliteUuid, task.getSatelliteUuid());
    }

    @Test
    public void setSsaEvent()
    {
        task.setEvent(ssaEvent);
        assertEquals(ssaEvent, task.getEvent());
    }

    @Test
    public void setRelationship()
    {
        task.setRelationship(Relationship.ACTOR);
        assertEquals(relationship, task.getRelationship());
    }

    @Test
    public void setUcn()
    {
        task.setUcn(ucn);
        assertEquals(ucn, task.getUcn());
    }

    @Test
    public void setId()
    {
        task.setId(o);
        assertNull(task.getId());
    }
}