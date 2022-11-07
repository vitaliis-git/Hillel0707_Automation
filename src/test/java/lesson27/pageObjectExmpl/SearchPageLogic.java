package lesson27.pageObjectExmpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageLogic {

    By firstProductTitle = (By.xpath("(//span[@class='goods-tile__title'])[1]"));
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String firstProductTitleText() {
        return driver.findElement(firstProductTitle).getText().trim();
    }

    public ProductPageLogic clickOnFirstProduct() {
        driver.findElement(firstProductTitle).click();
        return new ProductPageLogic(driver, wait);
    }
}
