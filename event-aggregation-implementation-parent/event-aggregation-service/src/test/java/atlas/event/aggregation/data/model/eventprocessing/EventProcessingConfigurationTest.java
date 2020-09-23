package atlas.event.aggregation.data.model.eventprocessing;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class EventProcessingConfigurationTest
{
    EventProcessingConfiguration task = new EventProcessingConfiguration();
    String eventProcessingConfigUuid = "eventProcessingConfigUuid";
    String classificationMarking = "classificationMarking";
    String ssaEventUuid = "ssaEventUuid";
    String candidateRsoReservationUuid = "candidateRsoReservationUuid";
    String analystRsoReservationUuid = "analystRsoReservationUuid";
    String catalogRsoReservationUuid = "catalogRsoReservationUuid";
    String ucnReservationUuid = "ucnReservationUuid";
    String candidateFormationParametersUuid = "candidateFormationParametersUuid";
    String validityCriteriaUuid = "validityCriteriaUuid";
    Integer currentFlag = 1;
    Integer saveAsFolderFlag = 2;
    String name = "name";
    String description = "description";

    @Test
    void setEventProcessingConfigUuid()
    {
        task.setEventProcessingConfigUuid(eventProcessingConfigUuid);
        assertEquals(eventProcessingConfigUuid, task.getEventProcessingConfigUuid());
    }

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setSsaEventUuid()
    {
        task.setSsaEventUuid(ssaEventUuid);
        assertEquals(ssaEventUuid, task.getSsaEventUuid());
    }

    @Test
    void setCandidateRsoReservationUuid()
    {
        task.setCandidateRsoReservationUuid(candidateRsoReservationUuid);
        assertEquals(candidateRsoReservationUuid, task.getCandidateRsoReservationUuid());
    }

    @Test
    void setAnalystRsoReservationUuid()
    {
        task.setAnalystRsoReservationUuid(analystRsoReservationUuid);
        assertEquals(analystRsoReservationUuid, task.getAnalystRsoReservationUuid());
    }

    @Test
    void setCatalogRsoReservationUuid()
    {
        task.setCatalogRsoReservationUuid(catalogRsoReservationUuid);
        assertEquals(catalogRsoReservationUuid, task.getCatalogRsoReservationUuid());
    }

    @Test
    void setUcnReservationUuid()
    {
        task.setUcnReservationUuid(ucnReservationUuid);
        assertEquals(ucnReservationUuid, task.getUcnReservationUuid());
    }

    @Test
    void setCandidateFormationParametersUuid()
    {
        task.setCandidateFormationParametersUuid(candidateFormationParametersUuid);
        assertEquals(candidateFormationParametersUuid, task.getCandidateFormationParametersUuid());
    }

    @Test
    void setValidityCriteriaUuid()
    {
        task.setValidityCriteriaUuid(eventProcessingConfigUuid);
        assertEquals(eventProcessingConfigUuid, task.getValidityCriteriaUuid());
    }

    @Test
    void setCurrentFlag()
    {
        task.setCurrentFlag(currentFlag);
        assertEquals(currentFlag, task.getCurrentFlag());
    }

    @Test
    void setSaveAsFolderFlag()
    {
        task.setSaveAsFolderFlag(saveAsFolderFlag);
        assertEquals(saveAsFolderFlag, task.getSaveAsFolderFlag());
    }

    @Test
    void setName()
    {
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }
}