package atlas.event.aggregation.data.model.Satellite;

import atlas.event.aggregation.GetterSetterTester;
import org.junit.Test;

public class SatObsAssociationControlTest
{
    @Test
    public void test() throws Exception
    {
        GetterSetterTester tester = new GetterSetterTester()
        {
            @Override
            protected Object getInstance()
            {
                return new SatObsAssociationControl();
            }
        };
        tester.testGettersAndSetters();
    }
}