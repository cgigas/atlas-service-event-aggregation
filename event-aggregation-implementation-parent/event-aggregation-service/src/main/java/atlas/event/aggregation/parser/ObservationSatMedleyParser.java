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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.model.ssaevent.EventType;
import atlas.event.aggregation.data.model.ssaevent.ObservationSatMedley;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("observationSatMedleyParser")
public class ObservationSatMedleyParser implements IParser
{
    @Override
    public String toJSONString(Object fromJson)
    {
        return null;
    }

    @Override
    public Object fromJsonString(String json)
    {
        return null;
    }

    @Override
    public Object fromJson(Object json)
    {
        List<ObservationSatMedley> datalist = new ArrayList<>();
        JSONArray array = (JSONArray) json;
        Iterator it = array.iterator();
        while (it.hasNext())
        {
            Map<String, Object> map = (Map) it.next();
            ObservationSatMedley medley = new ObservationSatMedley();
            medley.setId(getItemAsString("id", map));
            medley.setSatelliteId(getItemAsString("satelliteId", map));
            medley.setObservationId(getItemAsString("observationId", map));
            medley.setClassification(getItemAsString("classification", map));
            medley.setPromotable(getItemAsLong("isPromotable", map));
            medley.setCataloged(getItemAsLong("isCataloged", map));
            medley.setAnalyst(getItemAsLong("isAnalyst", map));
            medley.setCandidate(getItemAsLong("isCandidate", map));
            medley.setSatNo(getItemAsLong("satno", map));
            medley.setUcn(getItemAsLong("ucn", map));
            medley.setCommonName(getItemAsString("commonName", map));
            medley.setGroup(getItemAsString("group", map));
            String eventType = getItemAsString("type", map);
            if (StringUtils.isNotBlank(eventType))
            {
                medley.setType(EventType.valueOf(eventType));
            }
            medley.setRadarCrossSection(getItemAsDouble("radarCrossSection", map));
            medley.setEpoch(getItemAsOffSetDate("epoch", map));
            medley.setResult(getItemAsString("result", map));
            medley.setPeriod(getItemAsDouble("period", map));
            medley.setInclination(getItemAsDouble("inclination", map));
            medley.setApogee(getItemAsLong("apogee", map));
            medley.setPerigee(getItemAsLong("perigee", map));
            medley.setEccentricity(getItemAsDouble("eccentricity", map));
            medley.setTypeName(getItemAsString("typeName", map));
            datalist.add(medley);
        }
            return datalist;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        ObservationSatMedley medley = new ObservationSatMedley();
        medley.setId(getItemAsString("id", map));
        medley.setSatelliteId(getItemAsString("satelliteId", map));
        medley.setObservationId(getItemAsString("observationId", map));
        medley.setClassification(getItemAsString("classification", map));
        medley.setPromotable(getItemAsLong("isPromotable", map));
        medley.setCataloged(getItemAsLong("isCataloged", map));
        medley.setAnalyst(getItemAsLong("isAnalyst", map));
        medley.setCandidate(getItemAsLong("isCandidate", map));
        medley.setSatNo(getItemAsLong("satno", map));
        medley.setUcn(getItemAsLong("ucn", map));
        medley.setCommonName(getItemAsString("commonName", map));
        medley.setGroup(getItemAsString("group", map));
        String eventType = getItemAsString("type", map);
        if (StringUtils.isNotBlank(eventType))
        {
            medley.setType(EventType.valueOf(eventType));
        }

        medley.setRadarCrossSection(getItemAsDouble("radarCrossSection", map));
        medley.setEpoch(getItemAsOffSetDate("epoch", map));
        medley.setResult(getItemAsString("result", map));
        medley.setPeriod(getItemAsDouble("period", map));
        medley.setInclination(getItemAsDouble("inclination", map));
        medley.setApogee(getItemAsLong("apogee", map));
        medley.setPerigee(getItemAsLong("perigee", map));
        medley.setEccentricity(getItemAsDouble("eccentricity", map));
        medley.setTypeName(getItemAsString("typeName", map));

        return medley;
    }
}
