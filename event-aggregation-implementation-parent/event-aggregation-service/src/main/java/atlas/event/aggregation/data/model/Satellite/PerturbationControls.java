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

public class PerturbationControls
{
    String perturbationControlsUuid;
    String classificationMarking;
    String satelliteUuid;
    Application application;
    Float aprioriRadiationPressCoeff;
    Float aprioriSigmaBallCoeffPerct;
    Float aprioriSigmaAgomCoeffPerct;
    AtmosphericModel atmosphericModel;
    Float constantAp;
    Float constantF10;
    Float constantF10Bar;
    Boolean dragFlag;
    Float dragModulation;
    Boolean dcaDataFlag;
    Boolean dmspFlag;
    Boolean kappaFlag;
    String fluxId;
    FluxSource fluxSource;
    Float frontalAreaModulation;
    Boolean geopotentialFlag;
    String geopotentialModel;
    int geopotentialOriginalDegree;
    Boolean geopotentialPrintFlag;
    int geopotentialTesseralDegree;
    Boolean geopotentialTruncationFlag;
    int geopotentialZonalDegree;
    Boolean inTrackDurationThrustFlag;
    Boolean j70DcaFlag;
    String j70DcaId;
    Boolean mpeFlag;
    String mpeId;
    NutationModel nutationModel;
    Boolean solidEarthTidesFlag;
    RadiationPressureShadowModelOption radiationPressureShadowModelOption;
    LunarSolarGravityRepresentationOption lunarSolarGravityRepresentationOption;
    Boolean aprioriSigmaBalcoeUseInputValueFlag;
    Boolean aprioriSigmaBalcoeTimeVaryFlag;
    Boolean geopotentialApplyHybridModelFlag;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;

    public String getPerturbationControlsUuid()
    {
        return perturbationControlsUuid;
    }

