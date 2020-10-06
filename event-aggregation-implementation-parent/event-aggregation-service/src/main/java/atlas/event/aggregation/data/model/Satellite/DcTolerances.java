package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class DcTolerances
{
    String satelliteUuid;
    String classificationMarking;
    Boolean suspendMaintFlag;
    Float minTimeBetweenDcs;
    int minObservations;
    int minTracks;
    Float minResidualAcceptance;
    Float maxFitRms;
    int minObsForModelParamSol;
    int minTracksForModelParamSol;
    BaseMaintenanceParameter baseMaintenanceParameter;
    Float maxWeightedRms;
    Float eventRecoveryWindow;
    Float eventExitThreshold;
    SatTemplateType satTemplateType;
    Boolean sendEpgFlag;
    Boolean highInterestFlag;
    Float allowableTimeForUpdate;
    Float latencyTimeForPasses;
    Float maximumTimeBeforeUpdate;
    Float minimumTimeBeforeUpdate;
    int numPassesReqBeforeUpdate;
    Boolean updWithAfsssFencePassFlag;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
