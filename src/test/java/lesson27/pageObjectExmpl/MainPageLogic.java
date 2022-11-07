package lesson27.pageObjectExmpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {
    By searchInput = (By.name("search"));
    By findBtn = (By.xpath("//button[contains(@class, 'button_color_green')]"));

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MainPageLogic typeTextToSearchInput(String text) {
        driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public SearchPageLogic clickFindBtn() {
        driver.findElement(findBtn).click();
        return new SearchPageLogic(driver, wait);
    }
}
