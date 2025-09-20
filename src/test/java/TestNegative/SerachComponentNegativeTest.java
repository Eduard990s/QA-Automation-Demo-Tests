package TestNegative;

import Components.SearchComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SerachComponentNegativeTest {

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
    public void testSearchNonExistentProduct() {
        SearchComponent searchComponent = new SearchComponent(driver);
        searchComponent.enterBrand("Bmw");
        searchComponent.clickSearch();

        WebElement resultElement = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/p"));
        String productName = resultElement.getText();

        assertTrue(productName != null && productName.toLowerCase().equals("there is no product that matches the search criteria."),
                "Expected product name to contain 'iPhone', but was: " + productName);
    }
    @Test
    public void testSearchEmptyInput() {
        SearchComponent searchComponent = new SearchComponent(driver);

        searchComponent.enterBrand("");
        searchComponent.clickSearch();

        WebElement messageElement = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/p"));
        String messageText = messageElement.getText();

        assertTrue(messageText.toLowerCase().contains("there is no product that matches the search criteria.") ,
                "Expected message for empty search input, but was: " + messageText);
    }

        @AfterEach
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

