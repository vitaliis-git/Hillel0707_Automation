package lesson19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTestRun {

    private WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void firstRun() {
        driver.get("https://google.com/");
        WebElement buttonSearch = driver.findElement(By.name("btnK"));
        buttonSearch.click();

        WebElement logo = driver.findElement(By.cssSelector("img[alt='Rozetka Logo']"));
        WebElement searchButton = driver.findElement(By.cssSelector("button.search-form__submit[_ngcontent-rz-client-c98]"));
        WebElement autenticationPopup = driver.findElement(By.cssSelector("button.header__button"));
        WebElement logo1 = driver.findElement(By.xpath("//img[@alt='Rozetka Logo']"));
        WebElement searchButton1 = driver.findElement(By.xpath("//*[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
        WebElement autenticationPopup1 = driver.findElement(By.xpath("//*[@class='header__button ng-star-inserted']"));
    }
}
