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

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class EventTypeSummaryTest
{
    EventTypeSummary task = new EventTypeSummary();
    String id = "id";
    String type = "sat";
    Integer planned = 1;
    Integer active = 2;
    String typeName = "type";

    @Test
    void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    void setType()
    {
        task.setType(type);
        assertEquals(type, task.getType());
    }

    @Test
    void setPlanned()
    {
        task.setPlanned(planned);
        assertEquals(planned, task.getPlanned());
    }

    @Test
    void setActive()
    {
        task.setActive(active);
        assertEquals(active, task.getActive());
    }

    @Test
    void setTypeName()
    {
        task.setTypeName(typeName);
        assertEquals(typeName, task.getTypeName());
    }
}