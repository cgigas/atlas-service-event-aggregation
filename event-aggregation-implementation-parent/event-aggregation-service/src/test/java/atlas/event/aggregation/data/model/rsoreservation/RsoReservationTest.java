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
package atlas.event.aggregation.data.model.rsoreservation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RsoReservationTest
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
    public void setRsoReservationUuid()
    {
        task.setRsoReservationUuid(rsoReservationUuid);
        assertEquals(rsoReservationUuid, task.getRsoReservationUuid());
    }

    @Test
    public void setClassificationMarking()
    {
        task.setClassificationMarking(classificationMarking);
        assertEquals(classificationMarking, task.getClassificationMarking());
    }

    @Test
    public void setParentRsoReservationUuid()
    {
        task.setParentRsoReservationUuid(parentRsoReservationUuid);
        assertEquals(parentRsoReservationUuid, task.getParentRsoReservationUuid());
    }

    @Test
    public void setCategory()
    {
        task.setCategory(category);
        assertEquals(category, task.getCategory());
    }

    @Test
    public void setLegacyCompatibleFlag()
    {
        task.setLegacyCompatibleFlag(legacyCompatibleFlag);
        assertEquals(legacyCompatibleFlag, task.getLegacyCompatibleFlag());
    }

    @Test
    public void setTitle()
    {
        task.setTitle(title);
        assertEquals(title, task.getTitle());
    }

    @Test
    public void setPosition()
    {
        task.setPosition(position);
        assertEquals(position, task.getPosition());
    }

    @Test
    public void setSdaEventType()
    {
        task.setSdaEventType(sdaEventType);
        assertEquals(sdaEventType, task.getSdaEventType());
    }

    @Test
    public void setMinSatNo()
    {
        task.setMinSatNo(minSatNo);
        assertEquals(minSatNo, task.getMinSatNo());
    }

    @Test
    public void setMaxSatNo()
    {
        task.setMaxSatNo(maxSatNo);
        assertEquals(maxSatNo, task.getMaxSatNo());
    }

    @Test
    public void setMinUcn()
    {
        task.setMinUcn(minUcn);
        assertEquals(minUcn, task.getMinUcn());
    }

    @Test
    public void setMaxUcn()
    {
        task.setMaxUcn(maxUcn);
        assertEquals(maxUcn, task.getMaxUcn());
    }

    @Test
    public void setDescription()
    {
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    public void setReleaseableFlag()
    {
        task.setReleaseableFlag(releaseableFlag);
        assertEquals(releaseableFlag, task.getReleaseableFlag());
    }

    @Test
    public void setDeletableFlag()
    {
        task.setDeletableFlag(deletableFlag);
        assertEquals(deletableFlag, task.getDeletableFlag());
    }

    @Test
    public void setMinClassification()
    {
        task.setMinClassification(minClassification);
        assertEquals(minClassification, task.getMinClassification());
    }

    @Test
    public void setMaxClassification()
    {
        task.setMaxClassification(maxClassification);
        assertEquals(maxClassification, task.getMaxClassification());
    }
}