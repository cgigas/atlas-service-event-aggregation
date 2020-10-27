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
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class GraphQLServiceTest
{
    @Autowired
    ResourceLoader resourceLoader;
    TypeDefinitionRegistryBuilder registryBuilder = new TypeDefinitionRegistryBuilder(resourceLoader);
    @Mock
    GraphQlRuntimeWiringBuilder runtimeWiringBuilder = mock(GraphQlRuntimeWiringBuilder.class, Mockito.CALLS_REAL_METHODS);
    GraphQLService task;

    @Test(expected = NullPointerException.class)
    public void test() throws IOException
    {
        task = new GraphQLService(registryBuilder, runtimeWiringBuilder);
        assertNotNull(task);
        task.init();
        assertNotNull(task.getGraphQL());
    }

}