package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");

      clickOnElement(By.id("login-button"));
     assertVerifyText(By.xpath("//span[@class = 'title']"),"PRODUCTS");


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));

        int expectedResult = 6;
        List<WebElement> item = driver.findElements(By.className("inventory_item"));
        int actualresult = item.size();

        Assert.assertEquals("error occured", expectedResult, actualresult);


    }
    @After
    public void close() {
        closeBrowser();
    }
}
