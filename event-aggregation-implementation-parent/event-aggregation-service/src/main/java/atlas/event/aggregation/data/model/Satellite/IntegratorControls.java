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

public class IntegratorControls
{
    String integratorControlsUuid;
    String classificationMarking;
    String satelliteUuid;
    Application application;
    CoordinateSystem coordinateSystem;
    Float errorControl;
    Float inputStepSize;
    PartialDerivatives partialDerivatives;
    Boolean printStepChangeFlag;
    Propagator propagator;
    Boolean spadocEmulationFlag;
    StepMode stepMode;
    StepSizeMethod stepSizeMethod;
    StepSizeSource stepSizeSource;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;

    public String getIntegratorControlsUuid()
    {
        return integratorControlsUuid;
    }

    public void setIntegratorControlsUuid(String integratorControlsUuid)
    {
        this.integratorControlsUuid = integratorControlsUuid;
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

    public CoordinateSystem getCoordinateSystem()
    {
        return coordinateSystem;
    }

    public void setCoordinateSystem(CoordinateSystem coordinateSystem)
    {
        this.coordinateSystem = coordinateSystem;
    }

    public Float getErrorControl()
    {
        return errorControl;
    }

    public void setErrorControl(Float errorControl)
    {
        this.errorControl = errorControl;
    }

    public Float getInputStepSize()
    {
        return inputStepSize;
    }

    public void setInputStepSize(Float inputStepSize)
    {
        this.inputStepSize = inputStepSize;
    }

    public PartialDerivatives getPartialDerivatives()
    {
        return partialDerivatives;
    }

    public void setPartialDerivatives(PartialDerivatives partialDerivatives)
    {
        this.partialDerivatives = partialDerivatives;
    }

    public Boolean getPrintStepChangeFlag()
    {
        return printStepChangeFlag;
    }

    public void setPrintStepChangeFlag(Boolean printStepChangeFlag)
    {
        this.printStepChangeFlag = printStepChangeFlag;
    }

    public Propagator getPropagator()
    {
        return propagator;
    }

    public void setPropagator(Propagator propagator)
    {
        this.propagator = propagator;
    }

    public Boolean getSpadocEmulationFlag()
    {
        return spadocEmulationFlag;
    }

    public void setSpadocEmulationFlag(Boolean spadocEmulationFlag)
    {
        this.spadocEmulationFlag = spadocEmulationFlag;
    }

    public StepMode getStepMode()
    {
        return stepMode;
    }

    public void setStepMode(StepMode stepMode)
    {
        this.stepMode = stepMode;
    }

    public StepSizeMethod getStepSizeMethod()
    {
        return stepSizeMethod;
    }

    public void setStepSizeMethod(StepSizeMethod stepSizeMethod)
    {
        this.stepSizeMethod = stepSizeMethod;
    }

    public StepSizeSource getStepSizeSource()
    {
        return stepSizeSource;
    }

    public void setStepSizeSource(StepSizeSource stepSizeSource)
    {
        this.stepSizeSource = stepSizeSource;
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
