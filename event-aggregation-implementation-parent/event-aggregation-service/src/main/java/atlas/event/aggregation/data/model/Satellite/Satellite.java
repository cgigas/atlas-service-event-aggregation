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

import atlas.event.aggregation.data.model.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Satellite extends Audited implements Serializable
{
    private String satelliteUuid;
    private String ownerCode;
    private String classificationMarking;
    private int satNo;
    private String satNoVersion;
    private String commonName;
    private String intlDesignator;
    private Category category;
    private String note;
    private DateTime catalogDate;
    private boolean renumberFlag;
    private String templateSatelliteUuid;
    private SatelliteData satelliteData;
    private SatLaunch satLaunch;
    private SatDecay satDecay;
    private IntegratorControls integratorControls;
    private PerturbationControls perturbationControls;
    private DcControls dcControls;
    private DcTolerances dcTolerances;
    private ControlsTemplateCriteria controlsTemplateCriteria;
    private ElementConversionControls elementConversionControls;
    private SatObsAssociationControl satObsAssociationControl;
    private CurrentRcs currentRcs;
    private CurrentVisMag currentVismag;

    public String getSatelliteUuid()
    {
        return satelliteUuid;
    }

    public void setSatelliteUuid(String satelliteUuid)
    {
        this.satelliteUuid = satelliteUuid;
    }

    public String getOwnerCode()
    {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode)
    {
        this.ownerCode = ownerCode;
    }

    public String getClassificationMarking()
    {
        return classificationMarking;
    }

    public void setClassificationMarking(String classificationMarking)
    {
        this.classificationMarking = classificationMarking;
    }

    public int getSatNo()
    {
        return satNo;
    }

    public void setSatNo(int satNo)
    {
        this.satNo = satNo;
    }

    public String getSatNoVersion()
    {
        return satNoVersion;
    }

    public void setSatNoVersion(String satNoVersion)
    {
        this.satNoVersion = satNoVersion;
    }

    public String getCommonName()
    {
        return commonName;
    }

    public void setCommonName(String commonName)
    {
        this.commonName = commonName;
    }

    public String getIntlDesignator()
    {
        return intlDesignator;
    }

    public void setIntlDesignator(String intlDesignator)
    {
        this.intlDesignator = intlDesignator;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public DateTime getCatalogDate()
    {
        return catalogDate;
    }

    public void setCatalogDate(DateTime catalogDate)
    {
        this.catalogDate = catalogDate;
    }

    public boolean isRenumberFlag()
    {
        return renumberFlag;
    }

    public void setRenumberFlag(boolean renumberFlag)
    {
        this.renumberFlag = renumberFlag;
    }

    public String getTemplateSatelliteUuid()
    {
        return templateSatelliteUuid;
    }

    public void setTemplateSatelliteUuid(String templateSatelliteUuid)
    {
        this.templateSatelliteUuid = templateSatelliteUuid;
    }

    public SatelliteData getSatelliteData()
    {
        return satelliteData;
    }

    public void setSatelliteData(SatelliteData satelliteData)
    {
        this.satelliteData = satelliteData;
    }

    public SatLaunch getSatLaunch()
    {
        return satLaunch;
    }

    public void setSatLaunch(SatLaunch satLaunch)
    {
        this.satLaunch = satLaunch;
    }

    public SatDecay getSatDecay()
    {
        return satDecay;
    }

    public void setSatDecay(SatDecay satDecay)
    {
        this.satDecay = satDecay;
    }

    public IntegratorControls getIntegratorControls()
    {
        return integratorControls;
    }

    public void setIntegratorControls(IntegratorControls integratorControls)
    {
        this.integratorControls = integratorControls;
    }

    public PerturbationControls getPerturbationControls()
    {
        return perturbationControls;
    }

    public void setPerturbationControls(PerturbationControls perturbationControls)
    {
        this.perturbationControls = perturbationControls;
    }

    public DcControls getDcControls()
    {
        return dcControls;
    }

    public void setDcControls(DcControls dcControls)
    {
        this.dcControls = dcControls;
    }

    public DcTolerances getDcTolerances()
    {
        return dcTolerances;
    }

    public void setDcTolerances(DcTolerances dcTolerances)
    {
        this.dcTolerances = dcTolerances;
    }

    public ControlsTemplateCriteria getControlsTemplateCriteria()
    {
        return controlsTemplateCriteria;
    }

    public void setControlsTemplateCriteria(ControlsTemplateCriteria controlsTemplateCriteria)
    {
        this.controlsTemplateCriteria = controlsTemplateCriteria;
    }

    public ElementConversionControls getElementConversionControls()
    {
        return elementConversionControls;
    }

    public void setElementConversionControls(ElementConversionControls elementConversionControls)
    {
        this.elementConversionControls = elementConversionControls;
    }

    public SatObsAssociationControl getSatObsAssociationControl()
    {
        return satObsAssociationControl;
    }

    public void setSatObsAssociationControl(SatObsAssociationControl satObsAssociationControl)
    {
        this.satObsAssociationControl = satObsAssociationControl;
    }

    public CurrentRcs getCurrentRcs()
    {
        return currentRcs;
    }

    public void setCurrentRcs(CurrentRcs currentRcs)
    {
        this.currentRcs = currentRcs;
    }

    public CurrentVisMag getCurrentVismag()
    {
        return currentVismag;
    }

    public void setCurrentVismag(CurrentVisMag currentVismag)
    {
        this.currentVismag = currentVismag;
    }
}