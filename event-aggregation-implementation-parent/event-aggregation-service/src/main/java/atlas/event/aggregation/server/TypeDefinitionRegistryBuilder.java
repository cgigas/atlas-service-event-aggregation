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

import com.google.common.io.Resources;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

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
     * @param rootResourcePath the path to get files from
     * @return a merged schema object.
     * @throws IOException if files can't be read.
     */
    public TypeDefinitionRegistry buildRegistryFrom(String rootResourcePath) throws IOException
    {
        try
        {
            Collection files = FileUtils.listFiles(new File(rootResourcePath), new RegexFileFilter(".graphql"), DirectoryFileFilter.DIRECTORY);

            Resource[] graphqlResources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(String.valueOf(files));
            SchemaParser parser = new SchemaParser();
            TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

            for (Resource resource: graphqlResources)
            {
                String schemaString = Resources.toString(resource.getURL(), UTF_8);
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