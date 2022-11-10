package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageElement {

    SelenideElement pcAndLaptops = $(byXpath("//ul[contains(@class, 'categories_type_main')]/li[1]"));
}
