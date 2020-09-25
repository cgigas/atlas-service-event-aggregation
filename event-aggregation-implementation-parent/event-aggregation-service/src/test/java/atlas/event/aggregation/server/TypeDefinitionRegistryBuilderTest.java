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