package electronics;

import browsertesting.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified()
    {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='details']//a[contains(text(),'Nokia Lumia 1020')]"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020");
        // t0 verify the price
        assertVerifyText(By.xpath("//span[@id='price-value-20']"),"$349.00");

        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //updating the qty to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        assertVerifyText(By.xpath("//div[@id='bar-notification']/div/p"), "The product has been added to your shopping cart");
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("span.close"));

        mouseHoverOnElement(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
        //assertVerifyText(By.xpath("//input[@value='2']"),"2");
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"),"$698.00");

        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
//=============================Registration======================================================//


        clickOnElement(By.xpath("//a[@class ='ico-register']"));
        clickOnElement(By.xpath("//span[@class='female']"));
       sendTextToElement(By.id("FirstName"),"abc");
       sendTextToElement(By.id("LastName"),"abc123");

       selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"11");
       selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"September");
       selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1998");

       sendTextToElement(By.id("Email"),"abcsqp1301111001101771110@gmail.com");
       sendTextToElement(By.id("Password"),"12345678");
       sendTextToElement(By.id("ConfirmPassword"),"12345678");

       clickOnElement(By.id("register-button"));

       assertVerifyText(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"),"Your registration completed");
       clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

       assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");

        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));

       // sendTextToElement(By.id("BillingNewAddress_FirstName"),"abc");
        //sendTextToElement(By.id("BillingNewAddress_LastName"),"xyz");
        //sendTextToElement(By.id("BillingNewAddress_Email"),"abc@gmail.com");

        WebElement cnt = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select country = new Select(cnt);
        List<WebElement> allOptions =  country.getOptions();

        for(WebElement element : allOptions)
        {

            if(element.getText().equalsIgnoreCase("Romania"))
            {
                element.click();
            }
        }

        sendTextToElement(By.id("BillingNewAddress_City"),"london");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"101 street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"RT4 R74");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"758541258724");
        clickOnElement(By.xpath("//button[text() = 'Continue']"));

        clickOnElement(By.id("shippingoption_2"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']")); //credit card
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));//continue

        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Visa");
        sendTextToElement(By.id("CardholderName"),"abc");
        sendTextToElement(By.id("CardNumber"),"5232 1478 4876 3353");

        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2024");

        sendTextToElement(By.id("CardCode"),"000");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"),"Credit Card");
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"),"2nd Day Air");
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"),"$698.00");
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"),"Your order has been successfully processed!");


        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");

        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/",url);

    }

    @After
    public void close(){
    //    closeBrowser();
    }
}
