package atlas.event.aggregation.data.paging.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageInfoTest
{
    PageInfo task = new PageInfo();
    Integer page = 1;
    Integer size = 2;
    Sort sort = new Sort();

    @Test
    void setPage()
    {
        task.setPage(page);
        assertEquals(page, task.getPage());
    }

    @Test
    void setSize()
    {
        task.setSize(size);
        assertEquals(size, task.getSize());
    }

    @Test
    void setSort()
    {
        task.setSort(sort);
        assertEquals(sort, task.getSort());
    }
}