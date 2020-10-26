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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@Component
public class TypeDefinitionRegistryBuilder
{
    private final ResourceLoader resourceLoader;
    Logger log = LoggerFactory.getLogger(TypeDefinitionRegistryBuilder.class);

    public TypeDefinitionRegistryBuilder(ResourceLoader resourceLoader)
    {
        this.resourceLoader = resourceLoader;
    }

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
        log.info("TypeDefinitionRegistry.buildRegistryFrom(String)");
        try
        {
            log.info("Collecting graphql schema definition resources...");
            Resource[] graphqlResources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(rootResourcePath);
            SchemaParser parser = new SchemaParser();
            TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

            log.info("Creating graphql type registry from schema definition files.");
            for (Resource resource : graphqlResources)
            {
                String schemaString = Resources.toString(resource.getURL(), UTF_8);
                typeRegistry.merge(parser.parse(schemaString));
            }
            return typeRegistry;
        }
        catch (Throwable e)
        {
            log.error("Error configuring the Satellite Query GraphQL type registry", e);
            throw new IllegalStateException(e);
        }
    }


    /**
     * Factory method to create a GraphQLSchema from the files in a named resource path.
     * The path is assumed to be on the classpath for the current class loader.
     * The path will be recursively traversed.
     * The files in the named folder are assumed to be graphql schema definition files.
     *
     * @param rootResourcePath the path to get files from with assumption file extension is 'graphql' by default
     * @return a merged schema object.
     * @throws IOException if files can't be read.
     *                     public TypeDefinitionRegistry buildRegistryFrom(String rootResourcePath) throws IOException
     *                     {
     *                     log.info("TypeDefinitionRegistry.buildRegistryFrom(String)");
     *                     TypeDefinitionRegistry typeRegistry = null;
     *                     String resourceExtension = "graphql";
     *                     typeRegistry = buildRegistryFrom(resourceExtension, rootResourcePath);
     *                     return typeRegistry;
     *                     }
     */
    public TypeDefinitionRegistry buildRegistryFrom(String resourceExtension, String... rootResourcePath) throws IOException
    {
        TypeDefinitionRegistry typeRegistry = null;
        List<File> fileList = null;
        if ((StringUtils.isNotBlank(resourceExtension)) && (rootResourcePath != null))
        {
            for (String rootDirectory : rootResourcePath)
            {
                if (fileList == null)
                {
                    fileList = new ArrayList<>();
                }
                Resource graphqlResource = resourceLoader.getResource(rootDirectory);
                File rootDirectoryFile = graphqlResource.getFile();
                fileList.addAll(getFilesInDirectory(rootDirectoryFile, resourceExtension));
            }

            if (fileList != null)
            {
                typeRegistry = buildRegistryFrom(fileList);
            }
        }
        return typeRegistry;
    }

    /**
     * Factory method to create a GraphQLSchema from the files in a named resource path.
     * The path is assumed to be on the classpath for the current class loader.
     * The path will be recursively traversed.
     * The files in the named folder are assumed to be graphql schema definition files.
     *
     * @param fileList The list of all the files in the directory and subdirectories.
     * @return a merged schema object.
     * @throws IOException if files can't be read.
     */
    public TypeDefinitionRegistry buildRegistryFrom(List<File> fileList) throws IOException
    {
        try
        {
            SchemaParser parser = new SchemaParser();
            TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

            for (File fileItem : fileList)
            {
                typeRegistry.merge(parser.parse(fileItem));
            }
            return typeRegistry;
        }
        catch (Throwable e)
        {
            throw new IllegalStateException(e);
        }
    }

    private List<File> getFilesInDirectory(File directory, String fileExtension)
    {
        List<File> fileList = null;
        if ((directory != null))
        {
            File[] listOfFiles = directory.listFiles(new FilenameFilter()
            {
                @Override
                public boolean accept(File dir, String name)
                {
                    if (dir.isDirectory())
                    {
                        return true;
                    }
                    else
                    {
                        return name.toLowerCase().endsWith(fileExtension);
                    }
                }
            });

            if (listOfFiles != null)
            {
                if (fileList == null)
                {
                    fileList = new ArrayList<>();
                }
                for (File fileItem : listOfFiles)
                {
                    if (fileItem.isDirectory())
                    {
                        fileList.addAll(getFilesInDirectory(fileItem, fileExtension));
                    }
                    else
                    {
                        fileList.add(fileItem);
                    }
                }
            }
        }
        return fileList;
    }
}