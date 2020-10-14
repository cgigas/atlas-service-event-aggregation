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
package atlas.event.aggregation.config;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DataServiceConfigurationTest
{
    DataServiceConfiguration task = new DataServiceConfiguration();
    String satelliteServiceUrl = "http://172.30.211.106:9205/satellite-crud";
    String orbitalServiceUrl = "http://172.30.211.106:9204/orbital-crud";
    String observationServiceUrl = "http://172.30.211.103:9001/observation-crud";
    String sensorServiceUrl = "http://172.30.211.106:9206/sensor-crud";
    String notesServiceUrl = "http://172.30.211.106:9203/notes-crud";
    String graphQlExtension = "https://www.graphQlExtension.com";
    String eventServiceUrl = "http://172.30.211.106:9210/ssaevent-crud";

    @Test
    public void init()
    {
        task.init();
    }

    @Test
    public void setOrbitalServiceUrl()
    {
        task.setOrbitalServiceUrl(orbitalServiceUrl);
        assertEquals(orbitalServiceUrl, task.getOrbitalServiceUrl());
    }

    @Test
    public void setObservationServiceUrl()
    {
        task.setObservationServiceUrl(observationServiceUrl);
        assertEquals(observationServiceUrl, task.getObservationServiceUrl());
    }

    @Test
    public void setSensorServiceUrl()
    {
        task.setSensorServiceUrl(sensorServiceUrl);
        assertEquals(sensorServiceUrl, task.getSensorServiceUrl());
    }

    @Test
    public void setGraphQlExtension()
    {
        task.setGraphQlExtension(graphQlExtension);
        assertEquals(graphQlExtension, task.getGraphQlExtension());
    }

    @Test
    public void setEventServiceUrl()
    {
        task.setEventServiceUrl(eventServiceUrl);
        assertEquals(eventServiceUrl, task.getEventServiceUrl());
    }

    @Test
    public void setNotesServiceUrl()
    {
        task.setNotesServiceUrl(notesServiceUrl);
        assertEquals(notesServiceUrl, task.getNotesServiceUrl());
    }

    @Test
    public void setSatelliteServiceUrl()
    {
        task.setSatelliteServiceUrl(satelliteServiceUrl);
        assertEquals(satelliteServiceUrl, task.getSatelliteServiceUrl());
    }
}