package lesson22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class FirstTest {

    @Test
    public void currentTest() {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание
        driver.get("https://google.com.ua/");
        WebElement elementSearch = (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.className("search"))));//явное ожидание (плохая практика)
        elementSearch.click();
        driver.findElement(By.xpath("search")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://google.com.ua/");
        WebElement elementSearch1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("search")));
    }
}

