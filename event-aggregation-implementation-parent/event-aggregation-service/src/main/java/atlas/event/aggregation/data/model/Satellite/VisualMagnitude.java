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

public class VisualMagnitude
{
    String visualMagnitudeUuid;
    String classificationMarking;
    String satelliteUuid;
    int sensorNumber;
    DateTime reportDt;
    Float observedMv;
    Float normKm36000;
    Float solarPhaseAngle;
    Float solarDeclinationAngle;
    DateTime createDate;
    String createOrigin;
    DateTime updateDate;
    String updateOrigin;
    Long version;
}
