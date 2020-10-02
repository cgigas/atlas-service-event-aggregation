package atlas.event.aggregation.data.model.Comment;

import atlas.event.aggregation.data.model.Audited;
import java.io.Serializable;

public class Comment extends Audited implements Serializable
{
    private Long commentCodeId;


    public Long getCommentCodeId()
    {
        return commentCodeId;
    }

    public void setCommentCodeId(Long commentCodeId)
    {
        this.commentCodeId = commentCodeId;
    }
}
