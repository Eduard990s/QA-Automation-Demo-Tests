package TestNegative;

import Pages.LoginPage;
import Utils.AllureUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Authentication")
@Feature("Login")
@ExtendWith(io.qameta.allure.junit5.AllureJunit5.class)
public class LogintNegativeTest {

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
    @Story("Login with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that login fails when the user provides invalid credentials")
    public void unsuccessfulLogin() {
        Allure.step("Perform login with invalid credentials", () -> {
            loginPage.enterUsername("admin2");
            loginPage.enterPassword("parola123!");
            loginPage.clickLogin();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alert\"]/dirv")));
            String alertText = alertElement.getText();

            AllureUtils.attachScreenshot(driver, "Screenshot after login attempt");



            assertTrue(alertText.contains("Warning: No match for E-Mail Address and/or Password"),
                    "Popup text should contain Warning: No match for E-Mail Address and/or Password");
        });
    }



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
