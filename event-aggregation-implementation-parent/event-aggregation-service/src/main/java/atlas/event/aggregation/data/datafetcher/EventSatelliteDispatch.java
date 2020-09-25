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

import atlas.event.aggregation.constants.EventAggregationConstants;
import atlas.event.aggregation.data.model.ssaevent.Event;
import atlas.event.aggregation.data.model.ssaeventsat.EventSatellite;
import atlas.event.aggregation.parser.EventParser;
import atlas.event.aggregation.parser.EventSatelliteParser;
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
public class EventSatelliteDispatch extends AbstractDataDispatch<List<Event>>
{
    @Autowired
    private EventSatelliteParser eventSatelliteParser;
    @Autowired
    private EventParser eventParser;

    public EventSatelliteDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceMutation")
                .dataFetcher("addSatelliteToEvent", this)
                .dataFetcher("releaseSatelliteFromEvent", this)
                .dataFetcher("promoteEventSatellite", this));
        return builders;
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
                case "/addSatelliteToEvent":
                    result = processAddSatelliteToEvent(environment);
                    break;
                case "/releaseSatelliteFromEvent":
                    result = processReleaseSatelliteFromEvent(environment);
                    break;
                case "/promoteEventSatellite":
                    result = processPromoteEventSatellite(environment);
                    break;
            }
        }

        return result;
    }

    private EventSatellite processAddSatelliteToEvent(DataFetchingEnvironment environment)
    {
        EventSatellite eventSat = new EventSatellite();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/addSatelliteToEvent/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            eventSat = (EventSatellite) eventSatelliteParser.fromJsonString(resultRequestedData);
        }

        return eventSat;
    }

    private Event processReleaseSatelliteFromEvent(DataFetchingEnvironment environment)
    {
        Event event = new Event();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/releaseSatelliteFromEvent/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        event = (Event) eventParser.fromJsonString(resultRequestedData);

        return event;    }

    private EventSatellite processPromoteEventSatellite(DataFetchingEnvironment environment)
    {
        EventSatellite eventSat = new EventSatellite();
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        String eventId = environment.getArgument("eventId");
        String satelliteUuid = environment.getArgument("satelliteUuid");
        url += "/promoteEventSatellite/" + eventId + "/" + satelliteUuid;
        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            eventSat = (EventSatellite) eventSatelliteParser.fromJsonString(resultRequestedData);
        }

        return eventSat;
    }
}
