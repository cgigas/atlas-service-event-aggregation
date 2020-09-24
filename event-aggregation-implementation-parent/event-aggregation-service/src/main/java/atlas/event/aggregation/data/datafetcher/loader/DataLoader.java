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

import atlas.event.aggregation.base.DigitalBase;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Profile("dev")
public final class DataLoader extends DigitalBase
{

    @PostConstruct
    public void init()
    {
        String externalServiceurlFile = "configuration/ExternalServiceUrl.csv";
        BufferedReader reader = null;
        try
        {

            List<String> externalUrlCacheList = new ArrayList<>();
            URL externalServiceCacheFileUrl = Resources.getResource(externalServiceurlFile);
            CharSource charSource = Resources.asCharSource(externalServiceCacheFileUrl, StandardCharsets.UTF_8);
            reader = charSource.openBufferedStream();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                externalUrlCacheList.add(line);
            }
            if (externalUrlCacheList != null)
            {
                for (String item: externalUrlCacheList)
                {
                    String[] items = item.split(",");
                    String key = items[0];
                    String value = items[1];
                    getDigitalCache().addExternalServiceUrl(key, value);
                }
            }
            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}