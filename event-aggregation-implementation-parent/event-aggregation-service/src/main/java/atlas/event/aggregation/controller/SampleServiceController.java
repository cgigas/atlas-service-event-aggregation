/*
 *  ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */
package atlas.event.aggregation.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;

@Controller
public class SampleServiceController
{

    @RequestMapping("/eventTypeSummariesByTimePeriod/{startTime}/{endTime}")
    public void processEventTypeSummaries(@PathVariable long startTime, @PathVariable long endTime, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("        \"eventTypeSummariesByTimePeriod\": [\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97e6\",\n");
        buffer.append("                \"type\": \"Launch\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97e7\",\n");
        buffer.append("                \"type\": \"Multipayload\",\n");
        buffer.append("                \"planned\": 24,\n");
        buffer.append("                \"active\": 1\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97e8\",\n");
        buffer.append("                \"type\": \"Docking\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97e9\",\n");
        buffer.append("                \"type\": \"Separation\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97ea\",\n");
        buffer.append("                \"type\": \"Breakup\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97eb\",\n");
        buffer.append("                \"type\": \"Reentry\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97ec\",\n");
        buffer.append("                \"type\": \"Maneuver\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97ed\",\n");
        buffer.append("                \"type\": \"Conjunction\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-806162ac97e7\",\n");
        buffer.append("                \"type\": \"ASAT\",\n");
        buffer.append("                \"planned\": 72,\n");
        buffer.append("                \"active\": 3,\n");
        buffer.append("                \"typename\": \"EventTypeSummary\"\n");
        buffer.append("            }\n");
        buffer.append("        ]\n");
        buffer.append(" }\n");
        sendResponse(response, "application/json", buffer.toString().getBytes());
    }

    @RequestMapping("/getEventTypes")
    public void processGetEventTypes(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("\"eventTypes\": [\n");
        buffer.append("\"Breakup\",");
        buffer.append("\"Conjunction\",");
        buffer.append("\"Deorbit\",");
        buffer.append("\"Dock\",");
        buffer.append("\"EMI\",");
        buffer.append("\"Launch\",");
        buffer.append("\"Maneuver\",");
        buffer.append("\"Nudet\",");
        buffer.append("\"Other\",");
        buffer.append("\"Proximity\",");
        buffer.append("\"ReEntry\",");
        buffer.append("\"Rendezvous\",");
        buffer.append("\"Separation\",");
        buffer.append("\"Undock\",");
        buffer.append("]\n");
        buffer.append("}\n");
        sendResponse(response, "application/json", buffer.toString().getBytes());
    }

    @RequestMapping({"/eventById/{id}/{endDate}"})
    public void processEventById(@PathVariable String id, @PathVariable String endDate, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("\"event\": {\n");
        buffer.append("\"eventUuid\": \"4665664666a66166464662616\",\n");
        buffer.append("\"classification\": \"classification\",\n");
        buffer.append("\"predecessorEventUuid\": \"12323523521123415u233412\",\n");
        buffer.append("\"type\": 12,\n");
        buffer.append("\"eventName\": \"eventName\",\n");
        buffer.append("\"status\": 13,\n");
        buffer.append("\"startDate\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"endDate\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"description\": \"event description\",\n");
        buffer.append("\"internalNotes\": \"event internal notes\",\n");
        buffer.append("\"postingId\": \"event Posting Id\"\n");
        buffer.append("}\n");
        buffer.append("}\n");
        sendResponse(response, "application/json", buffer.toString().getBytes());
    }


    @RequestMapping({"/closeSdaEvent/{id}/{endDate}"})
    public void processCloseSdaEvent(@PathVariable String id, @PathVariable String endDate, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("\"event\": {\n");
        buffer.append("\"eventUuid\": \"4665664666a66166464662616\",\n");
        buffer.append("\"classification\": \"classification\",\n");
        buffer.append("\"predecessorEventUuid\": \"12323523521123415u233412\",\n");
        buffer.append("\"type\": 12,\n");
        buffer.append("\"eventName\": \"eventName\",\n");
        buffer.append("\"status\": 13,\n");
        buffer.append("\"startDate\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"endDate\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"description\": \"event description\",\n");
        buffer.append("\"internalNotes\": \"event internal notes\",\n");
        buffer.append("\"postingId\": \"event Posting Id\"\n");
        buffer.append("}\n");
        buffer.append("}\n");
        sendResponse(response, "application/json", buffer.toString().getBytes());
    }

