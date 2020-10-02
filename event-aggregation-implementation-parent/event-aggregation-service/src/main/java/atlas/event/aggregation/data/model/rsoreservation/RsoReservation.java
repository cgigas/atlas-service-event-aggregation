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
package atlas.event.aggregation.data.model.rsoreservation;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RsoReservation extends Audited
{
    /**
     * UUID assigned to this titled numbering range or group.
     */
    @Id
    private String rsoReservationUuid;

    /**
     * Security classification marking of the data in one row of this table in the form of a paragraph marking.
     */
    @NotNull
    private String classificationMarking;

    /**
     * Parent reservation. All top-level, hybrid satellite ranges have a null parent reservation and are used to carve out the master range values
     */
    private String parentRsoReservationUuid;

    /**
     * Identifies the broad type or category of RSO number
     */
    @NotNull
    private String category;

    /**
     * Indicates whether or not this range is compatible with the legacy 5-digit RSO numbering conventions.
     */
    @NotNull
    private Float legacyCompatibleFlag;

    /**
     * Title of the reservation.
     */
    @NotNull
    private String title;

    /**
     * Identifies any JSpOC operational support cell or division
     */
    private String position;

    /**
     * SSA event type
     */
    private String sdaEventType;

    /**
     * Lower bound of a satellite numbering range.
     */
    @NotNull
    private Integer minSatNo;

    /**
     * Upper bound of a satellite numbering range.
     */
    @NotNull
    private Integer  maxSatNo;

    /**
     * Lower bound of a UCN included in this reservation.
     */
    private Integer minUcn;

    /**
     * Upper bound of a UCN included in this reservation.
     */
    private Integer maxUcn;

    /**
     * Brief description for the functional use of the range.
     */
    private String description;

    /**
     * Indicates whether or not this reservation can be released.
     */
    @NotNull
    private String releaseableFlag;

    /**
     * Indicates whether or not RSO numbers within this range may be physically deleted.
     */
    @NotNull
    private Float deletableFlag;

    /**
     * Provides the recommended minimum classification range (U, C, S, TS) for ephemerides stored within this RSO range.
     */
    private Integer minClassification;

    /**
     * Provides the recommended maximum classification range (U, C, S, TS) for ephemerides stored within this RSO range.
     */
    private Integer  maxClassification;

    public String getRsoReservationUuid()
    {
        return rsoReservationUuid;
    }

    public void setRsoReservationUuid(String rsoReservationUuid)
    {
        this.rsoReservationUuid = rsoReservationUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getParentRsoReservationUuid()
    {
        return parentRsoReservationUuid;
    }

    public void setParentRsoReservationUuid(String parentRsoReservationUuid)
    {
        this.parentRsoReservationUuid = parentRsoReservationUuid;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public Float getLegacyCompatibleFlag()
    {
        return legacyCompatibleFlag;
    }

    public void setLegacyCompatibleFlag(Float legacyCompatibleFlag)
    {
        this.legacyCompatibleFlag = legacyCompatibleFlag;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getSdaEventType()
    {
        return sdaEventType;
    }

    public void setSdaEventType(String sdaEventType)
    {
        this.sdaEventType = sdaEventType;
    }

    public Integer getMinSatNo()
    {
        return minSatNo;
    }

    public void setMinSatNo(Integer minSatNo)
    {
        this.minSatNo = minSatNo;
    }

    public Integer getMaxSatNo()
    {
        return maxSatNo;
    }

    public void setMaxSatNo(Integer maxSatNo)
    {
        this.maxSatNo = maxSatNo;
    }

    public Integer getMinUcn()
    {
        return minUcn;
    }

    public void setMinUcn(Integer minUcn)
    {
        this.minUcn = minUcn;
    }

    public Integer getMaxUcn()
    {
        return maxUcn;
    }

    public void setMaxUcn(Integer maxUcn)
    {
        this.maxUcn = maxUcn;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getReleaseableFlag()
    {
        return releaseableFlag;
    }

    public void setReleaseableFlag(String releaseableFlag)
    {
        this.releaseableFlag = releaseableFlag;
    }

    public Float getDeletableFlag()
    {
        return deletableFlag;
    }

    public void setDeletableFlag(Float deletableFlag)
    {
        this.deletableFlag = deletableFlag;
    }

    public Integer getMinClassification()
    {
        return minClassification;
    }

    public void setMinClassification(Integer minClassification)
    {
        this.minClassification = minClassification;
    }

    public Integer getMaxClassification()
    {
        return maxClassification;
    }

    public void setMaxClassification(Integer maxClassification)
    {
        this.maxClassification = maxClassification;
    }
}
