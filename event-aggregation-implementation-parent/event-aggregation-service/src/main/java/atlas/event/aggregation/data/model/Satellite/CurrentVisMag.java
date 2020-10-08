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
package atlas.event.aggregation.data.model.Satellite;

public class CurrentVisMag
{
    String satelliteUuid;
    String visualMagnitudeUuid;
    VisualMagnitude visualMagnitude;
    Long version;

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public String getVisualMagnitudeUuid()
    {
        return visualMagnitudeUuid;
    }

    public void setVisualMagnitudeUuid(String visualMagnitudeUuid)
    {
        this.visualMagnitudeUuid = visualMagnitudeUuid;
    }

    public VisualMagnitude getVisualMagnitude()
    {
        return visualMagnitude;
    }

    public void setVisualMagnitude(VisualMagnitude visualMagnitude)
    {
        this.visualMagnitude = visualMagnitude;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }
}
