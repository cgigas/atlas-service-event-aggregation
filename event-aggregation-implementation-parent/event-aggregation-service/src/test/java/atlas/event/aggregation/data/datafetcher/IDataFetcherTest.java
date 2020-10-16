package atlas.event.aggregation.data.datafetcher;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class IDataFetcherTest
{
    IDataFetcher spy = Mockito.spy(IDataFetcher.class);
    String elementName = "element";
    Map<String, Object> map = new HashMap<>();
    JSONObject jsonObject = new JSONObject();

    @Test
    public void getItemAsOffSetDate()
    {
        spy.getItemAsOffSetDate(elementName, map);
    }

    @Test
    public void getItemAsDouble()
    {
        spy.getItemAsDouble("2.0", map);
    }

    @Test
    public void getItemAsInteger()
    {
        spy.getItemAsInteger("1", new JSONObject());
    }

    @Test
    public void getItemAsLong()
    {
        spy.getItemAsLong("3L", map);
    }

    @Test
    public void getItemAsString()
    {
        spy.getItemAsString(elementName, map);
    }

    @Test
    public void testGetItemAsOffSetDate()
    {
        spy.getItemAsOffSetDate(elementName, map);
    }
}