    public void setPerturbationControlsUuid(String perturbationControlsUuid)
    {
        this.perturbationControlsUuid = perturbationControlsUuid;
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

    public Float getAprioriRadiationPressCoeff()
    {
        return aprioriRadiationPressCoeff;
    }

    public void setAprioriRadiationPressCoeff(Float aprioriRadiationPressCoeff)
    {
        this.aprioriRadiationPressCoeff = aprioriRadiationPressCoeff;
    }

    public Float getAprioriSigmaBallCoeffPerct()
    {
        return aprioriSigmaBallCoeffPerct;
    }

    public void setAprioriSigmaBallCoeffPerct(Float aprioriSigmaBallCoeffPerct)
    {
        this.aprioriSigmaBallCoeffPerct = aprioriSigmaBallCoeffPerct;
    }

    public Float getAprioriSigmaAgomCoeffPerct()
    {
        return aprioriSigmaAgomCoeffPerct;
    }

    public void setAprioriSigmaAgomCoeffPerct(Float aprioriSigmaAgomCoeffPerct)
    {
        this.aprioriSigmaAgomCoeffPerct = aprioriSigmaAgomCoeffPerct;
    }

    public AtmosphericModel getAtmosphericModel()
    {
        return atmosphericModel;
    }

    public void setAtmosphericModel(AtmosphericModel atmosphericModel)
    {
        this.atmosphericModel = atmosphericModel;
    }

    public Float getConstantAp()
    {
        return constantAp;
    }

    public void setConstantAp(Float constantAp)
    {
        this.constantAp = constantAp;
    }

    public Float getConstantF10()
    {
        return constantF10;
    }

    public void setConstantF10(Float constantF10)
    {
        this.constantF10 = constantF10;
    }

    public Float getConstantF10Bar()
    {
        return constantF10Bar;
    }

    public void setConstantF10Bar(Float constantF10Bar)
    {
        this.constantF10Bar = constantF10Bar;
    }

    public Boolean getDragFlag()
    {
        return dragFlag;
    }

    public void setDragFlag(Boolean dragFlag)
    {
        this.dragFlag = dragFlag;
    }

    public Float getDragModulation()
    {
        return dragModulation;
    }

    public void setDragModulation(Float dragModulation)
    {
        this.dragModulation = dragModulation;
    }

    public Boolean getDcaDataFlag()
    {
        return dcaDataFlag;
    }

    public void setDcaDataFlag(Boolean dcaDataFlag)
    {
        this.dcaDataFlag = dcaDataFlag;
    }

    public Boolean getDmspFlag()
    {
        return dmspFlag;
    }

    public void setDmspFlag(Boolean dmspFlag)
    {
        this.dmspFlag = dmspFlag;
    }

    public Boolean getKappaFlag()
    {
        return kappaFlag;
    }

    public void setKappaFlag(Boolean kappaFlag)
    {
        this.kappaFlag = kappaFlag;
    }

    public String getFluxId()
    {
        return fluxId;
    }

    public void setFluxId(String fluxId)
    {
        this.fluxId = fluxId;
    }

    public FluxSource getFluxSource()
    {
        return fluxSource;
    }

    public void setFluxSource(FluxSource fluxSource)
    {
        this.fluxSource = fluxSource;
    }

    public Float getFrontalAreaModulation()
    {
        return frontalAreaModulation;
    }

    public void setFrontalAreaModulation(Float frontalAreaModulation)
    {
        this.frontalAreaModulation = frontalAreaModulation;
    }

    public Boolean getGeopotentialFlag()
    {
        return geopotentialFlag;
    }

    public void setGeopotentialFlag(Boolean geopotentialFlag)
    {
        this.geopotentialFlag = geopotentialFlag;
    }

    public String getGeopotentialModel()
    {
        return geopotentialModel;
    }

    public void setGeopotentialModel(String geopotentialModel)
    {
        this.geopotentialModel = geopotentialModel;
    }

    public int getGeopotentialOriginalDegree()
    {
        return geopotentialOriginalDegree;
    }

    public void setGeopotentialOriginalDegree(int geopotentialOriginalDegree)
    {
        this.geopotentialOriginalDegree = geopotentialOriginalDegree;
    }

    public Boolean getGeopotentialPrintFlag()
    {
        return geopotentialPrintFlag;
    }

    public void setGeopotentialPrintFlag(Boolean geopotentialPrintFlag)
    {
        this.geopotentialPrintFlag = geopotentialPrintFlag;
    }

    public int getGeopotentialTesseralDegree()
    {
        return geopotentialTesseralDegree;
    }

    public void setGeopotentialTesseralDegree(int geopotentialTesseralDegree)
    {
        this.geopotentialTesseralDegree = geopotentialTesseralDegree;
    }

    public Boolean getGeopotentialTruncationFlag()
    {
        return geopotentialTruncationFlag;
    }

    public void setGeopotentialTruncationFlag(Boolean geopotentialTruncationFlag)
    {
        this.geopotentialTruncationFlag = geopotentialTruncationFlag;
    }

    public int getGeopotentialZonalDegree()
    {
        return geopotentialZonalDegree;
    }

    public void setGeopotentialZonalDegree(int geopotentialZonalDegree)
    {
        this.geopotentialZonalDegree = geopotentialZonalDegree;
    }

    public Boolean getInTrackDurationThrustFlag()
    {
        return inTrackDurationThrustFlag;
    }

    public void setInTrackDurationThrustFlag(Boolean inTrackDurationThrustFlag)
    {
        this.inTrackDurationThrustFlag = inTrackDurationThrustFlag;
    }

    public Boolean getJ70DcaFlag()
    {
        return j70DcaFlag;
    }

    public void setJ70DcaFlag(Boolean j70DcaFlag)
    {
        this.j70DcaFlag = j70DcaFlag;
    }

    public String getJ70DcaId()
    {
        return j70DcaId;
    }

    public void setJ70DcaId(String j70DcaId)
    {
        this.j70DcaId = j70DcaId;
    }

    public Boolean getMpeFlag()
    {
        return mpeFlag;
    }

    public void setMpeFlag(Boolean mpeFlag)
    {
        this.mpeFlag = mpeFlag;
    }

    public String getMpeId()
    {
        return mpeId;
    }

    public void setMpeId(String mpeId)
    {
        this.mpeId = mpeId;
    }

    public NutationModel getNutationModel()
    {
        return nutationModel;
    }

    public void setNutationModel(NutationModel nutationModel)
    {
        this.nutationModel = nutationModel;
    }

    public Boolean getSolidEarthTidesFlag()
    {
        return solidEarthTidesFlag;
    }

    public void setSolidEarthTidesFlag(Boolean solidEarthTidesFlag)
    {
        this.solidEarthTidesFlag = solidEarthTidesFlag;
    }

    public RadiationPressureShadowModelOption getRadiationPressureShadowModelOption()
    {
        return radiationPressureShadowModelOption;
    }

    public void setRadiationPressureShadowModelOption(RadiationPressureShadowModelOption radiationPressureShadowModelOption)
    {
        this.radiationPressureShadowModelOption = radiationPressureShadowModelOption;
    }

    public LunarSolarGravityRepresentationOption getLunarSolarGravityRepresentationOption()
    {
        return lunarSolarGravityRepresentationOption;
    }

    public void setLunarSolarGravityRepresentationOption(LunarSolarGravityRepresentationOption lunarSolarGravityRepresentationOption)
    {
        this.lunarSolarGravityRepresentationOption = lunarSolarGravityRepresentationOption;
    }

    public Boolean getAprioriSigmaBalcoeUseInputValueFlag()
    {
        return aprioriSigmaBalcoeUseInputValueFlag;
    }

    public void setAprioriSigmaBalcoeUseInputValueFlag(Boolean aprioriSigmaBalcoeUseInputValueFlag)
    {
        this.aprioriSigmaBalcoeUseInputValueFlag = aprioriSigmaBalcoeUseInputValueFlag;
    }

    public Boolean getAprioriSigmaBalcoeTimeVaryFlag()
    {
        return aprioriSigmaBalcoeTimeVaryFlag;
    }

    public void setAprioriSigmaBalcoeTimeVaryFlag(Boolean aprioriSigmaBalcoeTimeVaryFlag)
    {
        this.aprioriSigmaBalcoeTimeVaryFlag = aprioriSigmaBalcoeTimeVaryFlag;
    }

    public Boolean getGeopotentialApplyHybridModelFlag()
    {
        return geopotentialApplyHybridModelFlag;
    }

    public void setGeopotentialApplyHybridModelFlag(Boolean geopotentialApplyHybridModelFlag)
    {
        this.geopotentialApplyHybridModelFlag = geopotentialApplyHybridModelFlag;
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
