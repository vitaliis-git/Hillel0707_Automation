package lesson24;

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

import java.time.Duration;

public class Test_SubmitBtn {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void submitTest() throws InterruptedException {
        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.sendKeys("QA");

        WebElement btnSearch = driver.findElement(By.name("btnK"));

        if (btnSearch.getAttribute("value").equals("Поиск в Google")) {
            btnSearch.submit();
        } else {
            Assert.fail();
        }
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
