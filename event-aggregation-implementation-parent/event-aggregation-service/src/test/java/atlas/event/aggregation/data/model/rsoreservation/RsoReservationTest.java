package atlas.event.aggregation.data.model.rsoreservation;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class RsoReservationTest
{
    RsoReservation task = new RsoReservation();
    String rsoReservationUuid = "rsoReservationUuid";
    String classificationMarking = "classificationMarking";
    String parentRsoReservationUuid = "parentRsoReservationUuid";
    String category = "category";
    Float legacyCompatibleFlag = Float.valueOf("1");
    String title = "title";
    String position = "position";
    String sdaEventType = "sdaEventType";
    Integer minSatNo = 2;
    Integer maxSatNo = 3;
    Integer minUcn = 4;
    Integer maxUcn = 5;
    String description = "description";
    String releaseableFlag = "releaseableFlag";
    Float deletableFlag = Float.valueOf("6");
    Integer minClassification = 7;
    Integer maxClassification = 8;

    @Test
    void setRsoReservationUuid()
    {
        task.setRsoReservationUuid(rsoReservationUuid);
        assertEquals(rsoReservationUuid, task.getRsoReservationUuid());
    }

    @Test
    void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    void setParentRsoReservationUuid()
    {
    }

    @Test
    void setCategory()
    {
    }

    @Test
    void setLegacyCompatibleFlag()
    {
    }

    @Test
    void setTitle()
    {
    }

    @Test
    void setPosition()
    {
    }

    @Test
    void setSdaEventType()
    {
    }

    @Test
    void setMinSatNo()
    {
    }

    @Test
    void setMaxSatNo()
    {
    }

    @Test
    void setMinUcn()
    {
    }

    @Test
    void setMaxUcn()
    {
    }

    @Test
    void setDescription()
    {
    }

    @Test
    void setReleaseableFlag()
    {
    }

    @Test
    void setDeletableFlag()
    {
    }

    @Test
    void setMinClassification()
    {
    }

    @Test
    void setMaxClassification()
    {
    }
}