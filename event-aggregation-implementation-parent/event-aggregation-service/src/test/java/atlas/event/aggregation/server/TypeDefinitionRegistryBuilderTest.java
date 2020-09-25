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
package atlas.event.aggregation.server;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ResourceLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TypeDefinitionRegistryBuilderTest
{
    TypeDefinitionRegistryBuilder task = new TypeDefinitionRegistryBuilder();
    String rootResourcePath = "event-aggregation-implementation-parent/event-aggregation-service/src/main/resources/graphql/MPEService.graphql";

    @Test
    void buildRegistryFrom()throws IOException
    {
        try
        {
            task.buildRegistryFrom(rootResourcePath);
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("cannot be resolved to URL because it does not exist"));
        }
    }
}