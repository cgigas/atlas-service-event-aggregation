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
package atlas.event.aggregation.config;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphQLWebAutoConfigurationTest
{
    GraphQLWebAutoConfiguration task = new GraphQLWebAutoConfiguration();

    String mapping = "map/*";

    @Test
    public void test()
    {
        task.setMapping(mapping);
        assertEquals(mapping, task.getMapping());
        assertEquals("map/*", task.getServletMapping());
        assertEquals("map/**", task.getCorsMapping());

        task.setMapping("map/**");
        assertEquals("map/*", task.getServletMapping());
        assertEquals("map/**", task.getCorsMapping());

        task.setMapping("map");
        assertEquals("map/*", task.getServletMapping());
        assertEquals("map/**", task.getCorsMapping());

        task.corsConfigurer();

        try
        {
            task.setMapping(null);
            task.getMapping();
        }
        catch (IllegalStateException e)
        {
            assertTrue(e.toString().contains("The property 'graphql.web.mapping' is undefined."));
        }
    }
}