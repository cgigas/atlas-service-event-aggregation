/*
 *  ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */
package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.data.model.mpeprocessing.MPEProcessingConfiguration;
import atlas.event.aggregation.handlers.MPEProcessingConfigHandler;
import atlas.event.aggregation.parser.ConfigParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class MPEProcessingConfigDispatch extends AbstractDataDispatch<MPEProcessingConfiguration>
{
    @Autowired
    private ConfigParser configParser;

    @Autowired
    private MPEProcessingConfigHandler mpeProcessingConfigHandler;

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
                .dataFetcher("createMpeConfig", this)
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
                    result = mpeProcessingConfigHandler.processMpeConfigTemplateByName(environment);
                    break;
                case "/createMpeConfig":
                    result = processCreateConfig(environment);
                    break;
                case "/updateMpeConfig":
                    result = processUpdateConfig(environment);
                    break;
            }
        }
        return result;
    }

    private MPEProcessingConfiguration processUpdateConfig(DataFetchingEnvironment environment)
    {
        return null;
    }

    private MPEProcessingConfiguration processCreateConfig(DataFetchingEnvironment environment)
    {
        return null;
    }
}
