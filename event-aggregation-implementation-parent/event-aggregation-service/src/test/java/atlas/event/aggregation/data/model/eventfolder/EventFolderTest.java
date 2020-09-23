package atlas.event.aggregation.data.model.eventfolder;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventFolderTest
{
    EventFolder task = new EventFolder();
    String eventFolderUuid = "folderUuid";
    String classificationMarking = "classMark";
    String eventProcessingConfigUuid = "eventUuid";
    Integer id = 1;
    Date year = new Date();
    String shortName = "short";
    String description = "desc";
    String remarks = "remark";

    @Test
    void setEventFolderUuid()
    {
        task.setEventFolderUuid(eventFolderUuid);
        assertEquals(eventFolderUuid, task.getEventFolderUuid());
    }

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setEventProcessingConfigUuid()
    {
        task.setEventProcessingConfigUuid(eventProcessingConfigUuid);
        assertEquals(eventProcessingConfigUuid, task.getEventProcessingConfigUuid());
    }

    @Test
    void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    void setYear()
    {
        task.setYear(year);
        assertEquals(year, task.getYear());
    }

    @Test
    void setShortName()
    {
        task.setShortName(shortName);
        assertEquals(shortName, task.getShortName());
    }

    @Test
    void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void setRemarks()
    {
        task.setRemarks(remarks);
        assertEquals(remarks, task.getRemarks());
    }
}