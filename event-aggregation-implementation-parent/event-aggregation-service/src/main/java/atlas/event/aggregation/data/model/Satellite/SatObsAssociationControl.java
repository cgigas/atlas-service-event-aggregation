package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class SatObsAssociationControl
{
    String satObsAssocControlUuid;
    String classificationMarking;
    String satelliteUuid;
    String retagPriorityUuid;
    RetagPriority retagPriority;
    Float gpDeltaTimeThreshold;
    Float gpDeltaBetaThreshold;
    Float gpDeltaHeightThreshold;
    Float gpDeltaTimeMultiplier;
    Float gpDeltaBetaMultiplier;
    Float gpDeltaHeightMultiplier;
    Float spDeltaTimeThreshold;
    Float spDeltaBetaThreshold;
    Float spDeltaHeightThreshold;
    Float spDeltaTimeMultiplier;
    Float spDeltaBetaMultiplier;
    Float spDeltaHeightMultiplier;
    Float chiMultiplier;
    Float covarianceValidityLimit;
    Float grossBetaLimit;
    Boolean forceTagIndicator;
    Boolean considerProphylacticCrosstag;
    Boolean autoNotifyFlag;
    Boolean usePredictionErrorModel;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
