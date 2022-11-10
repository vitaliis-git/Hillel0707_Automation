package lesson29.pageObjSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPageElement {

    SelenideElement laptops = $(byXpath("//*[contains(@href, 'c80004')]"));

}
