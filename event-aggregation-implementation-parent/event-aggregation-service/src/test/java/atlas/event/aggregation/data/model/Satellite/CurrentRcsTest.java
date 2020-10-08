package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrentRcsTest
{
    CurrentRcs task = new CurrentRcs();
    private String satelliteUuid = "uuid";
    private String rcsUuid = "rcs";
    private RadarCrossSection radarCrossSection = new RadarCrossSection();
    private Long version = 1L;

    @Test
    public void setSatelliteUuid()
    {
        task.setSatelliteUuid(satelliteUuid);
        assertEquals(satelliteUuid, task.getSatelliteUuid());
    }

    @Test
    public void setRcsUuid()
    {
        task.setRcsUuid(rcsUuid);
        assertEquals(rcsUuid, task.getRcsUuid());
    }

    @Test
    public void setRadarCrossSection()
    {
        task.setRadarCrossSection(radarCrossSection);
        assertEquals(radarCrossSection, task.getRadarCrossSection());
    }

    @Test
    public void setVersion()
    {
        task.setVersion(version);
        assertEquals(version, task.getVersion());
    }
}