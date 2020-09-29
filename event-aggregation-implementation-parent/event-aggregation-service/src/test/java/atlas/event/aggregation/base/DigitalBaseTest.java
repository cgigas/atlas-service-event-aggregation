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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DigitalBaseTest
{
    @Mock
    DataFetchingEnvironment environment;
    @Mock
    DigitalBase mockTask = mock(DigitalBase.class);
    @Autowired
    ApplicationContext applicationContext;
    DigitalBase task = new DigitalBase();

    @BeforeEach
    void setUp()
    {
        SpringContextFactory.setContext(applicationContext);
        when(mockTask.locateService(anyString())).thenReturn(new Object());
        when(mockTask.getDigitalCache()).thenReturn(new DigitalCache());
        when(mockTask.getRequestPath(environment)).thenReturn("");
    }

    @Test
    void testLocateService()
    {
        assertNull(task.locateService(""));
        assertThrows(NullPointerException.class, () ->
        {
            task.locateService("anchor");
        });

    }

    @Test
    void testGetDigitalCache()
    {
        assertThrows(NullPointerException.class, () ->
        {
            task.getDigitalCache();
        });
    }

    @Test
    void testGetRequestPath()
    {
        assertNull(task.getRequestPath(null));

        task.getRequestPath(environment);

    }
}