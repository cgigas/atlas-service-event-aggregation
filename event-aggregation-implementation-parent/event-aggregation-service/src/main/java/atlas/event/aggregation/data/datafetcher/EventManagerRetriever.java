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
import atlas.event.aggregation.data.model.ssaevent.Event;
import atlas.event.aggregation.handlers.EventDataHandler;
import atlas.event.aggregation.handlers.EventTypeSummaryHandler;
import atlas.event.aggregation.handlers.GetEventTypeHandler;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;


@Slf4j
@Component
@Profile("dev")
public class EventManagerRetriever extends AbstractDataFetcher<List<Event>>
{
    private SsaEventRepository repository;
    @Autowired
    EventTypeSummaryHandler eventTypeSummaryHandler;
    @Autowired
    EventDataHandler eventDataHandler;
    @Autowired
    GetEventTypeHandler getEventTypeHandler;

    public EventManagerRetriever(SsaEventRepository repo, RuntimeWiringTypeCollector collector)
    {
        this.repository = repo;
        this.collector = collector;
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
                case "/eventById":
                    result = eventDataHandler.processEventById(environment);
                    break;
                case "/eventTypeSummariesByTimePeriod":
                    result = eventTypeSummaryHandler.processRequest(environment);
                    break;
                case "/eventDetail":
                    result = eventDataHandler.processEventDetail(environment);
                    break;
                case "/getEventTypes":
                    result = getEventTypeHandler.processRequest(environment);
                    break;
                case "/eventsByTimePeriodAndType":
                    result = eventDataHandler.processEventsByTimePeriodAndType(environment);
                    break;
            }
        }

        return result;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("EventQuery")
                .dataFetcher("eventById", this)
                .dataFetcher("eventDetail", this)
                .dataFetcher("eventSummaries", this)
                .dataFetcher("eventTypeSummariesByTimePeriod", this)
                .dataFetcher("eventsByTimePeriodAndType", this));
        return builders;
    }
}