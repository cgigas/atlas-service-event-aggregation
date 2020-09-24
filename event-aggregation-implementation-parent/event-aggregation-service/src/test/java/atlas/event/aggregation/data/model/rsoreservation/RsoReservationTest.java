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
        task.setParentRsoReservationUuid(parentRsoReservationUuid);
        assertEquals(parentRsoReservationUuid, task.getParentRsoReservationUuid());
    }

    @Test
    void setCategory()
    {
        task.setCategory(category);
        assertEquals(category, task.getCategory());
    }

    @Test
    void setLegacyCompatibleFlag()
    {
        task.setLegacyCompatibleFlag(legacyCompatibleFlag);
        assertEquals(legacyCompatibleFlag, task.getLegacyCompatibleFlag());
    }

    @Test
    void setTitle()
    {
        task.setTitle(title);
        assertEquals(title, task.getTitle());
    }

    @Test
    void setPosition()
    {
        task.setPosition(position);
        assertEquals(position, task.getPosition());
    }

    @Test
    void setSdaEventType()
    {
        task.setSdaEventType(sdaEventType);
        assertEquals(sdaEventType, task.getSdaEventType());
    }

    @Test
    void setMinSatNo()
    {
        task.setMinSatNo(minSatNo);
        assertEquals(minSatNo, task.getMinSatNo());
    }

    @Test
    void setMaxSatNo()
    {
        task.setMaxSatNo(maxSatNo);
        assertEquals(maxSatNo, task.getMaxSatNo());
    }

    @Test
    void setMinUcn()
    {
        task.setMinUcn(minUcn);
        assertEquals(minUcn, task.getMinUcn());
    }

    @Test
    void setMaxUcn()
    {
        task.setMaxUcn(maxUcn);
        assertEquals(maxUcn, task.getMaxUcn());
    }

    @Test
    void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void setReleaseableFlag()
    {
        task.setReleaseableFlag(releaseableFlag);
        assertEquals(releaseableFlag, task.getReleaseableFlag());
    }

    @Test
    void setDeletableFlag()
    {
        task.setDeletableFlag(deletableFlag);
        assertEquals(deletableFlag, task.getDeletableFlag());
    }

    @Test
    void setMinClassification()
    {
        task.setMinClassification(minClassification);
        assertEquals(minClassification, task.getMinClassification());
    }

    @Test
    void setMaxClassification()
    {
        task.setMaxClassification(maxClassification);
        assertEquals(maxClassification, task.getMaxClassification());
    }
}