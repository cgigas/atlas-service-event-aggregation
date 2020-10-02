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
package atlas.event.aggregation.cache;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component("digitalCache")
public class DigitalCache
{
    private Map<String, String> businessHandlerMap;
    private Map<String, String> externalServiceUrlMap;

    public void addBusinessHandler(String key, String value)
    {
        getBusinessHandlerMap().put(key, value);
    }

    public void addExternalServiceUrl(String key, String value)
    {
        getExternalServiceUrlMap().put(key, value);
    }

    public String getExternalServiceUrl(String key)
    {
        return getExternalServiceUrlMap().get(key);
    }

    public String getBusinessHandler(String urlName)
    {
        String anchorName = null;
        if (StringUtils.isNotBlank(urlName))
        {
            anchorName = getBusinessHandlerMap().get(urlName);
        }

        return anchorName;
    }

    public Map<String, String> getBusinessHandlerMap()
    {
        if (businessHandlerMap == null)
        {
            businessHandlerMap = new HashMap<>();
        }
        return businessHandlerMap;
    }

    public void setBusinessHandlerMap(Map<String, String> businessHandlerMap)
    {
        this.businessHandlerMap = businessHandlerMap;
    }

    public Map<String, String> getExternalServiceUrlMap()
    {
        if (externalServiceUrlMap == null)
        {
            externalServiceUrlMap = new HashMap<>();
        }

        return externalServiceUrlMap;
    }

    public void setExternalServiceUrlMap(Map<String, String> externalServiceUrlMap)
    {
        this.externalServiceUrlMap = externalServiceUrlMap;
    }
}