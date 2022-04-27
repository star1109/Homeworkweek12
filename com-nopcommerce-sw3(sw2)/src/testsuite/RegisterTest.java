package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.xpath("//a[@class ='ico-register']"));
        assertVerifyText(By.xpath("//div[@class='page-title']"), "Register");

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//a[@class ='ico-register']"));
        clickOnElement(By.xpath("//span[@class='female']"));
        sendTextToElement(By.id("FirstName"), "Riya");
        sendTextToElement(By.id("LastName"), "Talati");

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "11");

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "September");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1998");

        sendTextToElement(By.id("Email"),"abcqp12322@gmail.com");
        sendTextToElement(By.id("Password"),"12345678");
        sendTextToElement(By.id("ConfirmPassword"),"12345678");
        clickOnElement(By.id("register-button"));
     assertVerifyText(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"),"Your registration completed");


    }

    @After
    public void close() {
      //  closeBrowser();
    }

}
