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
package atlas.event.aggregation.config;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import static org.junit.Assert.assertEquals;

public class SingleActiveProfileEnvironmentPostProcessorTest
{
    SingleActiveProfileEnvironmentPostProcessor task = new SingleActiveProfileEnvironmentPostProcessor();
    ConfigurableEnvironment environment = new StandardEnvironment();
    SpringApplication application = new SpringApplication();

    @Test
    public void postProcessEnvironment()
    {
        task.postProcessEnvironment(environment, application);
        environment.addActiveProfile("new profile");
        task.postProcessEnvironment(environment, application);
        environment.addActiveProfile("another new profile");
        task.postProcessEnvironment(environment, application);
        assertEquals(environment.getActiveProfiles().length, 1);
    }
}