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

import java.util.Map;

@Component
public class MPEProcessingConfigParser extends EventMasterParser
{
    @Override
    public Object fromGraphqlClient(Object graphql)
    {
        MpeProcessingConfiguration mpeProcessingConfiguration = new MpeProcessingConfiguration();
        if (graphql instanceof atlas.ssaevent.crud.graphql.MpeProcessingConfiguration)
        {
            atlas.ssaevent.crud.graphql.MpeProcessingConfiguration clientConfig = new MpeProcessingConfiguration();
            mpeProcessingConfiguration.setAnalystMinResidualAcceptance(clientConfig.getAnalystMinResidualAcceptance());
            mpeProcessingConfiguration.setAnalystMinReportingSensors(clientConfig.getAnalystMinReportingSensors());
            mpeProcessingConfiguration.setAnalystMinOdSolutions(clientConfig.getAnalystMinOdSolutions());
            mpeProcessingConfiguration.setAnalystMinArgumentLatitude(clientConfig.getAnalystMinArgumentLatitude());
            mpeProcessingConfiguration.setAnalystMinTracksPerDay(clientConfig.getAnalystMinTracksPerDay());
            mpeProcessingConfiguration.setAnalystMinTracksReceived(clientConfig.getAnalystMinTracksReceived());
            mpeProcessingConfiguration.setAnalystRmsTrendMean(clientConfig.getAnalystRmsTrendMean());
            mpeProcessingConfiguration.setAnalystRmsTrendSd(clientConfig.getAnalystRmsTrendSd());
            mpeProcessingConfiguration.setAnalystRsoReservationUuid(clientConfig.getAnalystRsoReservationUuid());
            mpeProcessingConfiguration.setCandidateFormationParameters(clientConfig.getCandidateFormationParameters());
            mpeProcessingConfiguration.setCandidateFormationParametersUuid(clientConfig.getCandidateFormationParametersUuid());
            mpeProcessingConfiguration.setCandidateRsoReservationUuid(clientConfig.getCandidateRsoReservationUuid());
            mpeProcessingConfiguration.setCatalogMinArgumentLatitude(clientConfig.getCatalogMinArgumentLatitude());
            mpeProcessingConfiguration.setCatalogMinOdSolutions(clientConfig.getCatalogMinOdSolutions());
            mpeProcessingConfiguration.setCatalogMinReportingSensors(clientConfig.getCatalogMinReportingSensors());
            mpeProcessingConfiguration.setCatalogMinResidualAcceptance(clientConfig.getCatalogMinResidualAcceptance());
            mpeProcessingConfiguration.setCatalogMinTracksReceived(clientConfig.getCatalogMinTracksReceived());
            mpeProcessingConfiguration.setCatalogRmsTrendSd(clientConfig.getCatalogRmsTrendSd());
            mpeProcessingConfiguration.setCatalogRsoReservationUuid(clientConfig.getCatalogRsoReservationUuid());
            mpeProcessingConfiguration.setClassificationMarking(clientConfig.getClassificationMarking());
            mpeProcessingConfiguration.setCreateOrigin(clientConfig.getCreateOrigin());
            mpeProcessingConfiguration.setCurrentFlag(clientConfig.getCurrentFlag());
            mpeProcessingConfiguration.setDescription(clientConfig.getDescription());
            mpeProcessingConfiguration.setEvent(clientConfig.getEvent());
            mpeProcessingConfiguration.setEventUuid(clientConfig.getEventUuid());
            mpeProcessingConfiguration.setMpeProcessingConfigUuid(clientConfig.getMpeProcessingConfigUuid());
            mpeProcessingConfiguration.setName(clientConfig.getName());
            mpeProcessingConfiguration.setUcnReservationUuid(clientConfig.getUcnReservationUuid());
            mpeProcessingConfiguration.setUpdateDate(clientConfig.getUpdateDate());
            mpeProcessingConfiguration.setUpdateOrigin(clientConfig.getUpdateOrigin());
            mpeProcessingConfiguration.setVersion(clientConfig.getVersion());
        }
        return mpeProcessingConfiguration;
    }

