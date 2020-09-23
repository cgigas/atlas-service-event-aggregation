package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.server.exception.EventAggregationQueryException;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collection;

class AbstractDataDispatchTest
{
    AbstractDataDispatch task = new AbstractDataDispatch()
    {
        @Override
        protected Object performFetch(DataFetchingEnvironment environment)
        {
            return null;
        }

        @Override
        protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
        {
            return null;
        }
    };

    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    @Mock
    DataFetchingEnvironment environment;

    @Test
    void initializeRuntimeTypeInformation()
    {
        task.initializeRuntimeTypeInformation();
    }

    @Test
    void get() throws Exception
    {
        task.get(environment);
    }

    @Test
    void buildErrorResult()
    {
        task.buildErrorResult(environment, new Object(), new RuntimeException());
    }

    @Test
    void buildWarningResult()
    {

    }

    @Test
    void getExtensions()
    {
        task.getExtensions(environment);
    }

    @Test
    void performFetch()
    {
        task.performFetch(environment);
    }

    @Test
    void provideRuntimeTypeWiring()
    {
        task.provideRuntimeTypeWiring();
    }

    @Test
    void addToLocalContext()
    {
        task.addToLocalContext("user.country","US");
    }

    @Test
    void getPageRequestArgument()
    {
        task.getPageRequestArgument(environment,"US");
    }
}