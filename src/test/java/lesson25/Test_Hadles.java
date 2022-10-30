package lesson25;

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

public class Test_Hadles {

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
    public void rozetkaTest() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath("//li[contains(@class,'--user')]"));
        login.click();

        WebElement reg = driver.findElement(By.xpath("//button[contains(@class,'register-link')]"));
        reg.click();

        WebElement privacyPolicy = driver.findElement(By.xpath("//a[contains(@class,'button--link')]"));
        privacyPolicy.click();

        String mainTab = driver.getWindowHandle();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        TimeUnit.SECONDS.sleep(5);

        driver.switchTo().window(mainTab);

        TimeUnit.SECONDS.sleep(5);
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
