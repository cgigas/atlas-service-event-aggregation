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
package atlas.event.aggregation.data.model.event;

import org.junit.Test;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import static org.junit.Assert.assertEquals;

public class EventTest
{
    Event task = new Event();
    long serialVersionUID = -2933110789647766059L;
    String eventUuid = "ssaEventUuid";
    String classificationMarking = "classificationMarking";
    EventState eventState = EventState.ACTIVE;
    String predecessorEventUuid = "ssaPredecessorEventUuid";
    EventType eventType = EventType.MANEUVER;
    String eventName = "eventName";
    EventStatus eventStatus = EventStatus.ACTIVE;
    OffsetDateTime startDt = OffsetDateTime.now();
    OffsetDateTime endDt = OffsetDateTime.of(2020, 10, 1, 1, 1, 1, 1, ZoneOffset.UTC);
    String eventDesc = "eventDesc";
    Boolean bigBoardFlag = true;
    String internalNotes = "internalNotes";
    String eventPostingId = "eventPostingId";

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setState()
    {
        task.setEventState(eventState);
        assertEquals(eventState, task.getEventState());
    }

    @Test
    public void setSsaPredecessorEventUuid()
    {
        task.setPredecessorEventUuid(predecessorEventUuid);
        assertEquals(predecessorEventUuid, task.getPredecessorEventUuid());
    }

    @Test
    public void setStartDt()
    {
        task.setStartDate(startDt);
        assertEquals(startDt, task.getStartDate());
    }

    @Test
    public void setEndDate()
    {
        task.setEndDate(endDt);
        assertEquals(endDt, task.getEndDate());
    }

    @Test
    public void setEventType()
    {
        task.setEventType(eventType);
        assertEquals(eventType, task.getEventType());
    }

    @Test
    public void setEventName()
    {
        task.setEventName(eventName);
        assertEquals(eventName, task.getEventName());
    }

    @Test
    public void setEventStatus()
    {
        task.setEventStatus(eventStatus);
        assertEquals(eventStatus, task.getEventStatus());
    }

    @Test
    public void setEventDesc()
    {
        task.setDescription(eventDesc);
        assertEquals(eventDesc, task.getDescription());
    }

    @Test
    public void setInternalNotes()
    {
        task.setInternalNotes(internalNotes);
        assertEquals(internalNotes, task.getInternalNotes());
    }

    @Test
    public void setEventPostingId()
    {
        task.setEventPostingId(eventPostingId);
        assertEquals(eventPostingId, task.getEventPostingId());
    }

    @Test
    public void setId()
    {
        task.setEventUuid(eventUuid);
        assertEquals(eventUuid, task.getEventUuid());
    }
}