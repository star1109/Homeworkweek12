package computer;

import browsertesting.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void priceLowToHigh() {
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Desktops"));
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Price: Low to High");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Desktops"));
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='products-wrapper']//div/div/div[1]//div[@class='buttons']/button[1]")).click();
        //assertVerifyText("Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");

        WebElement processor = driver.findElement(By.id("product_attribute_1"));
        Select select = new Select(processor);
        select.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(1000);

        //for ram selection
        WebElement ram = driver.findElement(By.cssSelector("select#product_attribute_2"));
        Select select1 = new Select(ram);
        select1.selectByValue("5");

        // for HDD
        clickOnElement(By.cssSelector("input#product_attribute_3_7"));
        clickOnElement(By.cssSelector("input#product_attribute_4_9"));// to click on the OS Vista Premium [+$60.00] radio button

        //clickOnElement(By.cssSelector("input#product_attribute_5_10"));// for Microsoft Office [+$50.00] checkbox
        clickOnElement(By.cssSelector("input#product_attribute_5_12"));// for Total Commander [+$5.00] checkbox

        //to verify the price
        Thread.sleep(3000);
        assertVerifyText(By.cssSelector("span#price-value-1"), "$1,475.00");
        clickOnElement(By.cssSelector("button#add-to-cart-button-1"));

        assertVerifyText(By.xpath("//div[@id='bar-notification']/div/p"), "The product has been added to your shopping cart");
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("span.close"));


        // mouse hower action on shoping cart
        Actions actions = new Actions(driver);
        WebElement shopingcart = driver.findElement(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        actions.moveToElement(shopingcart).build().perform();

        //clicking on the go to cart button
        clickOnElement(By.xpath("//button[text() = 'Go to cart']"));

        //verifing the message Shopping cart
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//tbody/tr/td[5]/input")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //updating the qty to 2
        sendTextToElement(By.xpath("//tbody/tr/td[5]/input"), "2");

        //click on update cart
        clickOnElement(By.cssSelector("button#updatecart"));

        assertVerifyText(By.xpath("//tr/td[6]/span"), "$2,950.00");

        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));

        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        clickOnElement(By.xpath("//button[text()='Checkout as Guest']"));

        sendTextToElement(By.id("BillingNewAddress_FirstName"),"abc");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"xyz");
        sendTextToElement(By.id("BillingNewAddress_Email"),"abc@gmail.com");

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

        clickOnElement(By.id("shippingoption_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        // to click on the continue button
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));

        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");

        sendTextToElement(By.id("CardholderName"),"abc");
        sendTextToElement(By.id("CardNumber"),"5232 1478 4876 3353");

        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2024");

        sendTextToElement(By.id("CardCode"),"000");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"),"Credit Card");
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"),"Next Day Air");
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"),"$2,950.00");
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"),"Your order has been successfully processed!");
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
    }


    @After
    public void close() {
         closeBrowser();
    }

}
