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
import atlas.event.aggregation.data.model.mpeprocessing.MPEProcessingConfiguration;
import atlas.event.aggregation.parser.MPEProcessingConfigParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import atlas.ssaevent.crud.graphql.EventCrudMutationExecutor;
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
    private MPEProcessingConfigParser MPEProcessingConfigParser;

    public MPEProcessingConfigDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceQuery")
            .dataFetcher("mpeProcessingConfiguration", this)
            .dataFetcher("mpeProcessingConfigurationPage", this)
            .dataFetcher("mpeProcessingConfigurationPageById", this)
            .dataFetcher("mpeProcessingConfigurationPageByExample", this)
            .dataFetcher("mpeProcessingConfigurationPageByCriteria", this)
            .dataFetcher("mpeProcessingConfigTemplate", this)
            .dataFetcher("mpeProcessingConfigTemplatePage", this)
            .dataFetcher("mpeProcessingConfigTemplatePageById", this)
            .dataFetcher("mpeProcessingConfigTemplatePageByExample", this)
            .dataFetcher("mpeProcessingConfigTemplatePageByCriteria", this));
        builders.add(newTypeWiring("MPEServiceMutation")
            .dataFetcher("createMpeProcessingConfiguration", this)
            .dataFetcher("deleteMpeProcessingConfiguration", this)
            .dataFetcher("updateMpeProcessingConfiguration", this)
            .dataFetcher("createMpeProcessingConfigTemplate", this)
            .dataFetcher("deleteMpeProcessingConfigTemplate", this)
            .dataFetcher("updateMpeProcessingConfigTemplate", this));
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
                case "/createMpeProcessingConfiguration":
                    result = processCreateMpeProcessingConfiguration(environment);
                    break;
                case "/deleteMpeProcessingConfiguration":
                    result = processDeleteMpeProcessingConfiguration(environment);
                    break;
                case "/updateMpeProcessingConfiguration":
                    result = processUpdateMpeProcessingConfiguration(environment);
                    break;
                case "/createMpeProcessingConfigTemplate":
                    break;
                case "/deleteMpeProcessingConfigTemplate":
                    break;
                case "/updateMpeProcessingConfigTemplate":
                    break;
            }
        }
        return result;
    }

    private MPEProcessingConfiguration processDeleteMpeProcessingConfiguration(DataFetchingEnvironment environment)
    {
        MPEProcessingConfiguration configuration = new MPEProcessingConfiguration();
        return configuration;
    }

    private MPEProcessingConfiguration processUpdateMpeProcessingConfiguration(DataFetchingEnvironment environment)
    {
        MPEProcessingConfiguration configuration = new MPEProcessingConfiguration();
        return configuration;
    }

    private MPEProcessingConfiguration processCreateMpeProcessingConfiguration(DataFetchingEnvironment environment)
    {
        MPEProcessingConfiguration mpeProcessingConfiguration = new MPEProcessingConfiguration();
        EventCrudMutationExecutor eventCrudMutationExecutor = null;

        if (environment != null)
        {
            eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
            Map<String, Object> configData = environment.getArgument("mpeProcessingConfiguration");
            if (configData != null)
            {
                atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput configEvent = (atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput) MPEProcessingConfigParser.toGraphqlClient(configData, Boolean.TRUE);
                atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput clientEventData;
                clientEventData = (atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput) MPEProcessingConfigParser.toGraphqlClient(configData.get("mpeProcessingConfiguration"), Boolean.TRUE);
                try
                {
                    StringBuffer queryString = new StringBuffer();
                    queryString.append("{mpeProcessingConfigUuid\n");
                    queryString.append(" classificationMarking\n");
                    queryString.append(" eventUuid\n");
                    queryString.append(" event{\n");
                    queryString.append(" eventUuid\n");
                    queryString.append(" classificationMarking\n");
                    queryString.append(" predecessorEventUuid\n");
                    queryString.append(" type\n");
                    queryString.append(" name\n");
                    queryString.append(" status\n");
                    queryString.append(" startDt\n");
                    queryString.append(" endDt\n");
                    queryString.append(" description\n");
                    queryString.append(" internalNotes\n");
                    queryString.append(" eventPostingId\n");
                    queryString.append(" eventData{\n");
                    queryString.append(" eventDataUuid\n");
                    queryString.append(" classificationMarking\n");
                    queryString.append(" eventUuid\n");
                    queryString.append(" name\n");
                    queryString.append(" uri\n");
                    queryString.append(" type\n");
                    queryString.append(" supplementalData\n");
                    queryString.append(" createDate\n");
                    queryString.append(" createOrigin\n");
                    queryString.append(" updateDate\n");
                    queryString.append(" updateOrigin\n");
                    queryString.append(" version}\n");
                    queryString.append(" }\n");
                    queryString.append(" createOrigin\n");
                    queryString.append(" updateDate\n");
                    queryString.append(" updateOrigin\n");
                    queryString.append(" version}\n");
                    queryString.append(" candidateRsoReservationUuid\n");
                    queryString.append(" analystRsoReservationUuid\n");
                    queryString.append(" catalogRsoReservationUuid\n");
                    queryString.append(" ucnReservationUuid\n");
                    queryString.append(" candidateFormationParametersUuid\n");
                    queryString.append(" candidateFormationParameters{\n");
                    queryString.append(" candidateFormationParametersUuid\n");
                    queryString.append(" classificationMarking\n");
                    queryString.append(" pdotCoefficients\n");
                    queryString.append(" coplanarCheckThreshold\n");
                    queryString.append(" periodAssociationThreshold\n");
                    queryString.append(" minimumTracksPerCluster\n");
                    queryString.append(" createDate\n");
                    queryString.append(" createOrigin\n");
                    queryString.append(" updateDate\n");
                    queryString.append(" updateOrigin\n");
                    queryString.append(" version}\n");
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
                    atlas.ssaevent.crud.graphql.MpeProcessingConfiguration configEventCreateResult = eventCrudMutationExecutor.createMpeProcessingConfiguration(queryString.toString(), configEvent, configEvent);
                    mpeProcessingConfiguration = (MPEProcessingConfiguration) MPEProcessingConfigParser.fromGraphqlClient(configEventCreateResult);
                }
                catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                {
                    e.printStackTrace();
                    throw new DataAccessorException(e);
                }
            }
        }
        return mpeProcessingConfiguration;
    }
}