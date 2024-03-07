package page_tests;


import org.testng.annotations.*;
import pages.GoogleSearchImFeelingLucky;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoogleSearchImFeelingLuckyTests extends BaseTest
{
   //WebDriver driver;
    GoogleSearchImFeelingLucky googleSearchImFeelingLucky;

    Logger logger = LogManager.getLogger(GoogleSearchImFeelingLuckyTests.class);


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
        logger.info("new driver launched");
        googleSearchImFeelingLucky.clickImFeelingLuckyBtn();
        Thread.sleep(5000);
        logger.info("Test completed and you can review status in Test Report generated!!!");
    }



}
