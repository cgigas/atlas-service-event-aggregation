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
package atlas.event.aggregation.parser.event;

import atlas.ssaevent.crud.graphql.EventRelationship;
import atlas.ssaevent.crud.graphql.EventSat;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class EventSatelliteParserTest
{
    EventSatelliteParser task = new EventSatelliteParser();

    @Test
    public void fromGraphqlClient()
    {
        atlas.ssaevent.crud.graphql.EventSat eventSat = new EventSat();
        eventSat.setEventSatUuid("uuid");
        eventSat.setSatelliteUuid("sat uuid");
        eventSat.setUcn(1);
        eventSat.setRelationship(EventRelationship.ACTOR);
        eventSat.setVersion(2L);
        assertNotNull(task.fromGraphqlClient(eventSat));
    }

    @Test
    public void toGraphqlClient()
    {
        Map model = new HashMap<>();
        model.put("satelliteUuid", "satelliteUuid");
        model.put("eventUuid", "eventUuid");
        model.put("relationship", "ACTOR");
        model.put("ucn", 1);
        model.put("version", 2L);
        assertNotNull(task.toGraphqlClient(model, true));
    }
}