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
package atlas.event.aggregation.data.model.eventdata;

import atlas.event.aggregation.data.model.Audited;

public class EventData extends Audited
{
    private String eventDataUuid;
    private String classificationMarking;
    private String eventUuid;
    private String name;
    private String uri;
    private String type;
    private Byte[] supplementalData;

    public String getEventDataUuid()
    {
        return eventDataUuid;
    }

    public void setEventDataUuid(String eventDataUuid)
    {
        this.eventDataUuid = eventDataUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getEventUuid()
    {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid)
    {
        this.eventUuid = eventUuid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUri()
    {
        return uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Byte[] getSupplementalData()
    {
        return supplementalData;
    }

    public void setSupplementalData(Byte[] supplementalData)
    {
        this.supplementalData = supplementalData;
    }
}