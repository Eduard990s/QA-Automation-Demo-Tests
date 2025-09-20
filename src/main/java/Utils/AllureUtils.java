package Utils;



import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureUtils {

    /**
     * Attaches a screenshot to the Allure report.
     *
     * @param driver   the WebDriver instance used to capture the screenshot
     * @param name     the name of the attachment in the Allure report
     */
    public static void attachScreenshot(WebDriver driver, String name) {
        if (driver == null) return;

        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshotBytes));
    }
}