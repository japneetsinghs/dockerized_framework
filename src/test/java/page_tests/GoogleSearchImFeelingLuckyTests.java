package page_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.GoogleSearchImFeelingLucky;

public class GoogleSearchImFeelingLuckyTests extends BaseTest
{
   //WebDriver driver;
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
