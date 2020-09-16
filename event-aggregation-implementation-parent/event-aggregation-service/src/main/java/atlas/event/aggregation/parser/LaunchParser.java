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

import atlas.event.aggregation.data.model.ssaevent.SsaLaunch;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("launchParser")
public class LaunchParser implements IParser
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
        return null;
    }

    @Override
    public Object fromJson(Map<String, Object> map)
    {
        SsaLaunch launch = new SsaLaunch();
        launch.setId(getItemAsString("id", map));
        launch.setLaunchTimeStamp(getItemAsOffSetDate("launchTimestamp", map));
        launch.setLaunchSite(getItemAsString("launchSite", map));
        launch.setLaunchCountry(getItemAsString("launchCountry", map));
        launch.setTypeName(getItemAsString("typeName", map));

        return launch;
    }
}