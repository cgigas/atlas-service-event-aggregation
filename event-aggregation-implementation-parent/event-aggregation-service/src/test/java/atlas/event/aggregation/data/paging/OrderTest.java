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
package atlas.event.aggregation.data.paging;

import atlas.event.aggregation.data.paging.elements.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderTest
{
    Order task = new Order();
    String property = "property";
    Direction direction = Direction.ASC;


    @Test
    void setProperty()
    {
        task.setProperty(property);
        assertEquals(property, task.getProperty());
    }

    @Test
    void setDirection()
    {
        task.setDirection(direction);
        assertEquals(direction, task.getDirection());
    }

    @Test
    void testToString()
    {
        assertNotNull(task.toString());
    }

    @Test
    void builder()
    {
        assertNotNull(task.builder());
    }

    @Test
    void field()
    {
        Order.Field propName = Order.Field.Property;
        assertEquals(Order.Field.Property, propName);
        Order.Field dirName = Order.Field.Direction;
        assertEquals(Order.Field.Direction, dirName);
    }
}