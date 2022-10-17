package lesson18;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OurFirstTest {

//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("executed method before test");
//    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("executed method before method");
    }

    @Test(description = "описание что делает тест", groups = "payments")
    public void firstTest() {
        System.out.println("opened google.com.ua");
    }

    @Test(alwaysRun = true)
    public void secondTest() {
        System.out.println("opened apple.com");
    }

    @Test(dependsOnMethods = "firstTest") //якщо firstTest не пройде, то цей тест не запуститься
    public void thirdTest() {
        System.out.println("opened hillel.com");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("executed method after test");
    }
}
