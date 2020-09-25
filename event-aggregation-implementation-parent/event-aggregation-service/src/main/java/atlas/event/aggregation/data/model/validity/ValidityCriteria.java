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
package atlas.event.aggregation.data.model.validity;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ValidityCriteria extends Audited 
{
    @Id
    private String validityCriteriaUuid;
    private String classificationMarking;
    private Integer analystMinTrackersPerDay;
    private Integer catalogMinTrackersPerDay;
    private Integer analystMinTracksReceived;
    private Integer catalogMinTracksReceived;
    private Integer analystMinODSolutions;
    private Integer catalogMinODSolutions;
    private Integer analystRmsTrendMean;
    private Integer catalogRmsTrendMean;
    private Integer analystRmsTrendSd;
    private Integer catalogStandardDeviation;
    private Integer analystMinResidualAcceptance;
    private Integer catalogMinResidualAcceptance;
    private Integer analystMinArgumentLatitude;
    private Integer catalogMinArgumentLatitude;
    private Integer analystMinReportingSensors;
    private Integer catalogMinReportingSensors;

    public String getValidityCriteriaUuid()
    {
        return validityCriteriaUuid;
    }

    public void setValidityCriteriaUuid(String validityCriteriaUuid)
    {
        this.validityCriteriaUuid = validityCriteriaUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public Integer getAnalystMinTrackersPerDay()
    {
        return analystMinTrackersPerDay;
    }

    public void setAnalystMinTrackersPerDay(Integer analystMinTrackersPerDay)
    {
        this.analystMinTrackersPerDay = analystMinTrackersPerDay;
    }

    public Integer getCatalogMinTrackersPerDay()
    {
        return catalogMinTrackersPerDay;
    }

    public void setCatalogMinTrackersPerDay(Integer catalogMinTrackersPerDay)
    {
        this.catalogMinTrackersPerDay = catalogMinTrackersPerDay;
    }

    public Integer getAnalystMinTracksReceived()
    {
        return analystMinTracksReceived;
    }

    public void setAnalystMinTracksReceived(Integer analystMinTracksReceived)
    {
        this.analystMinTracksReceived = analystMinTracksReceived;
    }

    public Integer getCatalogMinTracksReceived()
    {
        return catalogMinTracksReceived;
    }

    public void setCatalogMinTracksReceived(Integer catalogMinTracksReceived)
    {
        this.catalogMinTracksReceived = catalogMinTracksReceived;
    }

    public Integer getAnalystMinODSolutions()
    {
        return analystMinODSolutions;
    }

    public void setAnalystMinODSolutions(Integer analystMinODSolutions)
    {
        this.analystMinODSolutions = analystMinODSolutions;
    }

    public Integer getCatalogMinODSolutions()
    {
        return catalogMinODSolutions;
    }

    public void setCatalogMinODSolutions(Integer catalogMinODSolutions)
    {
        this.catalogMinODSolutions = catalogMinODSolutions;
    }

    public Integer getAnalystRmsTrendMean()
    {
        return analystRmsTrendMean;
    }

    public void setAnalystRmsTrendMean(Integer analystRmsTrendMean)
    {
        this.analystRmsTrendMean = analystRmsTrendMean;
    }

    public Integer getCatalogRmsTrendMean()
    {
        return catalogRmsTrendMean;
    }

    public void setCatalogRmsTrendMean(Integer catalogRmsTrendMean)
    {
        this.catalogRmsTrendMean = catalogRmsTrendMean;
    }

    public Integer getAnalystRmsTrendSd()
    {
        return analystRmsTrendSd;
    }

    public void setAnalystRmsTrendSd(Integer analystRmsTrendSd)
    {
        this.analystRmsTrendSd = analystRmsTrendSd;
    }

    public Integer getCatalogStandardDeviation()
    {
        return catalogStandardDeviation;
    }

    public void setCatalogStandardDeviation(Integer catalogStandardDeviation)
    {
        this.catalogStandardDeviation = catalogStandardDeviation;
    }

    public Integer getAnalystMinResidualAcceptance()
    {
        return analystMinResidualAcceptance;
    }

    public void setAnalystMinResidualAcceptance(Integer analystMinResidualAcceptance)
    {
        this.analystMinResidualAcceptance = analystMinResidualAcceptance;
    }

    public Integer getCatalogMinResidualAcceptance()
    {
        return catalogMinResidualAcceptance;
    }

    public void setCatalogMinResidualAcceptance(Integer catalogMinResidualAcceptance)
    {
        this.catalogMinResidualAcceptance = catalogMinResidualAcceptance;
    }

    public Integer getAnalystMinArgumentLatitude()
    {
        return analystMinArgumentLatitude;
    }

    public void setAnalystMinArgumentLatitude(Integer analystMinArgumentLatitude)
    {
        this.analystMinArgumentLatitude = analystMinArgumentLatitude;
    }

    public Integer getCatalogMinArgumentLatitude()
    {
        return catalogMinArgumentLatitude;
    }

    public void setCatalogMinArgumentLatitude(Integer catalogMinArgumentLatitude)
    {
        this.catalogMinArgumentLatitude = catalogMinArgumentLatitude;
    }

    public Integer getAnalystMinReportingSensors()
    {
        return analystMinReportingSensors;
    }

    public void setAnalystMinReportingSensors(Integer analystMinReportingSensors)
    {
        this.analystMinReportingSensors = analystMinReportingSensors;
    }

    public Integer getCatalogMinReportingSensors()
    {
        return catalogMinReportingSensors;
    }

    public void setCatalogMinReportingSensors(Integer catalogMinReportingSensors)
    {
        this.catalogMinReportingSensors = catalogMinReportingSensors;
    }
}
