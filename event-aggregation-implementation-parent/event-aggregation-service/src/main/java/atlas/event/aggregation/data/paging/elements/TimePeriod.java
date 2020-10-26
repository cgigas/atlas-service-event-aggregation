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
package atlas.event.aggregation.data.paging.elements;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.temporal.TemporalAmount;

@Data
@Setter(AccessLevel.NONE)
public final class TimePeriod
{
    @NonNull
    private final OffsetDateTime startTime;
    @NonNull
    private final OffsetDateTime endTime;

    private TimePeriod(OffsetDateTime start, OffsetDateTime end)
    {
        this.startTime = start;
        this.endTime = end;
    }

    //Only allow creation through static factory methods
    public static TimePeriod ofStartAndEnd(OffsetDateTime start, OffsetDateTime end)
    {
        if (start != null && end != null)
        {
            if (Duration.between(start, end).isNegative())
            {
                throw new IllegalArgumentException("The start time must be before the end time.");
            }
            return new TimePeriod(start, end);
        }
        else
        {
            throw new IllegalArgumentException("Neither start nor end times may be null.");
        }
    }

    public static TimePeriod withDurationOffset(OffsetDateTime refTime, Duration duration)
    {
        return getRelativeTimePeriod(refTime, duration);
    }

    public static TimePeriod withPeriodOffset(OffsetDateTime refTime, Period period)
    {
        return getRelativeTimePeriod(refTime, period);
    }

    private static TimePeriod getRelativeTimePeriod(OffsetDateTime refTime, TemporalAmount duration)
    {
        if (refTime != null && duration != null)
        {
            if (duration instanceof Duration)
            {
                Duration d = (Duration) duration;
                if (d.isNegative())
                {
                    // add negative time
                    return new TimePeriod(refTime.plus(d), refTime);
                }
                else
                {
                    return new TimePeriod(refTime, refTime.plus(d));
                }
            }
            else if (duration instanceof Period)
            {
                Period p = (Period) duration;
                if (p.isNegative())
                {
                    return new TimePeriod(refTime.plus(p), refTime);
                }
                else
                {
                    return new TimePeriod(refTime, refTime.plus(p));
                }
            }
            return null; // We have an unexpected TemporalAmount type
        }
        else
        {
            throw new IllegalArgumentException("Neither start time nor the duration may be null.");
        }
    }

/*    public double getStartTimeDays70()
    {
        return TimeFormat.toDays70(this.startTime);
    }

    public double getEndTimeDays70()
    {
        return TimeFormat.toDays70(this.endTime);
    }

 */
}
