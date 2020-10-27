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

import org.json.simple.JSONArray;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;

public class ObservationSatMedleyParserTest
{
    ObservationSatMedleyParser task = new ObservationSatMedleyParser();
    JSONArray fromJson = new JSONArray();
    String json = "";
    Map<String, Object> map = new HashMap<>();
    Object Map;

    @Test
    public void toJSONString()
    {
        assertNull(task.toJSONString(fromJson));
    }

    @Test
    public void fromJsonString()
    {
        assertNull(task.fromJsonString(json));
    }

    @Test
    public void fromJson()
    {
        fromJson.add(0, map);
        assertNull(task.fromJson(fromJson));
    }

    @Test
    public void testFromJson()
    {
        assertNull(task.fromJson(map));
    }

    @Test
    public void testGraphql()
    {
        assertNull(task.fromGraphqlClient(new Object()));
        assertNull(task.toGraphqlClient(new Object(), true));
    }
}