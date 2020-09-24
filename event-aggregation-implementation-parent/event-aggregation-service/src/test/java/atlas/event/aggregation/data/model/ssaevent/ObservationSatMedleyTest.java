package atlas.event.aggregation.data.model.ssaevent;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;

class ObservationSatMedleyTest
{
    ObservationSatMedley task = new ObservationSatMedley();
    String id = "id";
    String satelliteId = "sat id";
    String observationId = "ob id";
    String classification = "ts";
    String commonName = "hubble";
    String group = "group 1";
    String result = "clear";
    String typeName = "science";
    Long isPromotable = 1L;
    Long isCataloged = 2L;
    Long isAnalyst = 3L;
    Long isCandidate = 4L;
    Long satNo = 5L;
    Long ucn = 6L;
    Long type = 7L;
    Long apogee = 8L;
    Long perigee = 9L;
    Double radarCrossSection = 1.1;
    Double period = 1.2;
    Double inclination = 1.3;
    Double eccentricity = 1.4;
    OffsetDateTime epoch = OffsetDateTime.now();

    @Test
    void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    void setSatelliteId()
    {
        task.setSatelliteId(satelliteId);
        assertEquals(satelliteId, task.getSatelliteId());
    }

    @Test
    void setObservationId()
    {
        task.setObservationId(observationId);
        assertEquals(observationId, task.getObservationId());
    }

    @Test
    void setClassification()
    {
        task.setClassification(classification);
        assertEquals(classification, task.getClassification());
    }

    @Test
    void setPromotable()
    {
        task.setPromotable(isPromotable);
        assertEquals(isPromotable, task.getPromotable());
    }

    @Test
    void setCataloged()
    {
        task.setCataloged(isCataloged);
        assertEquals(isCataloged, task.getCataloged());
    }

    @Test
    void setAnalyst()
    {
        task.setAnalyst(isAnalyst);
        assertEquals(isAnalyst, task.getAnalyst());
    }

    @Test
    void setCandidate()
    {
        task.setCandidate(isCandidate);
        assertEquals(isCandidate, task.getCandidate());
    }

    @Test
    void setSatNo()
    {
        task.setSatNo(satNo);
        assertEquals(satNo, task.getSatNo());
    }

    @Test
    void setUcn()
    {
        task.setUcn(ucn);
        assertEquals(ucn, task.getUcn());
    }

    @Test
    void setCommonName()
    {
        task.setCommonName(commonName);
        assertEquals(commonName, task.getCommonName());
    }

    @Test
    void setGroup()
    {
        task.setGroup(group);
        assertEquals(group, task.getGroup());
    }

    @Test
    void setType()
    {
        task.setType(type);
        assertEquals(type, task.getType());
    }

    @Test
    void setRadarCrossSection()
    {
        task.setRadarCrossSection(radarCrossSection);
        assertEquals(radarCrossSection, task.getRadarCrossSection());
    }

    @Test
    void setEpoch()
    {
        task.setEpoch(epoch);
        assertEquals(epoch, task.getEpoch());
    }

    @Test
    void setResult()
    {
        task.setResult(result);
        assertEquals(result, task.getResult());
    }

    @Test
    void setPeriod()
    {
        task.setPeriod(period);
        assertEquals(period, task.getPeriod());
    }

    @Test
    void setInclination()
    {
        task.setInclination(inclination);
        assertEquals(inclination, task.getInclination());
    }

    @Test
    void setApogee()
    {
        task.setApogee(apogee);
        assertEquals(apogee, task.getApogee());
    }

    @Test
    void setPerigee()
    {
        task.setPerigee(perigee);
        assertEquals(perigee, task.getPerigee());
    }

    @Test
    void setEccentricity()
    {
        task.setEccentricity(eccentricity);
        assertEquals(eccentricity, task.getEccentricity());
    }

    @Test
    void setTypeName()
    {
        task.setTypeName(typeName);
        assertEquals(typeName, task.getTypeName());
    }
}