/*
 *  ******************************************************************************
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

package atlas.event.aggregation.data.datafetcher.mutation;

import atlas.event.aggregation.data.datafetcher.AbstractDataFetcher;
import atlas.event.aggregation.data.mapper.ObjectFieldUpdater;
import atlas.event.aggregation.data.model.repository.ssaevent.SsaEventRepository;
import atlas.event.aggregation.data.model.ssaevent.SsaEvent;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class SsaEventUpdater extends AbstractDataFetcher<SsaEvent>
{
    protected final SsaEventRepository repository;
    protected final ObjectFieldUpdater fieldUpdater;

    public SsaEventUpdater(SsaEventRepository repos, ObjectFieldUpdater updater)
    {
        this.repository = repos;
        this.fieldUpdater = updater;
    }

    @Override
    protected void performFetch(DataFetchingEnvironment environment)
    {
        returnValue = null;
        String idValue = environment.getArgument("id");

        Map<String, Object> fieldsMap = environment.getArgument("input");

        // decide what type of operation this is.
        MutationOperation operation = null;
        if (idValue == null && fieldsMap != null && !fieldsMap.isEmpty())
        {
            operation = MutationOperation.CREATE;
        }
        else if (idValue != null && fieldsMap != null && !fieldsMap.isEmpty())
        {
            operation = MutationOperation.UPDATE;
        }
        else if (idValue != null)
        {
            operation = MutationOperation.DELETE;
        }

        if (operation != null)
        {
//            performRequestValidation(operation, idValue, fieldsMap);
            switch (operation)
            {
                case CREATE:
                    SsaEvent ssaEvent = new SsaEvent();
                    ssaEvent.setSsaEventUuid(UUID.randomUUID().toString());
                    ssaEvent = (SsaEvent) fieldUpdater.updateFields(ssaEvent, fieldsMap);
                    ssaEvent = repository.save(ssaEvent);
                    returnValue = ssaEvent;
                    break;
//                case UPDATE:
//                    Optional<T> entity = repository.findById(idValue);
//
//                    if (entity.isPresent())
//                    {
//                        returnValue = entity.get();  // not sure this is necessary but may help return a partial result.
//                        // Map changed fields onto object
//                        T updatedControl = (T) fieldUpdater.updateFields(entity.get(), fieldsMap);
//                        // save the updated object
//                        updatedControl = repository.update(updatedControl);
//                        returnValue = updatedControl;
//                    }
//                    else
//                    {
//                        String msg = MessageFormat.format("A record of type {0} with id {1} was not found.", clazz.getName(), controlId);
//                        throw new UiAggregationQueryException(msg, UiAggregationExceptionCodes.WARNING);
//                    }
//                    break;
//                case DELETE:
//                    entity = repository.findById(idValue);
//                    if (entity.isPresent())
//                    {
//                        repository.deleteById(idValue);
//                        returnValue = entity.get();
//                    }
//                    break;
                default:
                    throw new IllegalStateException("An unexpected mutation operation was encountered.");
            }
        }
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("EasMutation")
            .dataFetcher("createSsaEvent", this));
        builders.add(newTypeWiring("EasMutation")
            .dataFetcher("updateSsaEvent", this));
        builders.add(newTypeWiring("EasMutation")
            .dataFetcher("deleteSsaEvent", this));
        return builders;
    }
}
