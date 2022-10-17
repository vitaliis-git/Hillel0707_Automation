package lesson19;

import org.testng.annotations.Test;

public class OurSecondTest {

    @Test(groups = {"regression"})
    public void ourThirdTest(){
        System.out.println("It is third test method");
    }
}
