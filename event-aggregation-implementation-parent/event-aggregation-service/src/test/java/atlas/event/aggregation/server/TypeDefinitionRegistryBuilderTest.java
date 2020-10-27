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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TypeDefinitionRegistryBuilderTest
{
    @Autowired
    ResourceLoader resourceLoader;

    TypeDefinitionRegistryBuilder task = new TypeDefinitionRegistryBuilder(resourceLoader);
    String rootResourcePath = "classpath:graphql";
    List<File> fileList = new ArrayList<>();

    @Test
    public void buildRegistry() throws IOException
    {
        try
        {
            task.buildRegistryFrom(rootResourcePath);
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("SchemaProblem"));
        }
    }

    @Test
    public void buildRegistryFrom() throws IOException
    {
        try
        {
            task.buildRegistryFrom("graphql", rootResourcePath);
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("NullPointerException"));
        }
    }

    @Test
    public void buildRegistryFromList() throws IOException
    {
        fileList.add(new File("src/main/resources/graphql/eventFolder.graphql"));
        try
        {
            task.buildRegistryFrom(fileList);
        }
        catch (Exception e)
        {
            assertTrue(e.toString().contains("SchemaProblem"));
        }
    }
}