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
import atlas.event.aggregation.data.model.candidateformation.CandidateFormationParameters;
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

    @NotNull
    @SuppressWarnings("JpaAttributeTypeInspection")
    private atlas.event.aggregation.data.model.event.Event event;

    /**
     * Reference to the associated Analyst  RSO satellite number range.
     */
    private String candidateRsoReservationUuid;

    /**
     * Reference to the associated Analyst  RSO satellite number range.
     */
    private String analystRsoReservationUuid;

    /**
     * Reference to the associated Catalog RSO satellite number range.
     */
    private String catalogRsoReservationUuid;

    /**
     * Reference to the associated UCN range.
     */
    private String ucnReservationUuid;

    /**
     * Reference to the associated Candidate RSO satellite number range.
     */
    private String candidateFormationParametersUuid;

    @SuppressWarnings("JpaAttributeTypeInspection")
    private CandidateFormationParameters candidateFormationParameters;
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
}