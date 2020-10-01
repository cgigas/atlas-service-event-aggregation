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
package atlas.event.aggregation.data.model.ssaeventdata;

import org.junit.Test;

import java.sql.Blob;

import static org.junit.Assert.assertEquals;

public class SsaEventDataTest
{
    SsaEventData task = new SsaEventData();
    String ssaEventDataUuid = "ssaEventDataUuid";
    String classificationMarking = "classificationMarking";
    String ssaEventUuid = "ssaEventUuid";
    String eventDataName = "eventDataName";
    String eventDataType = "eventDataType";
    Blob eventData = null;

    @Test
    public void setSsaEventDataUuid()
    {
        task.setSsaEventDataUuid(ssaEventDataUuid);
        assertEquals(ssaEventDataUuid, task.getSsaEventDataUuid());
    }

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setSsaEventUuid()
    {
        task.setSsaEventUuid(ssaEventUuid);
        assertEquals(ssaEventUuid, task.getSsaEventUuid());
    }

    @Test
    public void setEventDataName()
    {
        task.setEventDataName(eventDataName);
        assertEquals(eventDataName, task.getEventDataName());
    }

    @Test
    public void setEventDataType()
    {
        task.setEventDataType(eventDataType);
        assertEquals(eventDataType, task.getEventDataType());
    }

    @Test
    public void setEventData()
    {
        task.setEventData(eventData);
        assertEquals(eventData, task.getEventData());
    }
}