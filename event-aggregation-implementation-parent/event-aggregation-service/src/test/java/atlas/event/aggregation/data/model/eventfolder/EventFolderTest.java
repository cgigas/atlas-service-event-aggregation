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
package atlas.event.aggregation.data.model.eventfolder;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EventFolderTest
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
    public void setEventFolderUuid()
    {
        task.setEventFolderUuid(eventFolderUuid);
        assertEquals(eventFolderUuid, task.getEventFolderUuid());
    }

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setEventProcessingConfigUuid()
    {
        task.setEventProcessingConfigUuid(eventProcessingConfigUuid);
        assertEquals(eventProcessingConfigUuid, task.getEventProcessingConfigUuid());
    }

    @Test
    public void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    public void setYear()
    {
        task.setYear(year);
        assertEquals(year, task.getYear());
    }

    @Test
    public void setShortName()
    {
        task.setShortName(shortName);
        assertEquals(shortName, task.getShortName());
    }

    @Test
    public void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    public void setRemarks()
    {
        task.setRemarks(remarks);
        assertEquals(remarks, task.getRemarks());
    }
}