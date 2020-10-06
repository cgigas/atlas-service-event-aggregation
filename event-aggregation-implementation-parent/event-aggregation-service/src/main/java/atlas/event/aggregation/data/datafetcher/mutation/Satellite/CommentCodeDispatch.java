package atlas.event.aggregation.data.datafetcher.mutation.Satellite;

import atlas.event.aggregation.data.datafetcher.AbstractDataDispatch;
import atlas.event.aggregation.data.model.Satellite.CommentCode;
import atlas.event.aggregation.data.model.Satellite.CommentCodePage;
import atlas.event.aggregation.data.model.Satellite.Satellite;
import atlas.event.aggregation.server.wiring.RuntimeWiringTypeCollector;
import com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.TypeRuntimeWiring;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class CommentCodeDispatch extends AbstractDataDispatch<List<Satellite>>
{
    public CommentCodeDispatch(RuntimeWiringTypeCollector collector)
    {
        this.collector = collector;
    }
    
    @Override
    protected Object performFetch(DataFetchingEnvironment environment)
    {
        Object result = null;
        String path = getRequestPath(environment);
        if (StringUtils.isNotBlank(path))
        {
            switch (path)
            {
                //Mutation
                case "/createCommentCode":
                    result = createCommentCode(environment);
                    break;
                case "/updateCommentCode":
                    result = updateCommentCode(environment);
                    break;
                case "/deleteCommentCode":
                    result = deleteCommentCode(environment);
                    break;
                //Query
                case "/commentCode":
                    result = commentCode(environment);
                    break;
                case "/commentCodePage":
                    result = commentCodePage(environment);
                    break;
                case "/commentCodePageById":
                    result = commentCodePageById(environment);
                    break;
                case "/commentCodePageByExample":
                    result = commentCodePageByExample(environment);
                    break;
                case "/commentCodePageByCriteria":
                    result = commentCodePageByCriteria(environment);
                    break;
            }
        }

        return result;
    }

    private CommentCodePage commentCodePageByCriteria(DataFetchingEnvironment environment)
    {
        CommentCodePage page = new CommentCodePage();
        return page;
    }

    private CommentCodePage commentCodePageByExample(DataFetchingEnvironment environment)
    {
        CommentCodePage page = new CommentCodePage();
        return page;
    }

    private CommentCodePage commentCodePageById(DataFetchingEnvironment environment)
    {
        CommentCodePage page = new CommentCodePage();
        return page;
    }

    private CommentCodePage commentCodePage(DataFetchingEnvironment environment)
    {
        CommentCodePage page = new CommentCodePage();
        return page;
    }

    private CommentCodePage commentCode(DataFetchingEnvironment environment)
    {
        CommentCodePage page = new CommentCodePage();
        return page;
    }

    private CommentCode deleteCommentCode(DataFetchingEnvironment environment)
    {
        return null;
    }

    private CommentCode updateCommentCode(DataFetchingEnvironment environment)
    {
        CommentCode commentCode = new CommentCode();
        return commentCode;
    }

    private CommentCode createCommentCode(DataFetchingEnvironment environment)
    {
        CommentCode commentCode = new CommentCode();
        return commentCode;
    }

    @Override
    protected Collection<TypeRuntimeWiring.Builder> provideRuntimeTypeWiring()
    {
        Collection<TypeRuntimeWiring.Builder> builders = Lists.newArrayList();
        builders.add(newTypeWiring("MPEServiceMutation")
            .dataFetcher("createCommentCode", this)
            .dataFetcher("updateCommentCode", this)
            .dataFetcher("deleteCommentCode", this));
        builders.add(newTypeWiring("MPEServiceQuery")
            .dataFetcher("commentCode", this)
            .dataFetcher("commentCodePage", this)
            .dataFetcher("commentCodePageById", this)
            .dataFetcher("commentCodePageByExample", this)
            .dataFetcher("commentCodePageByCriteria", this));
        return builders;
    }
}