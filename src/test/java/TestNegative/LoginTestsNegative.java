package TestNegative;


import Pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestsNegative {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.goToLoginPage();
    }
    @Test
    public void unsuccessfulLogin() {
        loginPage.enterUsername("admin2");
        loginPage.enterPassword("parola123!");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alert\"]/dirv")));

        String alertText = alertElement.getText();
        assertTrue(alertText.contains("Warning: No match for E-Mail Address and/or Password"), "Popup text should contain Warning: No match for E-Mail Address and/or Password");


    }

}