    @RequestMapping({"/eventDetail/{ssaEventId}"})
    public void processEventDetail(@PathVariable String ssaEventId, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("\"eventDetail\": {\n");
        buffer.append("\"id\": \"293558d4-938a-4c58-8ca1-123456789000\",\n");
        buffer.append("\"state\": \"Planned\",\n");
        buffer.append("\"classification\": \"U\",\n");
        buffer.append("\"type\": 4,\n");
        buffer.append("\"name\": \"an event\",\n");
        buffer.append("\"startDt\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"endDt\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"catalogObjectCount\": 12,\n");
        buffer.append("\"analystObjects\": 20,\n");
        buffer.append("\"candidateObjectCount\": 28,\n");
        buffer.append("\"promotableObjectCount\": 23,\n");
        buffer.append("\"parentEvent\": {\n");
        buffer.append("\"eventUuid\": \"293558d4-938a-4c58-8ca1-123456789001\",\n");
        buffer.append("\"eventName\": \"the parent event\",\n");
        buffer.append("\"typeName\": \"Event\"\n");
        buffer.append("},\n");
        buffer.append("\"launch\": {\n");
        buffer.append("\"id\": \"293558d4-938a-4c58-8ca1-123456789002\",\n");
        buffer.append("\"launchTimestamp\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"launchSite\": \"SpaceX-MT\",\n");
        buffer.append("\"launchCountry\": \"US\",\n");
        buffer.append("\"typeName\": \"Launch\"\n");
        buffer.append("},\n");
        buffer.append("\"observationSatMedleyArray\": [{\n");
        buffer.append("\"id\": \"293558d4-938a-4c58-8ca1-123456789003\",\n");
        buffer.append("\"satelliteId\": \"293558d4-938a-4c58-8ca1-123456789004\",\n");
        buffer.append("\"observationId\": \"293558d4-938a-4c58-8ca1-123456789005\",\n");
        buffer.append("\"classification\": \"U\",\n");
        buffer.append("\"isPromotable\": 0,\n");
        buffer.append("\"isCataloged\": 0,\n");
        buffer.append("\"isAnalyst\": 1,\n");
        buffer.append("\"isCandidate\": 1,\n");
        buffer.append("\"satno\": 25544,\n");
        buffer.append("\"ucn\": 123456,\n");
        buffer.append("\"commonName\": \"ISS (ZARYA)\",\n");
        buffer.append("\"group\": \"Group\",\n");
        buffer.append("\"type\": 5,\n");
        buffer.append("\"radarCrossSection\": 2.12345,\n");
        buffer.append("\"epoch\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"result\": \"P/Reason\",\n");
        buffer.append("\"period\": 123.45,\n");
        buffer.append("\"inclination\": 45.45,\n");
        buffer.append("\"apogee\": 1234,\n");
        buffer.append("\"perigee\": 2345,\n");
        buffer.append("\"eccentricity\": 4.12345,\n");
        buffer.append("\"typeName\": \"ObservationSatMedley\"\n");
        buffer.append("},\n");
        buffer.append("{\n");
        buffer.append("\"id\": \"293558d4-938a-4c58-8ca1-123456789006\",\n");
        buffer.append("\"satelliteId\": \"293558d4-938a-4c58-8ca1-123456789007\",\n");
        buffer.append("\"observationId\": \"293558d4-938a-4c58-8ca1-123456789008\",\n");
        buffer.append("\"classification\": \"U\",\n");
        buffer.append("\"isPromotable\": 1,\n");
        buffer.append("\"isCataloged\": 1,\n");
        buffer.append("\"isAnalyst\": 0,\n");
        buffer.append("\"isCandidate\": 0,\n");
        buffer.append("\"satno\": 12345,\n");
        buffer.append("\"ucn\": 234567,\n");
        buffer.append("\"commonName\": \"Yellow satellite\",\n");
        buffer.append("\"group\": \"Group\",\n");
        buffer.append("\"type\": 5,\n");
        buffer.append("\"radarCrossSection\": 2.22345,\n");
        buffer.append("\"epoch\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"result\": \"P/Reason\",\n");
        buffer.append("\"period\": 234.56,\n");
        buffer.append("\"inclination\": 55.45,\n");
        buffer.append("\"apogee\": 2345,\n");
        buffer.append("\"perigee\": 3456,\n");
        buffer.append("\"eccentricity\": 2.12345,\n");
        buffer.append("\"typeName\": \"ObservationSatMedley\"\n");
        buffer.append("},\n");
        buffer.append("{\n");
        buffer.append("\"id\": \"293558d4-938a-4c58-8ca1-123456789009\",\n");
        buffer.append("\"satelliteId\": \"293558d4-938a-4c58-8ca1-123456789010\",\n");
        buffer.append("\"observationId\": \"293558d4-938a-4c58-8ca1-123456789011\",\n");
        buffer.append("\"classification\": \"U\",\n");
        buffer.append("\"isPromotable\": 0,\n");
        buffer.append("\"isCataloged\": 1,\n");
        buffer.append("\"isAnalyst\": 1,\n");
        buffer.append("\"isCandidate\": 0,\n");
        buffer.append("\"satno\": 23456,\n");
        buffer.append("\"ucn\": 345678,\n");
        buffer.append("\"commonName\": \"Green satellite\",\n");
        buffer.append("\"group\": \"Group\",\n");
        buffer.append("\"type\": 5,\n");
        buffer.append("\"radarCrossSection\": 3.12345,\n");
        buffer.append("\"epoch\": \"2020-09-10T10:16:42.846-06:00\",\n");
        buffer.append("\"result\": \"P/Reason\",\n");
        buffer.append("\"period\": 345.67,\n");
        buffer.append("\"inclination\": 65.45,\n");
        buffer.append("\"apogee\": 3456,\n");
        buffer.append("\"perigee\": 4567,\n");
        buffer.append("\"eccentricity\": 3.12345,\n");
        buffer.append("\"typeName\": \"ObservationSatMedley\"\n");
        buffer.append("}\n");
        buffer.append("],\n");
        buffer.append("\"typeName\": \"SsaEventDetail\"\n");
        buffer.append("}\n");
        buffer.append("}\n");
        sendResponse(response, "application/json", buffer.toString().getBytes());
    }

