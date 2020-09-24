package atlas.event.aggregation.handlers;

import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

class EventTypeSummaryHandlerTest
{
    EventTypeSummaryHandler task = new EventTypeSummaryHandler();
    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class);

    @Test
    void processRequest()
    {
        task.processRequest(environment);
    }
}