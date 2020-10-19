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
package atlas.event.aggregation.base;

import atlas.event.aggregation.cache.DigitalCache;
import com.google.common.annotations.VisibleForTesting;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class DigitalBase
{
    @Autowired
    ApplicationContext applicationContext;

    protected Object locateService(String anchorId)
    {
        Object serviceObject = null;

        if (StringUtils.isNotBlank(anchorId))
        {
            serviceObject = applicationContext.getBean(anchorId);
        }

        return serviceObject;
    }

    protected DigitalCache getDigitalCache()
    {
        DigitalCache cache = null;
        Object o = locateService("digitalCache");

        if (o instanceof DigitalCache)
        {
            cache = (DigitalCache) o;
        }
        return cache;
    }

    @VisibleForTesting
    protected String getRequestPath(DataFetchingEnvironment environment)
    {
        String requestPath = null;

        if (environment != null)
        {
            requestPath = environment.getExecutionStepInfo().getPath().toString();
        }

        return requestPath;
    }
}