    @RequestMapping({"/eventsByTimePeriodAndType/{eventType}/{startDate}/{endDate}"})
    public void processEventByTimePeriod(@PathVariable String eventType, Long startDate, Long endDate, HttpServletRequest request, HttpServletResponse response)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("        \"eventsByTimePeriodAndType\": [\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-123456789000\",\n");
        buffer.append("                \"state\": \"Planned\",\n");
        buffer.append("                \"classification\": \"U\",\n");
        buffer.append("                \"type\": 5,\n");
        buffer.append("                \"name\": \"an event\",\n");
        buffer.append("                \"startDt\": \"2020 159 23:59:59\"\n");
        buffer.append("                \"endDt\": \"2020 160 01:23:23\"\n");
        buffer.append("                \"typename\": \"Event\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-123456789001\",\n");
        buffer.append("                \"state\": \"Active\",\n");
        buffer.append("                \"classification\": \"U\",\n");
        buffer.append("                \"type\": 5,\n");
        buffer.append("                \"name\": \"some other event\",\n");
        buffer.append("                \"startDt\": \"2020 159 23:59:59\"\n");
        buffer.append("                \"endDt\": \"2020 160 01:23:23\"\n");
        buffer.append("                \"typename\": \"Event\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-123456789002\",\n");
        buffer.append("                \"state\": \"Closed\",\n");
        buffer.append("                \"classification\": \"U\",\n");
        buffer.append("                \"type\": 5,\n");
        buffer.append("                \"name\": \"yet another event\",\n");
        buffer.append("                \"startDt\": \"2020 159 23:59:59\"\n");
        buffer.append("                \"endDt\": \"2020 160 01:23:23\"\n");
        buffer.append("                \"typename\": \"Event\"\n");
        buffer.append("            }\n");
        buffer.append("        ]\n");
        buffer.append(" }\n");

        sendResponse(response, "application/json", buffer.toString().getBytes());
    }


    private void sendResponse(HttpServletResponse response, String mimeType, byte[] messageBody)
    {
        OutputStream out = null;
        try
        {
            response.setContentType(mimeType);
            out = response.getOutputStream();
            out.write(messageBody);
            out.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(out);
        }
    }
}
