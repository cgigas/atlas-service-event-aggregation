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
package atlas.event.aggregation.data.datafetcher.mutation.Satellite;

import atlas.event.aggregation.data.datafetcher.AbstractDataDispatch;
import atlas.event.aggregation.data.model.Satellite.CurrentRcs;
import atlas.event.aggregation.data.model.Satellite.CurrentRcsPage;
import atlas.event.aggregation.data.model.Satellite.Satellite;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class CurrentRcsDispatch extends AbstractDataDispatch<List<Satellite>>
{
    public CurrentRcsDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    protected Object performFetch(DataFetchingEnvironment environment)
    {
        Object result = null;
        String path = getRequestPath(environment);
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                //Mutation
                case "/createCurrentRcs":
                    result = createCurrentRcs(environment);
                    break;
                case "/updateCurrentRcs":
                    result = updateCurrentRcs(environment);

                    //Query
                case "/currentRcs":
                    result = currentRcs(environment);
                    break;
                case "/currentRcsPage":
                    result = currentRcsPage(environment);
                    break;
                case "/currentRcsPageById":
                    result = currentRcsPageById(environment);
                    break;
                case "/currentRcsPageByExample":
                    result = currentRcsPageByExample(environment);
                    break;
                case "/currentRcsPageByCriteria":
                    result = currentRcsPageByCriteria(environment);
                    break;
            }
        }
        return result;
    }

    private CurrentRcsPage currentRcsPageByCriteria(DataFetchingEnvironment environment)
    {
        CurrentRcsPage page = new CurrentRcsPage();
        return page;
    }

    private CurrentRcsPage currentRcsPageByExample(DataFetchingEnvironment environment)
    {
        CurrentRcsPage page = new CurrentRcsPage();
        return page;
    }

    private CurrentRcsPage currentRcsPageById(DataFetchingEnvironment environment)
    {
        CurrentRcsPage page = new CurrentRcsPage();
        return page;
    }

    private CurrentRcsPage currentRcsPage(DataFetchingEnvironment environment)
    {
        CurrentRcsPage page = new CurrentRcsPage();
        return page;
    }

    private CurrentRcs currentRcs(DataFetchingEnvironment environment)
    {
        CurrentRcs rcs = new CurrentRcs();
        return rcs;
    }

    private CurrentRcs updateCurrentRcs(DataFetchingEnvironment environment)
    {
        CurrentRcs rcs = new CurrentRcs();
        return rcs;
    }

    private CurrentRcs createCurrentRcs(DataFetchingEnvironment environment)
    {
        CurrentRcs rcs = new CurrentRcs();
        return rcs;
    }


    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceMutation")
            .dataFetcher("createControlsTemplateCriteria", this)
            .dataFetcher("updateControlsTemplateCriteria", this)
            .dataFetcher("deleteControlsTemplateCriteria", this));
        builders.add(newTypeWiring("MPEServiceQuery")
            .dataFetcher("controlsTemplateCriteria", this)
            .dataFetcher("controlsTemplateCriteriaPage", this)
            .dataFetcher("controlsTemplateCriteriaPageById", this)
            .dataFetcher("controlsTemplateCriteriaPageByExample", this)
            .dataFetcher("controlsTemplateCriteriaPageByCriteria", this));
        return builders;
    }
}