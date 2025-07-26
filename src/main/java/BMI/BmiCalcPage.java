package BMI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BmiCalcPage {
	@FindBy (how = How.ID, using = "heightCMS")
	private WebElement heightCMS;
	@FindBy (how = How.XPATH, using = "//input[@id='weightKg']")
	private WebElement weightKg;
	@FindBy (how = How.ID, using = "Calculate")
	private WebElement calculateButton;
	@FindBy(id = "bmi")
	private WebElement bmi;
	@FindBy(id="bmi_category")
	private WebElement bmiCategory;
	@FindBy(id = "error")
	private WebElement validationError;

	private WebDriver driver;
	private String url = "http://pragmatic.bg/automation/lecture15/bmicalculator.html";

	public BmiCalcPage() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Use this method to navigate your browser to the
	 * BMI Calculator page, it just opens the page.
	 */
	public void goTo() {
		driver.get(this.url);
	}

	/**
	 * This method fills the height and weight fields and then clicks
	 * the Calculate button to show u a result
	 * @param height the height you would like to put in the field
	 * @param weight the weight you would to be filled in field
	 */
	public void calculateBmi(String height, String weight) {
		heightCMS.sendKeys(height);
		weightKg.sendKeys(weight);
		calculateButton.click();
	}

	/**
	 * Asserts the expected BMI and BMI Category
	 * @param expectedBMI the body mass index u expect to be shown in your browser
	 * @param expectedBmiCategory the bmi category u expect to be shown in your browser
	 * @param messageOnFailure the message that will appear in your reports in case of test failure
	 */
	public void verifyExpectedBmiAndCategory(String expectedBMI, String expectedBmiCategory, String messageOnFailure) {
		Assert.assertEquals(bmi.getAttribute("value"), expectedBMI, messageOnFailure);
		Assert.assertEquals(bmiCategory.getAttribute("value"), expectedBmiCategory, messageOnFailure);
	}

	/**
	 * Asserts that the expected validation message appears properly
	 * based on wrong input in cm and kg
	 * @param expectedValidationMessage the validation message you expect to appear in the browser
	 * @param messageOnFailure the message that will appear in your tests reports in case of test failure
	 */
	public void verifyValidationMessage(String expectedValidationMessage, String messageOnFailure) {
		String actualValidationMessage = validationError.getText();
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage, messageOnFailure);
	}

	/**
	 * Quits the opened browser
	 */
	public void quit() {
		this.driver.quit();
	}


}
