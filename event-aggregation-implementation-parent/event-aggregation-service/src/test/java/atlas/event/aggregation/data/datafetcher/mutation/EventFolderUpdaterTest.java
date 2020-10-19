package atlas.event.aggregation.data.datafetcher.mutation;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EventFolderUpdaterTest
{
    EventFolderUpdater task = new EventFolderUpdater();

    @Test
    public void test()
    {
        assertNotNull(task);
    }
}