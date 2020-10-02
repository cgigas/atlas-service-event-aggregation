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
package atlas.event.aggregation.data.model.eventprocessing;

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
public class EventProcessingConfiguration extends Audited
{

    @Id
    private String eventProcessingConfigUuid;

    /**
     * Reference to the associated event to which the configuration applies.
     */
    private String classificationMarking;

    /**
     * Reference to the associated event to which the configuration applies
     */
    @NotNull
    private String ssaEventUuid;

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
     *
     */
    @NotNull
    private String validityCriteriaUuid;

    /**
     * Indicator as to whether the event processing configuraiton is the current configuraiton applicable to an event (True or False).
     */
    @NotNull
    private Integer currentFlag;

    /**
     * Indicator as to whether the MPE Event data should be saved as an Event Folder for later use as a template for future events similar in nature.
     */
    @NotNull
    private Integer saveAsFolderFlag;

    /**
     * Name provided to the event processing configuration.
     */
    private String name;

    /**
     * Short desciription of the event processing configuration.
     */
    private String description;

    public String getEventProcessingConfigUuid()
    {
        return eventProcessingConfigUuid;
    }

    public void setEventProcessingConfigUuid(String eventProcessingConfigUuid)
    {
        this.eventProcessingConfigUuid = eventProcessingConfigUuid;
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

    public String getValidityCriteriaUuid()
    {
        return validityCriteriaUuid;
    }

    public void setValidityCriteriaUuid(String validityCriteriaUuid)
    {
        this.validityCriteriaUuid = validityCriteriaUuid;
    }

    public Integer getCurrentFlag()
    {
        return currentFlag;
    }

    public void setCurrentFlag(Integer currentFlag)
    {
        this.currentFlag = currentFlag;
    }

    public Integer getSaveAsFolderFlag()
    {
        return saveAsFolderFlag;
    }

    public void setSaveAsFolderFlag(Integer saveAsFolderFlag)
    {
        this.saveAsFolderFlag = saveAsFolderFlag;
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
}
