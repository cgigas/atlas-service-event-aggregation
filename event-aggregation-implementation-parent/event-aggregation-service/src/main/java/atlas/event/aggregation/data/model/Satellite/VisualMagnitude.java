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

import org.joda.time.DateTime;

public class VisualMagnitude
{
    String visualMagnitudeUuid;
    String classificationMarking;
    String satelliteUuid;
    int sensorNumber;
    DateTime reportDt;
    Float observedMv;
    Float normKm36000;
    Float solarPhaseAngle;
    Float solarDeclinationAngle;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;

    public String getVisualMagnitudeUuid()
    {
        return visualMagnitudeUuid;
    }

    public void setVisualMagnitudeUuid(String visualMagnitudeUuid)
    {
        this.visualMagnitudeUuid = visualMagnitudeUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public int getSensorNumber()
    {
        return sensorNumber;
    }

    public void setSensorNumber(int sensorNumber)
    {
        this.sensorNumber = sensorNumber;
    }

    public DateTime getReportDt()
    {
        return reportDt;
    }

    public void setReportDt(DateTime reportDt)
    {
        this.reportDt = reportDt;
    }

    public Float getObservedMv()
    {
        return observedMv;
    }

    public void setObservedMv(Float observedMv)
    {
        this.observedMv = observedMv;
    }

    public Float getNormKm36000()
    {
        return normKm36000;
    }

    public void setNormKm36000(Float normKm36000)
    {
        this.normKm36000 = normKm36000;
    }

    public Float getSolarPhaseAngle()
    {
        return solarPhaseAngle;
    }

    public void setSolarPhaseAngle(Float solarPhaseAngle)
    {
        this.solarPhaseAngle = solarPhaseAngle;
    }

    public Float getSolarDeclinationAngle()
    {
        return solarDeclinationAngle;
    }

    public void setSolarDeclinationAngle(Float solarDeclinationAngle)
    {
        this.solarDeclinationAngle = solarDeclinationAngle;
    }

    public DateTime getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(DateTime createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateOrigin()
    {
        return createOrigin;
    }

    public void setCreateOrigin(String createOrigin)
    {
        this.createOrigin = createOrigin;
    }

    public DateTime getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(DateTime updateDate)
    {
        this.updateDate = updateDate;
    }

    public String getUpdateOrigin()
    {
        return updateOrigin;
    }

    public void setUpdateOrigin(String updateOrigin)
    {
        this.updateOrigin = updateOrigin;
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
