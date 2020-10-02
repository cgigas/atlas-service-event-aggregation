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
package atlas.event.aggregation.data.model.candidateformation;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CandidateFormationParameters extends Audited
{
    /**
     * Unique identifier
     */
    @Id
    private String candidateFormationParametersUuid;

    private Float pdotCoeficients;

    private Float coplanarCheckThreshold;

    private Float periodAssociationThreshold;

    private Integer minimumTrackersPerCluster;

    private Date updateDate;

    private Date createDate;

    private String updateOrigin;

    private String createOrigin;

    private int version;

    public String getCandidateFormationParametersUuid()
    {
        return candidateFormationParametersUuid;
    }

    public void setCandidateFormationParametersUuid(String candidateFormationParametersUuid)
    {
        this.candidateFormationParametersUuid = candidateFormationParametersUuid;
    }

    public Float getPdotCoeficients()
    {
        return pdotCoeficients;
    }

    public void setPdotCoeficients(Float pdotCoeficients)
    {
        this.pdotCoeficients = pdotCoeficients;
    }

    public Float getCoplanarCheckThreshold()
    {
        return coplanarCheckThreshold;
    }

    public void setCoplanarCheckThreshold(Float coplanarCheckThreshold)
    {
        this.coplanarCheckThreshold = coplanarCheckThreshold;
    }

    public Float getPeriodAssociationThreshold()
    {
        return periodAssociationThreshold;
    }

    public void setPeriodAssociationThreshold(Float periodAssociationThreshold)
    {
        this.periodAssociationThreshold = periodAssociationThreshold;
    }

    public Integer getMinimumTrackersPerCluster()
    {
        return minimumTrackersPerCluster;
    }

    public void setMinimumTrackersPerCluster(Integer minimumTrackersPerCluster)
    {
        this.minimumTrackersPerCluster = minimumTrackersPerCluster;
    }


    public Date getUpdateDate()
    {
        return updateDate;
    }


    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }


    public Date getCreateDate()
    {
        return createDate;
    }


    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }


    public String getUpdateOrigin()
    {
        return updateOrigin;
    }


    public void setUpdateOrigin(String updateOrigin)
    {
        this.updateOrigin = updateOrigin;
    }


    public String getCreateOrigin()
    {
        return createOrigin;
    }


    public void setCreateOrigin(String createOrigin)
    {
        this.createOrigin = createOrigin;
    }


    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }
}