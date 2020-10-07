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

import atlas.notes.crud.graphql.NotesCrudMutationExecutor;
import atlas.notes.crud.graphql.NotesCrudQueryExecutor;
import atlas.satellite.crud.graphql.SatelliteCrudMutationExecutor;
import atlas.satellite.crud.graphql.SatelliteCrudQueryExecutor;
import atlas.sensor.crud.graphql.SensorCrudMutationExecutor;
import atlas.sensor.crud.graphql.SensorCrudQueryExecutor;
import atlas.event.crud.graphql.EventCrudMutationExecutor;
import atlas.event.crud.graphql.EventCrudQueryExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.MessageFormat;

@Component("clientServiceLookup")
@ConfigurationProperties(prefix = "data.service")
@Slf4j
public class DataServiceConfiguration
{
    private String satelliteServiceUrl;
    private String orbitalServiceUrl;
    private String observationServiceUrl;
    private String sensorServiceUrl;
    private String notesServiceUrl;
    private String graphQlExtension;
    private String eventServiceUrl;
    private EventCrudQueryExecutor eventCrudQueryExecutor;
    private EventCrudMutationExecutor eventCrudMutationExecutor;
    private NotesCrudQueryExecutor notesCrudQueryExecutor;
    private NotesCrudMutationExecutor notesCrudMutationExecutor;
    private SensorCrudQueryExecutor sensorCrudQueryExecutor;
    private SensorCrudMutationExecutor sensorCrudMutationExecutor;
    private SatelliteCrudMutationExecutor satelliteCrudMutationExecutor;
    private SatelliteCrudQueryExecutor satelliteCrudQueryExecutor;
    
    @PostConstruct
    public void init()
    {
        String message = MessageFormat.format("The data services the UAS interacts with will be configured with the following URLs:\nSatellite-crud: {0}\nSensor-crud: {1}\nOrbital-crud: {2}\nObservation-data: {3}\nGraphql API Extension: {4}\n {5}Event-data",
                satelliteServiceUrl, sensorServiceUrl, orbitalServiceUrl, observationServiceUrl, graphQlExtension, eventServiceUrl);
    }

    public EventCrudQueryExecutor getEventCrudQueryExecutor()
    {
        if (eventCrudQueryExecutor == null)
        {
            if (eventServiceUrl != null)
            {
                String svcUrl = eventServiceUrl + graphQlExtension;
                eventCrudQueryExecutor = new EventCrudQueryExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Satellite Graphql Mutation client. The service URL was not specified in the environment variable 'SATELLITE_SVC_URL'");
            }
        }

        return eventCrudQueryExecutor;
    }

    public EventCrudMutationExecutor getEventCrudMutationExecutor()
    {
        if (eventCrudMutationExecutor == null)
        {
            if (eventServiceUrl != null)
            {
                String svcUrl = eventServiceUrl + graphQlExtension;
                eventCrudMutationExecutor = new EventCrudMutationExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Satellite Graphql Mutation client. The service URL was not specified in the environment variable 'SATELLITE_SVC_URL'");
            }
        }

        return eventCrudMutationExecutor;
    }


    public SatelliteCrudQueryExecutor getSatelliteCrudQueryExecutor()
    {
        if (satelliteCrudQueryExecutor == null)
        {
            if (satelliteServiceUrl != null)
            {
                String svcUrl = satelliteServiceUrl + graphQlExtension;
                satelliteCrudQueryExecutor = new SatelliteCrudQueryExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Satellite Graphql Mutation client. The service URL was not specified in the environment variable 'SATELLITE_SVC_URL'");
            }
        }

        return satelliteCrudQueryExecutor;
    }

    public SatelliteCrudMutationExecutor getSatelliteCrudMutationExecutor()
    {
        if (satelliteCrudMutationExecutor == null)
        {
            if (satelliteServiceUrl != null)
            {
                String svcUrl = satelliteServiceUrl + graphQlExtension;
                satelliteCrudMutationExecutor = new SatelliteCrudMutationExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Satellite Graphql Mutation client. The service URL was not specified in the environment variable 'SATELLITE_SVC_URL'");
            }
        }

        return satelliteCrudMutationExecutor;
    }

