package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControlsTemplateCriteriaTest
{
    ControlsTemplateCriteria task = new ControlsTemplateCriteria();
    private String ctrlsTemplateCriteriaUuid = "ctrlsTemplateCriteriaUuid";
    private String classificationMarking = "classificationMarking";
    private String satelliteUuid = "satelliteUuid";
    private String name = "name";
    private Float perigeeLowerBound = new Float("1");
    private Float perigeeUpperBound = new Float("2");
    private Float eccentricityLowerBound = new Float("3");
    private Float eccentricityUpperBound = new Float("4");
    private ObjectType objectType = ObjectType.Rocket_Body;
    private Category category = Category.Versioned;
    private SsaEventType ssaEventType = SsaEventType.Deorbit;
    private DateTime createDate = new DateTime();
    private String createOrigin = "createOrigin";
    private DateTime updateDate = new DateTime();
    private String updateOrigin = "updateOrigin";
    private Long version = 5L;

    @Test
    public void setCtrlsTemplateCriteriaUuid()
    {
        task.setCtrlsTemplateCriteriaUuid(ctrlsTemplateCriteriaUuid);
        assertEquals(ctrlsTemplateCriteriaUuid, task.getCtrlsTemplateCriteriaUuid());
    }

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setSatelliteUuid()
    {
        task.setSatelliteUuid(satelliteUuid);
        assertEquals(satelliteUuid, task.getSatelliteUuid());
    }

    @Test
    public void setName()
    {
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    public void setPerigeeLowerBound()
    {
        task.setPerigeeLowerBound(perigeeLowerBound);
        assertEquals(perigeeLowerBound, task.getPerigeeLowerBound());
    }

    @Test
    public void setPerigeeUpperBound()
    {
        task.setPerigeeUpperBound(perigeeUpperBound);
        assertEquals(perigeeUpperBound, task.getPerigeeUpperBound());
    }

    @Test
    public void setEccentricityLowerBound()
    {
        task.setEccentricityLowerBound(eccentricityLowerBound);
        assertEquals(eccentricityLowerBound, task.getEccentricityLowerBound());
    }

    @Test
    public void setEccentricityUpperBound()
    {
        task.setEccentricityUpperBound(eccentricityUpperBound);
        assertEquals(eccentricityUpperBound, task.getEccentricityUpperBound());
    }

    @Test
    public void setObjectType()
    {
        task.setObjectType(objectType);
        assertEquals(objectType, task.getObjectType());
    }

    @Test
    public void setCategory()
    {
        task.setCategory(category);
        assertEquals(category, task.getCategory());
    }

    @Test
    public void setSsaEventType()
    {
        task.setSsaEventType(ssaEventType);
        assertEquals(ssaEventType, task.getSsaEventType());
    }

    @Test
    public void setCreateDate()
    {
        task.setCreateDate(createDate);
        assertEquals(createDate, task.getCreateDate());
    }

    @Test
    public void setCreateOrigin()
    {
        task.setCreateOrigin(createOrigin);
        assertEquals(createOrigin, task.getCreateOrigin());
    }

    @Test
    public void setUpdateDate()
    {
        task.setUpdateDate(updateDate);
        assertEquals(updateDate, task.getUpdateDate());
    }

    @Test
    public void setUpdateOrigin()
    {
        task.setUpdateOrigin(updateOrigin);
        assertEquals(updateOrigin, task.getUpdateOrigin());
    }

    @Test
    public void setVersion()
    {
        task.setVersion(version);
        assertEquals(version, task.getVersion());
    }
}