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

import com.google.inject.internal.util.Lists;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/*
This component is injected into each datafetcher and collects runtime type wiring information from each datafetcher. It is then used
by the runtimeWiringBuilder to build up the type wiring for the graphql engine.
 */
@Component
@Slf4j
public class RuntimeWiringTypeCollector
{
    List<TypeRuntimeWiring.Builder> typeBuilders = Lists.newArrayList();

    public void addTypeWiring(TypeRuntimeWiring.Builder typeBuilder)
    {
        this.typeBuilders.add(typeBuilder);
    }

    public void addTypeWiring(Collection<TypeRuntimeWiring.Builder> typeBuilders)
    {
        this.typeBuilders.addAll(typeBuilders);
    }

    public List<TypeRuntimeWiring.Builder> getTypeBuilders()
    {
        return typeBuilders;
    }
}
