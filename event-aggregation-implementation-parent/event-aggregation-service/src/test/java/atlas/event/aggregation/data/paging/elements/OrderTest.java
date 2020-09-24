package atlas.event.aggregation.data.paging.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest
{
    Order task = new Order();
    String property = "property";
    Direction direction = Direction.DESC;

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
}