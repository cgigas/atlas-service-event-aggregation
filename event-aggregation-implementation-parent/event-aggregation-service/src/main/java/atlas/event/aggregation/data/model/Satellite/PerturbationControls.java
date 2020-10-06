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

public class PerturbationControls
{
    String perturbationControlsUuid;
    String classificationMarking;
    String satelliteUuid;
    Application application;
    Float aprioriRadiationPressCoeff;
    Float aprioriSigmaBallCoeffPerct;
    Float aprioriSigmaAgomCoeffPerct;
    AtmosphericModel atmosphericModel;
    Float constantAp;
    Float constantF10;
    Float constantF10Bar;
    Boolean dragFlag;
    Float dragModulation;
    Boolean dcaDataFlag;
    Boolean dmspFlag;
    Boolean kappaFlag;
    String fluxId;
    FluxSource fluxSource;
    Float frontalAreaModulation;
    Boolean geopotentialFlag;
    String geopotentialModel;
    int geopotentialOriginalDegree;
    Boolean geopotentialPrintFlag;
    int geopotentialTesseralDegree;
    Boolean geopotentialTruncationFlag;
    int geopotentialZonalDegree;
    Boolean inTrackDurationThrustFlag;
    Boolean j70DcaFlag;
    String j70DcaId;
    Boolean mpeFlag;
    String mpeId;
    NutationModel nutationModel;
    Boolean solidEarthTidesFlag;
    RadiationPressureShadowModelOption radiationPressureShadowModelOption;
    LunarSolarGravityRepresentationOption lunarSolarGravityRepresentationOption;
    Boolean aprioriSigmaBalcoeUseInputValueFlag;
    Boolean aprioriSigmaBalcoeTimeVaryFlag;
    Boolean geopotentialApplyHybridModelFlag;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
