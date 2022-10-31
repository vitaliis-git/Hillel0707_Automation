package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_Select {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(element);
        dropdown.selectByValue("1");
        TimeUnit.SECONDS.sleep(5);
        dropdown.selectByIndex(2);
        TimeUnit.SECONDS.sleep(5);

    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
