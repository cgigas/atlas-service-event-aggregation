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

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class EventDetail
{
    private String id;
    private String state;
    private String classification;
    private EventType type;
    private String name;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Long catalogObjectCount;
    private Long analystObjects;
    private Long candidateObjectCount;
    private Long promotableObjectCount;
    private String typeName;
    private Event parentEvent;
    private Launch launch;
    private List<ObservationSatMedley> observationSatMedleyArray;

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getClassification()
    {
        return classification;
    }

    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public EventType getType()
    {
        return type;
    }

    public void setType(EventType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public OffsetDateTime getStartDate()
    {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate)
    {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate()
    {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate)
    {
        this.endDate = endDate;
    }

    public Long getCatalogObjectCount()
    {
        return catalogObjectCount;
    }

    public void setCatalogObjectCount(Long catalogObjectCount)
    {
        this.catalogObjectCount = catalogObjectCount;
    }

    public Long getAnalystObjects()
    {
        return analystObjects;
    }

    public void setAnalystObjects(Long analystObjects)
    {
        this.analystObjects = analystObjects;
    }

    public Long getCandidateObjectCount()
    {
        return candidateObjectCount;
    }

    public void setCandidateObjectCount(Long candidateObjectCount)
    {
        this.candidateObjectCount = candidateObjectCount;
    }

    public Long getPromotableObjectCount()
    {
        return promotableObjectCount;
    }

    public void setPromotableObjectCount(Long promotableObjectCount)
    {
        this.promotableObjectCount = promotableObjectCount;
    }

    public Event getParentEvent()
    {
        return parentEvent;
    }

    public void setParentEvent(Event parentEvent)
    {
        this.parentEvent = parentEvent;
    }

    public Launch getLaunch()
    {
        return launch;
    }

    public void setLaunch(Launch launch)
    {
        this.launch = launch;
    }

    public List<ObservationSatMedley> getObservationSatMedleyArray()
    {
        if (observationSatMedleyArray == null)
        {
            observationSatMedleyArray = new ArrayList<>();
        }

        return observationSatMedleyArray;
    }

    public void setObservationSatMedleyArray(List<ObservationSatMedley> observationSatMedleyArray)
    {
        this.observationSatMedleyArray = observationSatMedleyArray;
    }
}
