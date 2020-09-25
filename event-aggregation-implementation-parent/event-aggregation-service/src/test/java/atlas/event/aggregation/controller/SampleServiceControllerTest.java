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
package atlas.event.aggregation.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertNotNull;

public class SampleServiceControllerTest
{
    SampleServiceController task = new SampleServiceController();
    long startTime = 2L;
    long endTime = 3L;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    HttpSession session = new MockHttpSession();
    String eventId = "event";
    String satelliteUuid = "satUuid";
    String id = "id";
    String eventStatus = "complete";
    String endDate = "2020-09-10T10:16:42.846-06:00";
    String ssaEventId = "ssaEventId";
    String eventType = "eventType";

    @Test
    public void test()
    {
        task.processEventTypeSummaries(startTime,endTime,request,response,session);
        task.processGetEventTypes(request,response,session);
        task.processPromoteEventSatellite(eventId,satelliteUuid,request,response,session);
        task.processAddSatelliteToEvent(eventId,satelliteUuid,request,response,session);
        task.processReleaseSatelliteFromEvent(eventId,satelliteUuid,request,response,session);
        task.processUpdateEventStatus(id,eventStatus,request,response,session);
        task.processDeleteSdaEvent(id,request,response,session);
        task.processCreateEvent(id,request,response);
        task.processEventById(id,request,response);
        task.processCloseSdaEvent(id,endDate,request,response,session);
        task.processEventDetail(ssaEventId,request,response,session);
        task.processEventByTimePeriod(eventType, startTime,endTime,request,response);
        assertNotNull(task);
    }
}