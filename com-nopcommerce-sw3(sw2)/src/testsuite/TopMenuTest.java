package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        clickOnElement(By.linkText("Computers"));
        assertVerifyText(By.className("page-title"),"Computers");
    }


    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully()
    {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        assertVerifyText(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"),"Electronics");

    }

    @Test

    public void userShouldNavigateToApparelPageSuccessfully()
    {
        clickOnElement(By.linkText("Apparel"));
        assertVerifyText(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"),"Apparel");
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully()
    {
        clickOnElement(By.linkText("Digital downloads"));
        assertVerifyText(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a"),"Digital downloads");

    }
    @Test
 public void userShouldNavigateToBooksPageSuccessfully()
    {

        clickOnElement(By.linkText("Books"));
        assertVerifyText(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"),"Books");

    }
    @Test
 public void Jewelry()
    {

        clickOnElement(By.linkText("Jewelry"));
        assertVerifyText(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a"),"Jewelry");


    }
    @Test
 public void GiftCards()
    {
        clickOnElement(By.linkText("Gift Cards"));
        assertVerifyText(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a"),"Gift Cards");

    }


    @After
    public void close() {
           closeBrowser();
    }
}
