package homeworks.homework29.hwSelenidePO;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PCAndLaptopPageElement {

    SelenideElement laptops = $(byXpath("//*[contains(@href, 'c80004')]"));
}
