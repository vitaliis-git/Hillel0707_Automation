package lesson19;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryClassExmpl {

    @Factory()
    @Test
    public Object[] getFactoryTests() {
        Object[] factory = new Object[2];
        factory[0] = new OurFirstTest();
        factory[1] = new OurSecondTest();
        return factory;
    }
}
