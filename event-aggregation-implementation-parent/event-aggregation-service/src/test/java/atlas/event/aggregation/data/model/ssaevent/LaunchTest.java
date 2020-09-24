package atlas.event.aggregation.data.model.ssaevent;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;

class LaunchTest
{
    Launch task = new Launch();
    String id = "id";
    OffsetDateTime launchTimeStamp = OffsetDateTime.now();
    String launchSite = "Cape Canaveral";
    String launchCountry = "USA";
    String typeName = "typeName";

    @Test
    void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    void setLaunchTimeStamp()
    {
        task.setLaunchTimeStamp(launchTimeStamp);
        assertEquals(launchTimeStamp, task.getLaunchTimeStamp());
    }

    @Test
    void setLaunchSite()
    {
        task.setLaunchSite(launchSite);
        assertEquals(launchSite, task.getLaunchSite());
    }

    @Test
    void setLaunchCountry()
    {
        task.setLaunchCountry(launchCountry);
        assertEquals(launchCountry, task.getLaunchCountry());
    }

    @Test
    void setTypeName()
    {
        task.setTypeName(typeName);
        assertEquals(typeName, task.getTypeName());
    }
}