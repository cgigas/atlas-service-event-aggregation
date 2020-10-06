package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class CommentCode
{
    private int commentCode;
    private String description;
    private DateTime createDate;
    private String createOrigin;
    private DateTime updateDate;
    private String updateOrigin;
    private long version;

    public int getCommentCode()
    {
        return commentCode;
    }

    public void setCommentCode(int commentCode)
    {
        this.commentCode = commentCode;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public DateTime getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(DateTime createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateOrigin()
    {
        return createOrigin;
    }

    public void setCreateOrigin(String createOrigin)
    {
        this.createOrigin = createOrigin;
    }

    public DateTime getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(DateTime updateDate)
    {
        this.updateDate = updateDate;
    }

    public String getUpdateOrigin()
    {
        return updateOrigin;
    }

    public void setUpdateOrigin(String updateOrigin)
    {
        this.updateOrigin = updateOrigin;
    }

    public long getVersion()
    {
        return version;
    }

    public void setVersion(long version)
    {
        this.version = version;
    }
}
