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
package atlas.event.aggregation.data.model.eventprocessing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventProcessingConfigurationTest
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
    public void setEventProcessingConfigUuid()
    {
        task.setEventProcessingConfigUuid(eventProcessingConfigUuid);
        assertEquals(eventProcessingConfigUuid, task.getEventProcessingConfigUuid());
    }

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setSsaEventUuid()
    {
        task.setSsaEventUuid(ssaEventUuid);
        assertEquals(ssaEventUuid, task.getSsaEventUuid());
    }

    @Test
    public void setCandidateRsoReservationUuid()
    {
        task.setCandidateRsoReservationUuid(candidateRsoReservationUuid);
        assertEquals(candidateRsoReservationUuid, task.getCandidateRsoReservationUuid());
    }

    @Test
    public void setAnalystRsoReservationUuid()
    {
        task.setAnalystRsoReservationUuid(analystRsoReservationUuid);
        assertEquals(analystRsoReservationUuid, task.getAnalystRsoReservationUuid());
    }

    @Test
    public void setCatalogRsoReservationUuid()
    {
        task.setCatalogRsoReservationUuid(catalogRsoReservationUuid);
        assertEquals(catalogRsoReservationUuid, task.getCatalogRsoReservationUuid());
    }

    @Test
    public void setUcnReservationUuid()
    {
        task.setUcnReservationUuid(ucnReservationUuid);
        assertEquals(ucnReservationUuid, task.getUcnReservationUuid());
    }

    @Test
    public void setCandidateFormationParametersUuid()
    {
        task.setCandidateFormationParametersUuid(candidateFormationParametersUuid);
        assertEquals(candidateFormationParametersUuid, task.getCandidateFormationParametersUuid());
    }

    @Test
    public void setValidityCriteriaUuid()
    {
        task.setValidityCriteriaUuid(eventProcessingConfigUuid);
        assertEquals(eventProcessingConfigUuid, task.getValidityCriteriaUuid());
    }

    @Test
    public void setCurrentFlag()
    {
        task.setCurrentFlag(currentFlag);
        assertEquals(currentFlag, task.getCurrentFlag());
    }

    @Test
    public void setSaveAsFolderFlag()
    {
        task.setSaveAsFolderFlag(saveAsFolderFlag);
        assertEquals(saveAsFolderFlag, task.getSaveAsFolderFlag());
    }

    @Test
    public void setName()
    {
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    public void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }
}