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
import atlas.event.aggregation.data.model.ssaevent.EventDetail;
import atlas.event.aggregation.data.model.ssaevent.Launch;
import atlas.event.aggregation.data.model.ssaevent.ObservationSatMedley;
import atlas.event.aggregation.exception.EventAggregateException;
import atlas.event.aggregation.parser.EventDetailParser;
import atlas.event.aggregation.parser.EventParser;
import atlas.event.aggregation.parser.LaunchParser;
import atlas.event.aggregation.parser.ObservationSatMedleyParser;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("dev")
public class EventDetailDispatch extends AbstractDataDispatch<List<EventDetail>>
{
    @Autowired
    private EventParser eventParser;
    @Autowired
    private EventDetailParser eventDetailParser;
    @Autowired
    private LaunchParser launchParser;
    @Autowired
    private ObservationSatMedleyParser observationSatMedleyParser;


    public EventDetailDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    protected Object performFetch(DataFetchingEnvironment environment)
    {
        Object result = null;
        String path = getRequestPath(environment);
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                case "/eventDetail":
                    result = processEventDetail(environment);
                    break;
            }
        }

        return result;
    }

    private EventDetail processEventDetail(DataFetchingEnvironment environment)
    {
        EventDetail eventDetail = null;
        String url = getDigitalCache().getExternalServiceUrl(EventAggregationConstants.EVENT_CRUD_URL);
        url += "/eventDetail/" + environment.getArgument("id");

        String resultRequestedData = sendHttpGetRestRequestAsString(url);

        if (StringUtils.isNotBlank(resultRequestedData))
        {
            try
            {
                JSONObject json = (JSONObject) new JSONParser().parse(resultRequestedData);
                Map<String, Object> map = (Map)json.get("eventDetail");

                eventDetail = (EventDetail) eventDetailParser.fromJson(map);
                if (eventDetail != null)
                {
                    eventDetail.setParentEvent((Event) eventParser.fromJson((Map) map.get("parentEvent")));
                    eventDetail.setLaunch((Launch) launchParser.fromJson((Map<String, Object>) map.get("launch")));

                    List<ObservationSatMedley> satMedleyList = (List) observationSatMedleyParser.fromJson((JSONArray) map.get("observationSatMedleyArray"));
                    eventDetail.getObservationSatMedleyArray().addAll(satMedleyList);
                }
            }
            catch (ParseException pe)
            {
                throw new EventAggregateException(pe);
            }
        }

        return eventDetail;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceQuery")
                .dataFetcher("eventDetail", this));
        return builders;
    }
}
