package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        clickOnElement(By.linkText("Forgot your password?"));
        assertVerifyText(By.xpath("//div/div[2]/h1"), "Forgot Your Password?");

    }

    @After
    public void close() {
        closeBrowser();
    }

}
