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
package atlas.event.aggregation.config;

import atlas.event.aggregation.GetterSetterTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DataServiceConfigurationTest
{
    @Before
    public void init()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        assertNotNull(task);
        task.init();
    }

    @Test
    public void testGettersSetters() throws Exception
    {
        GetterSetterTester tester = new GetterSetterTester()
        {
            @Override
            protected Object getInstance()
            {
                return new DataServiceConfiguration();
            }
        };
        assertNotNull(tester);
        tester.testGettersAndSetters();
    }


}