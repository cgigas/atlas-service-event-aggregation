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
import graphql.GraphQL;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
@Service
@Order(Ordered.HIGHEST_PRECEDENCE) // This should help ensure that this bean is initialized later than others
public class GraphQLService
{
    private final TypeDefinitionRegistryBuilder registryBuilder;
    private final GraphQlRuntimeWiringBuilder runtimeWiringBuilder;
    private GraphQL graphQL;
    Logger log = LoggerFactory.getLogger(TypeDefinitionRegistryBuilder.class);

    @Autowired
    public GraphQLService(TypeDefinitionRegistryBuilder registryBuilder,
            GraphQlRuntimeWiringBuilder runtimeWiringBuilder)
    {
        this.registryBuilder = registryBuilder;
        this.runtimeWiringBuilder = runtimeWiringBuilder;
    }

    @PostConstruct
    public void init()
    {
        try
        {

            RuntimeWiring runtimeWiring = runtimeWiringBuilder.buildRuntimeWiring();
            TypeDefinitionRegistry registry = registryBuilder.buildRegistryFrom("classpath:graphql/*.graphql");
            SchemaGenerator schemaGenerator = new SchemaGenerator();

            //log.info("Initializing graphql query and mutation processing engine.");
            GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(registry, runtimeWiring);
            // Turn on instrumentation for query tracing in GraphQL Playground, etc.
            this.graphQL = GraphQL.newGraphQL(graphQLSchema)
                    .instrumentation(new TracingInstrumentation())
                    .build();
        }
        catch (IllegalStateException | IOException e)
        {
            // log the error and abort the application
            //log.error("Error initializing the Satellite Query GraphQL service. Aborting startup.", e);
            log.error(e.getMessage(), e);
            throw new IllegalStateException("Unable to initialize the Satellite Query Service");
        }
    }

    @Bean
    public GraphQL getGraphQL()
    {
        return graphQL;
    }
}
