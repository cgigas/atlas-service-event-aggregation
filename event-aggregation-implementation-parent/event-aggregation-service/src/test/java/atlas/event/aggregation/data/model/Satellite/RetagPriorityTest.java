package atlas.event.aggregation.data.model.Satellite;

import atlas.event.aggregation.GetterSetterTester;
import org.junit.Test;

public class RetagPriorityTest
{
    @Test
    public void test() throws Exception
    {
        GetterSetterTester tester = new GetterSetterTester()
        {
            @Override
            protected Object getInstance()
            {
                return new RetagPriority();
            }
        };
        tester.testGettersAndSetters();
    }
}