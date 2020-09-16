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
package atlas.event.aggregation.data.model.eventfolder;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Stores template event processing configuration data for potential application to future like-kind events.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventFolder extends Audited
{
    /**
     *
     */
    @Id
    private String eventFolderUuid;

    /**
     *
     */
    private String classificationMarking;

    /**
     * Reference to the source/origin event processing configuration
     * data upon which the data in the event folder is based.
     */
    @NotNull
    private String eventProcessingConfigUuid;

    /**
     * Event folder identifier.
     */
    @NotNull
    private Integer id;

    /**
     * Year for which the folder is applicable.  Not necessarily the same as the epoch.
     */
    private Date year;

    /**
     * Abbreviated name assigned to the event folder.
     */
    @NotNull
    private String shortName;

    /**
     * Brief description of the event folder contents.
     */
    private String description;

    /**
     * Remarks about the event folder.
     */
    private String remarks;

    public String getEventFolderUuid()
    {
        return eventFolderUuid;
    }

    public void setEventFolderUuid(String eventFolderUuid)
    {
        this.eventFolderUuid = eventFolderUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getEventProcessingConfigUuid()
    {
        return eventProcessingConfigUuid;
    }

    public void setEventProcessingConfigUuid(String eventProcessingConfigUuid)
    {
        this.eventProcessingConfigUuid = eventProcessingConfigUuid;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getYear()
    {
        return year;
    }

    public void setYear(Date year)
    {
        this.year = year;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}
