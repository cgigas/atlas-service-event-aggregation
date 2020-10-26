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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * @param rootResourcePath the path to get files from with assumption file extension is 'graphql' by default
     * @return a merged schema object.
     * @throws IOException if files can't be read.
     */
    public TypeDefinitionRegistry buildRegistryFrom(String rootResourcePath) throws IOException
    {
        String resourceExtension = "graphql";
        return buildRegistryFrom(resourceExtension, rootResourcePath);
    }

    public TypeDefinitionRegistry buildRegistryFrom(String resourceExtension, String...rootResourcePath) throws IOException
    {
        TypeDefinitionRegistry typeRegistry = null;
        List<File> fileList = null;
        if ((StringUtils.isNotBlank(resourceExtension)) && (rootResourcePath != null))
        {
            for (String rootDirectory: rootResourcePath)
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
     * @param fileList The list of all the files in the directory and subdirectories.
     * @return a merged schema object.
     */
    public TypeDefinitionRegistry buildRegistryFrom(List<File> fileList)
    {
        SchemaParser parser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();

        for (File fileItem: fileList)
        {
            typeRegistry.merge(parser.parse(fileItem));
        }
        return typeRegistry;
    }

    private List<File> getFilesInDirectory(File directory, String fileExtension)
    {
        List<File> fileList = new ArrayList<>();
        if ((directory != null))
        {
            File[] listOfFiles = directory.listFiles((dir, name) ->
            {
                if (dir.isDirectory())
                {
                    return true;
                }
                else
                {
                    return name.toLowerCase().endsWith(fileExtension);
                }
            });

            if (listOfFiles != null)
            {
                for (File fileItem: listOfFiles)
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
