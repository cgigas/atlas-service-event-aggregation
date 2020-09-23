package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class EventDataDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    EventDataDispatch task = new EventDataDispatch(collector);
    @Mock
    DataFetchingEnvironment environment;

    @Test
    void provideRuntimeTypeWiring()
    {
        assertNotNull(task.provideRuntimeTypeWiring());
    }

    @Test
    void performFetch()
    {
        assertNull(task.performFetch(environment));
    }
}