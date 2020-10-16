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

import atlas.event.aggregation.data.model.Audited;
import atlas.event.aggregation.data.model.GqlSchemaCommon;
import atlas.event.aggregation.data.model.eventdata.EventData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event extends Audited implements Serializable, GqlSchemaCommon
{
    private static final long serialVersionUID = -2933110789647766059L;

    /**
     * Unique identifier
     */
    @Id
    private String eventUuid;

    /**
     * Security classification marking of the data in the form of a paragraph marking.
     */
    @NotNull
    private String classificationMarking;

    private EventState eventState;
    /**
     * Related or preceding SSA event.
     */
    private String predecessorEventUuid;

    /**
     * Identifies the type of Space Situational Awareness event
     */
    @NotNull
    private EventType eventType;

    /**
     * Name, title or designator assigned to the event.
     */
    @NotNull
    private String eventName;

    /**
     * Event status varies by event type
     */
    @NotNull
    private EventStatus eventStatus;

    /**
     * Date/time when the event began or was detected.
     */
    @NotNull
    private OffsetDateTime startDate;

    /**
     * Date/time when the event ended.
     */
    private OffsetDateTime endDate;

    /**
     * Expanded description of the event.
     */
    private String description;

    /**
     * Indicates whether or not this entry is of high interest and should be displayed on the data wall (Big Board).
     */
    private Boolean bigBoardFlag;

    /**
     * Optional analyst remarks section.
     */
    private String internalNotes;

    /**
     * Contains an identifier associated with the posting of this event to an external system, such as SKIWeb.
     */
    private String eventPostingId;

    private List<EventData> eventData;

    public List<EventData> getEventData()
    {
        if (eventData == null)
        {
            eventData = new ArrayList<>();
        }

        return eventData;
    }

    public void setEventData(List<EventData> eventData)
    {
        this.eventData = eventData;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public EventState getEventState()
    {
        return eventState;
    }

    public void setEventState(EventState eventState)
    {
        this.eventState = eventState;
    }

    public String getPredecessorEventUuid()
    {
        return predecessorEventUuid;
    }

    public void setPredecessorEventUuid(String predecessorEventUuid)
    {
        this.predecessorEventUuid = predecessorEventUuid;
    }

    public EventType getEventType()
    {
        return eventType;
    }


    public OffsetDateTime getStartDate()
    {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate)
    {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate()
    {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate)
    {
        this.endDate = endDate;
    }

    public void setEventType(EventType eventType)
    {
        this.eventType = eventType;
    }

    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public EventStatus getEventStatus()
    {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus)
    {
        this.eventStatus = eventStatus;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Boolean getBigBoardFlag()
    {
        return bigBoardFlag;
    }

    public void setBigBoardFlag(Boolean bigBoardFlag)
    {
        this.bigBoardFlag = bigBoardFlag;
    }

    public String getEventUuid()
    {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid)
    {
        this.eventUuid = eventUuid;
    }

    public String getInternalNotes()
    {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes)
    {
        this.internalNotes = internalNotes;
    }

    public String getEventPostingId()
    {
        return eventPostingId;
    }

    public void setEventPostingId(String eventPostingId)
    {
        this.eventPostingId = eventPostingId;
    }

    @Override
    public String getId()
    {
        return eventUuid;
    }

    @Override
    public void setId(Object o)
    {
        eventUuid = (String) o;
    }
}
