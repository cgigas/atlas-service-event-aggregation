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
package atlas.event.aggregation.data.paging.elements;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PageInfoTest
{
    PageInfo task = new PageInfo();
    Integer page = 1;
    Integer size = 2;
    Sort sort = new Sort();

    @Test
    public void setPage()
    {
        task.setPage(page);
        assertEquals(page, task.getPage());
    }

    @Test
    public void setSize()
    {
        task.setSize(size);
        assertEquals(size, task.getSize());
    }

    @Test
    public void setSort()
    {
        task.setSort(sort);
        assertEquals(sort, task.getSort());
    }
}