package atlas.event.aggregation.data.datafetcher.mutation.Satellite;

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;

public class CurrentRcsDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    CurrentRcsDispatch task = new CurrentRcsDispatch(collector);
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