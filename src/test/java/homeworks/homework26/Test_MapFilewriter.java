package homeworks.homework26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.String.valueOf;

public class Test_MapFilewriter {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws InterruptedException, IOException {
        WebElement pcAndLaptops = driver.findElement(By.xpath("//ul[contains(@class, 'menu-categories_type_main')]/li[1]"));
        pcAndLaptops.click();

        WebElement laptops = driver.findElement(By.xpath("//ul[@class='portal-grid portal-grid_type_1_6']/li[1]"));
        laptops.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='header__button ng-star-inserted']")));

        List<WebElement> itemTitles = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        List<WebElement> itemPrices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));

        Map<String, String> itemsList = mapping(itemTitles, itemPrices);
        addToFile(itemsList);
    }

    private static Map<String, String> mapping(List<WebElement> titles, List<WebElement> prices) {
        Map<String, String> itemsList = new LinkedHashMap<>();
        if (titles.size() == prices.size()) {
            for (int i = 0; i < titles.size()-1; i++) {
                String tempTitle = titles.get(i).getAttribute("innerText").replace(valueOf((char) 160),"");
                String tempPrice = prices.get(i).getText().replace(valueOf((char) 160),"");
                itemsList.put(tempTitle, tempPrice);
            }
    }
        return itemsList;
}

    private static void addToFile (Map<String, String> itemsList) throws IOException {
        FileWriter fileWriter = new FileWriter("rozetkaTest.txt");
        for (Map.Entry<String, String> item : itemsList.entrySet()) {
            fileWriter.write(item.getKey() + " - " + item.getValue() + " грн." + "\n");
        }
        fileWriter.close();
}

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
