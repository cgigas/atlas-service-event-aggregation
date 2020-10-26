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
package atlas.event.aggregation.data.access.accessor.exception;

public class DataAccessorException extends RuntimeException
{
    public DataAccessorException()
    {
        super();
    }

    public DataAccessorException(String message)
    {
        super(message);
    }

    public DataAccessorException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DataAccessorException(Throwable cause)
    {
        super(cause);
    }

    protected DataAccessorException(String message,
        Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
