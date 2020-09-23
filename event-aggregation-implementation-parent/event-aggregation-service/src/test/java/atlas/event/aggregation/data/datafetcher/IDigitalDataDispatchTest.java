package atlas.event.aggregation.data.datafetcher;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;

public class IDigitalDataDispatchTest
{
    public IDigitalDataDispatch task;
    String url = "https://www.google.com";

    @Test
    public void sendHttpGetRestRequestAsString()
    {
        String responseString = task.sendHttpGetRestRequestAsString(url);
        InputStream responseStream = task.sendHttpGetRestRequestAsStream(url);
    }
}