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