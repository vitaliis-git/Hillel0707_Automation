package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Main {
    LaptopsPageLogic laptopsPageLogic = new LaptopsPageLogic();
    CartPageLogic cartPageLogic = new CartPageLogic();
    private final MainPageLogic MAIN_PAGE_LOGIC = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1720x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {
        MAIN_PAGE_LOGIC
                .clickCompANDLaptops(MAIN_PAGE_LOGIC.pcAndLaptops)
                .clickOnLaptops(new PCAndLaptopsPageLogic().laptops)
                .clickOnBuyBtn(new LaptopsPageLogic().addToCartBtn);

        Assert.assertEquals(laptopsPageLogic.cartProductsNumber(), "1", "Number of goods in the cart is displayed incorrect");

        laptopsPageLogic.clickOnCartBtn(laptopsPageLogic.cartBtn);

        Assert.assertEquals(laptopsPageLogic.itemTitleText(), cartPageLogic.cartItemTitleText(), "Product titles don't equals");
    }
}
