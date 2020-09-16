/*
 *  * ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */

package atlas.event.aggregation.server.wiring;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RuntimeWiringBuilder implements GraphQlRuntimeWiringBuilder
{

    private final RuntimeWiringTypeCollector collector;

    @Autowired
    public RuntimeWiringBuilder(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    public RuntimeWiring buildRuntimeWiring()
    {
        RuntimeWiring.Builder wiringBuilder = RuntimeWiring.newRuntimeWiring();
        wiringBuilder = wiringBuilder.scalar(ExtendedScalars.DateTime);
        wiringBuilder = wiringBuilder.scalar(ExtendedScalars.NonNegativeInt);
        wiringBuilder = wiringBuilder.scalar(ExtendedScalars.NonNegativeFloat);
        wiringBuilder = wiringBuilder.scalar(ExtendedScalars.PositiveInt);
        wiringBuilder = wiringBuilder.scalar(ExtendedScalars.PositiveFloat);
        for (TypeRuntimeWiring.Builder builder : this.collector.getTypeBuilders())
        {
            wiringBuilder = wiringBuilder.type(builder);
        }
        return wiringBuilder.build();
    }
}