package lesson28;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstTest {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
//        Configuration.timeout = 6000; // default - 4000ms
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest() {
        $(By.name("search"))
                .setValue("Mac");
//                .pressEnter();
        $(By.xpath("//button[contains(@class, 'button_color_green')]"))
                .shouldBe(visible)
                .shouldHave(text("Знайти"), Duration.ofSeconds(10))
                .shouldNotHave(text("Alex"))
                .shouldNotHave(value("Поиск в Google"))
                .shouldHave(attribute("required"))
                        .click();
        sleep(5000);
    }
}
