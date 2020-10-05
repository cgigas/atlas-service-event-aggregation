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
import atlas.event.aggregation.data.model.candidateformation.CandidateFormationParametersPage;
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
        builders.add(newTypeWiring("MPEServiceQuery")
            .dataFetcher("candidateFormationParameters", this)
            .dataFetcher("candidateFormationParametersPage", this)
            .dataFetcher("candidateFormationParametersPageById", this)
            .dataFetcher("candidateFormationParametersPageByExample", this)
            .dataFetcher("candidateFormationParametersPageByCriteria", this));
        builders.add(newTypeWiring("MPEServiceMutation")
            .dataFetcher("createCandidateFormationParameters", this)
            .dataFetcher("deleteCandidateFormationParameters", this)
            .dataFetcher("updateCandidateFormationParameters", this));
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
                case "/candidateFormationParameters":
                    result = candidateFormationParameters(environment);
                    break;
                case "/candidateFormationParametersPage":
                    result = candidateFormationParametersPage(environment);
                    break;
                case "/candidateFormationParametersPageById":
                    result = candidateFormationParametersPageById(environment);
                    break;
                case "/candidateFormationParametersPageByExample":
                    result = candidateFormationParametersPageByExample(environment);
                    break;
                case "/candidateFormationParametersPageByCriteria":
                    result = candidateFormationParametersPageByCriteria(environment);
                    break;
            }
        }

        return result;
    }

    private CandidateFormationParametersPage candidateFormationParametersPageByCriteria(DataFetchingEnvironment environment)
    {
        CandidateFormationParametersPage page = new CandidateFormationParametersPage();
        CandidateFormationParameters content = new CandidateFormationParameters();
        content.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        content.setCoplanarCheckThreshold(new Float("2"));
        content.setPdotCoeficients(new Float("3"));
        content.setPeriodAssociationThreshold(new Float("4"));
        content.setMinimumTrackersPerCluster(5);
        content.setUpdateOrigin("updated origin");
        content.setUpdateDate(new Date());
        content.setCreateOrigin("created origin");
        content.setCreateDate(new Date());
        content.setVersion(6);
        page.setNumber(1);
        page.setTotalElements(2L);
        page.setTotalPages(3);
        page.setContent(content);
        return page;
    }

    private CandidateFormationParametersPage candidateFormationParametersPageByExample(DataFetchingEnvironment environment)
    {
        CandidateFormationParametersPage page = new CandidateFormationParametersPage();
        CandidateFormationParameters content = new CandidateFormationParameters();
        content.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        content.setCoplanarCheckThreshold(new Float("2"));
        content.setPdotCoeficients(new Float("3"));
        content.setPeriodAssociationThreshold(new Float("4"));
        content.setMinimumTrackersPerCluster(5);
        content.setUpdateOrigin("updated origin");
        content.setUpdateDate(new Date());
        content.setCreateOrigin("created origin");
        content.setCreateDate(new Date());
        content.setVersion(6);
        page.setNumber(1);
        page.setTotalElements(2L);
        page.setTotalPages(3);
        page.setContent(content);
        return page;
    }

    private CandidateFormationParametersPage candidateFormationParametersPageById(DataFetchingEnvironment environment)
    {
        CandidateFormationParametersPage page = new CandidateFormationParametersPage();
        CandidateFormationParameters content = new CandidateFormationParameters();
        content.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        content.setCoplanarCheckThreshold(new Float("2"));
        content.setPdotCoeficients(new Float("3"));
        content.setPeriodAssociationThreshold(new Float("4"));
        content.setMinimumTrackersPerCluster(5);
        content.setUpdateOrigin("updated origin");
        content.setUpdateDate(new Date());
        content.setCreateOrigin("created origin");
        content.setCreateDate(new Date());
        content.setVersion(6);
        page.setNumber(1);
        page.setTotalElements(2L);
        page.setTotalPages(3);
        page.setContent(content);
        return page;
    }

    private CandidateFormationParametersPage candidateFormationParametersPage(DataFetchingEnvironment environment)
    {
        CandidateFormationParametersPage page = new CandidateFormationParametersPage();
        CandidateFormationParameters content = new CandidateFormationParameters();
        content.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        content.setCoplanarCheckThreshold(new Float("2"));
        content.setPdotCoeficients(new Float("3"));
        content.setPeriodAssociationThreshold(new Float("4"));
        content.setMinimumTrackersPerCluster(5);
        content.setUpdateOrigin("updated origin");
        content.setUpdateDate(new Date());
        content.setCreateOrigin("created origin");
        content.setCreateDate(new Date());
        content.setVersion(6);
        page.setNumber(1);
        page.setTotalElements(2L);
        page.setTotalPages(3);
        page.setContent(content);
        return page;
    }

    private CandidateFormationParameters candidateFormationParameters(DataFetchingEnvironment environment)
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
        return null;
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