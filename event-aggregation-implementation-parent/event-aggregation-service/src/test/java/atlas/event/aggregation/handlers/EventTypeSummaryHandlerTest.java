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
package atlas.event.aggregation.handlers;

import graphql.schema.DataFetchingEnvironment;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class EventTypeSummaryHandlerTest
{
    EventTypeSummaryHandler task = new EventTypeSummaryHandler();
    @Mock
    DataFetchingEnvironment environment = mock(DataFetchingEnvironment.class);

    @Test(expected = NullPointerException.class)
    public void processRequest()
    {
        task.processRequest(environment);
    }
}