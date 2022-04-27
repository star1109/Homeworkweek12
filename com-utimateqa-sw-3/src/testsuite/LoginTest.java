package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        clickOnElement(By.linkText("Sign In"));
        assertVerifyText(By.cssSelector("h1.page__heading"), "Welcome Back!");
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Sign In")).click();
        sendTextToElement(By.id("user[email]"),"abc@gmail.com");
        sendTextToElement(By.id("user[password]"),"123456");
        clickOnElement(By.cssSelector("input.button.button-primary.g-recaptcha"));
  assertVerifyText(By.xpath("//li[text() ='Invalid email or password.' ]"),"Invalid email or password.");

    }


    @After
    public void close() {
        closeBrowser();
    }


}
