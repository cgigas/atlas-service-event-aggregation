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
import atlas.ssaevent.crud.graphql.EventStatus;
import atlas.ssaevent.crud.graphql.EventType;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class EventParserTest
{
    EventParser task = new EventParser();

    @Test
    public void testFromGraphqlClient()
    {
        atlas.ssaevent.crud.graphql.Event graphql = new atlas.ssaevent.crud.graphql.Event();
        graphql.setEventUuid("eventUUID");
        graphql.setClassificationMarking("classMark");
        graphql.setPredecessorEventUuid("PreUUID");
        graphql.setType(EventType.BREAKUP);
        graphql.setName("name");
        graphql.setStatus(EventStatus.ACTIVE);
        graphql.setStartDt(OffsetDateTime.now());
        graphql.setEndDt(OffsetDateTime.now());
        graphql.setDescription("desc");
        graphql.setInternalNotes("notes");
        graphql.setEventPostingId("eventID");
        List<atlas.ssaevent.crud.graphql.EventData> eventData = new ArrayList();
        graphql.setEventData(eventData);
        graphql.setCreateDate(OffsetDateTime.now());
        graphql.setCreateOrigin("createOrigin");
        graphql.setUpdateDate(OffsetDateTime.now());
        graphql.setUpdateOrigin("updateOrigin");
        assertNotNull(task.fromGraphqlClient(graphql));
    }

    @Test
    public void testToGraphqlClient()
    {
        Map<String, Object> model = new HashMap<>();
        model.put("classificationMarking", "classMark");
        model.put("predecessorEventUuid", "eventUUID");
        model.put("eventType", "DOCK");
        model.put("eventName", "docking");
        model.put("eventStatus", "PLANNED");
        model.put("startDate", OffsetDateTime.now());
        model.put("endDate", OffsetDateTime.now());
        model.put("eventDesc", "desc");
        model.put("internalNotes", "notes");
        model.put("eventPostingId", "eventID");
        model.put("version", 2L);
        task.toGraphqlClient(model, true);
        task.toGraphqlClient(model, false);
    }
}