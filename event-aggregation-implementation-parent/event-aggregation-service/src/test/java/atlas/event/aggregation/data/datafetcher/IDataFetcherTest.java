/*
 * ******************************************************************************
 *  WARNING: EXPORT CONTROLLED - EAR
 *  THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *  GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *  REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *  FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *  VIOLATION OF FEDERAL LAW.
 * ******************************************************************************
 *  Unlimited Government Rights
 *  WARNING: Do Not Use On A Privately Funded Program Without Permission.
 * ******************************************************************************
 *  CLASSIFICATION:   Unclassified
 *
 *  LIMITATIONS:      None
 * ******************************************************************************
 */
package atlas.event.aggregation.data.datafetcher;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class IDataFetcherTest
{
    IDataFetcher spy = Mockito.spy(IDataFetcher.class);
    Map<String, Object> map = new HashMap<>();
    JSONObject jsonObject = new JSONObject();

    @Test
    public void getItemAsOffSetDate()
    {
        map.put("stringName", "2007-12-03T10:15:30+01:00");
        assertNotNull(spy.getItemAsOffSetDate("stringName", map));
    }

    @Test
    public void getItemAsDouble()
    {
        map.put("2.0", 2.0);
        assertNotNull(spy.getItemAsDouble("2.0", map));
    }

    @Test
    public void getItemAsInteger()
    {
        jsonObject.put("1", 1);
        assertNotNull(spy.getItemAsInteger("1", jsonObject));
    }

    @Test
    public void getItemAsLong()
    {
        map.put("3L", 3L);
        spy.getItemAsLong("3L", map);
    }

    @Test
    public void getItemAsString()
    {
        map.put("string", "string");
        spy.getItemAsString("string", map);
    }
}