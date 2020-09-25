/*
 * ******************************************************************************
 *  WARNING: EXPORT CONTROLLED - EAR
 *  THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *  GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *  REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *  FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *  VIOLATION OF FEDERAL LAW.
 * ******************************************************************************
 *  Unlimited Government Rights
 *  WARNING: Do Not Use On A Privately Funded Program Without Permission.
 * ******************************************************************************
 *  CLASSIFICATION:   Unclassified
 *
 *  LIMITATIONS:      None
 * ******************************************************************************
 */
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