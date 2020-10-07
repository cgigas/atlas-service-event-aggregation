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

import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

@Slf4j
@Component
public class TypeDefinitionRegistryBuilder
{
    @Autowired
    ResourceLoader resourceLoader;

    /**
     * Factory method to create a GraphQLSchema from the files in a named resource path.
     * The path is assumed to be on the classpath for the current class loader.
     * The path will be recursively traversed.
     * The files in the named folder are assumed to be graphql schema definition files.
     *
     * @param rootResourcePath the path to get files from
     * @return a merged schema object.
     * @throws IOException if files can't be read.
     */
    public TypeDefinitionRegistry buildRegistryFrom(String rootResourcePath) throws IOException
    {
        File dir = new File(rootResourcePath);
        File[] files = dir.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".graphql");
            }
        });

        try
        {
            // Resource[] graphqlResources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(rootResourcePath);
            SchemaParser parser = new SchemaParser();
            TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

            for (File graphqlFile : files)
            {
                URL graphqlURL = graphqlFile.toURL();
                //String schemaString = Resources.toString(resource.getURL(), UTF_8);
                String schemaString = graphqlURL.toString();
                typeRegistry.merge(parser.parse(schemaString));
            }
            return typeRegistry;
        }
        catch (Throwable e)
        {
            throw new IllegalStateException(e);
        }
    }
}