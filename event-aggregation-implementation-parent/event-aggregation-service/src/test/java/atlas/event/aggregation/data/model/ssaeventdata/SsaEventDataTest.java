package atlas.event.aggregation.data.model.ssaeventdata;

import org.junit.jupiter.api.Test;

import java.sql.Blob;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SsaEventDataTest
{
    SsaEventData task = new SsaEventData();
    String ssaEventDataUuid = "ssaEventDataUuid";
    String classificationMarking = "classificationMarking";
    String ssaEventUuid = "ssaEventUuid";
    String eventDataName = "eventDataName";
    String eventDataType = "eventDataType";
    Blob eventData = null;

    @Test
    void setSsaEventDataUuid()
    {
        task.setSsaEventDataUuid(ssaEventDataUuid);
        assertEquals(ssaEventDataUuid, task.getSsaEventDataUuid());
    }

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setSsaEventUuid()
    {
        task.setSsaEventUuid(ssaEventUuid);
        assertEquals(ssaEventUuid, task.getSsaEventUuid());
    }

    @Test
    void setEventDataName()
    {
        task.setEventDataName(eventDataName);
        assertEquals(eventDataName, task.getEventDataName());
    }

    @Test
    void setEventDataType()
    {
        task.setEventDataType(eventDataType);
        assertEquals(eventDataType, task.getEventDataType());
    }

    @Test
    void setEventData()
    {
        task.setEventData(eventData);
        assertEquals(eventData, task.getEventData());
    }
}