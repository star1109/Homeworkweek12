package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends Utility
{
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl); //super class method to open the broswer

    }


    @Test
public void userShouldNavigateToLoginPageSuccessfully()
    {
        clickOnElement(By.linkText("Log in"));
        assertVerifyText(By.className("page-title"), "Welcome, Please Sign In!");

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        clickOnElement(By.linkText("Log in"));
       sendTextToElement(By.id("Email"),"abcqp123@gmail.com");
       sendTextToElement(By.id("Password"),"12345678");
       clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

       assertVerifyText(By.linkText("Log out"),"Log out");

    }

    @Test
    public void verifyTheErrorMessage()
    {
        clickOnElement(By.linkText("Log in"));
       // driver.findElement(By.linkText("Log in")).click();

        sendTextToElement(By.id("Email"),"abc@gmail.com");
        sendTextToElement(By.id("Password"),"12345678");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        assertVerifyText(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");

    }

    @After
    public void close()
    {
       closeBrowser();
    }










}


