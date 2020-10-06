package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class VisualMagnitude
{
    String visualMagnitudeUuid;
    String classificationMarking;
    String satelliteUuid;
    int sensorNumber;
    DateTime reportDt;
    Float observedMv;
    Float normKm36000;
    Float solarPhaseAngle;
    Float solarDeclinationAngle;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
