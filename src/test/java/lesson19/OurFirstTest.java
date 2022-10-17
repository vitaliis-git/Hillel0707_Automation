package lesson19;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFirstTest {

    @Parameters({"username", "password"})
    @Test(groups = {"regression", "smoke"})
    public void firstTestMethod(String user, String pass){
        System.out.println("It is first test method");
        System.out.println(user);
        System.out.println(pass);
    }

    @Test
    public void secondTestMethod(){
        System.out.println("It is second test method");
    }
}
