package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentCodeTest
{
    CommentCode task = new CommentCode();
    private int commentCode = 1;
    private String description = "desc";
    private DateTime createDate = new DateTime();
    private String createOrigin = "create";
    private DateTime updateDate = new DateTime();
    private String updateOrigin = "update";
    private long version = 2L;

    @Test
    public void setCommentCode()
    {
        task.setCommentCode(commentCode);
        assertEquals(commentCode, task.getCommentCode());
    }

    @Test
    public void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    public void setCreateOrigin()
    {
        task.setCreateOrigin(createOrigin);
        assertEquals(createOrigin, task.getCreateOrigin());
    }

    @Test
    public void setCreateDate()
    {
        task.setCreateDate(createDate);
        assertEquals(createDate, task.getCreateDate());
    }

    @Test
    public void setUpdateDate()
    {
        task.setUpdateDate(updateDate);
        assertEquals(updateDate, task.getUpdateDate());
    }

    @Test
    public void setUpdateOrigin()
    {
        task.setUpdateOrigin(updateOrigin);
        assertEquals(updateOrigin, task.getUpdateOrigin());
    }

    @Test
    public void setVersion()
    {
        task.setVersion(version);
        assertEquals(version, task.getVersion());
    }
}