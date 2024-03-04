package page_tests;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.GoogleSearchPage;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleSearchTests extends BaseTest
{
   // WebDriver driver;
    GoogleSearchPage googleSearchPage;


//    @Parameters({"browserName"})
//    @BeforeTest
//    public void setDriver(@Optional("chrome") String browserName) throws MalformedURLException {
//        //WebDriverManager.chromedriver().setup();
//        //ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--remote-allow-origins=*");
//        //driver = new ChromeDriver(options);
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName(browserName);
//        capabilities.setPlatform(Platform.LINUX);  //required when contaners are running on different OS
//
//        System.out.println(capabilities.getBrowserName());
//        System.out.println(capabilities.getBrowserVersion());
//    }
//
//    @AfterTest
//    public void tearDown()
//    {
//        driver.quit();
//    }

    @Test()
    public void testGoogleSearch() throws InterruptedException {
        googleSearchPage = new GoogleSearchPage(driver);
        //basic search operation test
        googleSearchPage.sendTextInSearch("Selenium latest release");
        Thread.sleep(2000);
        googleSearchPage.setGoogle_search_btn();
        Thread.sleep(2000);
    }

}
