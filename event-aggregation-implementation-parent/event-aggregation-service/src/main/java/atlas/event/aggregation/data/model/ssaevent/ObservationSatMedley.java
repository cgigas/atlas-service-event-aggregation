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
package atlas.event.aggregation.data.model.ssaevent;

import java.time.OffsetDateTime;

public class ObservationSatMedley
{
    private String id;
    private String satelliteId;
    private String observationId;
    private String classification;
    private Long isPromotable;
    private Long isCataloged;
    private Long isAnalyst;
    private Long isCandidate;
    private Long satNo;
    private Long ucn;
    private String commonName;
    private String group;
    private Long type;
    private Double radarCrossSection;
    private OffsetDateTime epoch;
    private String result;
    private Double period;
    private Double inclination;
    private Long apogee;
    private Long perigee;
    private Double eccentricity;
    private String typeName;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSatelliteId()
    {
        return satelliteId;
    }

    public void setSatelliteId(String satelliteId)
    {
        this.satelliteId = satelliteId;
    }

    public String getObservationId()
    {
        return observationId;
    }

    public void setObservationId(String observationId)
    {
        this.observationId = observationId;
    }

    public String getClassification()
    {
        return classification;
    }

    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public Long getPromotable()
    {
        return isPromotable;
    }

    public void setPromotable(Long promotable)
    {
        isPromotable = promotable;
    }

    public Long getCataloged()
    {
        return isCataloged;
    }

    public void setCataloged(Long cataloged)
    {
        isCataloged = cataloged;
    }

    public Long getAnalyst()
    {
        return isAnalyst;
    }

    public void setAnalyst(Long analyst)
    {
        isAnalyst = analyst;
    }

    public Long getCandidate()
    {
        return isCandidate;
    }

    public void setCandidate(Long candidate)
    {
        isCandidate = candidate;
    }

    public Long getSatNo()
    {
        return satNo;
    }

    public void setSatNo(Long satNo)
    {
        this.satNo = satNo;
    }

    public Long getUcn()
    {
        return ucn;
    }

    public void setUcn(Long ucn)
    {
        this.ucn = ucn;
    }

    public String getCommonName()
    {
        return commonName;
    }

    public void setCommonName(String commonName)
    {
        this.commonName = commonName;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public Long getType()
    {
        return type;
    }

    public void setType(Long type)
    {
        this.type = type;
    }

    public Double getRadarCrossSection()
    {
        return radarCrossSection;
    }

    public void setRadarCrossSection(Double radarCrossSection)
    {
        this.radarCrossSection = radarCrossSection;
    }

    public OffsetDateTime getEpoch()
    {
        return epoch;
    }

    public void setEpoch(OffsetDateTime epoch)
    {
        this.epoch = epoch;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public Double getPeriod()
    {
        return period;
    }

    public void setPeriod(Double period)
    {
        this.period = period;
    }

    public Double getInclination()
    {
        return inclination;
    }

    public void setInclination(Double inclination)
    {
        this.inclination = inclination;
    }

    public Long getApogee()
    {
        return apogee;
    }

    public void setApogee(Long apogee)
    {
        this.apogee = apogee;
    }

    public Long getPerigee()
    {
        return perigee;
    }

    public void setPerigee(Long perigee)
    {
        this.perigee = perigee;
    }

    public Double getEccentricity()
    {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity)
    {
        this.eccentricity = eccentricity;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
}
