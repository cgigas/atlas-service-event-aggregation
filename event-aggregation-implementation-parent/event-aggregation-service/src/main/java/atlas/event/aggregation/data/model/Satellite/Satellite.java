package atlas.event.aggregation.data.model.Satellite;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Satellite extends Audited implements Serializable
{
    private String satelliteUuid;
    private String ownerCode;
    private String classificationMarking;
    private int satNo;
    private String satNoVersion;
    private String commonName;
    private String intlDesignator;
    private Category category;
    private String note;
    private DateTime catalogDate;
    private boolean renumberFlag;
    private String templateSatelliteUuid;
    private DateTime createDate;
    private String createOrigin;
    private DateTime updateDate;
    private String updateOrigin;
    private Long version;
    private SatelliteData satelliteData;
    private SatLaunch satLaunch;
    private SatDecay satDecay;
    private IntegratorControls integratorControls;
    private PerturbationControls perturbationControls;
    private DcControls dcControls;
    private DcTolerances dcTolerances;
    private ControlsTemplateCriteria controlsTemplateCriteria;
    private ElementConversionControls elementConversionControls;
    private SatObsAssociationControl satObsAssociationControl;
    private CurrentRcs currentRcs;
    private CurrentVismag currentVismag;
}
class ControlsTemplateCriteria
{
    ctrlsTemplateCriteriaUuid: String!
    classificationMarking: String!
    satelliteUuid: String!
    name: String!
    perigeeLowerBound: NonNegativeFloat!
    perigeeUpperBound: NonNegativeFloat!
    eccentricityLowerBound: NonNegativeFloat!
    eccentricityUpperBound: NonNegativeFloat!
    objectType: ObjectType!
    category: Category!
    ssaEventType: SsaEventType
    createDate: DateTime
    createOrigin: String
    updateDate: DateTime
    updateOrigin: String
    version: Long
}
class DcTolerances
{
    satelliteUuid: String!
    classificationMarking: String!
    suspendMaintFlag: Boolean!
    minTimeBetweenDcs: NonNegativeFloat!
    minObservations: NonNegativeInt!
    minTracks: NonNegativeInt!
    minResidualAcceptance: NonNegativeFloat!
    maxFitRms: NonNegativeFloat!
    minObsForModelParamSol: NonNegativeInt!
    minTracksForModelParamSol: NonNegativeInt!
    baseMaintenanceParameter: BaseMaintenanceParameter!
    maxWeightedRms: Float!
    eventRecoveryWindow: NonNegativeFloat!
    eventExitThreshold: NonNegativeFloat!
    satTemplateType: SatTemplateType!
    sendEpgFlag: Boolean!
    highInterestFlag: Boolean!
    allowableTimeForUpdate: NonNegativeFloat!
    latencyTimeForPasses: NonNegativeFloat!
    maximumTimeBeforeUpdate: NonNegativeFloat!
    minimumTimeBeforeUpdate: NonNegativeFloat!
    numPassesReqBeforeUpdate: NonNegativeInt!
    updWithAfsssFencePassFlag: Boolean!
    createDate: DateTime
    createOrigin: String
    updateDate: DateTime
    updateOrigin: String
    version: Long
}