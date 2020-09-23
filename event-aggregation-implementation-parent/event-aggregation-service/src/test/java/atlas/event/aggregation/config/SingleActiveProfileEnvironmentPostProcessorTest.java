package atlas.event.aggregation.config;

import org.junit.jupiter.api.Test;
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