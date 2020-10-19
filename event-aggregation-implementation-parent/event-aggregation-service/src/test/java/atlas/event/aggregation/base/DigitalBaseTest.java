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
import graphql.schema.DataFetchingEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DigitalBaseTest
{
    @Mock
    DataFetchingEnvironment environment;
    @Autowired
    ApplicationContext applicationContext;

    @Before
    public void setUp()
    {
        SpringContextFactory.setContext(applicationContext);
    }

    @Test(expected = NullPointerException.class)
    public void test()
    {
        DigitalBase task = new DigitalBase();
        assertNotNull(task);
        task.getDigitalCache();
        task.getRequestPath(environment);
    }
}