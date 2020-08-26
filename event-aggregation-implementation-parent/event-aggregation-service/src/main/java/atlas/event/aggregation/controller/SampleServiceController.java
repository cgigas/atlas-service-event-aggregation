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
        sendResponse(response, "text/html", buffer.toString().getBytes());

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
