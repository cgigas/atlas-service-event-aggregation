package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class SatelliteData
{
    String satelliteUuid;
    int commentCode;
    CommentCode commentCodeData;
    String classificationMarking;
    String earthModel;
    ObjectType objectType;
    MaintenanceType maintenanceType;
    SsaEventType ssaEventType;
    int laserSatNumber;
    Boolean predSumPassFailFlag;
    Float unLongitude;
    Boolean highInterestFlag;
    String systemName;
    Boolean maneuverableFlag;
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

    public int getCommentCode()
    {
        return commentCode;
    }

    public void setCommentCode(int commentCode)
    {
        this.commentCode = commentCode;
    }

    public CommentCode getCommentCodeData()
    {
        return commentCodeData;
    }

    public void setCommentCodeData(CommentCode commentCodeData)
    {
        this.commentCodeData = commentCodeData;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public String getEarthModel()
    {
        return earthModel;
    }

    public void setEarthModel(String earthModel)
    {
        this.earthModel = earthModel;
    }

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public void setObjectType(ObjectType objectType)
    {
        this.objectType = objectType;
    }

    public MaintenanceType getMaintenanceType()
    {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType)
    {
        this.maintenanceType = maintenanceType;
    }

    public SsaEventType getSsaEventType()
    {
        return ssaEventType;
    }

    public void setSsaEventType(SsaEventType ssaEventType)
    {
        this.ssaEventType = ssaEventType;
    }

    public int getLaserSatNumber()
    {
        return laserSatNumber;
    }

    public void setLaserSatNumber(int laserSatNumber)
    {
        this.laserSatNumber = laserSatNumber;
    }

    public Boolean getPredSumPassFailFlag()
    {
        return predSumPassFailFlag;
    }

    public void setPredSumPassFailFlag(Boolean predSumPassFailFlag)
    {
        this.predSumPassFailFlag = predSumPassFailFlag;
    }

    public Float getUnLongitude()
    {
        return unLongitude;
    }

    public void setUnLongitude(Float unLongitude)
    {
        this.unLongitude = unLongitude;
    }

    public Boolean getHighInterestFlag()
    {
        return highInterestFlag;
    }

    public void setHighInterestFlag(Boolean highInterestFlag)
    {
        this.highInterestFlag = highInterestFlag;
    }

    public String getSystemName()
    {
        return systemName;
    }

    public void setSystemName(String systemName)
    {
        this.systemName = systemName;
    }

    public Boolean getManeuverableFlag()
    {
        return maneuverableFlag;
    }

    public void setManeuverableFlag(Boolean maneuverableFlag)
    {
        this.maneuverableFlag = maneuverableFlag;
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