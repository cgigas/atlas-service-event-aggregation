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
package atlas.event.aggregation.data.datafetcher.loader;

import atlas.event.aggregation.data.model.repository.ssaevent.SsaEventRepository;
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import atlas.event.aggregation.data.model.ssaevent.SsaEventStatus;
import atlas.event.aggregation.data.model.ssaevent.SsaEventType;
import com.google.common.collect.Lists;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@Profile("dev")
public final class DataLoader
{
    private final SsaEventRepository ssaEventRepository;

    @Autowired
    private DataLoader(SsaEventRepository ssaEventRepository)
    {

        this.ssaEventRepository = ssaEventRepository;
    }

    @PostConstruct
    public void init()
    {
        BufferedReader reader = null;
        try
        {

            List<String> ssaevent = Lists.newArrayList();
            URL ssaEventUrl = Resources.getResource("data/ssa_event.csv");
            CharSource charSource = Resources.asCharSource(ssaEventUrl, StandardCharsets.UTF_8);
            reader = charSource.openBufferedStream();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                String[] lineSplit = line.split(",");
                SsaEvent event = new SsaEvent();
                int cnt = 0;
                event.setId(lineSplit[cnt++]);
                event.setClassificationMarking(lineSplit[cnt++]);
                event.setSsaPredecessorEventUuid(lineSplit[cnt++]);
                event.setEventType(SsaEventType.valueOf(lineSplit[cnt++]));
                event.setEventName(lineSplit[cnt++]);
                event.setEventStatus(SsaEventStatus.valueOf(lineSplit[cnt++]));
                event.setStartDt(OffsetDateTime.now());
                event.setEndDt(OffsetDateTime.now());
                event.setEventDesc(lineSplit[cnt++]);
                event.setBigBoardFlag((lineSplit[cnt++].equals("0") ?Boolean.TRUE :Boolean.FALSE));
                event.setInternalNotes(lineSplit[cnt++]);
                event.setEventPostingId(lineSplit[cnt++]);
                event.setUpdateDate(new Date());
                event.setUpdateOrigin(lineSplit[cnt++]);
                event.setCreateDate(new Date());
                event.setCreateOrigin(lineSplit[cnt++]);
                event.setVersion(1L);
                ssaEventRepository.save(event);
            }

            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}