package atlas.event.aggregation.data.paging;

import atlas.event.aggregation.data.paging.elements.PageInfo;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageableBuilderTest
{
    PageableBuilder task = new PageableBuilder();

    @Test
    public void from()
    {
        PageInfo pageInfo = new PageInfo();
        atlas.event.aggregation.data.paging.elements.Sort sort = new atlas.event.aggregation.data.paging.elements.Sort();
        pageInfo.setSort(sort);
        pageInfo.setPage(1);
        pageInfo.setSize(2);
        org.springframework.data.domain.Sort defaultSort = Sort.by("properties");
        assertNotNull(task.from(pageInfo, defaultSort));
    }

    @Test
    public void testFrom()
    {
        Map<String, Object> inputMap = new HashMap<>();
        assertNull(task.from(inputMap));

        inputMap.put("a", "b");
        try
        {
            task.from(inputMap);
        }
        catch (IllegalStateException e)
        {
            assertTrue(e.toString().contains("Page and Size parameters of a PageRequest may not be null."));
        }

        inputMap.put("page", 1);
        inputMap.put("size", 1);
        assertNotNull(task.from(inputMap));
    }

    @Test
    public void sortFrom()
    {
        Map<String, Object> sortMap = new HashMap<>();
        task.sortFrom(sortMap);

        List<Sort.Order> orders = Lists.newArrayList();
        sortMap.put("orders", orders);
        task.sortFrom(sortMap);
    }

    @Test
    public void getOrderASC()
    {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("direction", "ASC");
        orderMap.put("property", "prop");
        task.getOrder(orderMap);
    }

    @Test
    public void getOrderDESC()
    {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("direction", "DESC");
        orderMap.put("property", "prop");
        task.getOrder(orderMap);
    }

    @Test
    public void getOrderOTHER()
    {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("direction", "other");
        orderMap.put("property", "prop");
        task.getOrder(orderMap);
    }
}