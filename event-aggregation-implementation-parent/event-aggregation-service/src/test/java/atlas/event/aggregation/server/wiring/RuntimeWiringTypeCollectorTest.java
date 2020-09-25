package atlas.event.aggregation.server.wiring;

import graphql.schema.idl.TypeRuntimeWiring;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuntimeWiringTypeCollectorTest
{
    RuntimeWiringTypeCollector task = new RuntimeWiringTypeCollector();
    TypeRuntimeWiring.Builder builder = new TypeRuntimeWiring.Builder();
    Collection<TypeRuntimeWiring.Builder> typeBuilders = new ArrayList<>();

    @Test
    void addTypeWiring()
    {
        task.addTypeWiring(builder);
        assertEquals(1, task.getTypeBuilders().size());
        task.addTypeWiring(typeBuilders);
    }
}