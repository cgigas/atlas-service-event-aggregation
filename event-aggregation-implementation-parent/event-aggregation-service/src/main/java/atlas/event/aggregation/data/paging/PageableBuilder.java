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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class PageableBuilder
{
    private static final String PROPERTY = "property";

    public static Pageable from(@NotNull PageInfo pageInfo, org.springframework.data.domain.Sort defaultSort)
    {
        org.springframework.data.domain.Sort sort = defaultSort != null ? defaultSort : org.springframework.data.domain.Sort.unsorted();
        if (pageInfo.getSort() != null)
        {
/*            List<org.springframework.data.domain.Sort.Order> orders = new ArrayList<>();
            pageInfo.getSort().getOrders().forEach(o ->
            {
                if (o.getDirection() == Direction.ASC)
                {
                    orders.add(org.springframework.data.domain.Sort.Order.asc(o.getProperty()));
                }
                else
                {
                    orders.add(org.springframework.data.domain.Sort.Order.desc(o.getProperty()));
                }
            });


            sort = org.springframework.data.domain.Sort.by(orders);

 */
        }
        return PageRequest.of(pageInfo.getPage(), pageInfo.getSize(), sort);
    }

    /**
     * This method extracts fields from a map containing expected keys and values, and creates a Spring domain PageRequest object.
     *
     * @param inputMap The input map
     * @return A PageRequest instance with the map field values.
     */
    public static Pageable from(Map<String, Object> inputMap)
    {
        if (inputMap != null && !inputMap.isEmpty())
        {
            Integer page = (Integer) inputMap.get("page");
            Integer size = (Integer) inputMap.get("size");

            if (page == null || size == null)
            {
                throw new IllegalStateException("Page and Size parameters of a PageRequest may not be null.");
            }

            org.springframework.data.domain.Sort sort = sortFrom((Map<String, Object>) inputMap.get("sort"));
            return PageRequest.of(page, size, sort);
        }
        return null;
    }

    public static org.springframework.data.domain.Sort sortFrom(Map<String, Object> sortMap)
    {
        org.springframework.data.domain.Sort sortOrder;
        if (sortMap != null && !sortMap.isEmpty())
        {
            List<org.springframework.data.domain.Sort.Order> orders = Lists.newArrayList();
            if (sortMap.containsKey("orders"))
            {
                for (Map<String, Object> orderMap : (List<Map<String, Object>>) sortMap.get("orders"))
                {
                    orders.add(getOrder(orderMap));
                }
            }
            sortOrder = org.springframework.data.domain.Sort.by(orders);
        }
        else
        {
            sortOrder = org.springframework.data.domain.Sort.unsorted();
        }
        return sortOrder;
    }

    public static org.springframework.data.domain.Sort.Order getOrder(Map<String, Object> orderMap)
    {
        org.springframework.data.domain.Sort.Direction direction = org.springframework.data.domain.Sort.Direction.ASC;

        if (orderMap.containsKey("direction"))
        {
            try
            {
                direction = org.springframework.data.domain.Sort.Direction.fromString((String) orderMap.get("direction"));
            }
            catch (IllegalArgumentException e)
            {
                direction = org.springframework.data.domain.Sort.Direction.ASC;
            }

        }

        if (org.springframework.data.domain.Sort.Direction.ASC.equals(direction))
        {
            return org.springframework.data.domain.Sort.Order.asc((String) orderMap.get(PROPERTY));
        }
        else if (org.springframework.data.domain.Sort.Direction.DESC.equals(direction))
        {
            return org.springframework.data.domain.Sort.Order.desc((String) orderMap.get(PROPERTY));
        }
        else
        {
            return Sort.Order.by((String) orderMap.get(PROPERTY));
        }
    }
}
