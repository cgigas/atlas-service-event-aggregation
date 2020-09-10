/*
 *  ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */
package atlas.event.aggregation.util;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class JSonUtil
{
    public static String getItemAsString(String elementName, JSONObject json)
    {
        String item = null;

        if ((StringUtils.isNotBlank(elementName)) && (json != null))
        {
            Object o = json.get(elementName);
            if (o != null)
            {
                item = (String) o;
            }
        }

        return item;
    }

    public static String getItemAsString(String elementName, Map<String, Object> map)
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

    public static Double getItemAsDouble(String elementName, Map<String, Object> map)
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

    public static Integer getItemAsInteger(String elementName, JSONObject json)
    {
        Integer item = null;
        if ((StringUtils.isNotBlank(elementName)) && (json != null))
        {
            Object o = json.get(elementName);
            if (o != null)
            {
                item = (Integer) o;
            }
        }

        return item;
    }

    public static Long getItemAsLong(String elementName, Map<String, Object> map)
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

    public static OffsetDateTime getItemAsOffSetDate(String elementName, JSONObject json)
    {
        OffsetDateTime item = null;
        if ((StringUtils.isNotBlank(elementName)) && (json != null))
        {
            Object o = json.get(elementName);
            if (o != null)
            {
                item = (OffsetDateTime) o;
            }
        }

        return item;
    }

    public static OffsetDateTime getItemAsOffSetDate(String elementName, Map<String, Object> map)
    {
        OffsetDateTime item = null;
        if ((StringUtils.isNotBlank(elementName)) && (map != null))
        {
            Object o = map.get(elementName);
            if (o != null)
            {
                item = OffsetDateTime.parse((String) o, DateTimeFormatter.ISO_DATE_TIME);
            }
        }

        return item;
    }
}
