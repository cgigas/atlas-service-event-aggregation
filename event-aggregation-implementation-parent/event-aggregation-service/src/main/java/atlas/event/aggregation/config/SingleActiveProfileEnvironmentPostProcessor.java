/*
 *  * ******************************************************************************
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

package atlas.event.aggregation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * This post processor is run before the ApplicationContext is initialized. In ensures that if no profile is specified or
 * if multiple profiles are specified that only the production profile is active. It is an error for the dev and prod profiles
 * to both be active at the same time.
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class SingleActiveProfileEnvironmentPostProcessor implements EnvironmentPostProcessor
{
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application)
    {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length == 0)
        {
            environment.addActiveProfile("prod");
        }
        else if (activeProfiles.length > 1)
        {
            environment.setActiveProfiles("prod");
        }
    }
}
