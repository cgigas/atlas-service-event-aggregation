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
}
