package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class PCAndLaptopsPageLogic extends PCAndLaptopPageElement {

    public LaptopsPageLogic clickOnLaptops(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(LaptopsPageLogic.class);
    }
}
