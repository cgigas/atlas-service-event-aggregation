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
                    resultBuffer.append("{ ");
                    resultBuffer.append("eventSatUuid ");
                    resultBuffer.append("satelliteUuid ");
                    resultBuffer.append("eventUuid ");
                    resultBuffer.append("relationship ");
                    resultBuffer.append("ucn ");
                    resultBuffer.append("version ");
                    resultBuffer.append("event { ");
                    resultBuffer.append("eventUuid ");
                    resultBuffer.append("classificationMarking ");
                    resultBuffer.append("predecessorEventUuid ");
                    resultBuffer.append("type ");
                    resultBuffer.append("name ");
                    resultBuffer.append("status ");
                    resultBuffer.append("startDt ");
                    resultBuffer.append("endDt ");
                    resultBuffer.append("description ");
                    resultBuffer.append("internalNotes ");
                    resultBuffer.append("eventPostingId ");

                    resultBuffer.append("eventData { ");
                    resultBuffer.append("eventUuid ");
                    resultBuffer.append("classificationMarking ");
                    resultBuffer.append("name ");
                    resultBuffer.append("uri ");
                    resultBuffer.append("type ");
                    resultBuffer.append("supplementalData ");
                    resultBuffer.append("createDate ");
                    resultBuffer.append("createOrigin ");
                    resultBuffer.append("updateDate ");
                    resultBuffer.append("updateOrigin ");
                    resultBuffer.append("version ");
                    resultBuffer.append("} ");

                    resultBuffer.append("createDate ");
                    resultBuffer.append("createOrigin ");
                    resultBuffer.append("updateDate ");
                    resultBuffer.append("updateOrigin ");
                    resultBuffer.append("version ");
                    resultBuffer.append("} ");


                    resultBuffer.append("} ");
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

    List<Event> processReleaseSatelliteFromEvent(DataFetchingEnvironment environment)
    {
        EventCrudMutationExecutor eventCrudMutationExecutor;
        List<Map<String, Object>> eventSatList = environment.getArgument("input");
        if (eventSatList != null)
        {
            Map<String, Object> eventSatMap = eventSatList.get(0);
            String eventId = (String) eventSatMap.get("eventId");
            String satelliteUuid = (String) eventSatMap.get("satelliteUuid");
            System.out.println("party time");
        }
        return null;
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
                    StringBuffer returnBuffer = new StringBuffer();
                    returnBuffer.append("{eventSatUuid \n");
                    returnBuffer.append("satelliteUuid \n");
                    returnBuffer.append("eventUuid \n");
                    returnBuffer.append("relationship \n");
                    returnBuffer.append("ucn \n");
                    returnBuffer.append("version \n");
                    returnBuffer.append("event { \n");
                    returnBuffer.append("eventUuid \n");
                    returnBuffer.append("classificationMarking \n");
                    returnBuffer.append("predecessorEventUuid \n");
                    returnBuffer.append("type \n");
                    returnBuffer.append("name \n");
                    returnBuffer.append("status \n");
                    returnBuffer.append("startDt \n");
                    returnBuffer.append("endDt \n");
                    returnBuffer.append("description \n");
                    returnBuffer.append("internalNotes \n");
                    returnBuffer.append("eventPostingId \n");
                    returnBuffer.append("eventData { \n");
                    returnBuffer.append("eventUuid \n");
                    returnBuffer.append("classificationMarking \n");
                    returnBuffer.append("eventUuid \n");
                    returnBuffer.append("name \n");
                    returnBuffer.append("uri \n");
                    returnBuffer.append("type \n");
                    returnBuffer.append("supplementalData \n");
                    returnBuffer.append("createDate \n");
                    returnBuffer.append("createOrigin \n");
                    returnBuffer.append("updateDate \n");
                    returnBuffer.append("updateOrigin \n");
                    returnBuffer.append("version \n");
                    returnBuffer.append("} \n");
                    returnBuffer.append("createDate \n");
                    returnBuffer.append("createOrigin \n");
                    returnBuffer.append("updateDate \n");
                    returnBuffer.append("updateOrigin \n");
                    returnBuffer.append("version \n");
                    returnBuffer.append("} \n");
                    for (Map<String, Object> eventSatPromotItem: eventSatPromoMapList)
                    {
                        String eventSatelliteUuid = getItemAsString("eventSatelliteUuid", eventSatPromotItem);
                        String relationship = getItemAsString("relationship", eventSatPromotItem);
                        try
                        {
                            atlas.ssaevent.crud.graphql.EventSat crudEventSat = eventCrudMutationExecutor.updateEventSat("", eventSatelliteUuid, EventRelationship.valueOf(relationship));
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