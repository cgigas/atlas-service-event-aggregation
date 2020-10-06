package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class ControlsTemplateCriteria
{
    String ctrlsTemplateCriteriaUuid;
    String classificationMarking;
    String satelliteUuid;
    String name;
    Float perigeeLowerBound;
    Float perigeeUpperBound;
    Float eccentricityLowerBound;
    Float eccentricityUpperBound;
    ObjectType objectType;
    Category category;
    SsaEventType ssaEventType;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
