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
                atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput clientEventData;

                clientEventData = (atlas.ssaevent.crud.graphql.MpeProcessingConfigurationInput) MPEProcessingConfigParser.toGraphqlClient(configData, Boolean.TRUE);
                try
                {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("{ mpeProcessingConfigUuid classificationMarking eventUuid event { eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData { eventDataUuid classificationMarking eventUuid name uri type supplementalData createDate createOrigin updateDate updateOrigin version } createDate createOrigin updateDate updateOrigin version } candidateRsoReservationUuid analystRsoReservationUuid catalogRsoReservationUuid ucnReservationUuid candidateFormationParametersUuid candidateFormationParameters { candidateFormationParametersUuid classificationMarking pdotCoefficients coplanarCheckThreshold periodAssociationThreshold minimumTracksPerCluster createDate createOrigin updateDate updateOrigin version } currentFlag name description analystMinTracksPerDay analystMinTracksReceived catalogMinTracksReceived analystMinOdSolutions catalogMinOdSolutions analystRmsTrendMean analystRmsTrendSd catalogRmsTrendSd analystMinResidualAcceptance catalogMinResidualAcceptance analystMinArgumentLatitude catalogMinArgumentLatitude analystMinReportingSensors catalogMinReportingSensors createOrigin updateDate updateOrigin version }  }");
                    atlas.ssaevent.crud.graphql.MpeProcessingConfiguration configEventCreateResult = eventCrudMutationExecutor.createMpeProcessingConfiguration(buffer.toString(), clientEventData);
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