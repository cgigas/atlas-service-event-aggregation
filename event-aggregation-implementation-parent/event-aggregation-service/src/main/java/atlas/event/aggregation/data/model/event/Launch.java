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
package atlas.event.aggregation.data.model.event;

import java.time.OffsetDateTime;

public class Launch
{
    private String id;
    private OffsetDateTime launchTimeStamp;
    private String launchSite;
    private String launchCountry;
    private String typeName;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public OffsetDateTime getLaunchTimeStamp()
    {
        return launchTimeStamp;
    }

    public void setLaunchTimeStamp(OffsetDateTime launchTimeStamp)
    {
        this.launchTimeStamp = launchTimeStamp;
    }

    public String getLaunchSite()
    {
        return launchSite;
    }

    public void setLaunchSite(String launchSite)
    {
        this.launchSite = launchSite;
    }

    public String getLaunchCountry()
    {
        return launchCountry;
    }

    public void setLaunchCountry(String launchCountry)
    {
        this.launchCountry = launchCountry;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
}
