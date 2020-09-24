package atlas.event.aggregation.data.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuditedTest
{
    Audited task = new Audited();
    Date createDate = new Date();
    Date updateDate = new Date();
    String createOrigin = "create";
    String updateOrigin = "update";

    @Test
    void setCreateDate()
    {
        task.setCreateDate(createDate);
        assertEquals(createDate, task.getCreateDate());
    }

    @Test
    void setCreateOrigin()
    {
        task.setCreateOrigin(createOrigin);
        assertEquals(createOrigin, task.getCreateOrigin());
    }

    @Test
    void setUpdateDate()
    {
        task.setUpdateDate(updateDate);
        assertEquals(updateDate, task.getUpdateDate());
    }

    @Test
    void setUpdateOrigin()
    {
        task.setUpdateOrigin(updateOrigin);
        assertEquals(updateOrigin, task.getUpdateOrigin());
    }
}