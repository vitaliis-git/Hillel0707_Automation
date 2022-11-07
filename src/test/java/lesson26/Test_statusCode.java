package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_statusCode {

//    private WebDriver driver;
//    private WebDriverWait wait;

//    @BeforeMethod
//    public void before(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @Test
    public void selectTest() throws InterruptedException, IOException {
        HttpURLConnection c = (HttpURLConnection)
                new URL("http://the-internet.herokuapp.com/status_codes/200").openConnection();
        c.connect();
        int statusCode = c.getResponseCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
