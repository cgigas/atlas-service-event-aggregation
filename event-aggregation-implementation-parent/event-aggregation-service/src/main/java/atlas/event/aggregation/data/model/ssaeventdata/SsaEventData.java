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
package atlas.event.aggregation.data.model.ssaeventdata;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SsaEventData extends Audited
{
    /**
     * UUID of the associated SSA event.
     */
    @Id
    private String ssaEventDataUuid;

    /**
     * Security classification marking of the data in one row of this table in the form of a paragraph marking
     */
    @NotNull
    private String classificationMarking;

    /**
     * UUID of the associated SSA event.
     */
    @NotNull
    private String ssaEventUuid;

    /**
     * Name or title of the supplementary data.
     */
    @NotNull
    private String eventDataName;

    /**
     * Used to identify the type or file extension for the event data, e.g., .pdf, .docx, .txt.
     */
    private String eventDataType;

    /**
     * Raw binary or character supplementary data (optional).
     */
    private Blob eventData;

    public String getSsaEventDataUuid()
    {
        return ssaEventDataUuid;
    }

    public void setSsaEventDataUuid(String ssaEventDataUuid)
    {
        this.ssaEventDataUuid = ssaEventDataUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getSsaEventUuid()
    {
        return ssaEventUuid;
    }

    public void setSsaEventUuid(String ssaEventUuid)
    {
        this.ssaEventUuid = ssaEventUuid;
    }

    public String getEventDataName()
    {
        return eventDataName;
    }

    public void setEventDataName(String eventDataName)
    {
        this.eventDataName = eventDataName;
    }

    public String getEventDataType()
    {
        return eventDataType;
    }

    public void setEventDataType(String eventDataType)
    {
        this.eventDataType = eventDataType;
    }

    public Blob getEventData()
    {
        return eventData;
    }

    public void setEventData(Blob eventData)
    {
        this.eventData = eventData;
    }
}