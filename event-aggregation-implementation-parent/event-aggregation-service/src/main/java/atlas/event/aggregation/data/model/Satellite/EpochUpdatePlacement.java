package atlas.event.aggregation.data.model.Satellite;

public enum EpochUpdatePlacement
{
    DoNotMoveEpoch,
    MoveEpochToTimeOfFirstObservation,
    MoveEpochToTimeOfLastObservation,
    MoveEpochToSpecifiedDCSpanStartTime,
    MoveEpochToSpecifiedDCSpanEndTime,
    MoveEpochToMeanObservationTime,
    MoveEpochToSpecifiedTimeTime
}
