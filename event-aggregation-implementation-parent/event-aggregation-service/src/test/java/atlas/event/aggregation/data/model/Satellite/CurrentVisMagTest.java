package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrentVisMagTest
{
    CurrentVisMag task = new CurrentVisMag();
    String satelliteUuid = "sat uuid";
    String visualMagnitudeUuid = "vis mag uuid";
    VisualMagnitude visualMagnitude = new VisualMagnitude();
    Long version = 1L;

    @Test
    public void setSatelliteUuid()
    {
        task.setSatelliteUuid(satelliteUuid);
        assertEquals(satelliteUuid, task.getSatelliteUuid());
    }

    @Test
    public void setVisualMagnitudeUuid()
    {
        task.setVisualMagnitudeUuid(visualMagnitudeUuid);
        assertEquals(visualMagnitudeUuid, task.getVisualMagnitudeUuid());
    }

    @Test
    public void setVisualMagnitude()
    {
        task.setVisualMagnitude(visualMagnitude);
        assertEquals(visualMagnitude, task.getVisualMagnitude());
    }

    @Test
    public void setVersion()
    {
        task.setVersion(version);
        assertEquals(version, task.getVersion());
    }
}