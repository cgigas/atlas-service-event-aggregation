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