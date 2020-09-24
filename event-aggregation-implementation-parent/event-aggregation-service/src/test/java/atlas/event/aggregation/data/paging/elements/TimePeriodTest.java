package atlas.event.aggregation.data.paging.elements;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TimePeriodTest
{
    @Test
    void ofStartAndEnd()
    {
        OffsetDateTime start = OffsetDateTime.now();
        OffsetDateTime end = OffsetDateTime.of(2020, 11, 1, 1, 1, 1, 1, ZoneOffset.UTC);
        TimePeriod.ofStartAndEnd(start, end);

        try
        {
            OffsetDateTime badEnd = OffsetDateTime.of(2020, 1, 1, 1, 1, 1, 1, ZoneOffset.UTC);
            TimePeriod.ofStartAndEnd(start, badEnd);
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
    void withDurationOffset()
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
    void withPeriodOffset()
    {
        OffsetDateTime refTime = OffsetDateTime.now();
        assertNotNull(TimePeriod.withPeriodOffset(refTime, Period.ofMonths(2)));
        assertNotNull(TimePeriod.withPeriodOffset(refTime, Period.ofWeeks(-3)));
    }
}