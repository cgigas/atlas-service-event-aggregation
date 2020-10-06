package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class SatLaunch
{
    String satelliteUuid;
    String classificationMarking;
    DateTime launchDt;
    String siteUuid;
    Float lat;
    Float lon;
    Float alt;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public DateTime getLaunchDt()
    {
        return launchDt;
    }

    public void setLaunchDt(DateTime launchDt)
    {
        this.launchDt = launchDt;
    }

    public String getSiteUuid()
    {
        return siteUuid;
    }

    public void setSiteUuid(String siteUuid)
    {
        this.siteUuid = siteUuid;
    }

    public Float getLat()
    {
        return lat;
    }

    public void setLat(Float lat)
    {
        this.lat = lat;
    }

    public Float getLon()
    {
        return lon;
    }

    public void setLon(Float lon)
    {
        this.lon = lon;
    }

    public Float getAlt()
    {
        return alt;
    }

    public void setAlt(Float alt)
    {
        this.alt = alt;
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
