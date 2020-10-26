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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.paging.elements.PageInfo;
import org.apache.commons.lang3.StringUtils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public interface IParser
{
    String toJSONString(Object fromJson);

    Object fromJsonString(String json);

    Object fromJson(Object json);

    Object fromJson(Map<String, Object> map);

    Object fromGraphqlClient(Object graphql);

    Object toGraphqlClient(Object model, Boolean inputMode);

    Object toPageInfo(Object model);

    PageInfo fromGraphqlPageInfo(Object graphqlPageInfo);

    default OffsetDateTime getItemAsOffSetDate(String elementName, Map<String, Object> map)
    {
        OffsetDateTime item = null;
        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                if (o instanceof OffsetDateTime)
                {
                    item = (OffsetDateTime) o;
                }
                else
                {
                    item = OffsetDateTime.parse((String) o, DateTimeFormatter.ISO_DATE_TIME);
                }
            }
        }

        return item;
    }


    default Double getItemAsDouble(String elementName, Map<String, Object> map)
    {
        Double item = null;

        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                item = (Double) o;
            }
        }

        return item;
    }

    default Integer getItemAsInteger(String elementName, Map<String, Object> map)
    {
        Integer item = null;
        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                item = (Integer) o;
            }
        }
        return item;
    }


    default Long getItemAsLong(String elementName, Map<String, Object> map)
    {
        Long item = null;
        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                item = (Long) o;
            }
        }

        return item;
    }

    default String getItemAsString(String elementName, Map<String, Object> map)
    {
        String item = null;

        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                item = (String) o;
            }
        }

        return item;
    }

    default Boolean getItemAsBoolean(String elementName, Map<String, Object> map)
    {
        Boolean item = null;
        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                item = (Boolean) o;
            }
        }

        return item;
    }
}