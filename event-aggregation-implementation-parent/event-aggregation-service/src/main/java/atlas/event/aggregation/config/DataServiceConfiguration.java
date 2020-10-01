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

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.MessageFormat;

@Component("dataServiceConfiguration")
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

    @PostConstruct
    public void init()
    {
        String message = MessageFormat.format("The data services the UAS interacts with will be configured with the following URLs:\nSatellite-crud: {0}\nSensor-crud: {1}\nOrbital-crud: {2}\nObservation-data: {3}\nGraphql API Extension: {4}\n {5}Event-data",
                satelliteServiceUrl, sensorServiceUrl, orbitalServiceUrl, observationServiceUrl, graphQlExtension, eventServiceUrl);
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
}