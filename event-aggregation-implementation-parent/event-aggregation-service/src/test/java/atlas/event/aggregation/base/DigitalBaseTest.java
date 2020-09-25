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
package atlas.event.aggregation.base;

import atlas.event.aggregation.SpringContextFactory;
import atlas.event.aggregation.cache.DigitalCache;
import graphql.schema.DataFetchingEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DigitalBaseTest
{
    @Mock
    DataFetchingEnvironment environment;
    @Mock
    DigitalBase mockTask = mock(DigitalBase.class);
    @Autowired
    ApplicationContext applicationContext;
    DigitalBase task = new DigitalBase();

    @Before
    public void setUp()
    {
        SpringContextFactory.setContext(applicationContext);
        when(mockTask.locateService(anyString())).thenReturn(new Object());
        when(mockTask.getDigitalCache()).thenReturn(new DigitalCache());
        when(mockTask.getRequestPath(environment)).thenReturn("");
    }

    @Test(expected = NullPointerException.class)
    public void testLocateService()
    {
        assertNull(task.locateService(""));
        task.locateService("anchor");
    }

    @Test(expected = NullPointerException.class)
    public void testGetDigitalCache()
    {
        task.getDigitalCache();
        assertNotNull(task);
    }

    @Test(expected = NullPointerException.class)
    public void testGetRequestPath()
    {
        assertNull(task.getRequestPath(null));
        task.getRequestPath(environment);
    }
}