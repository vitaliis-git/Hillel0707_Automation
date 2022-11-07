package homeworks.homework25;

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

public class Test_CheckingAddingToCart {

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
        WebElement laptopsAndComp = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopsAndComp.click();

        WebElement laptops = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
        laptops.click();

        WebElement addToCart = driver.findElement(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]//button[contains(@class,'buy-button')]"));
        addToCart.click();

        WebElement goodsInCart = driver.findElement(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        String numberOfGoodsInCart = goodsInCart.getAttribute("innerText").trim();

        WebElement productPageTitle = driver.findElement(By.xpath("(//span[@class='goods-tile__title'])[1]"));
        String productPageTitleText = productPageTitle.getAttribute("innerText").trim();

        WebElement cartBtn = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']"));
        cartBtn.click();

        WebElement cartProductTitle = driver.findElement(By.xpath("//a[@class='cart-product__title']"));
        String cartProductTitleText = cartProductTitle.getAttribute("innerText").trim();

        Assert.assertEquals(numberOfGoodsInCart, "1", "Number of goods in the cart is displayed incorrect");
        Assert.assertEquals(productPageTitleText, cartProductTitleText, "Product titles don't equals");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
