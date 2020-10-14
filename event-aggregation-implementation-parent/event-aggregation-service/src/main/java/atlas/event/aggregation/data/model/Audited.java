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
package atlas.event.aggregation.data.model;

import atlas.event.aggregation.data.model.event.Versioned;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.OffsetDateTime;

@ToString(callSuper = true)
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Audited extends Versioned
{
    /**
     * Entry creation date..
     */
    private OffsetDateTime createDate;

    /**
     * Origin or source of the entry..
     */
    private String createOrigin;

    /**
     * Date of last update..
     */
    private OffsetDateTime updateDate;

    /**
     * Origin or source of the last update..
     */
    private String updateOrigin;

    public OffsetDateTime getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateOrigin()
    {
        return createOrigin;
    }

    public void setCreateOrigin(String createOrigin)
    {
        this.createOrigin = createOrigin;
    }

    public OffsetDateTime getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate)
    {
        this.updateDate = updateDate;
    }

    public String getUpdateOrigin()
    {
        return updateOrigin;
    }

    public void setUpdateOrigin(String updateOrigin)
    {
        this.updateOrigin = updateOrigin;
    }
}
