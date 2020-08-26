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

import atlas.event.aggregation.data.model.Audited;
import atlas.event.aggregation.data.model.GqlSchemaCommon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SsaEvent extends Audited implements Serializable, GqlSchemaCommon
{
    private static final long serialVersionUID = -2933110789647766059L;

    /**
     * Unique identifier
     */
    @Id
    private String ssaEventUuid;

    /**
     * Security classification marking of the data in the form of a paragraph marking.
     */
    @NotNull
    private String classificationMarking;

    /**
     * Related or preceding SSA event.
     */
    private String ssaPredecessorEventUuid;

    /**
     * Identifies the type of Space Situational Awareness event
     */
    @NotNull
    private SsaEventType eventType;

    /**
     * Name, title or designator assigned to the event.
     */
    @NotNull
    private String eventName;

    /**
     * Event status varies by event type
     */
    @NotNull
    private SsaEventStatus eventStatus;

    /**
     * Date/time when the event began or was detected.
     */
    @NotNull
    private OffsetDateTime startDt;

    /**
     * Date/time when the event ended.
     */
    private OffsetDateTime endDt;

    /**
     * Expanded description of the event.
     */
    private String eventDesc;

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

    public String getSsaPredecessorEventUuid()
    {
        return ssaPredecessorEventUuid;
    }

    public void setSsaPredecessorEventUuid(String ssaPredecessorEventUuid)
    {
        this.ssaPredecessorEventUuid = ssaPredecessorEventUuid;
    }

    public SsaEventType getEventType()
    {
        return eventType;
    }

    public OffsetDateTime getStartDt()
    {
        return startDt;
    }

    public void setStartDt(OffsetDateTime startDt)
    {
        this.startDt = startDt;
    }

    public OffsetDateTime getEndDt()
    {
        return endDt;
    }

    public void setEndDt(OffsetDateTime endDt)
    {
        this.endDt = endDt;
    }

    public void setEventType(SsaEventType eventType)
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

    public SsaEventStatus getEventStatus()
    {
        return eventStatus;
    }

    public void setEventStatus(SsaEventStatus eventStatus)
    {
        this.eventStatus = eventStatus;
    }

    public String getEventDesc()
    {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc)
    {
        this.eventDesc = eventDesc;
    }

    public Boolean getBigBoardFlag()
    {
        return bigBoardFlag;
    }

    public void setBigBoardFlag(Boolean bigBoardFlag)
    {
        this.bigBoardFlag = bigBoardFlag;
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
        return ssaEventUuid;
    }

    @Override
    public void setId(Object o)
    {
        ssaEventUuid = (String) o;
    }
}
