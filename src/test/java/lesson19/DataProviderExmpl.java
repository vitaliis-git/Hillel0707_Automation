package lesson19;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExmpl {

    @DataProvider(name = "routes", parallel = true)
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"route1, www.ithillel.ua/contacts"}, {"route2, www.ithillel.ua"}};
    }

    @Test(dataProvider = "routes")
    public void testCheckingLogo(String data) {
        System.out.println("Test started with data: " + data);
        System.out.println("Checking logo");
    }
}
