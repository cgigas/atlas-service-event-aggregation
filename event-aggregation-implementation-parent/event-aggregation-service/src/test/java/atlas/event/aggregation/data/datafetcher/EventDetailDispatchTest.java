package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class EventDetailDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    EventDetailDispatch task = new EventDetailDispatch(collector);
    @Mock
    DataFetchingEnvironment environment;

    @Test
    void performFetch()
    {
        assertNull(task.performFetch(environment));
    }

    @Test
    void provideRuntimeTypeWiring()
    {
        assertNotNull(task.provideRuntimeTypeWiring());
    }
}