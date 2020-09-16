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
package atlas.event.aggregation.data.model.ssaeventsat;

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SsaEventSat extends Audited
{
    /**
     * UUID of the satellite associated with the event.
     */
    @Id
    private String satelliteUuid;

    /**
     * UUID of the SSA event.
     */
    @NotNull
    private String ssaEventUuid;

    /**
     * Identifies the relationship of the satellite to the event depending on the SSA event
     * For DOCK/UNDOCK/SEPARATION/BREAKUP use - PARENT, CHILD
     * For RENDEZVOUS/PROXIMITY use the pairs - ACTOR and TARGET
     * For NUDET - use TARGET
     * For LAUNCH - use ACTOR'
     */
    @NotNull
    private Relationship relationship;

    /**
     * 'UnCataloged Number - a convention for assigning numbers to uncataloged objects for CA purposes.
     * Specifically, it is a system used for pre-launch orbital screenings
     */
    private Integer ucn;

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public String getSsaEventUuid()
    {
        return ssaEventUuid;
    }

    public void setSsaEventUuid(String ssaEventUuid)
    {
        this.ssaEventUuid = ssaEventUuid;
    }

    public Relationship getRelationship()
    {
        return relationship;
    }

    public void setRelationship(Relationship relationship)
    {
        this.relationship = relationship;
    }

    public Integer getUcn()
    {
        return ucn;
    }

    public void setUcn(Integer ucn)
    {
        this.ucn = ucn;
    }
}
