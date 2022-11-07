package lesson28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideExmplMethods {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest() {
        SelenideElement findBtn = $(byXpath("//button[contains(@class, 'button_color_green')]"));
        String textFromFindBtn = findBtn.text();
        System.out.println(textFromFindBtn);

        String formActionAttrFromFindBtn = findBtn.attr("formAction");
        System.out.println(formActionAttrFromFindBtn);

        String backgroundFromFindBtn = findBtn.getCssValue("background-color");
        System.out.println(backgroundFromFindBtn);
    }
}
