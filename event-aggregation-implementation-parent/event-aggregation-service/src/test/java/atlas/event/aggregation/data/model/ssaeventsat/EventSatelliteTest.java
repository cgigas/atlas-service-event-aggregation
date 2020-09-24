package atlas.event.aggregation.data.model.ssaeventsat;

import atlas.event.aggregation.data.model.ssaevent.Event;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventSatelliteTest
{
    EventSatellite task = new EventSatellite();
    String eventSatUuid = "event sat uuid";
    String satelliteUuid = "sat uuid";
    Event ssaEvent = new Event();
    Long relationship = 2L;
    Long ucn = 3L;
    Object o = new Object();

    @Test
    void setEventSatUuid()
    {
        task.setEventSatUuid(eventSatUuid);
        assertEquals(eventSatUuid, task.getEventSatUuid());
    }

    @Test
    void setSatelliteUuid()
    {
        task.setSatelliteUuid(satelliteUuid);
        assertEquals(satelliteUuid, task.getSatelliteUuid());
    }

    @Test
    void setSsaEvent()
    {
        task.setSsaEvent(ssaEvent);
        assertEquals(ssaEvent, task.getSsaEvent());
    }

    @Test
    void setRelationship()
    {
        task.setRelationship(relationship);
        assertEquals(relationship, task.getRelationship());
    }

    @Test
    void setUcn()
    {
        task.setUcn(ucn);
        assertEquals(ucn, task.getUcn());
    }

    @Test
    void setId()
    {
        task.setId(o);
        assertNull(task.getId());
    }
}