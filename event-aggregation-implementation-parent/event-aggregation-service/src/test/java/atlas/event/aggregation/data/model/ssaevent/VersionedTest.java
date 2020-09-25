package atlas.event.aggregation.data.model.ssaevent;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class VersionedTest
{
    @Mock
    Versioned task = mock(Versioned.class, Mockito.CALLS_REAL_METHODS);
    Long version = 3L;

    @Test
    void setVersion()
    {
        task.setVersion(version);
        assertEquals(3, task.getVersion());
    }
}