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

    public String getSatObsAssocControlUuid()
    {
        return satObsAssocControlUuid;
    }

    public void setSatObsAssocControlUuid(String satObsAssocControlUuid)
    {
        this.satObsAssocControlUuid = satObsAssocControlUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public String getRetagPriorityUuid()
    {
        return retagPriorityUuid;
    }

    public void setRetagPriorityUuid(String retagPriorityUuid)
    {
        this.retagPriorityUuid = retagPriorityUuid;
    }

    public RetagPriority getRetagPriority()
    {
        return retagPriority;
    }

    public void setRetagPriority(RetagPriority retagPriority)
    {
        this.retagPriority = retagPriority;
    }

    public Float getGpDeltaTimeThreshold()
    {
        return gpDeltaTimeThreshold;
    }

    public void setGpDeltaTimeThreshold(Float gpDeltaTimeThreshold)
    {
        this.gpDeltaTimeThreshold = gpDeltaTimeThreshold;
    }

    public Float getGpDeltaBetaThreshold()
    {
        return gpDeltaBetaThreshold;
    }

    public void setGpDeltaBetaThreshold(Float gpDeltaBetaThreshold)
    {
        this.gpDeltaBetaThreshold = gpDeltaBetaThreshold;
    }

    public Float getGpDeltaHeightThreshold()
    {
        return gpDeltaHeightThreshold;
    }

    public void setGpDeltaHeightThreshold(Float gpDeltaHeightThreshold)
    {
        this.gpDeltaHeightThreshold = gpDeltaHeightThreshold;
    }

    public Float getGpDeltaTimeMultiplier()
    {
        return gpDeltaTimeMultiplier;
    }

    public void setGpDeltaTimeMultiplier(Float gpDeltaTimeMultiplier)
    {
        this.gpDeltaTimeMultiplier = gpDeltaTimeMultiplier;
    }

    public Float getGpDeltaBetaMultiplier()
    {
        return gpDeltaBetaMultiplier;
    }

    public void setGpDeltaBetaMultiplier(Float gpDeltaBetaMultiplier)
    {
        this.gpDeltaBetaMultiplier = gpDeltaBetaMultiplier;
    }

    public Float getGpDeltaHeightMultiplier()
    {
        return gpDeltaHeightMultiplier;
    }

    public void setGpDeltaHeightMultiplier(Float gpDeltaHeightMultiplier)
    {
        this.gpDeltaHeightMultiplier = gpDeltaHeightMultiplier;
    }

    public Float getSpDeltaTimeThreshold()
    {
        return spDeltaTimeThreshold;
    }

    public void setSpDeltaTimeThreshold(Float spDeltaTimeThreshold)
    {
        this.spDeltaTimeThreshold = spDeltaTimeThreshold;
    }

    public Float getSpDeltaBetaThreshold()
    {
        return spDeltaBetaThreshold;
    }

    public void setSpDeltaBetaThreshold(Float spDeltaBetaThreshold)
    {
        this.spDeltaBetaThreshold = spDeltaBetaThreshold;
    }

    public Float getSpDeltaHeightThreshold()
    {
        return spDeltaHeightThreshold;
    }

    public void setSpDeltaHeightThreshold(Float spDeltaHeightThreshold)
    {
        this.spDeltaHeightThreshold = spDeltaHeightThreshold;
    }

    public Float getSpDeltaTimeMultiplier()
    {
        return spDeltaTimeMultiplier;
    }

    public void setSpDeltaTimeMultiplier(Float spDeltaTimeMultiplier)
    {
        this.spDeltaTimeMultiplier = spDeltaTimeMultiplier;
    }

    public Float getSpDeltaBetaMultiplier()
    {
        return spDeltaBetaMultiplier;
    }

    public void setSpDeltaBetaMultiplier(Float spDeltaBetaMultiplier)
    {
        this.spDeltaBetaMultiplier = spDeltaBetaMultiplier;
    }

    public Float getSpDeltaHeightMultiplier()
    {
        return spDeltaHeightMultiplier;
    }

    public void setSpDeltaHeightMultiplier(Float spDeltaHeightMultiplier)
    {
        this.spDeltaHeightMultiplier = spDeltaHeightMultiplier;
    }

    public Float getChiMultiplier()
    {
        return chiMultiplier;
    }

    public void setChiMultiplier(Float chiMultiplier)
    {
        this.chiMultiplier = chiMultiplier;
    }

    public Float getCovarianceValidityLimit()
    {
        return covarianceValidityLimit;
    }

    public void setCovarianceValidityLimit(Float covarianceValidityLimit)
    {
        this.covarianceValidityLimit = covarianceValidityLimit;
    }

    public Float getGrossBetaLimit()
    {
        return grossBetaLimit;
    }

    public void setGrossBetaLimit(Float grossBetaLimit)
    {
        this.grossBetaLimit = grossBetaLimit;
    }

    public Boolean getForceTagIndicator()
    {
        return forceTagIndicator;
    }

    public void setForceTagIndicator(Boolean forceTagIndicator)
    {
        this.forceTagIndicator = forceTagIndicator;
    }

    public Boolean getConsiderProphylacticCrosstag()
    {
        return considerProphylacticCrosstag;
    }

    public void setConsiderProphylacticCrosstag(Boolean considerProphylacticCrosstag)
    {
        this.considerProphylacticCrosstag = considerProphylacticCrosstag;
    }

    public Boolean getAutoNotifyFlag()
    {
        return autoNotifyFlag;
    }

    public void setAutoNotifyFlag(Boolean autoNotifyFlag)
    {
        this.autoNotifyFlag = autoNotifyFlag;
    }

    public Boolean getUsePredictionErrorModel()
    {
        return usePredictionErrorModel;
    }

    public void setUsePredictionErrorModel(Boolean usePredictionErrorModel)
    {
        this.usePredictionErrorModel = usePredictionErrorModel;
    }

    public DateTime getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(DateTime createDate)
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

    public DateTime getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(DateTime updateDate)
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

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }
}
