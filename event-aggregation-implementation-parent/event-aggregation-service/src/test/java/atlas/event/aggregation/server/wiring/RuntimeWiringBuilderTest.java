package atlas.event.aggregation.server.wiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RuntimeWiringBuilderTest
{
    RuntimeWiringTypeCollector collector = new RuntimeWiringTypeCollector();
    RuntimeWiringBuilder task = new RuntimeWiringBuilder(collector);

    @Test
    void buildRuntimeWiring()
    {
        assertNotNull(task);
        TypeRuntimeWiring.Builder builder = new TypeRuntimeWiring.Builder();
        builder.typeName("builder");
        collector.addTypeWiring(builder);
        task.buildRuntimeWiring();
    }
}