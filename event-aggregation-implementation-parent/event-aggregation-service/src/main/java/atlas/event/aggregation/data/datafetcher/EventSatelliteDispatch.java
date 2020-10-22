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
import atlas.event.aggregation.data.model.event.Event;
import atlas.event.aggregation.data.model.ssaeventsat.EventSatellite;
import atlas.event.aggregation.parser.event.EventParser;
import atlas.event.aggregation.parser.event.EventSatelliteParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import atlas.ssaevent.crud.graphql.EventCrudMutationExecutor;
import atlas.ssaevent.crud.graphql.EventRelationship;
import com.google.common.collect.Lists;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("prod")
public class EventSatelliteDispatch extends AbstractDataDispatch<List<Event>>
{
    @Autowired
    private EventSatelliteParser eventSatelliteParser;
    @Autowired
    private EventParser eventParser;
    Logger log = LoggerFactory.getLogger(EventSatelliteDispatch.class);

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

    EventSatellite processAddSatelliteToEvent(DataFetchingEnvironment environment)
    {
        EventSatellite eventSat = new EventSatellite();
        EventCrudMutationExecutor eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
        if (environment != null)
        {
            Map<String, Object> eventSatMap = environment.getArgument("input");

            if (eventSatMap != null)
            {
                atlas.ssaevent.crud.graphql.EventSatInput crudEventSat = (atlas.ssaevent.crud.graphql.EventSatInput) eventSatelliteParser.toGraphqlClient(eventSatMap, Boolean.TRUE);
                try
                {
                    StringBuffer resultBuffer = new StringBuffer();
                    resultBuffer.append("{ eventSatUuid satelliteUuid eventUuid relationship ucn version event { eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData { eventUuid classificationMarking name uri type supplementalData createDate createOrigin updateDate updateOrigin version } createDate createOrigin updateDate updateOrigin version } }");
                    System.out.println(resultBuffer.toString());
                    atlas.ssaevent.crud.graphql.EventSat crudEventResult = eventCrudMutationExecutor.createEventSat(resultBuffer.toString(), crudEventSat);

                    eventSat = (EventSatellite) eventSatelliteParser.fromGraphqlClient(crudEventResult);
                }
                catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                {
                    e.printStackTrace();
                    throw new DataAccessorException(e);
                }
            }
        }

        return eventSat;
    }

    List<EventSatellite> processReleaseSatelliteFromEvent(DataFetchingEnvironment environment)
    {
        List<EventSatellite> eventSatelliteList = null;
        EventCrudMutationExecutor eventCrudMutationExecutor;
        if (environment != null)
        {
            List<String> eventSatList = environment.getArgument("eventSatUuid");
            if (eventSatList != null)
            {
                String returnParams = "{eventSatUuid satelliteUuid eventUuid relationship ucn version event { eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData { classificationMarking eventUuid name uri type supplementalData createDate createOrigin updateDate updateOrigin version } createDate createOrigin updateDate updateOrigin version }}}";
                eventSatelliteList = new ArrayList<>();
                eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
                for (String eventSatUuid: eventSatList)
                {
                    try
                    {
                        atlas.ssaevent.crud.graphql.EventSat crudEventResult = eventCrudMutationExecutor.deleteEventSat(returnParams, eventSatUuid);
                        EventSatellite eventSat = (EventSatellite) eventSatelliteParser.fromGraphqlClient(crudEventResult);
                        eventSatelliteList.add(eventSat);
                    }
                    catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                    {
                        log.error(e.toString());
                        throw new DataAccessorException(e);
                    }
                }
            }
        }
        return eventSatelliteList;
    }

    List<EventSatellite> processPromoteEventSatellite(DataFetchingEnvironment environment)
    {
        List<EventSatellite> eventSatelliteList = null;
        EventCrudMutationExecutor eventCrudMutationExecutor = getClientServiceLookup().getEventCrudMutationExecutor();
        if (environment != null)
        {
            List<Map<String, Object>> eventSatPromoMapList = environment.getArgument("eventSatellitePromotion");
            if (eventSatPromoMapList != null)
            {
                if (eventSatPromoMapList != null)
                {
                    eventSatelliteList = new ArrayList<>();
                    StringBuffer resultBuffer = new StringBuffer();
                    resultBuffer.append("{ eventSatUuid satelliteUuid eventUuid relationship ucn version event { eventUuid classificationMarking predecessorEventUuid type name status startDt endDt description internalNotes eventPostingId eventData { classificationMarking eventUuid name uri type supplementalData createDate createOrigin updateDate updateOrigin version } createDate createOrigin updateDate updateOrigin version } } }");
                    System.out.println(resultBuffer.toString());
                    for (Map<String, Object> eventSatPromotItem: eventSatPromoMapList)
                    {
                        String eventSatelliteUuid = getItemAsString("eventSatelliteUuid", eventSatPromotItem);
                        String relationship = getItemAsString("relationship", eventSatPromotItem);
                        try
                        {
                            atlas.ssaevent.crud.graphql.EventSat crudEventSat = eventCrudMutationExecutor.updateEventSat(resultBuffer.toString(), eventSatelliteUuid, EventRelationship.valueOf(relationship));
                            EventSatellite eventSatellite = (EventSatellite) eventSatelliteParser.fromGraphqlClient(crudEventSat);
                            eventSatelliteList.add(eventSatellite);
                        }
                        catch (GraphQLRequestPreparationException | GraphQLRequestExecutionException e)
                        {
                            e.printStackTrace();
                            throw new DataAccessorException(e);
                        }
                    }
                }
            }
        }
        return eventSatelliteList;
    }
}