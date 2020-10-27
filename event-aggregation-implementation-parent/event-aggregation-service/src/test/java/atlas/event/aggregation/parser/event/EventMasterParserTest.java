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

import atlas.ssaevent.crud.graphql.PageInfo;
import atlas.ssaevent.crud.graphql.Sort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;

public class EventMasterParserTest
{
    EventMasterParser task = spy(EventMasterParser.class);

    @Test
    public void toJSONString()
    {
        assertNull(task.toJSONString(new Object()));
    }

    @Test
    public void fromJsonString()
    {
        assertNull(task.fromJsonString(""));
    }

    @Test
    public void fromJson()
    {
        assertNull(task.fromJson(new Object()));
    }

    @Test
    public void testFromJson()
    {
        assertNull(task.fromJson(new HashMap<>()));
    }

    @Test
    public void fromGraphqlClient()
    {
        assertNull(task.fromGraphqlClient(new Object()));
    }

    @Test
    public void toGraphqlClient()
    {
        assertNull(task.toGraphqlClient(new Object(), true));
    }

    @Test
    public void toPageInfo()
    {
        Map model = new HashMap();
        Map<String, Object> sortMap = new HashMap<>();
        model.put("sort", sortMap);
        List<Map<String, Object>> orderList = new ArrayList<>();
        model.put("orders", orderList);
        assertNotNull(task.toPageInfo(model));
    }

    @Test
    public void fromGraphqlPageInfo()
    {
        atlas.ssaevent.crud.graphql.PageInfo graphqlPageInfo = new PageInfo();
        graphqlPageInfo.setPage(10);
        graphqlPageInfo.setSize(10);
        graphqlPageInfo.setSort(Sort.builder().build());
        assertNotNull(task.fromGraphqlPageInfo(graphqlPageInfo));
    }
}