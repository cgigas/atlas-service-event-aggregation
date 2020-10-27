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