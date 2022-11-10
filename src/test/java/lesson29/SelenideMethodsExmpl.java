package lesson29;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SelenideMethodsExmpl {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1720x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void example() {
        String contentUrl = url();
        System.out.println(contentUrl);

        String source = source();
        System.out.println(source);
    }
}
