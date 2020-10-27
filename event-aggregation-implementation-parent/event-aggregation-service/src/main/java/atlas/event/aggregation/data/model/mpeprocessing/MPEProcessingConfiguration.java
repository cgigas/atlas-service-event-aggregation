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
package atlas.event.aggregation.data.model.mpeprocessing;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Outlines how an event is processed to include available RSO satellite numbers, candidate formation parameters,
 * and criteria for moving an RSO along the path from Candidate to Catalog.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MPEProcessingConfiguration extends Audited
{

    @Id
    private String mpeProcessingConfigUuid;

    /**
     * Reference to the associated event to which the configuration applies.
     */
    private String classificationMarking;

    /**
     * Reference to the associated event to which the configuration applies
     */
    @NotNull
    private String eventUuid;

    /**
     * Reference to the associated Analyst  RSO satellite number range.
     */
    private String candidateRsoReservationUuid;

    /**
     * Reference to the associated Analyst  RSO satellite number range.
     */
    @NotNull
    private String analystRsoReservationUuid;

    /**
     * Reference to the associated Catalog RSO satellite number range.
     */
    @NotNull
    private String catalogRsoReservationUuid;

    /**
     * Reference to the associated UCN range.
     */
    @NotNull
    private String ucnReservationUuid;

    /**
     * Reference to the associated Candidate RSO satellite number range.
     */
    @NotNull
    private String candidateFormationParametersUuid;

    /**
     * Indicator as to whether the event processing configuration is the current configuration applicable to an event (True or False).
     */
    @NotNull
    private Boolean currentFlag;

    /**
     * Name provided to the event processing configuration.
     */
    private String name;

    /**
     * Short description of the event processing configuration.
     */
    private String description;

    private Integer analystMinTracksPerDay;
    private Integer catalogMinTracksPerDay;
    private Integer analystMinTracksReceived;
    private Integer catalogMinTracksReceived;
    private Integer analystMinOdSolutions;
    private Integer catalogMinOdSolutions;
    private Double analystRmsTrendMean;
    private Double catalogRmsTrendMean;
    private Double analystRmsTrendSd;
    private Double catalogRmsTrendSd;
    private Double analystMinResidualAcceptance;
    private Double catalogMinResidualAcceptance;
    private Double analystMinArgumentLatitude;
    private Double catalogMinArgumentLatitude;
    private Integer analystMinReportingSensors;
    private Integer catalogMinReportingSensors;

    public String getMpeProcessingConfigUuid()
    {
        return mpeProcessingConfigUuid;
    }

    public void setMpeProcessingConfigUuid(String mpeProcessingConfigUuid)
    {
        this.mpeProcessingConfigUuid = mpeProcessingConfigUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getEventUuid()
    {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid)
    {
        this.eventUuid = eventUuid;
    }

    public String getCandidateRsoReservationUuid()
    {
        return candidateRsoReservationUuid;
    }

    public void setCandidateRsoReservationUuid(String candidateRsoReservationUuid)
    {
        this.candidateRsoReservationUuid = candidateRsoReservationUuid;
    }

    public String getAnalystRsoReservationUuid()
    {
        return analystRsoReservationUuid;
    }

    public void setAnalystRsoReservationUuid(String analystRsoReservationUuid)
    {
        this.analystRsoReservationUuid = analystRsoReservationUuid;
    }

    public String getCatalogRsoReservationUuid()
    {
        return catalogRsoReservationUuid;
    }

    public void setCatalogRsoReservationUuid(String catalogRsoReservationUuid)
    {
        this.catalogRsoReservationUuid = catalogRsoReservationUuid;
    }

    public String getUcnReservationUuid()
    {
        return ucnReservationUuid;
    }

    public void setUcnReservationUuid(String ucnReservationUuid)
    {
        this.ucnReservationUuid = ucnReservationUuid;
    }

    public String getCandidateFormationParametersUuid()
    {
        return candidateFormationParametersUuid;
    }

    public void setCandidateFormationParametersUuid(String candidateFormationParametersUuid)
    {
        this.candidateFormationParametersUuid = candidateFormationParametersUuid;
    }

    public Boolean getCurrentFlag()
    {
        return currentFlag;
    }

    public void setCurrentFlag(Boolean currentFlag)
    {
        this.currentFlag = currentFlag;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getAnalystMinTracksPerDay()
    {
        return analystMinTracksPerDay;
    }

    public void setAnalystMinTracksPerDay(Integer analystMinTracksPerDay)
    {
        this.analystMinTracksPerDay = analystMinTracksPerDay;
    }

    public Integer getCatalogMinTracksPerDay()
    {
        return catalogMinTracksPerDay;
    }

    public void setCatalogMinTracksPerDay(Integer catalogMinTracksPerDay)
    {
        this.catalogMinTracksPerDay = catalogMinTracksPerDay;
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

    public Integer getAnalystMinOdSolutions()
    {
        return analystMinOdSolutions;
    }

    public void setAnalystMinOdSolutions(Integer analystMinOdSolutions)
    {
        this.analystMinOdSolutions = analystMinOdSolutions;
    }

    public Integer getCatalogMinOdSolutions()
    {
        return catalogMinOdSolutions;
    }

    public void setCatalogMinOdSolutions(Integer catalogMinOdSolutions)
    {
        this.catalogMinOdSolutions = catalogMinOdSolutions;
    }

    public Double getAnalystRmsTrendMean()
    {
        return analystRmsTrendMean;
    }

    public void setAnalystRmsTrendMean(Double analystRmsTrendMean)
    {
        this.analystRmsTrendMean = analystRmsTrendMean;
    }

    public Double getCatalogRmsTrendMean()
    {
        return catalogRmsTrendMean;
    }

    public void setCatalogRmsTrendMean(Double catalogRmsTrendMean)
    {
        this.catalogRmsTrendMean = catalogRmsTrendMean;
    }

    public Double getAnalystRmsTrendSd()
    {
        return analystRmsTrendSd;
    }

    public void setAnalystRmsTrendSd(Double analystRmsTrendSd)
    {
        this.analystRmsTrendSd = analystRmsTrendSd;
    }

    public Double getCatalogRmsTrendSd()
    {
        return catalogRmsTrendSd;
    }

    public void setCatalogRmsTrendSd(Double catalogRmsTrendSd)
    {
        this.catalogRmsTrendSd = catalogRmsTrendSd;
    }

    public Double getAnalystMinResidualAcceptance()
    {
        return analystMinResidualAcceptance;
    }

    public void setAnalystMinResidualAcceptance(Double analystMinResidualAcceptance)
    {
        this.analystMinResidualAcceptance = analystMinResidualAcceptance;
    }

    public Double getCatalogMinResidualAcceptance()
    {
        return catalogMinResidualAcceptance;
    }

    public void setCatalogMinResidualAcceptance(Double catalogMinResidualAcceptance)
    {
        this.catalogMinResidualAcceptance = catalogMinResidualAcceptance;
    }

    public Double getAnalystMinArgumentLatitude()
    {
        return analystMinArgumentLatitude;
    }

    public void setAnalystMinArgumentLatitude(Double analystMinArgumentLatitude)
    {
        this.analystMinArgumentLatitude = analystMinArgumentLatitude;
    }

    public Double getCatalogMinArgumentLatitude()
    {
        return catalogMinArgumentLatitude;
    }

    public void setCatalogMinArgumentLatitude(Double catalogMinArgumentLatitude)
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
