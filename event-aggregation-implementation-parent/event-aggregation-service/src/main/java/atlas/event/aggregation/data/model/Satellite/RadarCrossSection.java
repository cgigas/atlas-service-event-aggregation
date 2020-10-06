package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class RadarCrossSection
{
    String rcsUuid;
    String classificationMarking;
    String satelliteUuid;
    Float lastRcs;
    int lastSensorNumber;
    DateTime rcsDate;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
