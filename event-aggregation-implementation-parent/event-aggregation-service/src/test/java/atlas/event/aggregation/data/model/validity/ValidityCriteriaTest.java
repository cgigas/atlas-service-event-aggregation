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
package atlas.event.aggregation.data.model.validity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidityCriteriaTest
{
    ValidityCriteria task = new ValidityCriteria();
    String validityCriteriaUuid = "validityCriteriaUuid";
    String classificationMarking = "classificationMarking";
    Integer analystMinTrackersPerDay = 1;
    Integer catalogMinTrackersPerDay = 2;
    Integer analystMinTracksReceived = 3;
    Integer catalogMinTracksReceived = 4;
    Integer analystMinODSolutions = 5;
    Integer catalogMinODSolutions = 6;
    Integer analystRmsTrendMean = 7;
    Integer catalogRmsTrendMean = 8;
    Integer analystRmsTrendSd = 9;
    Integer catalogStandardDeviation = 10;
    Integer analystMinResidualAcceptance = 11;
    Integer catalogMinResidualAcceptance = 12;
    Integer analystMinArgumentLatitude = 13;
    Integer catalogMinArgumentLatitude = 14;
    Integer analystMinReportingSensors = 15;
    Integer catalogMinReportingSensors = 16;

    @Test
    public void setValidityCriteriaUuid()
    {
        task.setValidityCriteriaUuid(validityCriteriaUuid);
        assertEquals(validityCriteriaUuid, task.getValidityCriteriaUuid());
    }

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setAnalystMinTrackersPerDay()
    {
        task.setAnalystMinTrackersPerDay(analystMinTrackersPerDay);
        assertEquals(analystMinTrackersPerDay, task.getAnalystMinTrackersPerDay());
    }

    @Test
    public void setCatalogMinTrackersPerDay()
    {
        task.setCatalogMinTrackersPerDay(catalogMinTrackersPerDay);
        assertEquals(catalogMinTrackersPerDay, task.getCatalogMinTrackersPerDay());
    }

    @Test
    public void setAnalystMinTracksReceived()
    {
        task.setAnalystMinTracksReceived(analystMinTracksReceived);
        assertEquals(analystMinTracksReceived, task.getAnalystMinTracksReceived());
    }

    @Test
    public void setCatalogMinTracksReceived()
    {
        task.setCatalogMinTracksReceived(catalogMinTracksReceived);
        assertEquals(catalogMinTracksReceived, task.getCatalogMinTracksReceived());
    }

    @Test
    public void setAnalystMinODSolutions()
    {
        task.setAnalystMinODSolutions(analystMinODSolutions);
        assertEquals(analystMinODSolutions, task.getAnalystMinODSolutions());
    }

    @Test
    public void setCatalogMinODSolutions()
    {
        task.setCatalogMinODSolutions(catalogMinODSolutions);
        assertEquals(catalogMinODSolutions, task.getCatalogMinODSolutions());
    }

    @Test
    public void setAnalystRmsTrendMean()
    {
        task.setAnalystRmsTrendMean(analystRmsTrendMean);
        assertEquals(analystRmsTrendMean, task.getAnalystRmsTrendMean());
    }

    @Test
    public void setCatalogRmsTrendMean()
    {
        task.setCatalogRmsTrendMean(catalogRmsTrendMean);
        assertEquals(catalogRmsTrendMean, task.getCatalogRmsTrendMean());
    }

    @Test
    public void setAnalystRmsTrendSd()
    {
        task.setAnalystRmsTrendSd(analystRmsTrendSd);
        assertEquals(analystRmsTrendSd, task.getAnalystRmsTrendSd());
    }

    @Test
    public void setCatalogStandardDeviation()
    {
        task.setCatalogStandardDeviation(catalogStandardDeviation);
        assertEquals(catalogStandardDeviation, task.getCatalogStandardDeviation());
    }

    @Test
    public void setAnalystMinResidualAcceptance()
    {
        task.setAnalystMinResidualAcceptance(analystMinResidualAcceptance);
        assertEquals(analystMinResidualAcceptance, task.getAnalystMinResidualAcceptance());
    }

    @Test
    public void setCatalogMinResidualAcceptance()
    {
        task.setCatalogMinResidualAcceptance(catalogMinResidualAcceptance);
        assertEquals(catalogMinResidualAcceptance, task.getCatalogMinResidualAcceptance());
    }

    @Test
    public void setAnalystMinArgumentLatitude()
    {
        task.setAnalystMinArgumentLatitude(analystMinArgumentLatitude);
        assertEquals(analystMinArgumentLatitude, task.getAnalystMinArgumentLatitude());
    }

    @Test
    public void setCatalogMinArgumentLatitude()
    {
        task.setCatalogMinArgumentLatitude(catalogMinArgumentLatitude);
        assertEquals(catalogMinArgumentLatitude, task.getCatalogMinArgumentLatitude());
    }

    @Test
    public void setAnalystMinReportingSensors()
    {
        task.setAnalystMinReportingSensors(analystMinReportingSensors);
        assertEquals(analystMinReportingSensors, task.getAnalystMinReportingSensors());
    }

    @Test
    public void setCatalogMinReportingSensors()
    {
        task.setCatalogMinReportingSensors(catalogMinReportingSensors);
        assertEquals(catalogMinReportingSensors, task.getCatalogMinReportingSensors());
    }
}