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
package atlas.event.aggregation.data.datafetcher.mutation;

import atlas.event.aggregation.data.datafetcher.AbstractDataFetcher;
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.handlers.EventDataHandler;
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
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("dev")
public class EventManagerUpdater extends AbstractDataFetcher<SsaEvent>
{
    @Autowired
    private EventDataHandler eventDetailHandler;

    public EventManagerUpdater(RuntimeWiringTypeCollector collector)
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
                case "/closeSdaEvent":
                    result = eventDetailHandler.processCloseSdaEvent(environment);
                    break;
                case "/updateEventStatus":
                    result = eventDetailHandler.processUpdateEventStatus(environment);
                    break;
                case "/deleteSdaEvent":
                    result = eventDetailHandler.processDeleteSdaEvent(environment);
                    break;
                case "/addSatelliteToEvent":
                    result = eventDetailHandler.processAddSatelliteToEvent(environment);
                    break;
                case "/releaseSatelliteFromEvent":
                    result = eventDetailHandler.processReleaseSatelliteFromEvent(environment);
                    break;
                case "/addEditEventprocessingConfiguration":
                    break;
                case "/promoteEventSatellite":
                    result = eventDetailHandler.processPromoteEventSatellite(environment);
                    break;
                case "/addEventProcessingConfiguration":
                    result = eventDetailHandler.processPromoteEventSatellite(environment);
                    break;
            }
        }

        return result;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("EventMutation")
                .dataFetcher("closeSdaEvent", this)
                .dataFetcher("updateEventStatus", this)
                .dataFetcher("deleteSdaEvent", this)
                .dataFetcher("addSatelliteToEvent", this)
                .dataFetcher("releaseSatelliteFromEvent", this)
                .dataFetcher("promoteEventSatellite", this)
                .dataFetcher("addEditEventprocessingConfiguration", this)
        .dataFetcher("closeSdaEvent", this));

        return builders;
    }
}