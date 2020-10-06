package atlas.event.aggregation.data.model.Satellite;

public class CommentCodePage
{
    private int number;
    private long totalElements;
    private int totalPages;
    private CommentCode content;

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public long getTotalElements()
    {
        return totalElements;
    }

    public void setTotalElements(long totalElements)
    {
        this.totalElements = totalElements;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public CommentCode getContent()
    {
        return content;
    }

    public void setContent(CommentCode content)
    {
        this.content = content;
    }
}
