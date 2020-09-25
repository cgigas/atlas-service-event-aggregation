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
package atlas.event.aggregation.data.model.ssaevent;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EventTest
{
    Event task = new Event();
    long serialVersionUID = -2933110789647766059L;
    String ssaEventUuid = "ssaEventUuid";
    String classificationMarking = "classificationMarking";
    String state = "state";
    String ssaPredecessorEventUuid = "ssaPredecessorEventUuid";
    Long eventType = 2L;
    String eventName = "eventName";
    Long eventStatus = 3L;
    OffsetDateTime startDt = OffsetDateTime.now();
    OffsetDateTime endDt = OffsetDateTime.of(2020, 10, 1, 1, 1, 1, 1, ZoneOffset.UTC);
    String eventDesc = "eventDesc";
    Boolean bigBoardFlag = true;
    String internalNotes = "internalNotes";
    String eventPostingId = "eventPostingId";

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setState()
    {
        task.setState(state);
        assertEquals(state, task.getState());
    }

    @Test
    void setSsaPredecessorEventUuid()
    {
        task.setSsaPredecessorEventUuid(ssaPredecessorEventUuid);
        assertEquals(ssaPredecessorEventUuid, task.getSsaPredecessorEventUuid());
    }

    @Test
    void setStartDt()
    {
        task.setStartDt(startDt);
        assertEquals(startDt, task.getStartDt());
    }

    @Test
    void setEndDt()
    {
        task.setEndDt(endDt);
        assertEquals(endDt, task.getEndDt());
    }

    @Test
    void setEventType()
    {
        task.setEventType(eventType);
        assertEquals(eventType, task.getEventType());
    }

    @Test
    void setEventName()
    {
        task.setEventName(eventName);
        assertEquals(eventName, task.getEventName());
    }

    @Test
    void setEventStatus()
    {
        task.setEventStatus(eventStatus);
        assertEquals(eventStatus, task.getEventStatus());
    }

    @Test
    void setEventDesc()
    {
        task.setEventDesc(eventDesc);
        assertEquals(eventDesc, task.getEventDesc());
    }

    @Test
    void setBigBoardFlag()
    {
        task.setBigBoardFlag(bigBoardFlag);
        assertTrue(task.getBigBoardFlag());
    }

    @Test
    void setInternalNotes()
    {
        task.setInternalNotes(internalNotes);
        assertEquals(internalNotes, task.getInternalNotes());
    }

    @Test
    void setEventPostingId()
    {
        task.setEventPostingId(eventPostingId);
        assertEquals(eventPostingId, task.getEventPostingId());
    }

    @Test
    void setId()
    {
        task.setId(ssaEventUuid);
        assertEquals(ssaEventUuid, task.getId());
        assertEquals(serialVersionUID, Event.getSerialVersionUID());
    }
}