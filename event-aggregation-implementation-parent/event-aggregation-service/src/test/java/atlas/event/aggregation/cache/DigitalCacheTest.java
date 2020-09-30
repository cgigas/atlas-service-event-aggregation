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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DigitalCacheTest
{
    DigitalCache task = new DigitalCache();
    String key = "user.country";
    String value = "US";
    Map<String, String> businessHandlerMap = new HashMap<>();
    Map<String, String> externalServiceUrlMap = new HashMap<>();

    @Test
    public void addBusinessHandler()
    {
        task.addBusinessHandler(key, value);
        assertEquals(value, task.getBusinessHandler(key));
    }

    @Test
    public void addExternalServiceUrl()
    {
        task.addExternalServiceUrl(key, value);
        assertEquals(value, task.getExternalServiceUrl(key));
    }

    @Test
    public void setBusinessHandlerMap()
    {
        task.setBusinessHandlerMap(businessHandlerMap);
        assertEquals(businessHandlerMap, task.getBusinessHandlerMap());
    }

    @Test
    public void setExternalServiceUrlMap()
    {
        task.setExternalServiceUrlMap(externalServiceUrlMap);
        assertEquals(externalServiceUrlMap, task.getExternalServiceUrlMap());
    }
}