package lesson29.pageObjSelenide;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPageElement {

    ElementsCollection titles = $$(byXpath("//span[@class='goods-tile__tile']"));

}
