package atlas.event.aggregation.data.model.Satellite;

import atlas.event.aggregation.GetterSetterTester;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class DcControlsTest
{




    DcControlsTest task = new DcControlsTest();
    String dcControlsUuid="dcControlsUuid";
    String classificationMarking="classificationMarking";
    String satelliteUuid="satelliteUuid";
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

    @Test
    public void setDcControlsUuid()
    {
    }

    @Test
    public void setClassificationMarking()
    {
    }

    @Test
    public void setSatelliteUuid()
    {
    }

    @Test
    public void setApplication()
    {
    }

    @Test
    public void setSensorEvntExcludeListUuid()
    {
    }

    @Test
    public void setSensorDcIncludeListUuid()
    {
    }

    @Test
    public void setSensorSlrListUuid()
    {
    }

    @Test
    public void setSensorSsnListUuid()
    {
    }

    @Test
    public void setDcAltObsTagListUuid()
    {
    }

    @Test
    public void setAcceptAllResiduals()
    {
    }

    @Test
    public void setAcceptAllResidualsIteration()
    {
    }

    @Test
    public void setAllowHyperbolicElementsFlag()
    {
    }

    @Test
    public void setApplySensorBiasesFlag()
    {
    }

    @Test
    public void setAprBallCoefSegAutoCor()
    {
    }

    @Test
    public void setAprBallCoefSegSigma()
    {
    }

    @Test
    public void setAprBallCoefSigma()
    {
    }

    @Test
    public void setAprBallCoefValue()
    {
    }

    @Test
    public void setAprBdotSigma()
    {
    }

    @Test
    public void setAprBdotValue()
    {
    }

    @Test
    public void setAprRadPresCoefSegAutoCor()
    {
    }

    @Test
    public void setAprRadPresCoefSegSigma()
    {
    }

    @Test
    public void setAprRadPresCoefSigma()
    {
    }

    @Test
    public void setAprRadPresCoefValue()
    {
    }

    @Test
    public void setAprThrustSegAutoCor()
    {
    }

    @Test
    public void setAprThrustSegSigma()
    {
    }

    @Test
    public void setAprThrustSigma()
    {
    }

    @Test
    public void setAprThrustValue()
    {
    }

    @Test
    public void setConvergenceCriteria()
    {
    }

    @Test
    public void setConvergenceMode()
    {
    }

    @Test
    public void setCorAfFlag()
    {
    }

    @Test
    public void setCorAgFlag()
    {
    }

    @Test
    public void setCorBallCoefSegValFlag()
    {
    }

    @Test
    public void setCorBdotFlag()
    {
    }

    @Test
    public void setCorChiFlag()
    {
    }

    @Test
    public void setCorCmOffsetFlag()
    {
    }

    @Test
    public void setCorDragFlag()
    {
    }

    @Test
    public void setCorEccentricityFlag()
    {
    }

    @Test
    public void setCorLongFlag()
    {
    }

    @Test
    public void setCorLongOfPerigeeFlag()
    {
    }

    @Test
    public void setCorMeanmotionFlag()
    {
    }

    @Test
    public void setCorPerigeeRadiusFlag()
    {
    }

    @Test
    public void setCorPsiFlag()
    {
    }

    @Test
    public void setCorRadPresCoefFlag()
    {
    }

    @Test
    public void setCorRadPresCoefSegValFlag()
    {
    }

    @Test
    public void setCorThrustFlag()
    {
    }

    @Test
    public void setCorThrustSegValuesFlag()
    {
    }

    @Test
    public void setCorSequence()
    {
    }

    @Test
    public void setCrossTrackPosSigma()
    {
    }

    @Test
    public void setCrossTrackVelSigma()
    {
    }

    @Test
    public void setDcPassWeightingFlag()
    {
    }

    @Test
    public void setDcSummaryData()
    {
    }

    @Test
    public void setDcaFlag()
    {
    }

    @Test
    public void setDeltaApogeeThresholdSigma()
    {
    }

    @Test
    public void setDeltaPerigeeThresholdSigma()
    {
    }

    @Test
    public void setDiscardFenceRangeFlag()
    {
    }

    @Test
    public void setDisplayResidualsFlag()
    {
    }

    @Test
    public void setEpochUpdatePlacement()
    {
    }

    @Test
    public void setEpochUpdateTime()
    {
    }

    @Test
    public void setEvntAutoSpanRefineCriteria()
    {
    }

    @Test
    public void setEvntAutoSpanRefineFlag()
    {
    }

    @Test
    public void setEvntDetectionFlag()
    {
    }

    @Test
    public void setEvntDetectionThresholdSigma()
    {
    }

    @Test
    public void setEvntMinEgr()
    {
    }

    @Test
    public void setEvntMinOdi()
    {
    }

    @Test
    public void setEvntMinOdimps()
    {
    }

    @Test
    public void setEvntMinPasses()
    {
    }

    @Test
    public void setEvntMinPassesMps()
    {
    }

    @Test
    public void setFirstPassAdalineRejFlag()
    {
    }

    @Test
    public void setFirstPassAdalineRejTol()
    {
    }

    @Test
    public void setFirstPassCorrection()
    {
    }

    @Test
    public void setFirstPassOnlyFlag()
    {
    }

    @Test
    public void setFirstPassRangeRateRej()
    {
    }

    @Test
    public void setFirstPassSpatialRej()
    {
    }

    @Test
    public void setImmediateEpochUpdateFlag()
    {
    }

    @Test
    public void setInTrackPosSigma()
    {
    }

    @Test
    public void setInTrackVelSigma()
    {
    }

    @Test
    public void setInhibitNegBallCoefFlag()
    {
    }

    @Test
    public void setInhibitNegRadCoefFlag()
    {
    }

    @Test
    public void setLimitElevationFlag()
    {
    }

    @Test
    public void setLupiAlgorithm()
    {
    }

    @Test
    public void setLupiIncrease()
    {
    }

    @Test
    public void setLupiDecrease()
    {
    }

    @Test
    public void setLupiMultiplier()
    {
    }

    @Test
    public void setManualLupi()
    {
    }

    @Test
    public void setMaxBallCoefCorrection()
    {
    }

    @Test
    public void setMaxIterations()
    {
    }

    @Test
    public void setMaxRadPresCoefCorrection()
    {
    }

    @Test
    public void setMeasurementComponents()
    {
    }

    @Test
    public void setMeasurementWeightMode()
    {
    }

    @Test
    public void setMinObsForDragSolution()
    {
    }

    @Test
    public void setMinObsSpan()
    {
    }

    @Test
    public void setMinObsTotal()
    {
    }

    @Test
    public void setMinTracksForDragSolution()
    {
    }

    @Test
    public void setMinTracksTotal()
    {
    }

    @Test
    public void setMinElevation()
    {
    }

    @Test
    public void setObsDataSource()
    {
    }

    @Test
    public void setObsReferenceTime()
    {
    }

    @Test
    public void setObsOutputFlag()
    {
    }

    @Test
    public void setObsSourceType()
    {
    }

    @Test
    public void setObsStartTime()
    {
    }

    @Test
    public void setObsStopTime()
    {
    }

    @Test
    public void setObsUseTimeFlag()
    {
    }

    @Test
    public void setObsTag()
    {
    }

    @Test
    public void setObsFrom()
    {
    }

    @Test
    public void setObsUntil()
    {
    }

    @Test
    public void setPerformHalfSpanCheckFlag()
    {
    }

    @Test
    public void setPerformSparseDataCheckFlag()
    {
    }

    @Test
    public void setRadialPosSigma()
    {
    }

    @Test
    public void setRadialVelSigma()
    {
    }

    @Test
    public void setResidualOutput()
    {
    }

    @Test
    public void setResidualRejectionSource()
    {
    }

    @Test
    public void setRmsIncrease()
    {
    }

    @Test
    public void setRmsDecrease()
    {
    }

    @Test
    public void setRmsMultiplierSigma()
    {
    }

    @Test
    public void setSegFromSourceIdFlag()
    {
    }

    @Test
    public void setSegManualFlag()
    {
    }

    @Test
    public void setSegBallCoefFlag()
    {
    }

    @Test
    public void setSegCount()
    {
    }

    @Test
    public void setSegLength()
    {
    }

    @Test
    public void setSegModelParSolutionFlag()
    {
    }

    @Test
    public void setSegRadPresCoefFlag()
    {
    }

    @Test
    public void setSegRefTimeType()
    {
    }

    @Test
    public void setSegSize()
    {
    }

    @Test
    public void setSegStartTime()
    {
    }

    @Test
    public void setSegStopTime()
    {
    }

    @Test
    public void setSegThrustFlag()
    {
    }

    @Test
    public void setSegTimeAnchor()
    {
    }

    @Test
    public void setSegSourceId()
    {
    }

    @Test
    public void setSensorGeneratePerfStatFlag()
    {
    }

    @Test
    public void setShapeType()
    {
    }

    @Test
    public void setSolRelaxFactor()
    {
    }

    @Test
    public void setSummaryDataSource()
    {
    }

    @Test
    public void setThinObservationsFlag()
    {
    }

    @Test
    public void setTrackWeightingFlag()
    {
    }

    @Test
    public void setUpdateBestOnDivergenceFlag()
    {
    }

    @Test
    public void setUseAstat0Flag()
    {
    }

    @Test
    public void setUseAstat1Flag()
    {
    }

    @Test
    public void setUseAstat2Flag()
    {
    }

    @Test
    public void setUseAstat3Flag()
    {
    }

    @Test
    public void setUseAstat4Flag()
    {
    }

    @Test
    public void setUseAutoRejectionDataFlag()
    {
    }

    @Test
    public void setUseEveryNthObservation()
    {
    }

    @Test
    public void setUsePreviousSegValuesFlag()
    {
    }

    @Test
    public void setUseResidualRejDataFlag()
    {
    }

    @Test
    public void setUseTimeResidualsFlag()
    {
    }

    @Test
    public void setUseEphemerisObsFlag()
    {
    }

    @Test
    public void setConsiderCovarianceFlag()
    {
    }

    @Test
    public void setSourceInclusionSpan()
    {
    }

    @Test
    public void setPredictedEphemerisToUse()
    {
    }

    @Test
    public void setEphemerisWeightingControl()
    {
    }

    @Test
    public void setEphemerisDensityControl()
    {
    }

    @Test
    public void setUseGtdoaObservationsFlag()
    {
    }

    @Test
    public void setGtdoaObservationListUuid()
    {
    }

    @Test
    public void setUseTroposphericModelFlag()
    {
    }

    @Test
    public void setUseEphemerisAsReferenceFlag()
    {
    }

    @Test
    public void setReferenceEphemerisListUuid()
    {
    }

    @Test
    public void setOdFinishNotification()
    {
    }

    @Test
    public void setAbnormalUpdateFlag()
    {
    }

    @Test
    public void setCreateDate()
    {
    }

    @Test
    public void setCreateOrigin()
    {
    }

    @Test
    public void setUpdateDate()
    {
    }

    @Test
    public void setUpdateOrigin()
    {
    }

    @Test
    public void setVersion()
    {
    }
}