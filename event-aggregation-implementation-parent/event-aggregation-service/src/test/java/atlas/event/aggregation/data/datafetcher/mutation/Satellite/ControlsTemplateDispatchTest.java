package atlas.event.aggregation.data.datafetcher.mutation.Satellite;

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlsTemplateDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    ControlsTemplateDispatch task = new ControlsTemplateDispatch(collector);
    DataFetchingEnvironment environment;

    @Test
    public void performFetch()
    {
        task.performFetch(environment);
    }

    @Test
    public void provideRuntimeTypeWiring()
    {
        task.provideRuntimeTypeWiring();
    }
}