    public SensorCrudQueryExecutor getSensorCrudQueryExecutor()
    {
        if (sensorCrudQueryExecutor == null)
        {
            if (sensorServiceUrl != null)
            {
                String svcUrl = sensorServiceUrl + graphQlExtension;
                sensorCrudQueryExecutor = new SensorCrudQueryExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Sensor Graphql Query client. The service URL was not specified in the environment variable 'SENSOR_SVC_URL'");
            }
        }

        return sensorCrudQueryExecutor;
    }

    public SensorCrudMutationExecutor getSensorCrudMutationExecutor()
    {
        if (sensorCrudMutationExecutor == null)
        {
            if (sensorServiceUrl != null)
            {
                String svcUrl = sensorServiceUrl + graphQlExtension;
                sensorCrudMutationExecutor = new SensorCrudMutationExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Sensor Graphql Mutation client. The service URL was not specified in the environment variable 'SENSOR_SVC_URL'");
            }
        }

        return sensorCrudMutationExecutor;
    }

    public NotesCrudQueryExecutor getNotesCrudQueryExecutor()
    {
        if (notesCrudQueryExecutor == null)
        {
            if (notesServiceUrl != null)
            {
                String svcUrl = notesServiceUrl + graphQlExtension;
                notesCrudQueryExecutor = new NotesCrudQueryExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Notes Graphql Mutation client. The service URL was not specified in the environment variable 'NOTES_SVC_URL'");
            }
        }

        return notesCrudQueryExecutor;
    }

    public NotesCrudMutationExecutor getNotesCrudMutationExecutor()
    {
        if (notesCrudMutationExecutor == null)
        {
            if (notesServiceUrl != null)
            {
                String svcUrl = notesServiceUrl + graphQlExtension;
                notesCrudMutationExecutor = new NotesCrudMutationExecutor(svcUrl);
            }
            else
            {
                throw new IllegalStateException("Unable to instantiate the Notes Graphql Mutation client. The service URL was not specified in the environment variable 'NOTES_SVC_URL'");
            }
        }

        return notesCrudMutationExecutor;
    }

    public String getSatelliteServiceUrl()
    {
        return satelliteServiceUrl;
    }

    public void setSatelliteServiceUrl(String satelliteServiceUrl)
    {
        this.satelliteServiceUrl = satelliteServiceUrl;
    }

    public String getOrbitalServiceUrl()
    {
        return orbitalServiceUrl;
    }

    public void setOrbitalServiceUrl(String orbitalServiceUrl)
    {
        this.orbitalServiceUrl = orbitalServiceUrl;
    }

    public String getObservationServiceUrl()
    {
        return observationServiceUrl;
    }

    public void setObservationServiceUrl(String observationServiceUrl)
    {
        this.observationServiceUrl = observationServiceUrl;
    }

    public String getSensorServiceUrl()
    {
        return sensorServiceUrl;
    }

    public void setSensorServiceUrl(String sensorServiceUrl)
    {
        this.sensorServiceUrl = sensorServiceUrl;
    }

    public String getNotesServiceUrl()
    {
        return notesServiceUrl;
    }

    public void setNotesServiceUrl(String notesServiceUrl)
    {
        this.notesServiceUrl = notesServiceUrl;
    }

    public String getGraphQlExtension()
    {
        return graphQlExtension;
    }

    public void setGraphQlExtension(String graphQlExtension)
    {
        this.graphQlExtension = graphQlExtension;
    }

    public String getEventServiceUrl()
    {
        return eventServiceUrl;
    }

    public void setEventServiceUrl(String eventServiceUrl)
    {
        this.eventServiceUrl = eventServiceUrl;
    }

    public static void main(String[] args) throws Exception
    {
        String url = "http://172.30.211.106:9203/notes-crud/graphql";
        try
        {
            NotesCrudQueryExecutor executor = new NotesCrudQueryExecutor(url);
            System.out.println("SDFSDF");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}