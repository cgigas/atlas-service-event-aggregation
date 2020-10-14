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
package atlas.event.aggregation.data.datafetcher.util;

import graphql.language.Argument;
import graphql.language.ArrayValue;
import graphql.language.BooleanValue;
import graphql.language.EnumValue;
import graphql.language.Field;
import graphql.language.FloatValue;
import graphql.language.IntValue;
import graphql.language.ObjectField;
import graphql.language.ObjectValue;
import graphql.language.StringValue;
import graphql.language.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GraphqlUtility
{

    public String graphqlQueryStringFromField(Field field)
    {
        StringBuilder sb = new StringBuilder();
        openSpecification(sb, false);
        addField(field, sb);
        closeSpecification(sb, false);
        return sb.toString();
    }

    public String graphqlPartialQueryStringFromField(Field field)
    {
        StringBuilder sb = new StringBuilder();
        addFieldSpecifications(field, sb);
        return sb.toString();
    }

    protected void addField(Field field, StringBuilder strBuilder)
    {
        strBuilder.append(' ').append(field.getName());
        addFieldArguments(field, strBuilder);
        addFieldSpecifications(field, strBuilder);
    }

    protected void addFieldSpecifications(Field field, StringBuilder strBuilder)
    {
        if (field.getSelectionSet() != null)
        {
            openSpecification(strBuilder, true);
            for (Field fieldNode : field.getSelectionSet().getSelectionsOfType(Field.class))
            {
                // recursively build the query string for the field
                addField(fieldNode, strBuilder);
            }
            closeSpecification(strBuilder, true);
        }

    }

    protected void addFieldArguments(Field field, StringBuilder strBuilder)
    {
        if (field.getArguments() != null && !field.getArguments().isEmpty())
        {
            strBuilder.append("(");
            boolean isFirst = true;
            for (Argument argument : field.getArguments())
            {
                if (!isFirst)
                {
                    strBuilder.append(", ");
                }
                addArgumentString(argument, strBuilder);
                isFirst = false;
            }
            strBuilder.append(") ");
        }
    }

    protected void addArgumentString(Argument argument, StringBuilder strBuilder)
    {
        strBuilder.append(argument.getName()).append(": ");
        addValueString(argument.getValue(), strBuilder);
    }

    /**
     * This is nearly identical to addArgumentString because Argument and ObjectField are very similar
     * but neither share and interface that exposes getValue()
     *
     * @param field      the field to render
     * @param strBuilder the StringBuilder to render to.
     */
    protected void addObjectFieldString(ObjectField field, StringBuilder strBuilder)
    {
        strBuilder.append(field.getName()).append(": ");
        addValueString(field.getValue(), strBuilder);
    }

    protected void addValueString(Value<?> value, StringBuilder strBuilder)
    {
        Class<?> valueClass = value.getClass();
        if (valueClass.isAssignableFrom(StringValue.class))
        {
            strBuilder.append('"').append(((StringValue) value).getValue()).append('"');
        }
        else if (valueClass.isAssignableFrom(BooleanValue.class))
        {
            strBuilder.append(((BooleanValue) value).isValue());
        }
        else if (valueClass.isAssignableFrom(IntValue.class))
        {
            strBuilder.append(((IntValue) value).getValue());
        }
        else if (valueClass.isAssignableFrom(FloatValue.class))
        {
            strBuilder.append(((FloatValue) value).getValue());
        }
        else if (valueClass.isAssignableFrom(EnumValue.class))
        {
            strBuilder.append(((EnumValue) value).getName());
        }
        else if (valueClass.isAssignableFrom(ObjectValue.class))
        {
            ObjectValue objectValue = (ObjectValue) value;
            openSpecification(strBuilder, false);
            boolean isFirst = true;
            for (ObjectField objectField : objectValue.getObjectFields())
            {
                if (!isFirst)
                {
                    strBuilder.append(", ");
                }
                addObjectFieldString(objectField, strBuilder);
                isFirst = false;
            }
            closeSpecification(strBuilder, false);
        }
        else if (valueClass.isAssignableFrom(ArrayValue.class))
        {
            ArrayValue arrayValue = (ArrayValue) value;
            strBuilder.append(" [");
            boolean isFirst = true;
            for (Value<?> v : arrayValue.getValues())
            {
                if (!isFirst)
                {
                    strBuilder.append(", ");
                }
                addValueString(v, strBuilder);
                isFirst = false;
            }
            strBuilder.append("]");
        }
    }

    protected void openSpecification(StringBuilder strBuilder, boolean nested)
    {
        if (nested)
        {
            strBuilder.append(' ');
        }
        strBuilder.append("{ ");
    }

    protected void closeSpecification(StringBuilder strBuilder, boolean nested)
    {
        strBuilder.append(" }");
        if (nested)
        {
            strBuilder.append(' ');
        }
    }
}
