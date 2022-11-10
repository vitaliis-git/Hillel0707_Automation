package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class LaptopsPageLogic extends LaptopPageElement{

    public LaptopsPageLogic clickOnBuyBtn(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return this;
    }

    public String cartProductsNumber() {
        return itemsInCart.text().trim();
    }

    public String itemTitleText() {
        return itemTitle.text().trim();
    }

    public CartPageLogic clickOnCartBtn(SelenideElement button) {
        button.shouldBe(Condition.visible);
        button.click();
        return page(CartPageLogic.class);
    }
}
