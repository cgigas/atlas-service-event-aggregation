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

<<<<<<< HEAD:event-aggregation-implementation-parent/event-aggregation-service/src/main/java/atlas/event/aggregation/parser/ConfigParser.java
import atlas.event.aggregation.parser.event.EventMasterParser;
import atlas.ssaevent.crud.graphql.MpeProcessingConfiguration;
import org.springframework.stereotype.Component;
=======
import org.junit.Before;
import static org.junit.Assert.assertNotNull;
>>>>>>> sddTest:event-aggregation-implementation-parent/event-aggregation-service/src/test/java/atlas/event/aggregation/config/DataServiceConfigurationTest.java

public class DataServiceConfigurationTest
{
    @Before
    public void init()
    {
<<<<<<< HEAD:event-aggregation-implementation-parent/event-aggregation-service/src/main/java/atlas/event/aggregation/parser/ConfigParser.java
        MpeProcessingConfiguration configuration = new MpeProcessingConfiguration();
        if (graphql instanceof atlas.ssaevent.crud.graphql.MpeProcessingConfiguration)
        {
            atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput configurationInput = (atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput) graphql;
            configuration.setAnalystMinArgumentLatitude(configurationInput.getAnalystMinArgumentLatitude());
            configuration.setAnalystMinOdSolutions(configurationInput.getAnalystMinOdSolutions());
            configuration.setAnalystMinReportingSensors(configurationInput.getAnalystMinReportingSensors());
            configuration.setAnalystMinResidualAcceptance(configurationInput.getAnalystMinResidualAcceptance());
        }
        return configuration;
=======
        DataServiceConfiguration task = new DataServiceConfiguration();
        assertNotNull(task);
        task.init();
>>>>>>> sddTest:event-aggregation-implementation-parent/event-aggregation-service/src/test/java/atlas/event/aggregation/config/DataServiceConfigurationTest.java
    }
}