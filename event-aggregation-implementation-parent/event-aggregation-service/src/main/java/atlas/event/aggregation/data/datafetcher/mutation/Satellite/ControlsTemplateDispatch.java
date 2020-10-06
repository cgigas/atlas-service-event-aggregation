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
import atlas.event.aggregation.data.model.Satellite.ControlsTemplateCriteria;
import atlas.event.aggregation.data.model.Satellite.ControlsTemplateCriteriaPage;
import atlas.event.aggregation.data.model.Satellite.Satellite;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class ControlsTemplateDispatch extends AbstractDataDispatch<List<Satellite>>
{
    public ControlsTemplateDispatch(RuntimeWiringTypeCollector collector)
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
                case "/createControlsTemplateCriteria":
                    result = createControlsTemplateCriteria(environment);
                    break;
                case "/updateControlsTemplateCriteria":
                    result = updateControlsTemplateCriteria(environment);
                    break;
                case "/deleteControlsTemplateCriteria":
                    result = deleteControlsTemplateCriteria(environment);
                    break;
                //Query
                case "/controlsTemplateCriteria":
                    result = controlsTemplateCriteria(environment);
                    break;
                case "/controlsTemplateCriteriaPage":
                    result = controlsTemplateCriteriaPage(environment);
                    break;
                case "/controlsTemplateCriteriaPageById":
                    result = controlsTemplateCriteriaPageById(environment);
                    break;
                case "/controlsTemplateCriteriaPageByExample":
                    result = controlsTemplateCriteriaPageByExample(environment);
                    break;
                case "/controlsTemplateCriteriaPageByCriteria":
                    result = controlsTemplateCriteriaPageByCriteria(environment);
                    break;
            }
        }
        return result;
    }

    private ControlsTemplateCriteriaPage controlsTemplateCriteriaPageByCriteria(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteriaPage page = new ControlsTemplateCriteriaPage();
        return page;
    }

    private ControlsTemplateCriteriaPage controlsTemplateCriteriaPageByExample(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteriaPage page = new ControlsTemplateCriteriaPage();
        return page;
    }

    private ControlsTemplateCriteriaPage controlsTemplateCriteriaPageById(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteriaPage page = new ControlsTemplateCriteriaPage();
        return page;
    }

    private ControlsTemplateCriteriaPage controlsTemplateCriteriaPage(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteriaPage page = new ControlsTemplateCriteriaPage();
        return page;
    }

    private ControlsTemplateCriteria controlsTemplateCriteria(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteria criteria = new ControlsTemplateCriteria();
        return criteria;
    }

    private ControlsTemplateCriteria deleteControlsTemplateCriteria(DataFetchingEnvironment environment)
    {
        return null;
    }

    private ControlsTemplateCriteria updateControlsTemplateCriteria(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteria criteria = new ControlsTemplateCriteria();
        return criteria;
    }

    private ControlsTemplateCriteria createControlsTemplateCriteria(DataFetchingEnvironment environment)
    {
        ControlsTemplateCriteria criteria = new ControlsTemplateCriteria();
        return criteria;
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