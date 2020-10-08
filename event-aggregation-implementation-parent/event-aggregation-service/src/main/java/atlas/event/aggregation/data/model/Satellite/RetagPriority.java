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

public class RetagPriority
{
    String retagPriorityUuid;
    String classificationMarking;
    int retagPriority;
    String priorityName;
    AssociationStatus astatThreshold;
    Boolean enabled;
    Boolean obtype0;
    Boolean obtype1;
    Boolean obtype2;
    Boolean obtype3;
    Boolean obtype4;
    Boolean obtype5;
    Boolean obtype6;
    Boolean obtype7;
    Boolean obtype8;
    Boolean obtype9;
    Float minChiMeasureThreshold;
    Float minGpVmagThreshold;
    Float minSpVmagThreshold;
    Float gpDeltaTimeThreshold;
    Float gpDeltaBetaThreshold;
    Float gpDeltaHeightThreshold;
    Float spDeltaTimeThreshold;
    Float spDeltaBetaThreshold;
    Float spDeltaHeightThreshold;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;

    public String getRetagPriorityUuid()
    {
        return retagPriorityUuid;
    }

    public void setRetagPriorityUuid(String retagPriorityUuid)
    {
        this.retagPriorityUuid = retagPriorityUuid;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public int getRetagPriority()
    {
        return retagPriority;
    }

    public void setRetagPriority(int retagPriority)
    {
        this.retagPriority = retagPriority;
    }

    public String getPriorityName()
    {
        return priorityName;
    }

    public void setPriorityName(String priorityName)
    {
        this.priorityName = priorityName;
    }

    public AssociationStatus getAstatThreshold()
    {
        return astatThreshold;
    }

    public void setAstatThreshold(AssociationStatus astatThreshold)
    {
        this.astatThreshold = astatThreshold;
    }

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    public Boolean getObtype0()
    {
        return obtype0;
    }

    public void setObtype0(Boolean obtype0)
    {
        this.obtype0 = obtype0;
    }

    public Boolean getObtype1()
    {
        return obtype1;
    }

    public void setObtype1(Boolean obtype1)
    {
        this.obtype1 = obtype1;
    }

    public Boolean getObtype2()
    {
        return obtype2;
    }

    public void setObtype2(Boolean obtype2)
    {
        this.obtype2 = obtype2;
    }

    public Boolean getObtype3()
    {
        return obtype3;
    }

    public void setObtype3(Boolean obtype3)
    {
        this.obtype3 = obtype3;
    }

    public Boolean getObtype4()
    {
        return obtype4;
    }

    public void setObtype4(Boolean obtype4)
    {
        this.obtype4 = obtype4;
    }

    public Boolean getObtype5()
    {
        return obtype5;
    }

    public void setObtype5(Boolean obtype5)
    {
        this.obtype5 = obtype5;
    }

    public Boolean getObtype6()
    {
        return obtype6;
    }

    public void setObtype6(Boolean obtype6)
    {
        this.obtype6 = obtype6;
    }

    public Boolean getObtype7()
    {
        return obtype7;
    }

    public void setObtype7(Boolean obtype7)
    {
        this.obtype7 = obtype7;
    }

    public Boolean getObtype8()
    {
        return obtype8;
    }

    public void setObtype8(Boolean obtype8)
    {
        this.obtype8 = obtype8;
    }

    public Boolean getObtype9()
    {
        return obtype9;
    }

    public void setObtype9(Boolean obtype9)
    {
        this.obtype9 = obtype9;
    }

    public Float getMinChiMeasureThreshold()
    {
        return minChiMeasureThreshold;
    }

    public void setMinChiMeasureThreshold(Float minChiMeasureThreshold)
    {
        this.minChiMeasureThreshold = minChiMeasureThreshold;
    }

    public Float getMinGpVmagThreshold()
    {
        return minGpVmagThreshold;
    }

    public void setMinGpVmagThreshold(Float minGpVmagThreshold)
    {
        this.minGpVmagThreshold = minGpVmagThreshold;
    }

    public Float getMinSpVmagThreshold()
    {
        return minSpVmagThreshold;
    }

    public void setMinSpVmagThreshold(Float minSpVmagThreshold)
    {
        this.minSpVmagThreshold = minSpVmagThreshold;
    }

    public Float getGpDeltaTimeThreshold()
    {
        return gpDeltaTimeThreshold;
    }

    public void setGpDeltaTimeThreshold(Float gpDeltaTimeThreshold)
    {
        this.gpDeltaTimeThreshold = gpDeltaTimeThreshold;
    }

    public Float getGpDeltaBetaThreshold()
    {
        return gpDeltaBetaThreshold;
    }

    public void setGpDeltaBetaThreshold(Float gpDeltaBetaThreshold)
    {
        this.gpDeltaBetaThreshold = gpDeltaBetaThreshold;
    }

    public Float getGpDeltaHeightThreshold()
    {
        return gpDeltaHeightThreshold;
    }

    public void setGpDeltaHeightThreshold(Float gpDeltaHeightThreshold)
    {
        this.gpDeltaHeightThreshold = gpDeltaHeightThreshold;
    }

    public Float getSpDeltaTimeThreshold()
    {
        return spDeltaTimeThreshold;
    }

    public void setSpDeltaTimeThreshold(Float spDeltaTimeThreshold)
    {
        this.spDeltaTimeThreshold = spDeltaTimeThreshold;
    }

    public Float getSpDeltaBetaThreshold()
    {
        return spDeltaBetaThreshold;
    }

    public void setSpDeltaBetaThreshold(Float spDeltaBetaThreshold)
    {
        this.spDeltaBetaThreshold = spDeltaBetaThreshold;
    }

    public Float getSpDeltaHeightThreshold()
    {
        return spDeltaHeightThreshold;
    }

    public void setSpDeltaHeightThreshold(Float spDeltaHeightThreshold)
    {
        this.spDeltaHeightThreshold = spDeltaHeightThreshold;
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
