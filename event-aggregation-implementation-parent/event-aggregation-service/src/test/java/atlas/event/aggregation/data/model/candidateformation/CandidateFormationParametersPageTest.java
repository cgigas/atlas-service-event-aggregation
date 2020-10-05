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
package atlas.event.aggregation.data.model.candidateformation;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CandidateFormationParametersPageTest
{

    CandidateFormationParametersPage page = new CandidateFormationParametersPage();
    CandidateFormationParameters content = new CandidateFormationParameters();

    @Before
    public void setUp()
    {
        content.setCandidateFormationParametersUuid("candidateFormationParametersUuid");
        content.setCoplanarCheckThreshold(new Float("2"));
        content.setPdotCoeficients(new Float("3"));
        content.setPeriodAssociationThreshold(new Float("4"));
        content.setMinimumTrackersPerCluster(5);
        content.setUpdateOrigin("updated origin");
        content.setUpdateDate(new Date());
        content.setCreateOrigin("created origin");
        content.setCreateDate(new Date());
        content.setVersion(6);
        page.setNumber(1);
        page.setTotalElements(2L);
        page.setTotalPages(3);
        page.setContent(content);
    }

    @Test
    public void testNumber()
    {
        assertEquals(1, page.getNumber());
    }

    @Test
    public void testTotalElements()
    {
        assertEquals(2L, page.getTotalElements());
    }

    @Test
    public void testTotalPages()
    {
        assertEquals(3, page.getTotalPages());
    }

    @Test
    public void testContent()
    {
        assertEquals(content, page.getContent());
    }
}