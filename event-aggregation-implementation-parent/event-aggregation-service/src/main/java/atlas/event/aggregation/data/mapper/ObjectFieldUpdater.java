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
package atlas.event.aggregation.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * A general class that uses reflection to apply update values, held in a map to the provided object
 */
@Slf4j
@Component
public class ObjectFieldUpdater
{
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Object updateFields(Object target,  Map<String, Object> fieldMap)
    {
        Preconditions.checkNotNull(target, "The object to update may not be null.");
        Preconditions.checkNotNull(fieldMap, "The map of field values may not be null.");
        if (!fieldMap.isEmpty())
        {
            try
            {
                if (fieldMap.get("id") != null)
                {
                    fieldMap.remove("id"); // We don't want to update any primary id fields, most aren't named 'id' either.
                }
                String mapAsJson = objectMapper.writeValueAsString(fieldMap);

                ObjectReader objectReader = objectMapper.readerForUpdating(target);
                target = objectReader.readValue(mapAsJson);
            }
            catch (IOException e)
            {
                throw new IllegalStateException("Error updating an Object with new field values." + e.getMessage(), e);
            }
        }

        return target;
    }
}
