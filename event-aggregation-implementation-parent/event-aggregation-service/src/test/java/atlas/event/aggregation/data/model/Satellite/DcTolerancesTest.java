package atlas.event.aggregation.data.model.Satellite;

import atlas.event.aggregation.GetterSetterTester;
import org.junit.Test;

import static org.junit.Assert.*;

public class DcTolerancesTest
{
    @Test
    public void test() throws Exception
    {
        GetterSetterTester tester = new GetterSetterTester()
        {
            @Override
            protected Object getInstance()
            {
                return new DcTolerances();
            }
        };
        tester.testGettersAndSetters();
    }
}