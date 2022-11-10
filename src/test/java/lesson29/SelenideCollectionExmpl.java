package lesson29;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideCollectionExmpl {

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void example() {
        ElementsCollection sideBarMenu = $$(byXpath("//a[@class='menu-categories__link']"));
        int sizeCollection = sideBarMenu.size();
        System.out.println(sizeCollection);

        String text = sideBarMenu.get(1).getText();
        System.out.println(text);

        ElementsCollection sideBarMenuWithFilter = sideBarMenu.filterBy(Condition.text("Смартфони, ТВ і електроніка"));
        System.out.println(sideBarMenuWithFilter.size() + " sideBarMenuWithFilter size");

        sideBarMenu.shouldHave(CollectionCondition.size(16));
    }
}
