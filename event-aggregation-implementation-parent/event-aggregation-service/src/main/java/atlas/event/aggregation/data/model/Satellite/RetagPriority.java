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
package atlas.event.aggregation.data.model.Satellite;

import org.joda.time.DateTime;

public class RetagPriority
{
    String retagPriorityUuid;
    String classificationMarking;
    int retagPriority;
    String priorityName;
    AssociationStatus astatThreshold;
    Boolean enabled;
    Boolean obtype0;
    Boolean obtype1;
    Boolean obtype2;
    Boolean obtype3;
    Boolean obtype4;
    Boolean obtype5;
    Boolean obtype6;
    Boolean obtype7;
    Boolean obtype8;
    Boolean obtype9;
    Float minChiMeasureThreshold;
    Float minGpVmagThreshold;
    Float minSpVmagThreshold;
    Float gpDeltaTimeThreshold;
    Float gpDeltaBetaThreshold;
    Float gpDeltaHeightThreshold;
    Float spDeltaTimeThreshold;
    Float spDeltaBetaThreshold;
    Float spDeltaHeightThreshold;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
