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
        assertNotNull(PageableBuilder.from(pageInfo, defaultSort));
    }

    @Test
    public void testFrom()
    {
        Map<String, Object> inputMap = new HashMap<>();
        assertNull(PageableBuilder.from(inputMap));

        inputMap.put("a", "b");
        try
        {
            PageableBuilder.from(inputMap);
        }
        catch (IllegalStateException e)
        {
            assertTrue(e.toString().contains("Page and Size parameters of a PageRequest may not be null."));
        }

        inputMap.put("page", 1);
        inputMap.put("size", 1);
        assertNotNull(PageableBuilder.from(inputMap));
    }

    @Test
    public void sortFrom()
    {
        Map<String, Object> sortMap = new HashMap<>();
        PageableBuilder.sortFrom(sortMap);

        List<Sort.Order> orders = Lists.newArrayList();
        sortMap.put("orders", orders);
        PageableBuilder.sortFrom(sortMap);
    }

    @Test
    public void getOrderASC()
    {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("direction", "ASC");
        orderMap.put("property", "prop");
        PageableBuilder.getOrder(orderMap);
    }

    @Test
    public void getOrderDESC()
    {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("direction", "DESC");
        orderMap.put("property", "prop");
        PageableBuilder.getOrder(orderMap);
    }

    @Test
    public void getOrderOTHER()
    {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("direction", "other");
        orderMap.put("property", "prop");
        PageableBuilder.getOrder(orderMap);
    }
}