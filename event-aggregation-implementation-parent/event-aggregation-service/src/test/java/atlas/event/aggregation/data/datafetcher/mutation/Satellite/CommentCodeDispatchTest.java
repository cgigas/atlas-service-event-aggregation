package atlas.event.aggregation.data.datafetcher.mutation.Satellite;

import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommentCodeDispatchTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    CommentCodeDispatch task = new CommentCodeDispatch(collector);
    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class, Mockito.CALLS_REAL_METHODS);

    @Test(expected = NullPointerException.class)
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