    @Override
    public Object toGraphqlClient(Object model, Boolean inputMode)
    {
        Object result = null;
        if ((model != null) && (model instanceof Map))
        {
            if (inputMode)
            {
                Map<String, Object> map = (Map) model;
                atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput mpeProcessingConfigurationInput = new atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput();
                mpeProcessingConfigurationInput.setClassificationMarking(getItemAsString("classificationMarking", map));
                mpeProcessingConfigurationInput.setEventUuid(getItemAsString("eventUuid", map));
                mpeProcessingConfigurationInput.setCandidateFormationParametersUuid(getItemAsString("candidateRsoReservationUuid", map));
                mpeProcessingConfigurationInput.setAnalystRsoReservationUuid(getItemAsString("analystRsoReservationUuid", map));
                mpeProcessingConfigurationInput.setCatalogRsoReservationUuid(getItemAsString("catalogRsoReservationUuid", map));
                mpeProcessingConfigurationInput.setUcnReservationUuid(getItemAsString("ucnReservationUuid", map));
                mpeProcessingConfigurationInput.setCandidateFormationParametersUuid(getItemAsString("candidateFormationParametersUuid", map));
                mpeProcessingConfigurationInput.setCurrentFlag(getItemAsBoolean("currentFlag", map));
                mpeProcessingConfigurationInput.setName(getItemAsString("name", map));
                mpeProcessingConfigurationInput.setDescription(getItemAsString("description", map));
                mpeProcessingConfigurationInput.setAnalystMinTracksPerDay(getItemAsInteger("analystMinTracksPerDay", map));
                mpeProcessingConfigurationInput.setCatalogMinTracksReceived(getItemAsInteger("catalogMinTracksReceived", map));
                mpeProcessingConfigurationInput.setAnalystMinOdSolutions(getItemAsInteger("analystMinOdSolutions", map));
                mpeProcessingConfigurationInput.setCatalogMinOdSolutions(getItemAsInteger("catalogMinOdSolutions", map));
                mpeProcessingConfigurationInput.setAnalystRmsTrendMean(getItemAsDouble("analystRmsTrendMean", map));
                mpeProcessingConfigurationInput.setCatalogRmsTrendSd(getItemAsDouble("catalogRmsTrendSd", map));
                mpeProcessingConfigurationInput.setCatalogMinResidualAcceptance(getItemAsDouble("catalogMinResidualAcceptance", map));
                mpeProcessingConfigurationInput.setAnalystMinArgumentLatitude(getItemAsDouble("analystsMinArgumentLatitude", map));
                mpeProcessingConfigurationInput.setCatalogMinArgumentLatitude(getItemAsDouble("catalogMinArgumentLatitude", map));
                mpeProcessingConfigurationInput.setAnalystMinReportingSensors(getItemAsInteger("analystMinReportingSensors", map));
                mpeProcessingConfigurationInput.setCatalogMinReportingSensors(getItemAsInteger("catalogMinReportingSensors", map));
                mpeProcessingConfigurationInput.setVersion(getItemAsLong("version", map));

                result = mpeProcessingConfigurationInput;
            }
            else
            {
                Map<String, Object> map = (Map) model;
                atlas.ssaevent.crud.graphql.MpeProcessingConfiguration mpeProcessingConfiguration = new atlas.ssaevent.crud.graphql.MpeProcessingConfiguration();
                mpeProcessingConfiguration.setClassificationMarking(getItemAsString("classificationMarking", map));
                mpeProcessingConfiguration.setEventUuid(getItemAsString("eventUuid", map));
                mpeProcessingConfiguration.setCandidateFormationParametersUuid(getItemAsString("candidateRsoReservationUuid", map));
                mpeProcessingConfiguration.setAnalystRsoReservationUuid(getItemAsString("analystRsoReservationUuid", map));
                mpeProcessingConfiguration.setCatalogRsoReservationUuid(getItemAsString("catalogRsoReservationUuid", map));
                mpeProcessingConfiguration.setUcnReservationUuid(getItemAsString("ucnReservationUuid", map));
                mpeProcessingConfiguration.setCandidateFormationParametersUuid(getItemAsString("candidateFormationParametersUuid", map));
                mpeProcessingConfiguration.setCurrentFlag(getItemAsBoolean("currentFlag", map));
                mpeProcessingConfiguration.setName(getItemAsString("name", map));
                mpeProcessingConfiguration.setDescription(getItemAsString("description", map));
                mpeProcessingConfiguration.setAnalystMinTracksPerDay(getItemAsInteger("analystMinTracksPerDay", map));
                mpeProcessingConfiguration.setCatalogMinTracksReceived(getItemAsInteger("catalogMinTracksReceived", map));
                mpeProcessingConfiguration.setAnalystMinOdSolutions(getItemAsInteger("analystMinOdSolutions", map));
                mpeProcessingConfiguration.setCatalogMinOdSolutions(getItemAsInteger("catalogMinOdSolutions", map));
                mpeProcessingConfiguration.setAnalystRmsTrendMean(getItemAsDouble("analystRmsTrendMean", map));
                mpeProcessingConfiguration.setCatalogRmsTrendSd(getItemAsDouble("catalogRmsTrendSd", map));
                mpeProcessingConfiguration.setCatalogMinResidualAcceptance(getItemAsDouble("catalogMinResidualAcceptance", map));
                mpeProcessingConfiguration.setAnalystMinArgumentLatitude(getItemAsDouble("analystsMinArgumentLatitude", map));
                mpeProcessingConfiguration.setCatalogMinArgumentLatitude(getItemAsDouble("catalogMinArgumentLatitude", map));
                mpeProcessingConfiguration.setAnalystMinReportingSensors(getItemAsInteger("analystMinReportingSensors", map));
                mpeProcessingConfiguration.setCatalogMinReportingSensors(getItemAsInteger("catalogMinReportingSensors", map));
                mpeProcessingConfiguration.setVersion(getItemAsLong("version", map));

                result = mpeProcessingConfiguration;
            }

        }
        return result;
    }
}
