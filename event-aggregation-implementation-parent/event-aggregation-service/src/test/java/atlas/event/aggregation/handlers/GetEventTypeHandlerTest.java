package atlas.event.aggregation.handlers;

import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class GetEventTypeHandlerTest
{
    GetEventTypeHandler task = new GetEventTypeHandler();

    @Mock
    DataFetchingEnvironment environment;

    @Test
    void processRequest()
    {
        task.processRequest(environment);
    }
}