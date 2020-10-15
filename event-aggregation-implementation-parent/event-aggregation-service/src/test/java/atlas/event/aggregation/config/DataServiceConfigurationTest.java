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
import org.junit.Test;

public class DataServiceConfigurationTest
{
    DataServiceConfiguration task = new DataServiceConfiguration();
    String satelliteServiceUrl = "http://172.30.211.106:9205/satellite-crud";
    String orbitalServiceUrl = "http://172.30.211.106:9204/orbital-crud";
    String observationServiceUrl = "http://172.30.211.103:9001/observation-crud";
    String sensorServiceUrl = "http://172.30.211.106:9206/sensor-crud";
    String notesServiceUrl = "http://172.30.211.106:9203/notes-crud";
    String graphQlExtension = "https://www.graphQlExtension.com";
    String eventServiceUrl = "http://172.30.211.106:9210/ssaevent-crud";

    @Test
    public void init()
    {
        task.init();
    }

    @Test
    public void test() throws Exception
    {
        GetterSetterTester tester = new GetterSetterTester()
        {
            @Override
            protected Object getInstance()
            {
                return new DataServiceConfiguration();
            }
        };
        tester.testGettersAndSetters();
    }
}