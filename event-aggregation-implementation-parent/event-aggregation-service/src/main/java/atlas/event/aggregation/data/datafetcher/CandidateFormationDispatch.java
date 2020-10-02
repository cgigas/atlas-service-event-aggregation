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

import atlas.event.aggregation.data.model.candidateformation.CandidateFormationParameters;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("dev")
public class CandidateFormationDispatch extends AbstractDataDispatch<CandidateFormationParameters>
{
    public CandidateFormationDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceMutation")
            .dataFetcher("createCandidateFormationParameters", this));
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
                case "/createCandidateFormationParameters":
                    result = createCandidateFormationParameters(environment);
                    break;
                case "/deleteCandidateFormationParameters":
                    result = deleteCandidateFormationParameters(environment);
                    break;
                case "/updateCandidateFormationParameters":
                    result = updateCandidateFormationParameters(environment);
                    break;
            }
        }

        return result;
    }

    private CandidateFormationParameters updateCandidateFormationParameters(DataFetchingEnvironment environment)
    {
        CandidateFormationParameters parameters = new CandidateFormationParameters();
        parameters.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        parameters.setCoplanarCheckThreshold(new Float("2"));
        parameters.setPdotCoeficients(new Float("3"));
        parameters.setPeriodAssociationThreshold(new Float("4"));
        parameters.setMinimumTrackersPerCluster(5);
        parameters.setUpdateOrigin("updated origin");
        parameters.setUpdateDate(new Date());
        parameters.setCreateOrigin("created origin");
        parameters.setCreateDate(new Date());
        parameters.setVersion(6);
        return parameters;
    }

    private CandidateFormationParameters deleteCandidateFormationParameters(DataFetchingEnvironment environment)
    {
        CandidateFormationParameters parameters = new CandidateFormationParameters();
        return parameters;
    }

    private CandidateFormationParameters createCandidateFormationParameters(DataFetchingEnvironment environment)
    {
        CandidateFormationParameters parameters = new CandidateFormationParameters();
        parameters.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        parameters.setCoplanarCheckThreshold(new Float("2"));
        parameters.setPdotCoeficients(new Float("3"));
        parameters.setPeriodAssociationThreshold(new Float("4"));
        parameters.setMinimumTrackersPerCluster(5);
        parameters.setUpdateOrigin("updated origin");
        parameters.setUpdateDate(new Date());
        parameters.setCreateOrigin("created origin");
        parameters.setCreateDate(new Date());
        parameters.setVersion(6);
        return parameters;
    }
}