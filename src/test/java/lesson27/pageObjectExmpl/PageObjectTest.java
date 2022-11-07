package lesson27.pageObjectExmpl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class PageObjectTest {

    // На главной странице в интпут ввести Mac
    // Сохранить тайтл первого товара в поисковой выдаче
    // Перейти на продуктовую страницу первого товара
    // Проверить, что тайтл на поисковой выдаче соответствует тайтлу на продуктовой странице

    private WebDriver driver;
    private WebDriverWait wait;
    final String URL = "https://rozetka.com.ua/ua/";

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @Test
    public void rozetkaTest() throws InterruptedException {
        new MainPageLogic(driver, wait)
                .typeTextToSearchInput("Mac")
                .clickFindBtn();

        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);
        String titleFromSearch = searchPageLogic.firstProductTitleText();
        searchPageLogic.clickOnFirstProduct();

        String titleTextFromProductPage = new ProductPageLogic(driver, wait).getTitleText();

        Assert.assertEquals(titleFromSearch, titleTextFromProductPage);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
