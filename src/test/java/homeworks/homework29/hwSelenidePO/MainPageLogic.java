package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElement{

    public PCAndLaptopsPageLogic clickCompANDLaptops(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(PCAndLaptopsPageLogic.class);
    }
}
