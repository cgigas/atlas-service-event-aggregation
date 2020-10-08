package atlas.event.aggregation.data.model.Satellite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentCodePageTest
{
    CommentCodePage task = new CommentCodePage();
    private int number = 1;
    private long totalElements = 2L;
    private int totalPages = 3;
    private CommentCode content = new CommentCode();

    @Test
    public void setNumber()
    {
        task.setNumber(number);
        assertEquals(number, task.getNumber());
    }

    @Test
    public void setTotalElements()
    {
        task.setTotalElements(totalElements);
        assertEquals(totalElements, task.getTotalElements());
    }

    @Test
    public void setTotalPages()
    {
        task.setTotalPages(totalPages);
        assertEquals(totalPages, task.getTotalPages());
    }

    @Test
    public void setContent()
    {
        task.setContent(content);
        assertEquals(content, task.getContent());
    }
}