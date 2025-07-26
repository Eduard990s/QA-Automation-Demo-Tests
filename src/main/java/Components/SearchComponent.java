package Components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the search component on the webpage,
 * providing methods to enter a brand name and trigger the search.
 */
public class SearchComponent {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='search']/input")
    private WebElement brandInput;

    @FindBy(xpath = "//*[@id='search']/button")
    private WebElement searchButton;

    /**
     * Constructor that initializes the SearchComponent and its web elements.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public SearchComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the given brand name into the search input field.
     *
     * @param brand the brand name to search for
     */
    public void enterBrand(String brand) {
        brandInput.sendKeys(brand);
    }

    /**
     * Clicks the search button to submit the search query.
     */
    public void clickSearch() {
        searchButton.click();
    }

}
