package atlas.event.aggregation.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceConfigurationTest
{
    DataServiceConfiguration task = new DataServiceConfiguration();
    String satelliteServiceUrl = "https://www.satelliteService.com";
    String orbitalServiceUrl = "https://www.orbitalService.com";
    String observationServiceUrl = "https://www.observationService.com";
    String sensorServiceUrl = "https://www.sensorService.com";
    String notesServiceUrl = "https://www.notesService.com";
    String graphQlExtension = "https://www.graphQlExtension.com";
    String eventServiceUrl = "https://www.eventService.com";

    @Test
    void init()
    {
        task.init();
    }

    @Test
    void setOrbitalServiceUrl()
    {
        task.setOrbitalServiceUrl(orbitalServiceUrl);
        assertEquals(orbitalServiceUrl, task.getOrbitalServiceUrl());
    }

    @Test
    void setObservationServiceUrl()
    {
        task.setObservationServiceUrl(observationServiceUrl);
        assertEquals(observationServiceUrl, task.getObservationServiceUrl());
    }

    @Test
    void setSensorServiceUrl()
    {
        task.setSensorServiceUrl(sensorServiceUrl);
        assertEquals(sensorServiceUrl, task.getSensorServiceUrl());
    }

    @Test
    void setGraphQlExtension()
    {
        task.setGraphQlExtension(graphQlExtension);
        assertEquals(graphQlExtension, task.getGraphQlExtension());
    }

    @Test
    void setEventServiceUrl()
    {
        task.setEventServiceUrl(eventServiceUrl);
        assertEquals(eventServiceUrl, task.getEventServiceUrl());
    }

    @Test
    void setNotesServiceUrl()
    {
        task.setNotesServiceUrl(notesServiceUrl);
        assertEquals(notesServiceUrl, task.getNotesServiceUrl());
    }

    @Test
    void setSatelliteServiceUrl()
    {
        task.setSatelliteServiceUrl(satelliteServiceUrl);
        assertEquals(satelliteServiceUrl, task.getSatelliteServiceUrl());
    }
}