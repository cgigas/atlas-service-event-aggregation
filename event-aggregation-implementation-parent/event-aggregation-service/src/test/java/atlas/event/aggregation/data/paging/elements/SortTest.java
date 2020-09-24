package atlas.event.aggregation.data.paging.elements;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SortTest
{
    List<Order> orders;

    @Test
    public void test()
    {
        Sort task = new Sort();
        assertNotNull(task);
    }
}