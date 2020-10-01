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

import atlas.event.aggregation.data.model.mpeprocessing.MPEProcessingConfiguration;
import atlas.event.aggregation.exception.EventAggregateException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("configParser")
public class ConfigParser implements IParser
{
    @Override
    public String toJSONString(Object fromJson)
    {
        return toJSONString(fromJson);
    }

    @Override
    public Object fromJsonString(String json)
    {
        Object result = null;
        try
        {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
            result = fromJson((Map) jsonObject.get("config"));
        }
        catch (ParseException pe)
        {
            throw new EventAggregateException(pe);
        }
        return result;
    }

    @Override
    public Object fromJson(Object json)
    {
        MPEProcessingConfiguration mpeConfig = null;
        if (json instanceof JSONObject)
        {
            JSONObject jsonObject = (JSONObject) json;
            Map<String, Object> map = (Map) jsonObject.get("config");
            mpeConfig = (MPEProcessingConfiguration) fromJson(map);
        }
        return mpeConfig;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        MPEProcessingConfiguration mpeConfig = new MPEProcessingConfiguration();
        mpeConfig.setMpeProcessingConfigUuid(getItemAsString("mpeProcessingConfigUuid", map));
        mpeConfig.setClassificationMarking(getItemAsString("classificationMarking", map));
        mpeConfig.setEventUuid(getItemAsString("eventUuid", map));
        mpeConfig.setCandidateRsoReservationUuid(getItemAsString("candidateRsoReservationUuid", map));
        mpeConfig.setAnalystRsoReservationUuid(getItemAsString("analystRsoReservationUuid", map));
        mpeConfig.setCatalogRsoReservationUuid(getItemAsString("catalogRsoReservationUuid", map));
        mpeConfig.setUcnReservationUuid(getItemAsString("ucnReservationUuid", map));
        mpeConfig.setCandidateFormationParametersUuid(getItemAsString("candidateFormationParametersUuid", map));
        mpeConfig.setCurrentFlag(getItemAsInteger("currentFlag", (JSONObject) map));
        mpeConfig.setName(getItemAsString("name", map));
        mpeConfig.setDescription(getItemAsString("description", map));
        mpeConfig.setAnalystMinTracksPerDay(getItemAsInteger("analystMinTracksPerDay", (JSONObject) map));
        mpeConfig.setCatalogMinTracksPerDay(getItemAsInteger("catalogMinTracksPerDay", (JSONObject) map));
        mpeConfig.setAnalystMinTracksReceived(getItemAsInteger("analystMinTracksReceived", (JSONObject) map));
        mpeConfig.setCatalogMinTracksReceived(getItemAsInteger("catalogMinTracksReceived", (JSONObject) map));
        mpeConfig.setAnalystMinOdSolutions(getItemAsInteger("analystMinOdSolutions", (JSONObject) map));
        mpeConfig.setCatalogMinOdSolutions(getItemAsInteger("catalogMinOdSolutions", (JSONObject) map));
        mpeConfig.setAnalystRmsTrendMean(getItemAsDouble("analystRmsTrendMean", map));
        mpeConfig.setCatalogRmsTrendMean(getItemAsDouble("catalogRmsTrendMean", map));
        mpeConfig.setAnalystRmsTrendSd(getItemAsDouble("analystRmsTrendSd", map));
        mpeConfig.setCatalogRmsTrendSd(getItemAsDouble("catalogRmsTrendSd", map));
        mpeConfig.setAnalystMinResidualAcceptance(getItemAsDouble("analystMinResidualAcceptance", map));
        mpeConfig.setCatalogMinResidualAcceptance(getItemAsDouble("catalogMinResidualAcceptance", map));
        mpeConfig.setAnalystMinArgumentLatitude(getItemAsDouble("analystMinArgumentLatitude", map));
        mpeConfig.setCatalogMinArgumentLatitude(getItemAsDouble("catalogMinArgumentLatitude", map));
        mpeConfig.setAnalystMinReportingSensors(getItemAsInteger("analystMinReportingSensors", (JSONObject) map));
        mpeConfig.setCatalogMinReportingSensors(getItemAsInteger("catalogMinReportingSensors", (JSONObject) map));

        return mpeConfig;
    }
}
