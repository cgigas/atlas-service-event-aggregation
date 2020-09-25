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

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventDetailTest
{
    EventDetail task = new EventDetail();
    String id = "id";
    String state = "state";
    String classification = "classification";
    Long type = 1L;
    String name = "name";
    OffsetDateTime startDate = OffsetDateTime.now();
    OffsetDateTime endDate = OffsetDateTime.of(2020, 10, 1, 1, 1, 1, 1, ZoneOffset.UTC);
    Long catalogObjectCount = 2L;
    Long analystObjects = 3L;
    Long candidateObjectCount = 4L;
    Long promotableObjectCount = 5L;
    String typeName = "typeName";
    Event parentEvent = new Event();
    Launch launch = new Launch();
    List<ObservationSatMedley> observationSatMedleyArray = new ArrayList<>();

    @Test
    void setTypeName()
    {
        task.setTypeName(typeName);
        assertEquals(typeName, task.getTypeName());
    }

    @Test
    void setId()
    {
        task.setId(id);
        assertEquals(id, task.getId());
    }

    @Test
    void setState()
    {
        task.setState(state);
        assertEquals(state, task.getState());
    }

    @Test
    void setClassification()
    {
        task.setClassification(classification);
        assertEquals(classification, task.getClassification());
    }

    @Test
    void setType()
    {
        task.setType(type);
        assertEquals(type, task.getType());
    }

    @Test
    void setName()
    {
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    void setStartDate()
    {
        task.setStartDate(startDate);
        assertEquals(startDate, task.getStartDate());
    }

    @Test
    void setEndDate()
    {
        task.setEndDate(endDate);
        assertEquals(endDate, task.getEndDate());
    }

    @Test
    void setCatalogObjectCount()
    {
        task.setCatalogObjectCount(catalogObjectCount);
        assertEquals(catalogObjectCount, task.getCatalogObjectCount());
    }

    @Test
    void setAnalystObjects()
    {
        task.setAnalystObjects(analystObjects);
        assertEquals(analystObjects, task.getAnalystObjects());
    }

    @Test
    void setCandidateObjectCount()
    {
        task.setCandidateObjectCount(candidateObjectCount);
        assertEquals(candidateObjectCount, task.getCandidateObjectCount());
    }

    @Test
    void setPromotableObjectCount()
    {
        task.setPromotableObjectCount(promotableObjectCount);
        assertEquals(promotableObjectCount, task.getPromotableObjectCount());
    }

    @Test
    void setParentEvent()
    {
        task.setParentEvent(parentEvent);
        assertEquals(parentEvent, task.getParentEvent());
    }

    @Test
    void setLaunch()
    {
        task.setLaunch(launch);
        assertEquals(launch, task.getLaunch());
    }

    @Test
    void setObservationSatMedleyArray()
    {
        task.setObservationSatMedleyArray(null);
        assertEquals(observationSatMedleyArray, task.getObservationSatMedleyArray());
        task.setObservationSatMedleyArray(observationSatMedleyArray);
        assertEquals(observationSatMedleyArray, task.getObservationSatMedleyArray());
    }
}