package atlas.event.aggregation.data.model.ssaevent;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class VersionedTest
{
    @Mock
    Versioned task = mock(Versioned.class);
    Long version = 3L;

    @Test
    void setVersion()
    {
        task.setVersion(version);
        assertEquals(0, task.getVersion());
    }
}