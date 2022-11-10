package lesson29.pageObjSelenide;

import com.codeborne.selenide.CollectionCondition;

public class SearchPageLogic extends SearchPageElement {

    public SearchPageLogic checkProductQty(int size) {
        titles.shouldHave(CollectionCondition.size(size));
        return this;
    }
}
