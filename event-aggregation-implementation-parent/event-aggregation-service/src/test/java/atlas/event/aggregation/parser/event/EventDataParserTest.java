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

import atlas.ssaevent.crud.graphql.EventData;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EventDataParserTest
{
    EventDataParser task = new EventDataParser();

    @Test
    public void fromGraphqlClient()
    {
        atlas.ssaevent.crud.graphql.EventData graphql = new EventData();
        task.fromGraphqlClient(graphql);
    }

    @Test
    public void toGraphqlClient()
    {
        Map<String, Object> model = new HashMap<>();
        task.toGraphqlClient(model, true);
        task.toGraphqlClient(model, false);
    }
}