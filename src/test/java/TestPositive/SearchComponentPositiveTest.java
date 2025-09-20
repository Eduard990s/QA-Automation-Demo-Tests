package TestPositive;

import Components.SearchComponent;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchComponentPositiveTest {
    private WebDriver driver;

    private final String Base_URL = "http://auto.pragmatic.bg/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(Base_URL);
    }
    @Test
    public void testSearchIphone() {
        SearchComponent searchComponent = new SearchComponent(driver);
        searchComponent.enterBrand("iPhone");
        searchComponent.clickSearch();

        WebElement resultElement = driver.findElement(By.xpath("//*[@id=\"product-list\"]/div/div/div[2]/div/h4/a"));
        String productName = resultElement.getText();

        assertTrue(productName != null && productName.toLowerCase().contains("iphone"),
                "Expected product name to contain 'iPhone', but was: " + productName);
    }
    @Test
    public void testSearchWithPartialName() {
        SearchComponent searchComponent = new SearchComponent(driver);
        searchComponent.enterBrand("ip");
        searchComponent.clickSearch();

        WebElement resultElement = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[5]/div[1]/div/div[2]/div/h4/a"));
        String productName = resultElement.getText();

        assertTrue(productName != null && productName.toLowerCase().contains("iphone"),
                "Expected product name to contain 'iPhone', but was: " + productName);
    }



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
