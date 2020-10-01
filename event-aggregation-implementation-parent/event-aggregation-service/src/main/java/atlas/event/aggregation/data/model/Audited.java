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
package atlas.event.aggregation.data.model;

import atlas.event.aggregation.data.model.ssaevent.Versioned;
import lombok.Data;

import java.util.Date;

@Data
public class Audited extends Versioned
{
    /**
     * Entry creation date..
     */
    private Date createDate;

    /**
     * Origin or source of the entry..
     */
    private String createOrigin;

    /**
     * Date of last update..
     */
    private Date updateDate;

    /**
     * Origin or source of the last update..
     */
    private String updateOrigin;
}
