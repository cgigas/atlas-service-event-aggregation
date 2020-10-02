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

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CandidateFormationParametersTest
{
    CandidateFormationParameters task = new CandidateFormationParameters();
    String candidateFormationParametersUuid = "canFormParaUuid";
    Float pdotCoeficients = Float.valueOf(3);
    Float coplanarCheckThreshold = Float.valueOf(4);
    Float periodThreshold = Float.valueOf(5);
    Integer minimumTrackersPerCluster = 6;
    Date updateDate = new Date();
    Date createDate = new Date();
    String updateOrigin = "update";
    String createOrigin = "create";
    int version = 7;

    @Test
    public void setCandidateFormationParametersUuid()
    {
        task.setCandidateFormationParametersUuid(candidateFormationParametersUuid);
        assertEquals(candidateFormationParametersUuid, task.getCandidateFormationParametersUuid());
    }

    @Test
    public void setPdotCoeficients()
    {
        task.setPdotCoeficients(pdotCoeficients);
        assertEquals(pdotCoeficients, task.getPdotCoeficients());
    }

    @Test
    public void setMinimumTrackersPerCluster()
    {
        task.setMinimumTrackersPerCluster(minimumTrackersPerCluster);
        assertEquals(minimumTrackersPerCluster, task.getMinimumTrackersPerCluster());
    }

    @Test
    public void setCoplanarCheckThreshold()
    {
        task.setCoplanarCheckThreshold(coplanarCheckThreshold);
        assertEquals(coplanarCheckThreshold, task.getCoplanarCheckThreshold());
    }

    @Test
    public void setPeriodThreshold()
    {
        task.setPeriodAssociationThreshold(periodThreshold);
        assertEquals(periodThreshold, task.getPeriodAssociationThreshold());
    }

    @Test
    public void testDate()
    {
        task.setCreateDate(createDate);
        assertEquals(createDate, task.getCreateDate());

        task.setUpdateDate(updateDate);
        assertEquals(updateDate, task.getUpdateDate());
    }

    @Test
    public void testOrigin()
    {
        task.setCreateOrigin(createOrigin);
        assertEquals(createOrigin, task.getCreateOrigin());

        task.setUpdateOrigin(updateOrigin);
        assertEquals(updateOrigin, task.getUpdateOrigin());
    }

    @Test
    public void testVersion()
    {
        task.setVersion(version);
        assertEquals(version, task.getVersion());
    }
}