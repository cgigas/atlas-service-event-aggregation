package atlas.event.aggregation.base;

import atlas.event.aggregation.cache.DigitalCache;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DigitalBaseTest
{
    @Mock
    DataFetchingEnvironment environment;
    @Mock
    DigitalBase mockTask = mock(DigitalBase.class);
    @Mock
    ApplicationContext mockContext = mock(ApplicationContext.class);
    DigitalBase task = new DigitalBase();

    @Before
    public void setUp()
    {
        when(mockContext.getBean(anyString())).thenReturn(new Object());
        when(mockTask.locateService(anyString())).thenReturn(new Object());
    }

    @Test
    public void testLocateService()
    {
        try
        {
            task.locateService("anchor");
        }
        catch (Exception e)
        {
        }
        assertNull(task.locateService(""));
    }

    @Test
    public void testGetDigitalCache()
    {
        mockTask.getDigitalCache();
    }

    @Test
    public void testGetRequestPath()
    {
        mockTask.getRequestPath(environment);
    }

}