package atlas.event.aggregation.data.datafetcher.loader;

import atlas.event.aggregation.data.model.repository.ssaevent.SsaEventRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class DataLoaderTest
{
    DataLoader task;

    @Before
    public void setUp()
    {
    }

    @Test
    public void testInit()
    {
        task.init();
    }
}