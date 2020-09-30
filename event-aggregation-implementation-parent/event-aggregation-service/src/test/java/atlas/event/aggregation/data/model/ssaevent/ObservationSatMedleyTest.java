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
package atlas.event.aggregation.data.model.ssaevent;

import org.junit.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;

public class ObservationSatMedleyTest
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
    EventType type = EventType.LAUNCH;
    Long apogee = 8L;
    Long perigee = 9L;
    Double radarCrossSection = 1.1;
    Double period = 1.2;
    Double inclination = 1.3;
    Double eccentricity = 1.4;
    OffsetDateTime epoch = OffsetDateTime.now();

    @Test
    public void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    public void setSatelliteId()
    {
        task.setSatelliteId(satelliteId);
        assertEquals(satelliteId, task.getSatelliteId());
    }

    @Test
    public void setObservationId()
    {
        task.setObservationId(observationId);
        assertEquals(observationId, task.getObservationId());
    }

    @Test
    public void setClassification()
    {
        task.setClassification(classification);
        assertEquals(classification, task.getClassification());
    }

    @Test
    public void setPromotable()
    {
        task.setPromotable(isPromotable);
        assertEquals(isPromotable, task.getPromotable());
    }

    @Test
    public void setCataloged()
    {
        task.setCataloged(isCataloged);
        assertEquals(isCataloged, task.getCataloged());
    }

    @Test
    public void setAnalyst()
    {
        task.setAnalyst(isAnalyst);
        assertEquals(isAnalyst, task.getAnalyst());
    }

    @Test
    public void setCandidate()
    {
        task.setCandidate(isCandidate);
        assertEquals(isCandidate, task.getCandidate());
    }

    @Test
    public void setSatNo()
    {
        task.setSatNo(satNo);
        assertEquals(satNo, task.getSatNo());
    }

    @Test
    public void setUcn()
    {
        task.setUcn(ucn);
        assertEquals(ucn, task.getUcn());
    }

    @Test
    public void setCommonName()
    {
        task.setCommonName(commonName);
        assertEquals(commonName, task.getCommonName());
    }

    @Test
    public void setGroup()
    {
        task.setGroup(group);
        assertEquals(group, task.getGroup());
    }

    @Test
    public void setType()
    {
        task.setType(type);
        assertEquals(type, task.getType());
    }

    @Test
    public void setRadarCrossSection()
    {
        task.setRadarCrossSection(radarCrossSection);
        assertEquals(radarCrossSection, task.getRadarCrossSection());
    }

    @Test
    public void setEpoch()
    {
        task.setEpoch(epoch);
        assertEquals(epoch, task.getEpoch());
    }

    @Test
    public void setResult()
    {
        task.setResult(result);
        assertEquals(result, task.getResult());
    }

    @Test
    public void setPeriod()
    {
        task.setPeriod(period);
        assertEquals(period, task.getPeriod());
    }

    @Test
    public void setInclination()
    {
        task.setInclination(inclination);
        assertEquals(inclination, task.getInclination());
    }

    @Test
    public void setApogee()
    {
        task.setApogee(apogee);
        assertEquals(apogee, task.getApogee());
    }

    @Test
    public void setPerigee()
    {
        task.setPerigee(perigee);
        assertEquals(perigee, task.getPerigee());
    }

    @Test
    public void setEccentricity()
    {
        task.setEccentricity(eccentricity);
        assertEquals(eccentricity, task.getEccentricity());
    }

    @Test
    public void setTypeName()
    {
        task.setTypeName(typeName);
        assertEquals(typeName, task.getTypeName());
    }
}