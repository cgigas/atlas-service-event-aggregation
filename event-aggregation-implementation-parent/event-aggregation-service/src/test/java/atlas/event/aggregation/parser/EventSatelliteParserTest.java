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

import atlas.event.aggregation.parser.event.EventSatelliteParser;
import atlas.ssaevent.crud.graphql.EventRelationship;
import atlas.ssaevent.crud.graphql.EventSat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class EventSatelliteParserTest
{
    EventSatelliteParser task = new EventSatelliteParser();

    @Test
    public void testFromGraphql()
    {
        EventSat graphql = new EventSat();
        graphql.setEventSatUuid("uuid");
        graphql.setSatelliteUuid("sat uuid");
        graphql.setUcn(1);
        graphql.setRelationship(EventRelationship.ACTOR);
        graphql.setVersion(2L);
        assertNotNull(task.fromGraphqlClient(graphql));
    }

    @Test
    public void testToGraphql()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("satelliteUuid", "satelliteUuid");
        map.put("eventUuid", "eventUuid");
        map.put("relationship", "ACTOR");
        map.put("ucn", 2);
        map.put("version", 2L);
        assertNotNull(task.toGraphqlClient(map, true));
    }
}