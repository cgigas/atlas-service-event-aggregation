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
package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.data.access.accessor.exception.DataAccessorException;
import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.mpeprocessing.MPEProcessingConfiguration;
import atlas.event.aggregation.parser.ConfigParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import atlas.ssaevent.crud.graphql.EventCrudMutationExecutor;
import atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput;
import com.google.common.collect.Lists;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("prod")
public class MPEProcessingConfigDispatch extends AbstractDataDispatch<MPEProcessingConfiguration>
{
    @Autowired
    private ConfigParser configParser;

    public MPEProcessingConfigDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceQuery")
            .dataFetcher("mpeConfigTemplateByName", this));
        builders.add(newTypeWiring("MPEServiceMutation")
            .dataFetcher("createMpeProcessingConfiguration", this)
            .dataFetcher("updateMpeConfig", this)
            .dataFetcher("createMpeConfigFromTemplate", this));
        return builders;
    }

    @Override
    protected Object performFetch(DataFetchingEnvironment environment)
    {
        String path = getRequestPath(environment);
        Object result = null;
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                case "/mpeConfigTemplateByName":
                    result = null;
                    break;
                case "/createMpeProcessingConfiguration":
                    result = processCreateConfig(environment);
                    break;
                case "/deleteMpeConfig":
                    result = processDeleteConfig(environment);
                    break;
                case "/updateMpeConfig":
                    result = processUpdateConfig(environment);
                    break;
            }
        }
        return result;
    }

    private MPEProcessingConfiguration processDeleteConfig(DataFetchingEnvironment environment)
    {
        MPEProcessingConfiguration configuration = new MPEProcessingConfiguration();
        return configuration;
    }

    private MPEProcessingConfiguration processUpdateConfig(DataFetchingEnvironment environment)
    {
        MPEProcessingConfiguration configuration = new MPEProcessingConfiguration();
        return configuration;
    }

    private MPEProcessingConfiguration processCreateConfig(DataFetchingEnvironment environment)
    {
        MPEProcessingConfiguration mpeProcessingConfiguration = new MPEProcessingConfiguration();
        EventCrudMutationExecutor eventCrudMutationExecutor = null;

        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            Map<String, Object> configData = environment.getArgument("configData");
            if (configData != null)
            {
                atlas.ssaevent.crud.graphql.MpeProcessingConfiguration configEvent = (atlas.ssaevent.crud.graphql.MpeProcessingConfiguration) configParser.toGraphqlClient(configData, Boolean.TRUE);
                atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput clientEventData = null;

                // check for Config Data
                if (configData.containsKey("configData"))
                {
                    clientEventData = (atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput) configParser.toGraphqlClient(configData.get("configData"), Boolean.TRUE);
                    try
                    {
                        StringBuffer queryString = new StringBuffer();
                        queryString.append(" mpeProcessingConfigUuid\n");
                        queryString.append(" classificationMarking\n");
                        queryString.append(" eventUuid\n");
                        queryString.append(" event\n");
                        queryString.append(" candidateRsoReservationUuid\n");
                        queryString.append(" analystRsoReservationUuid\n");
                        queryString.append(" catalogRsoReservationUuid\n");
                        queryString.append(" ucnReservationUuid\n");
                        queryString.append(" candidateFormationParametersUuid\n");
                        queryString.append(" candidateFormationParameters\n");
                        queryString.append(" currentFlag\n");
                        queryString.append(" name\n");
                        queryString.append(" description\n");
                        queryString.append(" analystMinTracksPerDay\n");
                        queryString.append(" analystMinTracksReceived\n");
                        queryString.append(" catalogMinTracksReceived\n");
                        queryString.append(" analystMinOdSolutions\n");
                        queryString.append(" catalogMinOdSolutions\n");
                        queryString.append(" analystRmsTrendMean\n");
                        queryString.append(" analystRmsTrendSd\n");
                        queryString.append(" catalogRmsTrendSd\n");
                        queryString.append(" analystMinResidualAcceptance\n");
                        queryString.append(" catalogMinResidualAcceptance\n");
                        queryString.append(" analystMinArgumentLatitude\n");
                        queryString.append(" catalogMinArgumentLatitude\n");
                        queryString.append(" analystMinReportingSensors\n");
                        queryString.append(" catalogMinReportingSensors\n");
                        queryString.append(" createOrigin\n");
                        queryString.append(" updateDate\n");
                        queryString.append(" updateOrigin\n");
                        queryString.append(" version\n");
                        queryString.append("}\n");
                        atlas.ssaevent.crud.graphql.MpeProcessingConfiguration configEventCreateResult = eventCrudMutationExecutor.createMpeProcessingConfiguration(queryString.toString(), clientEventData, configEvent);
                        mpeProcessingConfiguration = (MPEProcessingConfiguration) configParser.fromGraphqlClient(configEventCreateResult);
                    }
                    catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                    {
                        e.printStackTrace();
                        throw new DataAccessorException(e);
                    }
                }
            }
        }
        return mpeProcessingConfiguration;
    }
}