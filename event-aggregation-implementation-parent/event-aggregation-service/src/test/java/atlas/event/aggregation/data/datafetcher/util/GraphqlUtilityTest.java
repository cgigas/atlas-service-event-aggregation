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
import graphql.language.SelectionSet;
import graphql.language.StringValue;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class GraphqlUtilityTest
{
    GraphqlUtility task;
    Field stringField;
    List<Argument> arguments;
    Field argListField;
    SelectionSet selectionSet;
    Field selectionSetArgField;
    Field selSetField;

    @Before
    public void setUp()
    {
        task = new GraphqlUtility();
        stringField = new Field("Field");
        arguments = new ArrayList<>();
        arguments.add(new Argument("arg", new StringValue("arg")));
        arguments.add(new Argument("arg", new BooleanValue(true)));
        arguments.add(new Argument("arg", new IntValue(BigInteger.ONE)));
        arguments.add(new Argument("arg", new FloatValue(BigDecimal.ONE)));
        arguments.add(new Argument("arg", new EnumValue("Date")));
        java.util.List<graphql.language.ObjectField> objectFields = new ArrayList<>();
        objectFields.add(new ObjectField("strField", new StringValue("arg")));
        objectFields.add(new ObjectField("boolField", new BooleanValue(true)));
        arguments.add(new Argument("arg", new ObjectValue(objectFields)));
        ArrayList arrList = new ArrayList<>();
        arrList.add(new StringValue("arg"));
        arrList.add(new BooleanValue(true));
        arguments.add(new Argument("arg", new ArrayValue(arrList)));
        argListField = new Field("", arguments);
        java.util.Collection<graphql.language.Selection> selections = new ArrayList<>();
        selections.add(new Field("new"));
        selectionSet = new SelectionSet(selections);
        selectionSetArgField = new Field("", arguments, selectionSet);
        selSetField = new Field("", selectionSet);
    }

    @Test
    public void graphqlQueryStringFromField()
    {
        assertNotNull(task.graphqlQueryStringFromField(stringField));
        assertNotNull(task.graphqlQueryStringFromField(argListField));
        assertNotNull(task.graphqlQueryStringFromField(selectionSetArgField));
        assertNotNull(task.graphqlQueryStringFromField(selSetField));
    }

    @Test
    public void graphqlPartialQueryStringFromField()
    {
        assertNotNull(task.graphqlPartialQueryStringFromField(stringField));
        assertNotNull(task.graphqlPartialQueryStringFromField(argListField));
        assertNotNull(task.graphqlPartialQueryStringFromField(selectionSetArgField));
        assertNotNull(task.graphqlPartialQueryStringFromField(selSetField));
    }
}