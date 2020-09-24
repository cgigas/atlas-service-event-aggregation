package atlas.event.aggregation.handlers;

import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

class EventDataHandlerTest
{
    EventDataHandler task = new EventDataHandler();

    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class);

    @Test
    void processUpdateEventStatus()
    {
        task.processUpdateEventStatus(environment);
    }

    @Test
    void processEventById()
    {
        task.processEventById(environment);
    }

    @Test
    void processDeleteSdaEvent()
    {
        task.processDeleteSdaEvent(environment);
    }

    @Test
    void processPromoteEventSatellite()
    {
        task.processPromoteEventSatellite(environment);
    }

    @Test
    void processReleaseSatelliteFromEvent()
    {
        task.processReleaseSatelliteFromEvent(environment);
    }

    @Test
    void processAddSatelliteToEvent()
    {
        task.processAddSatelliteToEvent(environment);
    }

    @Test
    void processCloseSdaEvent()
    {
        task.processCloseSdaEvent(environment);
    }

    @Test
    void processEventsByTimePeriodAndType()
    {
        task.processEventsByTimePeriodAndType(environment);
    }
}