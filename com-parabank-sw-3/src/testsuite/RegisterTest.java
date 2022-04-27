package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends Utility
{
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void open() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay()
    {
        clickOnElement(By.linkText("Register"));
       assertVerifyText(By.xpath("//div[@id='rightPanel']/h1"),"Signing up is easy!");
    }

    @Test
    public void userSholdRegisterAccountSuccessfully()
    {
        clickOnElement(By.linkText("Register"));
        sendTextToElement(By.id("customer.firstName"),"prime");
        sendTextToElement(By.id("customer.lastName"),"testing");
        sendTextToElement(By.xpath("//tr/td[2]/input[@id='customer.address.street']"),"abc street");
        sendTextToElement(By.id("customer.address.city"),"kingston");
        sendTextToElement(By.id("customer.address.state"),"london");
        sendTextToElement(By.id("customer.address.zipCode"),"123456");
        sendTextToElement(By.id("customer.phoneNumber"),"1234567890");
        sendTextToElement(By.id("customer.ssn"),"0000");
        sendTextToElement(By.id("customer.username"),"abc123456");
        sendTextToElement(By.id("customer.password"),"1234");
        sendTextToElement(By.id("repeatedPassword"),"1234");
        clickOnElement(By.xpath("//input[@value='Register']"));
      assertVerifyText(By.xpath("//div[@id='rightPanel']/p"),"Your account was created successfully. You are now logged in.");

    }

    @After
    public void close() {
        // closeBrowser();
    }
}
