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

public class ElementConversionControls
{
    String elementConvControlsUuid;
    String classificationMarking;
    String satelliteUuid;
    Application application;
    EpochPlacement epochPlacement;
    Float extrapolationDcDeltaSpan;
    Float extrapolationDcDragErRms;
    Boolean extrapolationDc;
    Float extrapolationDcEpochErRms;
    Float extrapolationDcEpochMargin;
    int extrapolationDcKeepNthPnt;
    Float extrapolationDcMaxPosRms;
    Float extrapolationDcMinSpan;
    Float extrapolationDcSpan;
    ExtrapolationSpanUnits extrapolationSpanUnits;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;

    public String getElementConvControlsUuid()
    {
        return elementConvControlsUuid;
    }

    public void setElementConvControlsUuid(String elementConvControlsUuid)
    {
        this.elementConvControlsUuid = elementConvControlsUuid;
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

    public Application getApplication()
    {
        return application;
    }

    public void setApplication(Application application)
    {
        this.application = application;
    }

    public EpochPlacement getEpochPlacement()
    {
        return epochPlacement;
    }

    public void setEpochPlacement(EpochPlacement epochPlacement)
    {
        this.epochPlacement = epochPlacement;
    }

    public Float getExtrapolationDcDeltaSpan()
    {
        return extrapolationDcDeltaSpan;
    }

    public void setExtrapolationDcDeltaSpan(Float extrapolationDcDeltaSpan)
    {
        this.extrapolationDcDeltaSpan = extrapolationDcDeltaSpan;
    }

    public Float getExtrapolationDcDragErRms()
    {
        return extrapolationDcDragErRms;
    }

    public void setExtrapolationDcDragErRms(Float extrapolationDcDragErRms)
    {
        this.extrapolationDcDragErRms = extrapolationDcDragErRms;
    }

    public Boolean getExtrapolationDc()
    {
        return extrapolationDc;
    }

    public void setExtrapolationDc(Boolean extrapolationDc)
    {
        this.extrapolationDc = extrapolationDc;
    }

    public Float getExtrapolationDcEpochErRms()
    {
        return extrapolationDcEpochErRms;
    }

    public void setExtrapolationDcEpochErRms(Float extrapolationDcEpochErRms)
    {
        this.extrapolationDcEpochErRms = extrapolationDcEpochErRms;
    }

    public Float getExtrapolationDcEpochMargin()
    {
        return extrapolationDcEpochMargin;
    }

    public void setExtrapolationDcEpochMargin(Float extrapolationDcEpochMargin)
    {
        this.extrapolationDcEpochMargin = extrapolationDcEpochMargin;
    }

    public int getExtrapolationDcKeepNthPnt()
    {
        return extrapolationDcKeepNthPnt;
    }

    public void setExtrapolationDcKeepNthPnt(int extrapolationDcKeepNthPnt)
    {
        this.extrapolationDcKeepNthPnt = extrapolationDcKeepNthPnt;
    }

    public Float getExtrapolationDcMaxPosRms()
    {
        return extrapolationDcMaxPosRms;
    }

    public void setExtrapolationDcMaxPosRms(Float extrapolationDcMaxPosRms)
    {
        this.extrapolationDcMaxPosRms = extrapolationDcMaxPosRms;
    }

    public Float getExtrapolationDcMinSpan()
    {
        return extrapolationDcMinSpan;
    }

    public void setExtrapolationDcMinSpan(Float extrapolationDcMinSpan)
    {
        this.extrapolationDcMinSpan = extrapolationDcMinSpan;
    }

    public Float getExtrapolationDcSpan()
    {
        return extrapolationDcSpan;
    }

    public void setExtrapolationDcSpan(Float extrapolationDcSpan)
    {
        this.extrapolationDcSpan = extrapolationDcSpan;
    }

    public ExtrapolationSpanUnits getExtrapolationSpanUnits()
    {
        return extrapolationSpanUnits;
    }

    public void setExtrapolationSpanUnits(ExtrapolationSpanUnits extrapolationSpanUnits)
    {
        this.extrapolationSpanUnits = extrapolationSpanUnits;
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
