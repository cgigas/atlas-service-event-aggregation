package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class SatDecay
{
    String satelliteUuid;
    String classificationMarking;
    DateTime decayDt;
    DecayType decayType;
    Float lat;
    Float lon;
    Float alt;
    Long revNo;
    String comments;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
