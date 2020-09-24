package atlas.event.aggregation.data.model.validity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidityCriteriaTest
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
    void setValidityCriteriaUuid()
    {
        task.setValidityCriteriaUuid(validityCriteriaUuid);
        assertEquals(validityCriteriaUuid, task.getValidityCriteriaUuid());
    }

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setAnalystMinTrackersPerDay()
    {
        task.setAnalystMinTrackersPerDay(analystMinTrackersPerDay);
        assertEquals(analystMinTrackersPerDay, task.getAnalystMinTrackersPerDay());
    }

    @Test
    void setCatalogMinTrackersPerDay()
    {
        task.setCatalogMinTrackersPerDay(catalogMinTrackersPerDay);
        assertEquals(catalogMinTrackersPerDay, task.getCatalogMinTrackersPerDay());
    }

    @Test
    void setAnalystMinTracksReceived()
    {
        task.setAnalystMinTracksReceived(analystMinTracksReceived);
        assertEquals(analystMinTracksReceived, task.getAnalystMinTracksReceived());
    }

    @Test
    void setCatalogMinTracksReceived()
    {
        task.setCatalogMinTracksReceived(catalogMinTracksReceived);
        assertEquals(catalogMinTracksReceived, task.getCatalogMinTracksReceived());
    }

    @Test
    void setAnalystMinODSolutions()
    {
        task.setAnalystMinODSolutions(analystMinODSolutions);
        assertEquals(analystMinODSolutions, task.getAnalystMinODSolutions());
    }

    @Test
    void setCatalogMinODSolutions()
    {
        task.setCatalogMinODSolutions(catalogMinODSolutions);
        assertEquals(catalogMinODSolutions, task.getCatalogMinODSolutions());
    }

    @Test
    void setAnalystRmsTrendMean()
    {
        task.setAnalystRmsTrendMean(analystRmsTrendMean);
        assertEquals(analystRmsTrendMean, task.getAnalystRmsTrendMean());
    }

    @Test
    void setCatalogRmsTrendMean()
    {
        task.setCatalogRmsTrendMean(catalogRmsTrendMean);
        assertEquals(catalogRmsTrendMean, task.getCatalogRmsTrendMean());
    }

    @Test
    void setAnalystRmsTrendSd()
    {
        task.setAnalystRmsTrendSd(analystRmsTrendSd);
        assertEquals(analystRmsTrendSd, task.getAnalystRmsTrendSd());
    }

    @Test
    void setCatalogStandardDeviation()
    {
        task.setCatalogStandardDeviation(catalogStandardDeviation);
        assertEquals(catalogStandardDeviation, task.getCatalogStandardDeviation());
    }

    @Test
    void setAnalystMinResidualAcceptance()
    {
        task.setAnalystMinResidualAcceptance(analystMinResidualAcceptance);
        assertEquals(analystMinResidualAcceptance, task.getAnalystMinResidualAcceptance());
    }

    @Test
    void setCatalogMinResidualAcceptance()
    {
        task.setCatalogMinResidualAcceptance(catalogMinResidualAcceptance);
        assertEquals(catalogMinResidualAcceptance, task.getCatalogMinResidualAcceptance());
    }

    @Test
    void setAnalystMinArgumentLatitude()
    {
        task.setAnalystMinArgumentLatitude(analystMinArgumentLatitude);
        assertEquals(analystMinArgumentLatitude, task.getAnalystMinArgumentLatitude());
    }

    @Test
    void setCatalogMinArgumentLatitude()
    {
        task.setCatalogMinArgumentLatitude(catalogMinArgumentLatitude);
        assertEquals(catalogMinArgumentLatitude, task.getCatalogMinArgumentLatitude());
    }

    @Test
    void setAnalystMinReportingSensors()
    {
        task.setAnalystMinReportingSensors(analystMinReportingSensors);
        assertEquals(analystMinReportingSensors, task.getAnalystMinReportingSensors());
    }

    @Test
    void setCatalogMinReportingSensors()
    {
        task.setCatalogMinReportingSensors(catalogMinReportingSensors);
        assertEquals(catalogMinReportingSensors, task.getCatalogMinReportingSensors());
    }
}