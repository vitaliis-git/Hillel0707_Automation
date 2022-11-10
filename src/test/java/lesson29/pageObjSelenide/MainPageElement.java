package lesson29.pageObjSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageElement {

    ElementsCollection sideBarMenu = $$(byXpath("//a[@class='menu-categories__link']"));
    SelenideElement compAndLaptops = $(byXpath("//ul[contains(@class, 'categories_type_main')]/li[1]"));
}
