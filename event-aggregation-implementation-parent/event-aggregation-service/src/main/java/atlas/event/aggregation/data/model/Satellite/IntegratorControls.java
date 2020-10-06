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
}
