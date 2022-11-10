package lesson29.pageObjSelenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    // Перейти на главную страницу https://rozetka.com.ua/ua/
    // Кликнуть на категорию Кппьютеры и ноутбуки
    // Кликнуть на категорию Ноутбуки
    // Проверить, что в поисковой выдаче на первой странице пагинации отобразилось 60 товаров

    private final MainPageLogic MAIN_PAGE_LOGIC = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1720x1080";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void example() {
        MAIN_PAGE_LOGIC
                .checkCategoryQty(16)
                .clickOnCategory(MAIN_PAGE_LOGIC.compAndLaptops)
                .clickOnCategory(new CategoryPageLogic().laptops)
                .checkProductQty(60);
    }
}
