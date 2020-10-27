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
package atlas.event.aggregation.parser.event;

import atlas.event.aggregation.data.paging.elements.*;
import atlas.event.aggregation.parser.IParser;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class EventMasterParser implements IParser
{
    @Override
    public String toJSONString(Object fromJson)
    {
        return null;
    }

    @Override
    public Object fromJsonString(String json)
    {
        return null;
    }

    @Override
    public Object fromJson(Object json)
    {
        return null;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        return null;
    }

    public abstract Object fromGraphqlClient(Object graphql);

    @Override
    public abstract Object toGraphqlClient(Object model, Boolean inputMode);

    public Object toTimePeriod(Object model)
    {
        Object result = null;

        return result;
    }

    public TimePeriod fromGraphqlTimePeriod(Object graphqlTimePeriod)
    {
        TimePeriod timePeriod = null;

        if (graphqlTimePeriod instanceof Map)
        {
            Map<String, Object> map = (Map) graphqlTimePeriod;
            OffsetDateTime startDate = getItemAsOffSetDate("startref", map);
            OffsetDateTime endDate = getItemAsOffSetDate("end", map);
            String durationUnits = getItemAsString("durationUnit", map);
            Integer durationAmount = getItemAsInteger("duration", map);
            if (endDate == null)
            {
                endDate = startDate.plus(durationAmount, ChronoUnit.valueOf(durationUnits));
            }

            timePeriod = TimePeriod.ofStartAndEnd(startDate, endDate);

        }

        return timePeriod;
    }

    public Object toPageInfo(Object model)
    {
        atlas.ssaevent.crud.graphql.PageInfo eventCrudPageInfo = null;
        if (model != null)
        {
            if (model instanceof Map)
            {
                eventCrudPageInfo = new atlas.ssaevent.crud.graphql.PageInfo();
                Map<String, Object> pageMap = (Map) model;
                eventCrudPageInfo.setPage(getItemAsInteger("page", pageMap));
                eventCrudPageInfo.setSize(getItemAsInteger("size", pageMap));

                // now the sort
                Map<String, Object> sortMap = (Map)pageMap.get("sort");
                if (sortMap != null)
                {
                    atlas.ssaevent.crud.graphql.Sort eventCrudSort = new atlas.ssaevent.crud.graphql.Sort();
                    List<atlas.ssaevent.crud.graphql.Order> eventCrudOrderList = new ArrayList<>();
                    eventCrudSort.setOrders(eventCrudOrderList);
                    eventCrudPageInfo.setSort(eventCrudSort);
                    List<Map<String, Object>> orderList = (List)sortMap.get("orders");
                    if (orderList != null)
                    {
                        for (Map<String, Object> orderItemMap: orderList)
                        {
                            atlas.ssaevent.crud.graphql.Order order = new atlas.ssaevent.crud.graphql.Order();
                            order.setDirection(atlas.ssaevent.crud.graphql.Direction.valueOf((String)orderItemMap.get("direction")));
                            order.setProperty(getItemAsString("property", orderItemMap));
                            eventCrudOrderList.add(order);
                        }
                    }
                }
            }
        }
        return eventCrudPageInfo;
    }

    @Override
    public PageInfo fromGraphqlPageInfo(Object graphqlPageInfo)
    {
        PageInfo eventPageInfo = null;
        if (graphqlPageInfo != null)
        {
            if (graphqlPageInfo instanceof atlas.ssaevent.crud.graphql.PageInfo)
            {
                atlas.ssaevent.crud.graphql.PageInfo eventCrudPageInfo = (atlas.ssaevent.crud.graphql.PageInfo) graphqlPageInfo;
                eventPageInfo = new PageInfo();
                eventPageInfo.setSize(eventCrudPageInfo.getSize());
                eventPageInfo.setPage(eventCrudPageInfo.getPage());

                // convert over the sort
                Sort eventSort = null;
                if (eventCrudPageInfo.getSort() != null)
                {
                    eventSort = new Sort();
                    eventPageInfo.setSort(eventSort);

                    atlas.ssaevent.crud.graphql.Sort eventCrudSort = eventCrudPageInfo.getSort();
                    if ((eventCrudSort != null) && (eventCrudSort.getOrders() != null))
                    {
                        for (atlas.ssaevent.crud.graphql.Order eventCrudOrderItem: eventCrudSort.getOrders())
                        {
                            Order order = new Order();
                            order.setDirection(Direction.valueOf(eventCrudOrderItem.getDirection().name()));
                            order.setProperty(eventCrudOrderItem.getProperty());
                            eventSort.getOrders().add(order);
                        }
                    }
                }
            }
        }

        return eventPageInfo;
    }
}
