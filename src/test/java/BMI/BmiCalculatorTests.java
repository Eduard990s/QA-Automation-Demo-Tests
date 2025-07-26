package BMI;

import org.testng.annotations.Test;

public class BmiCalculatorTests {

	@Test
	public void anotherTest() {
		BmiCalcPage calcPage = new BmiCalcPage();
		calcPage.goTo();
		calcPage.calculateBmi("187", "91");
		calcPage.verifyExpectedBmiAndCategory(
				"26.0",
				"Overweight",
				"the calculation of BMI and Cat was not wright");
		calcPage.quit();
	}


	@Test
	public void successfulBmiTest() {
		BmiCalcPage calcPage = new BmiCalcPage();
		calcPage.goTo();
		calcPage.calculateBmi("234", "3242");
		calcPage.verifyExpectedBmiAndCategory("234232", "blbal", "dsfadsfasf");
		calcPage.quit();
	}











}
