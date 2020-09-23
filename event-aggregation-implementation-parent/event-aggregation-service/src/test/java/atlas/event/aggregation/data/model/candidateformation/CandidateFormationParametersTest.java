package atlas.event.aggregation.data.model.candidateformation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandidateFormationParametersTest
{
    CandidateFormationParameters task = new CandidateFormationParameters();
    String candidateFormationParametersUuid = "canFormParaUuid";
    String classificationMarking = "classMark";
    Float pdotCoeficients = Float.valueOf(3);
    Float coplanarCheckThreshold = Float.valueOf(4);
    Float periodThreshold = Float.valueOf(5);
    Integer minimumTrackersPerCluster = 6;

    @Test
    void setCandidateFormationParametersUuid()
    {
        task.setCandidateFormationParametersUuid(candidateFormationParametersUuid);
        assertEquals(candidateFormationParametersUuid, task.getCandidateFormationParametersUuid());
    }

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setPdotCoeficients()
    {
        task.setPdotCoeficients(pdotCoeficients);
        assertEquals(pdotCoeficients, task.getPdotCoeficients());
    }

    @Test
    void setMinimumTrackersPerCluster()
    {
        task.setMinimumTrackersPerCluster(minimumTrackersPerCluster);
        assertEquals(minimumTrackersPerCluster, task.getMinimumTrackersPerCluster());
    }

    @Test
    void setCoplanarCheckThreshold()
    {
        task.setCoplanarCheckThreshold(coplanarCheckThreshold);
        assertEquals(coplanarCheckThreshold, task.getCoplanarCheckThreshold());
    }

    @Test
    void setPeriodThreshold()
    {
        task.setPeriodThreshold(periodThreshold);
        assertEquals(periodThreshold, task.getPeriodThreshold());
    }
}