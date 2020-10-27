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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataServiceConfigurationTest
{
    String url = "url";

    @Before
    public void init()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        assertNotNull(task);
        task.init();
    }

    @Test
    public void testGettersSetters()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setOrbitalServiceUrl(url);
        assertEquals(url, task.getOrbitalServiceUrl());
        task.setObservationServiceUrl(url);
        assertEquals(url, task.getObservationServiceUrl());
        task.setGraphQlExtension(url);
        assertEquals("/url", task.getGraphQlExtension());
    }

    @Test(expected = IllegalStateException.class)
    public void testEventQueryExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setEventServiceUrl(url);
        assertNotNull(task.getEventCrudQueryExecutor());
        assertEquals(url, task.getEventServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getEventCrudQueryExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testSatQueryExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setSatelliteServiceUrl(url);
        assertNotNull(task.getSatelliteCrudQueryExecutor());
        assertEquals(url, task.getSatelliteServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getSatelliteCrudQueryExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testSensorQueryExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setSensorServiceUrl(url);
        assertNotNull(task.getSensorCrudQueryExecutor());
        assertEquals(url, task.getSensorServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getSensorCrudQueryExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testNotesQueryExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setNotesServiceUrl(url);
        assertNotNull(task.getNotesCrudQueryExecutor());
        assertEquals(url, task.getNotesServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getNotesCrudQueryExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testEventMutationExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setEventServiceUrl(url);
        assertNotNull(task.getEventCrudMutationExecutor());
        assertEquals(url, task.getEventServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getEventCrudMutationExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testSatMutationExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setSatelliteServiceUrl(url);
        assertNotNull(task.getSatelliteCrudMutationExecutor());
        assertEquals(url, task.getSatelliteServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getSatelliteCrudMutationExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testSensorMutationExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setSensorServiceUrl(url);
        assertNotNull(task.getSensorCrudMutationExecutor());
        assertEquals(url, task.getSensorServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getSensorCrudMutationExecutor();
    }

    @Test(expected = IllegalStateException.class)
    public void testNotesMutationExecutors()
    {
        DataServiceConfiguration task = new DataServiceConfiguration();
        task.setNotesServiceUrl(url);
        assertNotNull(task.getNotesCrudMutationExecutor());
        assertEquals(url, task.getNotesServiceUrl());
        DataServiceConfiguration task2 = new DataServiceConfiguration();
        task2.getNotesCrudMutationExecutor();
    }
}