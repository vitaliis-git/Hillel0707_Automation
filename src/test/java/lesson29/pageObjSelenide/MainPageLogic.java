package lesson29.pageObjSelenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElement {

    public MainPageLogic checkCategoryQty(int size) {
        sideBarMenu.shouldHave(CollectionCondition.size(size));
        return this;
    }

    public CategoryPageLogic clickOnCategory(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(CategoryPageLogic.class);
    }
}
