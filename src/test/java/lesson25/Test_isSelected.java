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

public class Test_isSelected {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {
        WebElement login = driver.findElement(By.xpath("//li[contains(@class,'--user')]"));
        login.click();

        WebElement rememberCheckboxInput = driver.findElement(By.id("remember_me"));
        WebElement rememberCheckbox = driver.findElement(By.xpath("//label[@for='remember_me']"));

        System.out.println(rememberCheckboxInput.isSelected());

        rememberCheckbox.click();

        System.out.println(rememberCheckboxInput.isSelected());
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
