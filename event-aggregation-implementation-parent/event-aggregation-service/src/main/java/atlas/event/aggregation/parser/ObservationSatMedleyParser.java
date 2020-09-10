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
package atlas.event.aggregation.parser;

import atlas.event.aggregation.data.model.ssaevent.ObservationSatMedley;
import atlas.event.aggregation.util.JSonUtil;
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
            medley.setId(JSonUtil.getItemAsString("id", map));
            medley.setSatelliteId(JSonUtil.getItemAsString("satelliteId", map));
            medley.setObservationId(JSonUtil.getItemAsString("observationId", map));
            medley.setClassification(JSonUtil.getItemAsString("classification", map));
            medley.setPromotable(JSonUtil.getItemAsLong("isPromotable", map));
            medley.setCataloged(JSonUtil.getItemAsLong("isCataloged", map));
            medley.setAnalyst(JSonUtil.getItemAsLong("isAnalyst", map));
            medley.setCandidate(JSonUtil.getItemAsLong("isCandidate", map));
            medley.setSatNo(JSonUtil.getItemAsLong("satno", map));
            medley.setUcn(JSonUtil.getItemAsLong("ucn", map));
            medley.setCommonName(JSonUtil.getItemAsString("commonName", map));
            medley.setGroup(JSonUtil.getItemAsString("group", map));
            medley.setType(JSonUtil.getItemAsLong("type", map));
            medley.setRadarCrossSection(JSonUtil.getItemAsDouble("radarCrossSection", map));
            medley.setEpoch(JSonUtil.getItemAsOffSetDate("epoch", map));
            medley.setResult(JSonUtil.getItemAsString("result", map));
            medley.setPeriod(JSonUtil.getItemAsDouble("period", map));
            medley.setInclination(JSonUtil.getItemAsDouble("inclination", map));
            medley.setApogee(JSonUtil.getItemAsLong("apogee", map));
            medley.setPerigee(JSonUtil.getItemAsLong("perigee", map));
            medley.setEccentricity(JSonUtil.getItemAsDouble("eccentricity", map));
            medley.setTypeName(JSonUtil.getItemAsString("typeName", map));
            datalist.add(medley);
        }
            return datalist;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        ObservationSatMedley medley = new ObservationSatMedley();
        medley.setId(JSonUtil.getItemAsString("id", map));
        medley.setSatelliteId(JSonUtil.getItemAsString("satelliteId", map));
        medley.setObservationId(JSonUtil.getItemAsString("observationId", map));
        medley.setClassification(JSonUtil.getItemAsString("classification", map));
        medley.setPromotable(JSonUtil.getItemAsLong("isPromotable", map));
        medley.setCataloged(JSonUtil.getItemAsLong("isCataloged", map));
        medley.setAnalyst(JSonUtil.getItemAsLong("isAnalyst", map));
        medley.setCandidate(JSonUtil.getItemAsLong("isCandidate", map));
        medley.setSatNo(JSonUtil.getItemAsLong("satno", map));
        medley.setUcn(JSonUtil.getItemAsLong("ucn", map));
        medley.setCommonName(JSonUtil.getItemAsString("commonName", map));
        medley.setGroup(JSonUtil.getItemAsString("group", map));
        medley.setType(JSonUtil.getItemAsLong("type", map));
        medley.setRadarCrossSection(JSonUtil.getItemAsDouble("radarCrossSection", map));
        medley.setEpoch(JSonUtil.getItemAsOffSetDate("epoch", map));
        medley.setResult(JSonUtil.getItemAsString("result", map));
        medley.setPeriod(JSonUtil.getItemAsDouble("period", map));
        medley.setInclination(JSonUtil.getItemAsDouble("inclination", map));
        medley.setApogee(JSonUtil.getItemAsLong("apogee", map));
        medley.setPerigee(JSonUtil.getItemAsLong("perigee", map));
        medley.setEccentricity(JSonUtil.getItemAsDouble("eccentricity", map));
        medley.setTypeName(JSonUtil.getItemAsString("typeName", map));

        return medley;
    }
}
