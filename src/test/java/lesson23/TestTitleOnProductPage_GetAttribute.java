package lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTitleOnProductPage_GetAttribute {

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
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement btnSearch = driver.findElement(By.xpath("//button[contains(@class, 'button button_color_green')]"));
        btnSearch.click();

        WebElement firstProduct = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='goods-tile__title']")));
        String titleOfFirstProduct = firstProduct.getText().trim();
        firstProduct.click();
        WebElement productPageTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));
        String productPageTitleText = productPageTitle.getAttribute("innerText").trim();
        Assert.assertEquals(titleOfFirstProduct, productPageTitleText, "Titles don't equal");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
