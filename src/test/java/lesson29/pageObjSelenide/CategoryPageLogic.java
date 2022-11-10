package lesson29.pageObjSelenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic extends CategoryPageElement{

    public SearchPageLogic clickOnCategory(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(SearchPageLogic.class);
    }
}
