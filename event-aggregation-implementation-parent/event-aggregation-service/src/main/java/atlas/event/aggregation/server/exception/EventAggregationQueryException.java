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
package atlas.event.aggregation.server.exception;

import com.google.common.collect.Maps;
import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This is a multi-purpose warning and error class that supports extensions that will be returned in server
 * responses. The extensions can be used to provide context and additional information to the client.
 * If an instance is initialized with an exception, it is classified as an error, otherwise a warning.
 */
public class EventAggregationQueryException extends RuntimeException implements GraphQLError
{
    private static final String EXCEPTION_TYPE = "exceptionType";
    private final EventAggregationExceptionCodes code;
    private Map<String, Object> extensions = Maps.newHashMap();

    /**
     * Construct a basic warning exception with no extensions.
     *
     * @param message the message to return to the client
     */
    public EventAggregationQueryException(String message)
    {
        super(message);
        this.code = null;
        addCode();
    }

    public EventAggregationQueryException(String message, EventAggregationExceptionCodes code)
    {
        super(message);
        this.code = code;
        addCode();
    }

    /**
     * Construct a warning exception (no cause)
     *
     * @param message    The message to return to the client
     * @param extensions optional map of additional information
     */
    public EventAggregationQueryException(String message, Map<String, Object> extensions)
    {
        super(message);
        this.extensions = extensions;
        this.code = null;
        addCode();
    }

    public EventAggregationQueryException(String message, EventAggregationExceptionCodes code, Map<String, Object> extensions)
    {
        super(message);
        this.code = code;
        this.extensions = extensions;
        addCode();
    }

    /**
     * Construct an error exception
     *
     * @param message    the message to return to the client
     * @param cause      the exception related to the error
     * @param extensions optional map of additional information
     */
    public EventAggregationQueryException(String message,
        Throwable cause,
        Map<String, Object> extensions)
    {
        super(message, cause);
        this.extensions = extensions;
        this.code = null;
        addCode();
    }

    @Override
    public List<SourceLocation> getLocations()
    {
        return Collections.emptyList();
    }

    @Override
    public ErrorClassification getErrorType()
    {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions()
    {
        return extensions;
    }

    public void setExtensions(Map<String, Object> ext)
    {
        this.extensions = ext;
    }

    public EventAggregationExceptionCodes getCode()
    {
        return this.code;
    }

    private void addCode()
    {
        if (extensions == null)
        {
            extensions = Maps.newHashMap();
        }
        // if we have an exception, we'll assume this should be classified as an error
        if (this.code != null)
        {
            extensions.put(EXCEPTION_TYPE, this.code);
        }
        else if (getCause() != null)
        {
            extensions.put(EXCEPTION_TYPE, EventAggregationExceptionCodes.ERROR);
        }
        else
        {
            extensions.put(EXCEPTION_TYPE, EventAggregationExceptionCodes.WARNING);
        }
    }
}
