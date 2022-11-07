package homeworks.homework28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideHomework1 {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {
        $(byXpath("//ul[contains(@class, 'categories_type_main')]/li[1]")).click();
        $(byXpath("//*[contains(@href, 'c80004')]")).click();
        $(byXpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]//button[contains(@class,'buy-button')]")).click();

        SelenideElement itemsInCart = $(byXpath("//span[@class='counter counter--green ng-star-inserted']"));
        String itemsInCartNumber = itemsInCart.text().trim();

        SelenideElement itemTitle = $(byXpath("(//span[@class='goods-tile__title'])[1]"));
        String itemTitleText = itemTitle.text().trim();

        $(byXpath("//button[contains(@class,'header__button--active')]")).click();

        SelenideElement cartItemTitle = $(byXpath("//a[@class='cart-product__title']"));
        String cartItemTitleText = cartItemTitle.text().trim();

        Assert.assertEquals(itemsInCartNumber, "1", "Number of goods in the cart is displayed incorrect");
        Assert.assertEquals(itemTitleText, cartItemTitleText, "Product titles don't equals");
    }
}
