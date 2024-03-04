package page_tests;

import base.BaseTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.GoogleSearchImFeelingLucky;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleSearchImFeelingLuckyTests extends BaseTest
{
   // WebDriver driver;
    GoogleSearchImFeelingLucky googleSearchImFeelingLucky;

//    @Parameters({"browserName"})
//    @BeforeTest
//    public void setupDriver(@Optional("firefox") String browserName) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName(browserName);
//        capabilities.setPlatform(Platform.LINUX);  //required when contaners are running on different OS
//        driver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), capabilities);
//        System.out.println(capabilities.getBrowserName());
//        System.out.println(capabilities.getBrowserVersion());
//    }

//    @AfterTest
//    public void tearDown()
//    {
//        driver.quit();
//    }

    @Test()
    public void click2ndLink() throws InterruptedException {
        googleSearchImFeelingLucky = new GoogleSearchImFeelingLucky(driver);
        googleSearchImFeelingLucky.clickImFeelingLuckyBtn();
        Thread.sleep(5000);
    }



}
