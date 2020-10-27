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

public class EventTypeSummary
{
    private EventType type;
    private Integer planned = 0;
    private Integer active = 0;
    private String typename;

    public void addOneToPlanned()
    {
        planned++;
    }

    public void addOneToActive()
    {
        active++;
    }

    public EventType getType()
    {
        return type;
    }

    public void setType(EventType type)
    {
        this.type = type;
    }

    public Integer getPlanned()
    {
        if (planned == null)
        {
            planned = 0;
        }

        return planned;
    }

    public void setPlanned(Integer planned)
    {
        this.planned = planned;
    }

    public Integer getActive()
    {
        if (active == null)
        {
            active = 0;
        }

        return active;
    }

    public void setActive(Integer active)
    {
        this.active = active;
    }

    public String getTypename()
    {
        return typename;
    }

    public void setTypename(String typename)
    {
        this.typename = typename;
    }
}
