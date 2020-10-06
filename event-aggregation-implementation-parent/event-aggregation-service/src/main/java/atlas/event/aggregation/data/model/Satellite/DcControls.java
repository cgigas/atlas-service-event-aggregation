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

public class DcControls
{
    String dcControlsUuid;
    String classificationMarking;
    String satelliteUuid;
    Application application;
    String sensorEvntExcludeListUuid;
    String sensorDcIncludeListUuid;
    String sensorSlrListUuid;
    String sensorSsnListUuid;
    String dcAltObsTagListUuid;
    Residual acceptAllResiduals;
    int acceptAllResidualsIteration;
    Boolean allowHyperbolicElementsFlag;
    Boolean applySensorBiasesFlag;
    Float aprBallCoefSegAutoCor;
    Float aprBallCoefSegSigma;
    Float aprBallCoefSigma;
    Float aprBallCoefValue;
    Float aprBdotSigma;
    Float aprBdotValue;
    Float aprRadPresCoefSegAutoCor;
    Float aprRadPresCoefSegSigma;
    Float aprRadPresCoefSigma;
    Float aprRadPresCoefValue;
    Float aprThrustSegAutoCor;
    Float aprThrustSegSigma;
    Float aprThrustSigma;
    Float aprThrustValue;
    Float convergenceCriteria;
    ConvergenceMode convergenceMode;
    Boolean corAfFlag;
    Boolean corAgFlag;
    Boolean corBallCoefSegValFlag;
    Boolean corBdotFlag;
    Boolean corChiFlag;
    Boolean corCmOffsetFlag;
    Boolean corDragFlag;
    Boolean corEccentricityFlag;
    Boolean corLongFlag;
    Boolean corLongOfPerigeeFlag;
    Boolean corMeanmotionFlag;
    Boolean corPerigeeRadiusFlag;
    Boolean corPsiFlag;
    Boolean corRadPresCoefFlag;
    Boolean corRadPresCoefSegValFlag;
    Boolean corThrustFlag;
    Boolean corThrustSegValuesFlag;
    CorrectionSequence corSequence;
    Float crossTrackPosSigma;
    Float crossTrackVelSigma;
    Boolean dcPassWeightingFlag;
    int dcSummaryData;
    Boolean dcaFlag;
    Float deltaApogeeThresholdSigma;
    Float deltaPerigeeThresholdSigma;
    Boolean discardFenceRangeFlag;
    Boolean displayResidualsFlag;
    EpochUpdatePlacement epochUpdatePlacement;
    Float epochUpdateTime;
    Float evntAutoSpanRefineCriteria;
    Boolean evntAutoSpanRefineFlag;
    EventDetectionFlag evntDetectionFlag;
    Float evntDetectionThresholdSigma;
    Float evntMinEgr;
    Float evntMinOdi;
    Float evntMinOdimps;
    int evntMinPasses;
    int evntMinPassesMps;
    Boolean firstPassAdalineRejFlag;
    Float firstPassAdalineRejTol;
    FirstPassCorrection firstPassCorrection;
    Boolean firstPassOnlyFlag;
    Float firstPassRangeRateRej;
    Float firstPassSpatialRej;
    Boolean immediateEpochUpdateFlag;
    Float inTrackPosSigma;
    Float inTrackVelSigma;
    Boolean inhibitNegBallCoefFlag;
    Boolean inhibitNegRadCoefFlag;
    Boolean limitElevationFlag;
    LupiAlgorithm lupiAlgorithm;
    Float lupiIncrease;
    Float lupiDecrease;
    Float lupiMultiplier;
    Float manualLupi;
    Float maxBallCoefCorrection;
    int maxIterations;
    Float maxRadPresCoefCorrection;
    MeasuredComponents measurementComponents;
    MeasurementWeightMode measurementWeightMode;
    int minObsForDragSolution;
    Float minObsSpan;
    int minObsTotal;
    int minTracksForDragSolution;
    int minTracksTotal;
    Float minElevation;
    int obsDataSource;
    Float obsReferenceTime;
    Boolean obsOutputFlag;
    ObsSourceType obsSourceType;
    Float obsStartTime;
    Float obsStopTime;
    Boolean obsUseTimeFlag;
    ObsTag obsTag;
    ObsFrom obsFrom;
    ObsUntil obsUntil;
    Boolean performHalfSpanCheckFlag;
    Boolean performSparseDataCheckFlag;
    Float radialPosSigma;
    Float radialVelSigma;
    ResidualOutput residualOutput;
    String residualRejectionSource;
    Float rmsIncrease;
    Float rmsDecrease;
    Float rmsMultiplierSigma;
    Boolean segFromSourceIdFlag;
    Boolean segManualFlag;
    Boolean segBallCoefFlag;
    int segCount;
    Float segLength;
    Boolean segModelParSolutionFlag;
    Boolean segRadPresCoefFlag;
    SegRefTimeType segRefTimeType;
    SegSize segSize;
    Float segStartTime;
    Float segStopTime;
    Boolean segThrustFlag;
    SegTimeAnchor segTimeAnchor;
    String segSourceId;
    Boolean sensorGeneratePerfStatFlag;
    ShapeType shapeType;
    Float solRelaxFactor;
    String summaryDataSource;
    Boolean thinObservationsFlag;
    Boolean trackWeightingFlag;
    Boolean updateBestOnDivergenceFlag;
    Boolean useAstat0Flag;
    Boolean useAstat1Flag;
    Boolean useAstat2Flag;
    Boolean useAstat3Flag;
    Boolean useAstat4Flag;
    Boolean useAutoRejectionDataFlag;
    int useEveryNthObservation;
    Boolean usePreviousSegValuesFlag;
    Boolean useResidualRejDataFlag;
    Boolean useTimeResidualsFlag;
    Boolean useEphemerisObsFlag;
    Boolean considerCovarianceFlag;
    Float sourceInclusionSpan;
    Float predictedEphemerisToUse;
    Float ephemerisWeightingControl;
    Float ephemerisDensityControl;
    Boolean useGtdoaObservationsFlag;
    Boolean gtdoaObservationListUuid;
    Boolean useTroposphericModelFlag;
    Boolean useEphemerisAsReferenceFlag;
    String referenceEphemerisListUuid;
    Boolean odFinishNotification;
    Boolean abnormalUpdateFlag;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
