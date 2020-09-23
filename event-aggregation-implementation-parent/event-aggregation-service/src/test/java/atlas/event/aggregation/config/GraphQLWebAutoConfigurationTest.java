package atlas.event.aggregation.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphQLWebAutoConfigurationTest
{
    GraphQLWebAutoConfiguration task = new GraphQLWebAutoConfiguration();

    String mapping = "map/*";

    @Test
    void test()
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