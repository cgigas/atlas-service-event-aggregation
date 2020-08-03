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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Records various types of Space Situational Awareness events across the system, including LAUNCH, BREAKUP, REENTRY,
 * DEORBIT, DECAY, PROXIMITY, RENDEZVOUS, SEPARATION, DOCKING, EMI, and CA. SSA events can be recorded against
 * one or many satellites.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SsaEvent extends Audited implements Serializable
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
    private Date startDt;

    /**
     * Date/time when the event ended.
     */
    private Date endDt;

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
}
