package Pages;

import Components.SearchComponent;
import org.openqa.selenium.WebDriver;
/**
 * Represents the Home Page of the application.
 * Provides access to components and elements on the home page.
 */
public class HomePage {
    private WebDriver driver;
    private SearchComponent searchComponent;
    /**
     * Constructor that initializes the HomePage with the given WebDriver instance.
     * Also initializes the SearchComponent.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        searchComponent = new SearchComponent(driver);
    }

    /**
     * Returns the Search Component instante to allow interaction with the search feture.
     * @return the SearchComponent of the Home Page
     */
    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
}
