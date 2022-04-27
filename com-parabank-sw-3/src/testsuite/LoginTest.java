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
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void open() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"), "abc123456");
        sendTextToElement(By.name("password"), "1234");
        clickOnElement(By.xpath("//input[@class = 'button']"));

        assertVerifyText(By.xpath("//h1[@class = 'title']"),"Accounts Overview");

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.name("username")).sendKeys("abc12311121");
        driver.findElement(By.name("password")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@class = 'button']")).click();
        assertVerifyText(By.xpath("//div[@id = 'rightPanel']/p"), "The username and password could not be verified.");

    }

    @Test
    public void userShouldLogOutSuccessfully() {

        driver.findElement(By.name("username")).sendKeys("abc12356");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class = 'button']")).click();

        clickOnElement(By.linkText("Log Out"));
    assertVerifyText(By.xpath("//div[@id = 'leftPanel']/h2"),"Customer Login");

    }

    @After
    public void close() {
        // closeBrowser();
    }

}
