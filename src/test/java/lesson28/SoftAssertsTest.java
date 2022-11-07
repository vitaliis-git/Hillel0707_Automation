package lesson28;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertsTest {

    @Test(enabled = false)
    public void testCaseOne() {
        System.out.println("*** test case one started ***");
        Assert.assertEquals(5, 5);
        System.out.println("hard assert is success...");
        Assert.assertTrue("Hello".equals("hello"));
        System.out.println("*** test case is executed successfully ***");
    }

    @Test
    public void testcaseTwo() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("*** test case one started ***");
        softAssert.assertEquals(5,5);
        System.out.println("hard assert is success...");
        softAssert.assertTrue("Hello".equals("hello"));
        System.out.println("*** test case is executed successfully ***");
        softAssert.assertAll();
    }

}
