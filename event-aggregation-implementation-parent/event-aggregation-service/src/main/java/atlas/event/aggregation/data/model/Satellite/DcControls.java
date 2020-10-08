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

    public String getDcControlsUuid()
    {
        return dcControlsUuid;
    }

    public void setDcControlsUuid(String dcControlsUuid)
    {
        this.dcControlsUuid = dcControlsUuid;
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

    public Application getApplication()
    {
        return application;
    }

    public void setApplication(Application application)
    {
        this.application = application;
    }

    public String getSensorEvntExcludeListUuid()
    {
        return sensorEvntExcludeListUuid;
    }

    public void setSensorEvntExcludeListUuid(String sensorEvntExcludeListUuid)
    {
        this.sensorEvntExcludeListUuid = sensorEvntExcludeListUuid;
    }

    public String getSensorDcIncludeListUuid()
    {
        return sensorDcIncludeListUuid;
    }

    public void setSensorDcIncludeListUuid(String sensorDcIncludeListUuid)
    {
        this.sensorDcIncludeListUuid = sensorDcIncludeListUuid;
    }

    public String getSensorSlrListUuid()
    {
        return sensorSlrListUuid;
    }

    public void setSensorSlrListUuid(String sensorSlrListUuid)
    {
        this.sensorSlrListUuid = sensorSlrListUuid;
    }

    public String getSensorSsnListUuid()
    {
        return sensorSsnListUuid;
    }

    public void setSensorSsnListUuid(String sensorSsnListUuid)
    {
        this.sensorSsnListUuid = sensorSsnListUuid;
    }

    public String getDcAltObsTagListUuid()
    {
        return dcAltObsTagListUuid;
    }

    public void setDcAltObsTagListUuid(String dcAltObsTagListUuid)
    {
        this.dcAltObsTagListUuid = dcAltObsTagListUuid;
    }

    public Residual getAcceptAllResiduals()
    {
        return acceptAllResiduals;
    }

    public void setAcceptAllResiduals(Residual acceptAllResiduals)
    {
        this.acceptAllResiduals = acceptAllResiduals;
    }

    public int getAcceptAllResidualsIteration()
    {
        return acceptAllResidualsIteration;
    }

    public void setAcceptAllResidualsIteration(int acceptAllResidualsIteration)
    {
        this.acceptAllResidualsIteration = acceptAllResidualsIteration;
    }

    public Boolean getAllowHyperbolicElementsFlag()
    {
        return allowHyperbolicElementsFlag;
    }

    public void setAllowHyperbolicElementsFlag(Boolean allowHyperbolicElementsFlag)
    {
        this.allowHyperbolicElementsFlag = allowHyperbolicElementsFlag;
    }

    public Boolean getApplySensorBiasesFlag()
    {
        return applySensorBiasesFlag;
    }

    public void setApplySensorBiasesFlag(Boolean applySensorBiasesFlag)
    {
        this.applySensorBiasesFlag = applySensorBiasesFlag;
    }

    public Float getAprBallCoefSegAutoCor()
    {
        return aprBallCoefSegAutoCor;
    }

    public void setAprBallCoefSegAutoCor(Float aprBallCoefSegAutoCor)
    {
        this.aprBallCoefSegAutoCor = aprBallCoefSegAutoCor;
    }

    public Float getAprBallCoefSegSigma()
    {
        return aprBallCoefSegSigma;
    }

    public void setAprBallCoefSegSigma(Float aprBallCoefSegSigma)
    {
        this.aprBallCoefSegSigma = aprBallCoefSegSigma;
    }

    public Float getAprBallCoefSigma()
    {
        return aprBallCoefSigma;
    }

    public void setAprBallCoefSigma(Float aprBallCoefSigma)
    {
        this.aprBallCoefSigma = aprBallCoefSigma;
    }

    public Float getAprBallCoefValue()
    {
        return aprBallCoefValue;
    }

    public void setAprBallCoefValue(Float aprBallCoefValue)
    {
        this.aprBallCoefValue = aprBallCoefValue;
    }

    public Float getAprBdotSigma()
    {
        return aprBdotSigma;
    }

    public void setAprBdotSigma(Float aprBdotSigma)
    {
        this.aprBdotSigma = aprBdotSigma;
    }

    public Float getAprBdotValue()
    {
        return aprBdotValue;
    }

    public void setAprBdotValue(Float aprBdotValue)
    {
        this.aprBdotValue = aprBdotValue;
    }

    public Float getAprRadPresCoefSegAutoCor()
    {
        return aprRadPresCoefSegAutoCor;
    }

    public void setAprRadPresCoefSegAutoCor(Float aprRadPresCoefSegAutoCor)
    {
        this.aprRadPresCoefSegAutoCor = aprRadPresCoefSegAutoCor;
    }

    public Float getAprRadPresCoefSegSigma()
    {
        return aprRadPresCoefSegSigma;
    }

    public void setAprRadPresCoefSegSigma(Float aprRadPresCoefSegSigma)
    {
        this.aprRadPresCoefSegSigma = aprRadPresCoefSegSigma;
    }

    public Float getAprRadPresCoefSigma()
    {
        return aprRadPresCoefSigma;
    }

    public void setAprRadPresCoefSigma(Float aprRadPresCoefSigma)
    {
        this.aprRadPresCoefSigma = aprRadPresCoefSigma;
    }

    public Float getAprRadPresCoefValue()
    {
        return aprRadPresCoefValue;
    }

    public void setAprRadPresCoefValue(Float aprRadPresCoefValue)
    {
        this.aprRadPresCoefValue = aprRadPresCoefValue;
    }

    public Float getAprThrustSegAutoCor()
    {
        return aprThrustSegAutoCor;
    }

    public void setAprThrustSegAutoCor(Float aprThrustSegAutoCor)
    {
        this.aprThrustSegAutoCor = aprThrustSegAutoCor;
    }

    public Float getAprThrustSegSigma()
    {
        return aprThrustSegSigma;
    }

    public void setAprThrustSegSigma(Float aprThrustSegSigma)
    {
        this.aprThrustSegSigma = aprThrustSegSigma;
    }

    public Float getAprThrustSigma()
    {
        return aprThrustSigma;
    }

    public void setAprThrustSigma(Float aprThrustSigma)
    {
        this.aprThrustSigma = aprThrustSigma;
    }

    public Float getAprThrustValue()
    {
        return aprThrustValue;
    }

    public void setAprThrustValue(Float aprThrustValue)
    {
        this.aprThrustValue = aprThrustValue;
    }

    public Float getConvergenceCriteria()
    {
        return convergenceCriteria;
    }

    public void setConvergenceCriteria(Float convergenceCriteria)
    {
        this.convergenceCriteria = convergenceCriteria;
    }

    public ConvergenceMode getConvergenceMode()
    {
        return convergenceMode;
    }

    public void setConvergenceMode(ConvergenceMode convergenceMode)
    {
        this.convergenceMode = convergenceMode;
    }

    public Boolean getCorAfFlag()
    {
        return corAfFlag;
    }

    public void setCorAfFlag(Boolean corAfFlag)
    {
        this.corAfFlag = corAfFlag;
    }

    public Boolean getCorAgFlag()
    {
        return corAgFlag;
    }

    public void setCorAgFlag(Boolean corAgFlag)
    {
        this.corAgFlag = corAgFlag;
    }

    public Boolean getCorBallCoefSegValFlag()
    {
        return corBallCoefSegValFlag;
    }

    public void setCorBallCoefSegValFlag(Boolean corBallCoefSegValFlag)
    {
        this.corBallCoefSegValFlag = corBallCoefSegValFlag;
    }

    public Boolean getCorBdotFlag()
    {
        return corBdotFlag;
    }

    public void setCorBdotFlag(Boolean corBdotFlag)
    {
        this.corBdotFlag = corBdotFlag;
    }

    public Boolean getCorChiFlag()
    {
        return corChiFlag;
    }

    public void setCorChiFlag(Boolean corChiFlag)
    {
        this.corChiFlag = corChiFlag;
    }

    public Boolean getCorCmOffsetFlag()
    {
        return corCmOffsetFlag;
    }

    public void setCorCmOffsetFlag(Boolean corCmOffsetFlag)
    {
        this.corCmOffsetFlag = corCmOffsetFlag;
    }

    public Boolean getCorDragFlag()
    {
        return corDragFlag;
    }

    public void setCorDragFlag(Boolean corDragFlag)
    {
        this.corDragFlag = corDragFlag;
    }

    public Boolean getCorEccentricityFlag()
    {
        return corEccentricityFlag;
    }

    public void setCorEccentricityFlag(Boolean corEccentricityFlag)
    {
        this.corEccentricityFlag = corEccentricityFlag;
    }

    public Boolean getCorLongFlag()
    {
        return corLongFlag;
    }

    public void setCorLongFlag(Boolean corLongFlag)
    {
        this.corLongFlag = corLongFlag;
    }

    public Boolean getCorLongOfPerigeeFlag()
    {
        return corLongOfPerigeeFlag;
    }

    public void setCorLongOfPerigeeFlag(Boolean corLongOfPerigeeFlag)
    {
        this.corLongOfPerigeeFlag = corLongOfPerigeeFlag;
    }

    public Boolean getCorMeanmotionFlag()
    {
        return corMeanmotionFlag;
    }

    public void setCorMeanmotionFlag(Boolean corMeanmotionFlag)
    {
        this.corMeanmotionFlag = corMeanmotionFlag;
    }

    public Boolean getCorPerigeeRadiusFlag()
    {
        return corPerigeeRadiusFlag;
    }

    public void setCorPerigeeRadiusFlag(Boolean corPerigeeRadiusFlag)
    {
        this.corPerigeeRadiusFlag = corPerigeeRadiusFlag;
    }

    public Boolean getCorPsiFlag()
    {
        return corPsiFlag;
    }

    public void setCorPsiFlag(Boolean corPsiFlag)
    {
        this.corPsiFlag = corPsiFlag;
    }

    public Boolean getCorRadPresCoefFlag()
    {
        return corRadPresCoefFlag;
    }

    public void setCorRadPresCoefFlag(Boolean corRadPresCoefFlag)
    {
        this.corRadPresCoefFlag = corRadPresCoefFlag;
    }

    public Boolean getCorRadPresCoefSegValFlag()
    {
        return corRadPresCoefSegValFlag;
    }

    public void setCorRadPresCoefSegValFlag(Boolean corRadPresCoefSegValFlag)
    {
        this.corRadPresCoefSegValFlag = corRadPresCoefSegValFlag;
    }

    public Boolean getCorThrustFlag()
    {
        return corThrustFlag;
    }

    public void setCorThrustFlag(Boolean corThrustFlag)
    {
        this.corThrustFlag = corThrustFlag;
    }

    public Boolean getCorThrustSegValuesFlag()
    {
        return corThrustSegValuesFlag;
    }

    public void setCorThrustSegValuesFlag(Boolean corThrustSegValuesFlag)
    {
        this.corThrustSegValuesFlag = corThrustSegValuesFlag;
    }

    public CorrectionSequence getCorSequence()
    {
        return corSequence;
    }

    public void setCorSequence(CorrectionSequence corSequence)
    {
        this.corSequence = corSequence;
    }

    public Float getCrossTrackPosSigma()
    {
        return crossTrackPosSigma;
    }

    public void setCrossTrackPosSigma(Float crossTrackPosSigma)
    {
        this.crossTrackPosSigma = crossTrackPosSigma;
    }

    public Float getCrossTrackVelSigma()
    {
        return crossTrackVelSigma;
    }

    public void setCrossTrackVelSigma(Float crossTrackVelSigma)
    {
        this.crossTrackVelSigma = crossTrackVelSigma;
    }

    public Boolean getDcPassWeightingFlag()
    {
        return dcPassWeightingFlag;
    }

    public void setDcPassWeightingFlag(Boolean dcPassWeightingFlag)
    {
        this.dcPassWeightingFlag = dcPassWeightingFlag;
    }

    public int getDcSummaryData()
    {
        return dcSummaryData;
    }

    public void setDcSummaryData(int dcSummaryData)
    {
        this.dcSummaryData = dcSummaryData;
    }

    public Boolean getDcaFlag()
    {
        return dcaFlag;
    }

    public void setDcaFlag(Boolean dcaFlag)
    {
        this.dcaFlag = dcaFlag;
    }

    public Float getDeltaApogeeThresholdSigma()
    {
        return deltaApogeeThresholdSigma;
    }

    public void setDeltaApogeeThresholdSigma(Float deltaApogeeThresholdSigma)
    {
        this.deltaApogeeThresholdSigma = deltaApogeeThresholdSigma;
    }

    public Float getDeltaPerigeeThresholdSigma()
    {
        return deltaPerigeeThresholdSigma;
    }

    public void setDeltaPerigeeThresholdSigma(Float deltaPerigeeThresholdSigma)
    {
        this.deltaPerigeeThresholdSigma = deltaPerigeeThresholdSigma;
    }

    public Boolean getDiscardFenceRangeFlag()
    {
        return discardFenceRangeFlag;
    }

    public void setDiscardFenceRangeFlag(Boolean discardFenceRangeFlag)
    {
        this.discardFenceRangeFlag = discardFenceRangeFlag;
    }

    public Boolean getDisplayResidualsFlag()
    {
        return displayResidualsFlag;
    }

    public void setDisplayResidualsFlag(Boolean displayResidualsFlag)
    {
        this.displayResidualsFlag = displayResidualsFlag;
    }

    public EpochUpdatePlacement getEpochUpdatePlacement()
    {
        return epochUpdatePlacement;
    }

    public void setEpochUpdatePlacement(EpochUpdatePlacement epochUpdatePlacement)
    {
        this.epochUpdatePlacement = epochUpdatePlacement;
    }

    public Float getEpochUpdateTime()
    {
        return epochUpdateTime;
    }

    public void setEpochUpdateTime(Float epochUpdateTime)
    {
        this.epochUpdateTime = epochUpdateTime;
    }

    public Float getEvntAutoSpanRefineCriteria()
    {
        return evntAutoSpanRefineCriteria;
    }

    public void setEvntAutoSpanRefineCriteria(Float evntAutoSpanRefineCriteria)
    {
        this.evntAutoSpanRefineCriteria = evntAutoSpanRefineCriteria;
    }

    public Boolean getEvntAutoSpanRefineFlag()
    {
        return evntAutoSpanRefineFlag;
    }

    public void setEvntAutoSpanRefineFlag(Boolean evntAutoSpanRefineFlag)
    {
        this.evntAutoSpanRefineFlag = evntAutoSpanRefineFlag;
    }

    public EventDetectionFlag getEvntDetectionFlag()
    {
        return evntDetectionFlag;
    }

    public void setEvntDetectionFlag(EventDetectionFlag evntDetectionFlag)
    {
        this.evntDetectionFlag = evntDetectionFlag;
    }

    public Float getEvntDetectionThresholdSigma()
    {
        return evntDetectionThresholdSigma;
    }

    public void setEvntDetectionThresholdSigma(Float evntDetectionThresholdSigma)
    {
        this.evntDetectionThresholdSigma = evntDetectionThresholdSigma;
    }

    public Float getEvntMinEgr()
    {
        return evntMinEgr;
    }

    public void setEvntMinEgr(Float evntMinEgr)
    {
        this.evntMinEgr = evntMinEgr;
    }

    public Float getEvntMinOdi()
    {
        return evntMinOdi;
    }

    public void setEvntMinOdi(Float evntMinOdi)
    {
        this.evntMinOdi = evntMinOdi;
    }

    public Float getEvntMinOdimps()
    {
        return evntMinOdimps;
    }

    public void setEvntMinOdimps(Float evntMinOdimps)
    {
        this.evntMinOdimps = evntMinOdimps;
    }

    public int getEvntMinPasses()
    {
        return evntMinPasses;
    }

    public void setEvntMinPasses(int evntMinPasses)
    {
        this.evntMinPasses = evntMinPasses;
    }

    public int getEvntMinPassesMps()
    {
        return evntMinPassesMps;
    }

    public void setEvntMinPassesMps(int evntMinPassesMps)
    {
        this.evntMinPassesMps = evntMinPassesMps;
    }

    public Boolean getFirstPassAdalineRejFlag()
    {
        return firstPassAdalineRejFlag;
    }

    public void setFirstPassAdalineRejFlag(Boolean firstPassAdalineRejFlag)
    {
        this.firstPassAdalineRejFlag = firstPassAdalineRejFlag;
    }

    public Float getFirstPassAdalineRejTol()
    {
        return firstPassAdalineRejTol;
    }

    public void setFirstPassAdalineRejTol(Float firstPassAdalineRejTol)
    {
        this.firstPassAdalineRejTol = firstPassAdalineRejTol;
    }

    public FirstPassCorrection getFirstPassCorrection()
    {
        return firstPassCorrection;
    }

    public void setFirstPassCorrection(FirstPassCorrection firstPassCorrection)
    {
        this.firstPassCorrection = firstPassCorrection;
    }

    public Boolean getFirstPassOnlyFlag()
    {
        return firstPassOnlyFlag;
    }

    public void setFirstPassOnlyFlag(Boolean firstPassOnlyFlag)
    {
        this.firstPassOnlyFlag = firstPassOnlyFlag;
    }

    public Float getFirstPassRangeRateRej()
    {
        return firstPassRangeRateRej;
    }

    public void setFirstPassRangeRateRej(Float firstPassRangeRateRej)
    {
        this.firstPassRangeRateRej = firstPassRangeRateRej;
    }

    public Float getFirstPassSpatialRej()
    {
        return firstPassSpatialRej;
    }

    public void setFirstPassSpatialRej(Float firstPassSpatialRej)
    {
        this.firstPassSpatialRej = firstPassSpatialRej;
    }

    public Boolean getImmediateEpochUpdateFlag()
    {
        return immediateEpochUpdateFlag;
    }

    public void setImmediateEpochUpdateFlag(Boolean immediateEpochUpdateFlag)
    {
        this.immediateEpochUpdateFlag = immediateEpochUpdateFlag;
    }

    public Float getInTrackPosSigma()
    {
        return inTrackPosSigma;
    }

    public void setInTrackPosSigma(Float inTrackPosSigma)
    {
        this.inTrackPosSigma = inTrackPosSigma;
    }

    public Float getInTrackVelSigma()
    {
        return inTrackVelSigma;
    }

    public void setInTrackVelSigma(Float inTrackVelSigma)
    {
        this.inTrackVelSigma = inTrackVelSigma;
    }

    public Boolean getInhibitNegBallCoefFlag()
    {
        return inhibitNegBallCoefFlag;
    }

    public void setInhibitNegBallCoefFlag(Boolean inhibitNegBallCoefFlag)
    {
        this.inhibitNegBallCoefFlag = inhibitNegBallCoefFlag;
    }

    public Boolean getInhibitNegRadCoefFlag()
    {
        return inhibitNegRadCoefFlag;
    }

    public void setInhibitNegRadCoefFlag(Boolean inhibitNegRadCoefFlag)
    {
        this.inhibitNegRadCoefFlag = inhibitNegRadCoefFlag;
    }

    public Boolean getLimitElevationFlag()
    {
        return limitElevationFlag;
    }

    public void setLimitElevationFlag(Boolean limitElevationFlag)
    {
        this.limitElevationFlag = limitElevationFlag;
    }

    public LupiAlgorithm getLupiAlgorithm()
    {
        return lupiAlgorithm;
    }

    public void setLupiAlgorithm(LupiAlgorithm lupiAlgorithm)
    {
        this.lupiAlgorithm = lupiAlgorithm;
    }

    public Float getLupiIncrease()
    {
        return lupiIncrease;
    }

    public void setLupiIncrease(Float lupiIncrease)
    {
        this.lupiIncrease = lupiIncrease;
    }

    public Float getLupiDecrease()
    {
        return lupiDecrease;
    }

    public void setLupiDecrease(Float lupiDecrease)
    {
        this.lupiDecrease = lupiDecrease;
    }

    public Float getLupiMultiplier()
    {
        return lupiMultiplier;
    }

    public void setLupiMultiplier(Float lupiMultiplier)
    {
        this.lupiMultiplier = lupiMultiplier;
    }

    public Float getManualLupi()
    {
        return manualLupi;
    }

    public void setManualLupi(Float manualLupi)
    {
        this.manualLupi = manualLupi;
    }

    public Float getMaxBallCoefCorrection()
    {
        return maxBallCoefCorrection;
    }

    public void setMaxBallCoefCorrection(Float maxBallCoefCorrection)
    {
        this.maxBallCoefCorrection = maxBallCoefCorrection;
    }

    public int getMaxIterations()
    {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations)
    {
        this.maxIterations = maxIterations;
    }

    public Float getMaxRadPresCoefCorrection()
    {
        return maxRadPresCoefCorrection;
    }

    public void setMaxRadPresCoefCorrection(Float maxRadPresCoefCorrection)
    {
        this.maxRadPresCoefCorrection = maxRadPresCoefCorrection;
    }

    public MeasuredComponents getMeasurementComponents()
    {
        return measurementComponents;
    }

    public void setMeasurementComponents(MeasuredComponents measurementComponents)
    {
        this.measurementComponents = measurementComponents;
    }

    public MeasurementWeightMode getMeasurementWeightMode()
    {
        return measurementWeightMode;
    }

    public void setMeasurementWeightMode(MeasurementWeightMode measurementWeightMode)
    {
        this.measurementWeightMode = measurementWeightMode;
    }

    public int getMinObsForDragSolution()
    {
        return minObsForDragSolution;
    }

    public void setMinObsForDragSolution(int minObsForDragSolution)
    {
        this.minObsForDragSolution = minObsForDragSolution;
    }

    public Float getMinObsSpan()
    {
        return minObsSpan;
    }

    public void setMinObsSpan(Float minObsSpan)
    {
        this.minObsSpan = minObsSpan;
    }

    public int getMinObsTotal()
    {
        return minObsTotal;
    }

    public void setMinObsTotal(int minObsTotal)
    {
        this.minObsTotal = minObsTotal;
    }

    public int getMinTracksForDragSolution()
    {
        return minTracksForDragSolution;
    }

    public void setMinTracksForDragSolution(int minTracksForDragSolution)
    {
        this.minTracksForDragSolution = minTracksForDragSolution;
    }

    public int getMinTracksTotal()
    {
        return minTracksTotal;
    }

    public void setMinTracksTotal(int minTracksTotal)
    {
        this.minTracksTotal = minTracksTotal;
    }

    public Float getMinElevation()
    {
        return minElevation;
    }

    public void setMinElevation(Float minElevation)
    {
        this.minElevation = minElevation;
    }

    public int getObsDataSource()
    {
        return obsDataSource;
    }

    public void setObsDataSource(int obsDataSource)
    {
        this.obsDataSource = obsDataSource;
    }

    public Float getObsReferenceTime()
    {
        return obsReferenceTime;
    }

    public void setObsReferenceTime(Float obsReferenceTime)
    {
        this.obsReferenceTime = obsReferenceTime;
    }

    public Boolean getObsOutputFlag()
    {
        return obsOutputFlag;
    }

    public void setObsOutputFlag(Boolean obsOutputFlag)
    {
        this.obsOutputFlag = obsOutputFlag;
    }

    public ObsSourceType getObsSourceType()
    {
        return obsSourceType;
    }

    public void setObsSourceType(ObsSourceType obsSourceType)
    {
        this.obsSourceType = obsSourceType;
    }

    public Float getObsStartTime()
    {
        return obsStartTime;
    }

    public void setObsStartTime(Float obsStartTime)
    {
        this.obsStartTime = obsStartTime;
    }

    public Float getObsStopTime()
    {
        return obsStopTime;
    }

    public void setObsStopTime(Float obsStopTime)
    {
        this.obsStopTime = obsStopTime;
    }

    public Boolean getObsUseTimeFlag()
    {
        return obsUseTimeFlag;
    }

    public void setObsUseTimeFlag(Boolean obsUseTimeFlag)
    {
        this.obsUseTimeFlag = obsUseTimeFlag;
    }

    public ObsTag getObsTag()
    {
        return obsTag;
    }

    public void setObsTag(ObsTag obsTag)
    {
        this.obsTag = obsTag;
    }

    public ObsFrom getObsFrom()
    {
        return obsFrom;
    }

    public void setObsFrom(ObsFrom obsFrom)
    {
        this.obsFrom = obsFrom;
    }

    public ObsUntil getObsUntil()
    {
        return obsUntil;
    }

    public void setObsUntil(ObsUntil obsUntil)
    {
        this.obsUntil = obsUntil;
    }

    public Boolean getPerformHalfSpanCheckFlag()
    {
        return performHalfSpanCheckFlag;
    }

    public void setPerformHalfSpanCheckFlag(Boolean performHalfSpanCheckFlag)
    {
        this.performHalfSpanCheckFlag = performHalfSpanCheckFlag;
    }

    public Boolean getPerformSparseDataCheckFlag()
    {
        return performSparseDataCheckFlag;
    }

    public void setPerformSparseDataCheckFlag(Boolean performSparseDataCheckFlag)
    {
        this.performSparseDataCheckFlag = performSparseDataCheckFlag;
    }

    public Float getRadialPosSigma()
    {
        return radialPosSigma;
    }

    public void setRadialPosSigma(Float radialPosSigma)
    {
        this.radialPosSigma = radialPosSigma;
    }

    public Float getRadialVelSigma()
    {
        return radialVelSigma;
    }

    public void setRadialVelSigma(Float radialVelSigma)
    {
        this.radialVelSigma = radialVelSigma;
    }

    public ResidualOutput getResidualOutput()
    {
        return residualOutput;
    }

    public void setResidualOutput(ResidualOutput residualOutput)
    {
        this.residualOutput = residualOutput;
    }

    public String getResidualRejectionSource()
    {
        return residualRejectionSource;
    }

    public void setResidualRejectionSource(String residualRejectionSource)
    {
        this.residualRejectionSource = residualRejectionSource;
    }

    public Float getRmsIncrease()
    {
        return rmsIncrease;
    }

    public void setRmsIncrease(Float rmsIncrease)
    {
        this.rmsIncrease = rmsIncrease;
    }

    public Float getRmsDecrease()
    {
        return rmsDecrease;
    }

    public void setRmsDecrease(Float rmsDecrease)
    {
        this.rmsDecrease = rmsDecrease;
    }

    public Float getRmsMultiplierSigma()
    {
        return rmsMultiplierSigma;
    }

    public void setRmsMultiplierSigma(Float rmsMultiplierSigma)
    {
        this.rmsMultiplierSigma = rmsMultiplierSigma;
    }

    public Boolean getSegFromSourceIdFlag()
    {
        return segFromSourceIdFlag;
    }

    public void setSegFromSourceIdFlag(Boolean segFromSourceIdFlag)
    {
        this.segFromSourceIdFlag = segFromSourceIdFlag;
    }

    public Boolean getSegManualFlag()
    {
        return segManualFlag;
    }

    public void setSegManualFlag(Boolean segManualFlag)
    {
        this.segManualFlag = segManualFlag;
    }

    public Boolean getSegBallCoefFlag()
    {
        return segBallCoefFlag;
    }

    public void setSegBallCoefFlag(Boolean segBallCoefFlag)
    {
        this.segBallCoefFlag = segBallCoefFlag;
    }

    public int getSegCount()
    {
        return segCount;
    }

    public void setSegCount(int segCount)
    {
        this.segCount = segCount;
    }

    public Float getSegLength()
    {
        return segLength;
    }

    public void setSegLength(Float segLength)
    {
        this.segLength = segLength;
    }

    public Boolean getSegModelParSolutionFlag()
    {
        return segModelParSolutionFlag;
    }

    public void setSegModelParSolutionFlag(Boolean segModelParSolutionFlag)
    {
        this.segModelParSolutionFlag = segModelParSolutionFlag;
    }

    public Boolean getSegRadPresCoefFlag()
    {
        return segRadPresCoefFlag;
    }

    public void setSegRadPresCoefFlag(Boolean segRadPresCoefFlag)
    {
        this.segRadPresCoefFlag = segRadPresCoefFlag;
    }

    public SegRefTimeType getSegRefTimeType()
    {
        return segRefTimeType;
    }

    public void setSegRefTimeType(SegRefTimeType segRefTimeType)
    {
        this.segRefTimeType = segRefTimeType;
    }

    public SegSize getSegSize()
    {
        return segSize;
    }

    public void setSegSize(SegSize segSize)
    {
        this.segSize = segSize;
    }

    public Float getSegStartTime()
    {
        return segStartTime;
    }

    public void setSegStartTime(Float segStartTime)
    {
        this.segStartTime = segStartTime;
    }

    public Float getSegStopTime()
    {
        return segStopTime;
    }

    public void setSegStopTime(Float segStopTime)
    {
        this.segStopTime = segStopTime;
    }

    public Boolean getSegThrustFlag()
    {
        return segThrustFlag;
    }

    public void setSegThrustFlag(Boolean segThrustFlag)
    {
        this.segThrustFlag = segThrustFlag;
    }

    public SegTimeAnchor getSegTimeAnchor()
    {
        return segTimeAnchor;
    }

    public void setSegTimeAnchor(SegTimeAnchor segTimeAnchor)
    {
        this.segTimeAnchor = segTimeAnchor;
    }

    public String getSegSourceId()
    {
        return segSourceId;
    }

    public void setSegSourceId(String segSourceId)
    {
        this.segSourceId = segSourceId;
    }

    public Boolean getSensorGeneratePerfStatFlag()
    {
        return sensorGeneratePerfStatFlag;
    }

    public void setSensorGeneratePerfStatFlag(Boolean sensorGeneratePerfStatFlag)
    {
        this.sensorGeneratePerfStatFlag = sensorGeneratePerfStatFlag;
    }

    public ShapeType getShapeType()
    {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType)
    {
        this.shapeType = shapeType;
    }

    public Float getSolRelaxFactor()
    {
        return solRelaxFactor;
    }

    public void setSolRelaxFactor(Float solRelaxFactor)
    {
        this.solRelaxFactor = solRelaxFactor;
    }

    public String getSummaryDataSource()
    {
        return summaryDataSource;
    }

    public void setSummaryDataSource(String summaryDataSource)
    {
        this.summaryDataSource = summaryDataSource;
    }

    public Boolean getThinObservationsFlag()
    {
        return thinObservationsFlag;
    }

    public void setThinObservationsFlag(Boolean thinObservationsFlag)
    {
        this.thinObservationsFlag = thinObservationsFlag;
    }

    public Boolean getTrackWeightingFlag()
    {
        return trackWeightingFlag;
    }

    public void setTrackWeightingFlag(Boolean trackWeightingFlag)
    {
        this.trackWeightingFlag = trackWeightingFlag;
    }

    public Boolean getUpdateBestOnDivergenceFlag()
    {
        return updateBestOnDivergenceFlag;
    }

    public void setUpdateBestOnDivergenceFlag(Boolean updateBestOnDivergenceFlag)
    {
        this.updateBestOnDivergenceFlag = updateBestOnDivergenceFlag;
    }

    public Boolean getUseAstat0Flag()
    {
        return useAstat0Flag;
    }

    public void setUseAstat0Flag(Boolean useAstat0Flag)
    {
        this.useAstat0Flag = useAstat0Flag;
    }

    public Boolean getUseAstat1Flag()
    {
        return useAstat1Flag;
    }

    public void setUseAstat1Flag(Boolean useAstat1Flag)
    {
        this.useAstat1Flag = useAstat1Flag;
    }

    public Boolean getUseAstat2Flag()
    {
        return useAstat2Flag;
    }

    public void setUseAstat2Flag(Boolean useAstat2Flag)
    {
        this.useAstat2Flag = useAstat2Flag;
    }

    public Boolean getUseAstat3Flag()
    {
        return useAstat3Flag;
    }

    public void setUseAstat3Flag(Boolean useAstat3Flag)
    {
        this.useAstat3Flag = useAstat3Flag;
    }

    public Boolean getUseAstat4Flag()
    {
        return useAstat4Flag;
    }

    public void setUseAstat4Flag(Boolean useAstat4Flag)
    {
        this.useAstat4Flag = useAstat4Flag;
    }

    public Boolean getUseAutoRejectionDataFlag()
    {
        return useAutoRejectionDataFlag;
    }

    public void setUseAutoRejectionDataFlag(Boolean useAutoRejectionDataFlag)
    {
        this.useAutoRejectionDataFlag = useAutoRejectionDataFlag;
    }

    public int getUseEveryNthObservation()
    {
        return useEveryNthObservation;
    }

    public void setUseEveryNthObservation(int useEveryNthObservation)
    {
        this.useEveryNthObservation = useEveryNthObservation;
    }

    public Boolean getUsePreviousSegValuesFlag()
    {
        return usePreviousSegValuesFlag;
    }

    public void setUsePreviousSegValuesFlag(Boolean usePreviousSegValuesFlag)
    {
        this.usePreviousSegValuesFlag = usePreviousSegValuesFlag;
    }

    public Boolean getUseResidualRejDataFlag()
    {
        return useResidualRejDataFlag;
    }

    public void setUseResidualRejDataFlag(Boolean useResidualRejDataFlag)
    {
        this.useResidualRejDataFlag = useResidualRejDataFlag;
    }

    public Boolean getUseTimeResidualsFlag()
    {
        return useTimeResidualsFlag;
    }

    public void setUseTimeResidualsFlag(Boolean useTimeResidualsFlag)
    {
        this.useTimeResidualsFlag = useTimeResidualsFlag;
    }

    public Boolean getUseEphemerisObsFlag()
    {
        return useEphemerisObsFlag;
    }

    public void setUseEphemerisObsFlag(Boolean useEphemerisObsFlag)
    {
        this.useEphemerisObsFlag = useEphemerisObsFlag;
    }

    public Boolean getConsiderCovarianceFlag()
    {
        return considerCovarianceFlag;
    }

    public void setConsiderCovarianceFlag(Boolean considerCovarianceFlag)
    {
        this.considerCovarianceFlag = considerCovarianceFlag;
    }

    public Float getSourceInclusionSpan()
    {
        return sourceInclusionSpan;
    }

    public void setSourceInclusionSpan(Float sourceInclusionSpan)
    {
        this.sourceInclusionSpan = sourceInclusionSpan;
    }

    public Float getPredictedEphemerisToUse()
    {
        return predictedEphemerisToUse;
    }

    public void setPredictedEphemerisToUse(Float predictedEphemerisToUse)
    {
        this.predictedEphemerisToUse = predictedEphemerisToUse;
    }

    public Float getEphemerisWeightingControl()
    {
        return ephemerisWeightingControl;
    }

    public void setEphemerisWeightingControl(Float ephemerisWeightingControl)
    {
        this.ephemerisWeightingControl = ephemerisWeightingControl;
    }

    public Float getEphemerisDensityControl()
    {
        return ephemerisDensityControl;
    }

    public void setEphemerisDensityControl(Float ephemerisDensityControl)
    {
        this.ephemerisDensityControl = ephemerisDensityControl;
    }

    public Boolean getUseGtdoaObservationsFlag()
    {
        return useGtdoaObservationsFlag;
    }

    public void setUseGtdoaObservationsFlag(Boolean useGtdoaObservationsFlag)
    {
        this.useGtdoaObservationsFlag = useGtdoaObservationsFlag;
    }

    public Boolean getGtdoaObservationListUuid()
    {
        return gtdoaObservationListUuid;
    }

    public void setGtdoaObservationListUuid(Boolean gtdoaObservationListUuid)
    {
        this.gtdoaObservationListUuid = gtdoaObservationListUuid;
    }

    public Boolean getUseTroposphericModelFlag()
    {
        return useTroposphericModelFlag;
    }

    public void setUseTroposphericModelFlag(Boolean useTroposphericModelFlag)
    {
        this.useTroposphericModelFlag = useTroposphericModelFlag;
    }

    public Boolean getUseEphemerisAsReferenceFlag()
    {
        return useEphemerisAsReferenceFlag;
    }

    public void setUseEphemerisAsReferenceFlag(Boolean useEphemerisAsReferenceFlag)
    {
        this.useEphemerisAsReferenceFlag = useEphemerisAsReferenceFlag;
    }

    public String getReferenceEphemerisListUuid()
    {
        return referenceEphemerisListUuid;
    }

    public void setReferenceEphemerisListUuid(String referenceEphemerisListUuid)
    {
        this.referenceEphemerisListUuid = referenceEphemerisListUuid;
    }

    public Boolean getOdFinishNotification()
    {
        return odFinishNotification;
    }

    public void setOdFinishNotification(Boolean odFinishNotification)
    {
        this.odFinishNotification = odFinishNotification;
    }

    public Boolean getAbnormalUpdateFlag()
    {
        return abnormalUpdateFlag;
    }

    public void setAbnormalUpdateFlag(Boolean abnormalUpdateFlag)
    {
        this.abnormalUpdateFlag = abnormalUpdateFlag;
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