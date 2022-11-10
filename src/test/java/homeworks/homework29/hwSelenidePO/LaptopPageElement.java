package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LaptopPageElement {

    SelenideElement addToCartBtn = $(byXpath("//ul[@class='catalog-grid ng-star-inserted']/li[1]//button[contains(@class,'buy-button')]"));
    SelenideElement itemTitle = $(byXpath("(//span[@class='goods-tile__title'])[1]"));
    SelenideElement itemsInCart = $(byXpath("//span[@class='counter counter--green ng-star-inserted']"));
    SelenideElement cartBtn = $(byXpath("//button[contains(@class,'header__button--active')]"));
}
