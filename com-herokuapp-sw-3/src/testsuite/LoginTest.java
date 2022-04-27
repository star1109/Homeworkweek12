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
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void open()
    {
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");

       clickOnElement(By.xpath("//button[@type='submit']"));
      assertVerifyText(By.xpath("//h2[text()=' Secure Area']"),"Secure Area");

    }
    @Test
    public void verifyTheUsernameErrorMessage()
    {

        sendTextToElement(By.id("username"),"tomsmith1");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@type='submit']"));

        String expectedResult = "Your username is invalid!";
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Your username is invalid!')]"));
        String actualResult = element.getText();
        String mainResult = actualResult.substring(0,25);
        //System.out.println(main);

        Assert.assertEquals("error occur",expectedResult,mainResult);
    }

    @Test
    public void verifyThePasswordErrorMessage()
    {

        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword1!");
        clickOnElement(By.xpath("//button[@type='submit']"));

        String expectedResult = "Your password is invalid!";
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
        String actualResult = element.getText();
        String mainResult = actualResult.substring(0,25);


        Assert.assertEquals("error occur",expectedResult,mainResult);
    }
    @After
    public void close()
    {
     closeBrowser();
    }
}
