package homepage;

import browsertesting.Utility;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenu extends Utility {
     String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void open()
    {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully()
    {
            clickOnElement(By.linkText("Shipping"));
            assertVerifyText(By.id("page-title"),"Shipping");
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully()
    {
        clickOnElement(By.linkText("New!"));
        assertVerifyText(By.id("page-title"),"New arrivals");
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully()
    {
        clickOnElement(By.linkText("Coming soon"));
        assertVerifyText(By.id("page-title"),"Coming soon");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully()
    {
        clickOnElement(By.linkText("Contact us"));
        assertVerifyText(By.id("page-title"),"Contact us");
    }
}
