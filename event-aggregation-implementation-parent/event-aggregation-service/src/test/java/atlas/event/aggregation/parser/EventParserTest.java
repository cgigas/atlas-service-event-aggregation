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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.parser.event.EventParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

public class EventParserTest
{
    @Mock
    EventParser task = mock(EventParser.class, Mockito.CALLS_REAL_METHODS);
    JSONObject jsonObj = new JSONObject();
    Map<String, Object> map = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testFromJsonString()
    {
        map.put("event", "sat");

        try
        {
            String jstring = objectMapper.writeValueAsString(map);
            task.fromJsonString(jstring);
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("java.lang.String cannot be cast to java.util.Map"));
        }

        try
        {
            task.fromJsonString(anyString());
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("Unexpected token END OF FILE at position 0"));
        }
    }

    @Test
    public void testFromJson()
    {
        assertNotNull(task.fromJson(jsonObj));
        assertNotNull(task.fromJson(map));
    }
}