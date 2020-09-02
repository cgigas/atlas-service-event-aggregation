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

    @RequestMapping({"/eventDetail/{ssaEventId}"})
    public void processEventDetail(@PathVariable String ssaEventId, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n");
        buffer.append("    \"eventDetail\": [\n");
        buffer.append("      {\n");
        buffer.append("        \"ssaEventUuid\": \"715f5b89-88a8-4ea0-95f3-3020bcbdceb5\",\n");
        buffer.append("        \"classificationMarking\": \"marking-4981\",\n");
        buffer.append("        \"ssaPredecessorEventUuid\": \"0b29c86d-aed3-4cfb-9b75-464c385e2eef\",\n");
        buffer.append("        \"eventType\": \"MANEUVER\",\n");
        buffer.append("        \"eventName\": \"EventName-4981\",\n");
        buffer.append("        \"eventStatus\": \"CONFIRMED\",\n");
        buffer.append("        \"startDt\": \"2020-08-25T13:02:39.201-06:00\",\n");
        buffer.append("        \"endDt\": \"2020-08-25T13:02:39.201-06:00\",\n");
        buffer.append("        \"eventDesc\": \"2015-08-14 10:11:35\",\n");
        buffer.append("        \"bigBoardFlag\": true,\n");
        buffer.append("        \"internalNotes\": \"2015-08-14 10:11:35\",\n");
        buffer.append("        \"eventPostingId\": \"event description-4981\"\n");
        buffer.append("      }\n");
        buffer.append("    ]\n");
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
        buffer.append("                \"type\": \"Multi-payload\",\n");
        buffer.append("                \"name\": \"an event\",\n");
        buffer.append("                \"startDt\": \"2020 159 23:59:59\"\n");
        buffer.append("                \"endDt\": \"2020 160 01:23:23\"\n");
        buffer.append("                \"typename\": \"Event\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-123456789001\",\n");
        buffer.append("                \"state\": \"Active\",\n");
        buffer.append("                \"classification\": \"U\",\n");
        buffer.append("                \"type\": \"Multi-payload\",\n");
        buffer.append("                \"name\": \"some other event\",\n");
        buffer.append("                \"startDt\": \"2020 159 23:59:59\"\n");
        buffer.append("                \"endDt\": \"2020 160 01:23:23\"\n");
        buffer.append("                \"typename\": \"Event\"\n");
        buffer.append("            },\n");
        buffer.append("            {\n");
        buffer.append("                \"id\": \"293558d4-938a-4c58-8ca1-123456789002\",\n");
        buffer.append("                \"state\": \"Closed\",\n");
        buffer.append("                \"classification\": \"U\",\n");
        buffer.append("                \"type\": \"Multi-payload\",\n");
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
