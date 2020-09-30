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
package atlas.event.aggregation.data.model.ssaevent;

import org.junit.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;

public class LaunchTest
{
    Launch task = new Launch();
    String id = "id";
    OffsetDateTime launchTimeStamp = OffsetDateTime.now();
    String launchSite = "Cape Canaveral";
    String launchCountry = "USA";
    String typeName = "typeName";

    @Test
    public void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    public void setLaunchTimeStamp()
    {
        task.setLaunchTimeStamp(launchTimeStamp);
        assertEquals(launchTimeStamp, task.getLaunchTimeStamp());
    }

    @Test
    public void setLaunchSite()
    {
        task.setLaunchSite(launchSite);
        assertEquals(launchSite, task.getLaunchSite());
    }

    @Test
    public void setLaunchCountry()
    {
        task.setLaunchCountry(launchCountry);
        assertEquals(launchCountry, task.getLaunchCountry());
    }

    @Test
    public void setTypeName()
    {
        task.setTypeName(typeName);
        assertEquals(typeName, task.getTypeName());
    }
}