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
package atlas.event.aggregation.server;

import atlas.event.aggregation.server.wiring.GraphQlRuntimeWiringBuilder;
import graphql.schema.idl.RuntimeWiring;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class GraphQLServiceTest
{
    @Autowired
    GraphQLService graphQLService;

    @Test
    public void test()
    {
        GraphQLService service = ContextConfiguration.graphQLService();

        assertNull(service.getGraphQL());
        try
        {
            service.init();
        }
        catch (NullPointerException e)
        {
        }
    }

    @Configuration
    public static class ContextConfiguration
    {
        @Bean
        public static GraphQLService graphQLService()
        {
            TypeDefinitionRegistryBuilder registryBuilder = new TypeDefinitionRegistryBuilder();
            GraphQlRuntimeWiringBuilder runtimeWiringBuilder = new GraphQlRuntimeWiringBuilder()
            {
                @Override
                public RuntimeWiring buildRuntimeWiring()
                {
                    return null;
                }
            };
            GraphQLService service = new GraphQLService(registryBuilder, runtimeWiringBuilder);
            return service;
        }
    }
}