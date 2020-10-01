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
package atlas.event.aggregation.data.paging.elements;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest
{
    Order task = new Order();
    String property = "property";
    Direction direction = Direction.DESC;

    @Test
    public void setProperty()
    {
        task.setProperty(property);
        assertEquals(property, task.getProperty());
    }

    @Test
    public void setDirection()
    {
        task.setDirection(direction);
        assertEquals(direction, task.getDirection());
    }
}