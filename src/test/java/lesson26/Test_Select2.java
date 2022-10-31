package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_Select2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.autodoc.de/");
    }

    @Test
    public void selectTest() throws InterruptedException {
        selectOption(driver,"5");

        TimeUnit.SECONDS.sleep(5);
    }

    public void selectOption(WebDriver driver, String option) {
        WebElement makerList = driver.findElement(By.id("form_maker_id"));
        String makerListOption = String.format("//select[@id='form_maker_id']/optgroup[2]/option[@value='%s']", option);
        makerList.click();
        driver.findElement(By.xpath(makerListOption)).click();
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
