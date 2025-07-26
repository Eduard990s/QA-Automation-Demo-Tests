package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the login page of the application.
 * Provides methods to interact with login elements such as username, password, and login button.
 */
public class LoginPage {


    private WebDriver driver;
    private String loginUrl = "https://auto.pragmatic.bg/index.php?route=account/login&language=en-gb";

    @FindBy(id = "input-email")
    private WebElement usernameInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"form-login\"]/div[3]/button")
    private WebElement loginButton;


    /**
     * Constructor initializes web elements using PageFactory.
     * @param driver the WebDriver instance to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Method that opens the Login Page url.
     */
    public void goToLoginPage() {
        driver.get(loginUrl);
    }
    /**
     * Enters the username into the username input field.
     * @param username the username or email to enter
     */
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }
    /**
     * Enters the password into the password input field.
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    /**
     * Clicks the login button to submit the login form.
     */
    public void clickLogin() {
        loginButton.click();
    }



}
