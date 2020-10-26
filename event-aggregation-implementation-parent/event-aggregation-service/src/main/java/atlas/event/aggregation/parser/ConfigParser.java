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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.parser.event.EventMasterParser;
import atlas.ssaevent.crud.graphql.MpeProcessingConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ConfigParser extends EventMasterParser
{
    @Override
    public Object fromGraphqlClient(Object graphql)
    {
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
    }

    @Override
    public Object toGraphqlClient(Object model, Boolean inputMode)
    {
        return null;
    }
}
