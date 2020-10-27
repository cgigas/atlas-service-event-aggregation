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

import org.junit.Test;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TimePeriodTest
{
    OffsetDateTime startTime = OffsetDateTime.now();
    OffsetDateTime endTime = OffsetDateTime.of(2020, 11, 1, 1, 1, 1, 1, ZoneOffset.UTC);

    @Test
    public void ofStartAndEnd()
    {
        TimePeriod.ofStartAndEnd(startTime, endTime);

        try
        {
            OffsetDateTime badEnd = OffsetDateTime.of(2020, 1, 1, 1, 1, 1, 1, ZoneOffset.UTC);
            TimePeriod.ofStartAndEnd(startTime, badEnd);
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(e.toString().contains("The start time must be before the end time."));
        }

        try
        {
            TimePeriod.ofStartAndEnd(null, null);
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(e.toString().contains("Neither start nor end times may be null."));
        }
    }

    @Test
    public void withDurationOffset()
    {
        OffsetDateTime refTime = OffsetDateTime.now();
        assertNotNull(TimePeriod.withDurationOffset(refTime, Duration.ofHours(3L)));
        assertNotNull(TimePeriod.withDurationOffset(refTime, Duration.ofHours(-3L)));

        try
        {
            TimePeriod.withDurationOffset(null, null);
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(e.toString().contains("Neither start time nor the duration may be null."));
        }
    }

    @Test
    public void withPeriodOffset()
    {
        OffsetDateTime refTime = OffsetDateTime.now();
        assertNotNull(TimePeriod.withPeriodOffset(refTime, Period.ofMonths(2)));
        assertNotNull(TimePeriod.withPeriodOffset(refTime, Period.ofWeeks(-3)));
    }
}