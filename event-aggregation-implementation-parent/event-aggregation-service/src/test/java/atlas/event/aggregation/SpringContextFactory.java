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
package atlas.event.aggregation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringContextFactory implements ApplicationContextAware
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringContextFactory.class);
    private static ApplicationContext context = null;

    /**
     * Get the active context.
     *
     * @return spring configuration application context
     * @throws IllegalStateException when context is not previously set.
     */
    public static synchronized ApplicationContext getContext()
    {
        if (context == null)
        {
            throw new IllegalStateException("Context not found.");
        }
        return context;
    }

    /**
     * This method is provided primarily for test support or for when the application context
     * is created through a different means but needs to be available through this factory.
     *
     * @param newContext
     */
    public static synchronized void setContext(ApplicationContext newContext)
    {
        context = newContext;
    }

    /**
     * Build Spring Context given valid annotatedClasses. Caller is responsible for providing valid and discoverable
     * classes.
     *
     * @param annotatedClasses
     */
    @SuppressWarnings("rawtypes")
    public static synchronized void buildContext(Class... annotatedClasses)
    {
        if (context == null)
        {
            context = new AnnotationConfigApplicationContext(annotatedClasses);
            if (context instanceof AbstractApplicationContext)
            {
                ((AbstractApplicationContext) context).registerShutdownHook();
            }
        }
        else
        {
            LOGGER.debug("context already exists. reusing existing context object");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext newContext) throws BeansException
    {
        if (context == null)
        {
            context = newContext;
        }
    }
}