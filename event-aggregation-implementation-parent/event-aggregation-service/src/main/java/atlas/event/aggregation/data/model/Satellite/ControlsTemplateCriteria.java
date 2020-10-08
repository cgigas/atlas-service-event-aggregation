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

public class ControlsTemplateCriteria
{
    private String ctrlsTemplateCriteriaUuid;
    private String classificationMarking;
    private String satelliteUuid;
    private String name;
    private Float perigeeLowerBound;
    private Float perigeeUpperBound;
    private Float eccentricityLowerBound;
    private Float eccentricityUpperBound;
    private ObjectType objectType;
    private Category category;
    private SsaEventType ssaEventType;
    private DateTime createDate;
    private String createOrigin;
    private DateTime updateDate;
    private String updateOrigin;
    private Long version;

    public String getCtrlsTemplateCriteriaUuid()
    {
        return ctrlsTemplateCriteriaUuid;
    }

    public void setCtrlsTemplateCriteriaUuid(String ctrlsTemplateCriteriaUuid)
    {
        this.ctrlsTemplateCriteriaUuid = ctrlsTemplateCriteriaUuid;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Float getPerigeeLowerBound()
    {
        return perigeeLowerBound;
    }

    public void setPerigeeLowerBound(Float perigeeLowerBound)
    {
        this.perigeeLowerBound = perigeeLowerBound;
    }

    public Float getPerigeeUpperBound()
    {
        return perigeeUpperBound;
    }

    public void setPerigeeUpperBound(Float perigeeUpperBound)
    {
        this.perigeeUpperBound = perigeeUpperBound;
    }

    public Float getEccentricityLowerBound()
    {
        return eccentricityLowerBound;
    }

    public void setEccentricityLowerBound(Float eccentricityLowerBound)
    {
        this.eccentricityLowerBound = eccentricityLowerBound;
    }

    public Float getEccentricityUpperBound()
    {
        return eccentricityUpperBound;
    }

    public void setEccentricityUpperBound(Float eccentricityUpperBound)
    {
        this.eccentricityUpperBound = eccentricityUpperBound;
    }

    public ObjectType getObjectType()
    {
        return objectType;
    }

    public void setObjectType(ObjectType objectType)
    {
        this.objectType = objectType;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public SsaEventType getSsaEventType()
    {
        return ssaEventType;
    }

    public void setSsaEventType(SsaEventType ssaEventType)
    {
        this.ssaEventType = ssaEventType;
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