package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_keys {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void selectTest() throws InterruptedException, IOException {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "mac"));

        TimeUnit.SECONDS.sleep(5);

        WebElement btnSearch = driver.findElement(By.xpath("//*[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
        btnSearch.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);


    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
