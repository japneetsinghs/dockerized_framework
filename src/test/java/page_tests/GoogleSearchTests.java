package page_tests;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;
import pages.GoogleSearchPage;


import org.apache.logging.log4j.Logger;

public class GoogleSearchTests extends BaseTest
{
   // WebDriver driver;
    GoogleSearchPage googleSearchPage;
    //private  final Logger logger = LogManager.getLogManager(GoogleSearchTests.class);
    Logger logger = LogManager.getLogger(GoogleSearchTests.class);

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
    public void testGoogleSearch() throws InterruptedException
    {
        googleSearchPage = new GoogleSearchPage(driver);
        //basic search operation test
        googleSearchPage.sendTextInSearch("Selenium latest release");
        logger.info("Text send: Selenium latest release");
        Thread.sleep(2000);
        googleSearchPage.setGoogle_search_btn();
        logger.info("button clicked!!!!");
        Thread.sleep(2000);
    }

}
