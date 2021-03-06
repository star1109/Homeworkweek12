package browsertesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
       // String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //que - how do you launch the url in selenium
        // to launch the url driver.get() method
        driver.get(baseUrl);//url variable

        driver.manage().window().maximize(); // to maximize the size of window

        //to give the implicit timw to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}
