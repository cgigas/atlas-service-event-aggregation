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

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public Boolean getSuspendMaintFlag()
    {
        return suspendMaintFlag;
    }

    public void setSuspendMaintFlag(Boolean suspendMaintFlag)
    {
        this.suspendMaintFlag = suspendMaintFlag;
    }

    public Float getMinTimeBetweenDcs()
    {
        return minTimeBetweenDcs;
    }

    public void setMinTimeBetweenDcs(Float minTimeBetweenDcs)
    {
        this.minTimeBetweenDcs = minTimeBetweenDcs;
    }

    public int getMinObservations()
    {
        return minObservations;
    }

    public void setMinObservations(int minObservations)
    {
        this.minObservations = minObservations;
    }

    public int getMinTracks()
    {
        return minTracks;
    }

    public void setMinTracks(int minTracks)
    {
        this.minTracks = minTracks;
    }

    public Float getMinResidualAcceptance()
    {
        return minResidualAcceptance;
    }

    public void setMinResidualAcceptance(Float minResidualAcceptance)
    {
        this.minResidualAcceptance = minResidualAcceptance;
    }

    public Float getMaxFitRms()
    {
        return maxFitRms;
    }

    public void setMaxFitRms(Float maxFitRms)
    {
        this.maxFitRms = maxFitRms;
    }

    public int getMinObsForModelParamSol()
    {
        return minObsForModelParamSol;
    }

    public void setMinObsForModelParamSol(int minObsForModelParamSol)
    {
        this.minObsForModelParamSol = minObsForModelParamSol;
    }

    public int getMinTracksForModelParamSol()
    {
        return minTracksForModelParamSol;
    }

    public void setMinTracksForModelParamSol(int minTracksForModelParamSol)
    {
        this.minTracksForModelParamSol = minTracksForModelParamSol;
    }

    public BaseMaintenanceParameter getBaseMaintenanceParameter()
    {
        return baseMaintenanceParameter;
    }

    public void setBaseMaintenanceParameter(BaseMaintenanceParameter baseMaintenanceParameter)
    {
        this.baseMaintenanceParameter = baseMaintenanceParameter;
    }

    public Float getMaxWeightedRms()
    {
        return maxWeightedRms;
    }

    public void setMaxWeightedRms(Float maxWeightedRms)
    {
        this.maxWeightedRms = maxWeightedRms;
    }

    public Float getEventRecoveryWindow()
    {
        return eventRecoveryWindow;
    }

    public void setEventRecoveryWindow(Float eventRecoveryWindow)
    {
        this.eventRecoveryWindow = eventRecoveryWindow;
    }

    public Float getEventExitThreshold()
    {
        return eventExitThreshold;
    }

    public void setEventExitThreshold(Float eventExitThreshold)
    {
        this.eventExitThreshold = eventExitThreshold;
    }

    public SatTemplateType getSatTemplateType()
    {
        return satTemplateType;
    }

    public void setSatTemplateType(SatTemplateType satTemplateType)
    {
        this.satTemplateType = satTemplateType;
    }

    public Boolean getSendEpgFlag()
    {
        return sendEpgFlag;
    }

    public void setSendEpgFlag(Boolean sendEpgFlag)
    {
        this.sendEpgFlag = sendEpgFlag;
    }

    public Boolean getHighInterestFlag()
    {
        return highInterestFlag;
    }

    public void setHighInterestFlag(Boolean highInterestFlag)
    {
        this.highInterestFlag = highInterestFlag;
    }

    public Float getAllowableTimeForUpdate()
    {
        return allowableTimeForUpdate;
    }

    public void setAllowableTimeForUpdate(Float allowableTimeForUpdate)
    {
        this.allowableTimeForUpdate = allowableTimeForUpdate;
    }

    public Float getLatencyTimeForPasses()
    {
        return latencyTimeForPasses;
    }

    public void setLatencyTimeForPasses(Float latencyTimeForPasses)
    {
        this.latencyTimeForPasses = latencyTimeForPasses;
    }

    public Float getMaximumTimeBeforeUpdate()
    {
        return maximumTimeBeforeUpdate;
    }

    public void setMaximumTimeBeforeUpdate(Float maximumTimeBeforeUpdate)
    {
        this.maximumTimeBeforeUpdate = maximumTimeBeforeUpdate;
    }

    public Float getMinimumTimeBeforeUpdate()
    {
        return minimumTimeBeforeUpdate;
    }

    public void setMinimumTimeBeforeUpdate(Float minimumTimeBeforeUpdate)
    {
        this.minimumTimeBeforeUpdate = minimumTimeBeforeUpdate;
    }

    public int getNumPassesReqBeforeUpdate()
    {
        return numPassesReqBeforeUpdate;
    }

    public void setNumPassesReqBeforeUpdate(int numPassesReqBeforeUpdate)
    {
        this.numPassesReqBeforeUpdate = numPassesReqBeforeUpdate;
    }

    public Boolean getUpdWithAfsssFencePassFlag()
    {
        return updWithAfsssFencePassFlag;
    }

    public void setUpdWithAfsssFencePassFlag(Boolean updWithAfsssFencePassFlag)
    {
        this.updWithAfsssFencePassFlag = updWithAfsssFencePassFlag;
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
