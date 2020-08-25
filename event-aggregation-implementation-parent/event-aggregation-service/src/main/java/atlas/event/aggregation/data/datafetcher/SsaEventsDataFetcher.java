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

import atlas.event.aggregation.data.model.repository.ssaevent.SsaEventRepository;
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.handlers.EventDataHandler;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;


@Slf4j
@Component
@Profile("dev")
public class SsaEventsDataFetcher extends AbstractDataFetcher<List<SsaEvent>>
{
    private SsaEventRepository repository;
    @Autowired
    private EventDataHandler eventDataHandler;

    public SsaEventsDataFetcher(SsaEventRepository repo,  RuntimeWiringTypeCollector collector)
    {
        this.repository = repo;
        this.collector = collector;
    }

    @Override
    protected void performFetch(DataFetchingEnvironment environment)
    {
        returnValue = null;

        String path = getRequestPath(environment);
        if (!StringUtils.isEmpty(path))
        {

            processRequest(path, environment);
            switch (path)
            {
                case "/getSsaEventById":
                case "/eventDetail":
                    String id = getIdArgument(environment);
                    Optional<SsaEvent> result = repository.findById(id);
                    Object o = result.get();
                    returnValue = Lists.newArrayList(result.get());
                    break;
                case "/ssaEvents":
                    returnValue  = Lists.newArrayList(repository.findAll());
                    break;
                case "/eventSummaries":

            }
        }
    }

    protected String getIdArgument(DataFetchingEnvironment environment)
    {
        return environment.getArgument(ID_ARG);
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("EasQuery")
            .dataFetcher("ssaEvents", this)
            .dataFetcher("eventDetail", this)
            .dataFetcher("eventSummaries", this)
            .dataFetcher("getSsaEventById", this)
        .dataFetcher("deleteSsaEvent", this));
        return builders;
    }
}
