package atlas.event.aggregation.data.datafetcher;

import atlas.event.aggregation.data.model.Comment.Comment;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Collection;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Slf4j
@Component
@Profile("dev")
public class CommentDataDispatch extends AbstractDataDispatch<Comment>
{
    public CommentDataDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceMutation")
                .dataFetcher("createCommentCode", this));
        return builders;
    }

    @Override
    protected Object performFetch(DataFetchingEnvironment environment)
    {
        String path = getRequestPath(environment);
        Object result = null;
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                case "/createCommentCode":
                    result = createCommentCode(environment);
                    break;
            }
        }

        return result;
    }

    private Comment createCommentCode(DataFetchingEnvironment environment)
    {
        Comment comment = null;

        // access client code this process could be recursive...
        //com
        comment.setCommentCodeId(123428935472933L);
        atlas.satellite.crud.graphql.SatelliteCrudMutationExecutor e = null;
        e.
        return comment;
    }
}
