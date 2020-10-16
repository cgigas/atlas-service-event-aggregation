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
package atlas.event.crud.graphql.scalars;

import graphql.language.StringValue;
import graphql.scalars.util.Kit;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.util.Base64;

public class ByteArrayScalar extends GraphQLScalarType
{
    public ByteArrayScalar()
    {
        super("ByteArray", "A Base64 representation of a Byte array", new Coercing<byte[], String>()
        {

            @Override
            public String serialize(Object input) throws CoercingSerializeException
            {
                if (input instanceof byte[])
                {
                    return Base64.getEncoder().encodeToString((byte[])input);
                }
                else if (input instanceof String)
                {
                    return Base64.getEncoder().encodeToString(parseString((String)input));
                }
                throw new CoercingSerializeException("Expected a 'String' or 'byte[]' but was '" + Kit.typeName(input) + "'.");
            }

            @Override
            public byte[] parseValue(Object input) throws CoercingParseValueException
            {
                if (input instanceof byte[])
                {
                    return (byte[])input;
                }
                else if (input instanceof String)
                {
                    return parseString((String)input);
                }
                throw new CoercingParseLiteralException("Expected a 'String' or 'byte[]' but was '" + Kit.typeName(input) + "'.");
            }

            @Override
            public byte[] parseLiteral(Object input) throws CoercingParseLiteralException
            {
                if (!(input instanceof StringValue))
                {
                    throw new CoercingParseLiteralException("Expected AST type 'StringValue' but was '" + Kit.typeName(input) + "'.");
                }
                else
                {
                    return parseString(((StringValue)input).getValue());
                }
            }

            private byte[] parseString(String input)
            {
                try
                {
                    return Base64.getDecoder().decode(input);
                }
                catch (IllegalArgumentException e)
                {
                    throw new CoercingParseLiteralException("Expected a Base64 string", e);
                }
            }
        });
    }
}
