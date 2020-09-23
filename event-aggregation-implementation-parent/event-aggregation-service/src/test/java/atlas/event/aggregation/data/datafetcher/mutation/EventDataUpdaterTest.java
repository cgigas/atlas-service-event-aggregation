package atlas.event.aggregation.data.datafetcher.mutation;

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EventDataUpdaterTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    EventDataUpdater task = new EventDataUpdater(collector);
    @Mock
    DataFetchingEnvironment environment;

    @Test
    void performFetch()
    {
        //when(environment.getExecutionStepInfo().getPath().toString()).thenReturn("/closeSdaEvent");
        assertNull(task.performFetch(environment));
    }

    @Test
    void provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        task.provideRuntimeTypeWiring();
        assertNotNull(builders);
    }
}