package homeworks.homework24;

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

import static java.lang.Thread.sleep;

public class TestCheckingTopSalesBadge {

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
    public void rozetkaTest() throws InterruptedException {
        WebElement PcAndLaptops = driver.findElement(By.xpath("//a[@class='menu-categories__link']"));
        PcAndLaptops.click();

        WebElement Laptops = driver.findElement(By.xpath("//a[@title='Ноутбуки']"));
        Laptops.click();

        WebElement SellerRozetka = driver.findElement(By.xpath("//a[@data-id='Rozetka']"));
        SellerRozetka.click();

        WebElement PriceLimitInput = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class='slider-filter__inner']/input[2]")));
        PriceLimitInput.clear();
        PriceLimitInput.sendKeys("100000");

        WebElement SubmitBtn = driver.findElement(By.xpath("//button[@class='button button_color_gray button_size_small slider-filter__button']"));
        SubmitBtn.click();

        WebElement FirstProduct = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='goods-tile__title']")));
        FirstProduct.click();

        WebElement TopSalesBadge = driver.findElement(By.xpath("//rz-label[@class='main-slider__label ng-star-inserted']"));
        Assert.assertTrue(TopSalesBadge.isDisplayed(), "Top Sales badge doesn't appear");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
