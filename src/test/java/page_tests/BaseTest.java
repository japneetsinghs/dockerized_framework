package page_tests;

import base.AppConstants;
import base.BasePage;
import base.BrowserOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import org.openqa.selenium.chrome.ChromeOptions;
import utils.ExtentReportHelper;

import static base.AppConstants.*;
import static utils.ExtentReportHelper.getReportObject;

public class BaseTest {
    protected WebDriver driver;
    protected String browser;

    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();
    private static final ExtentReports reports = getReportObject();
    //private  static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    private static final Logger logger = LogManager.getLogger(BaseTest.class);


    @Parameters({"browserName"})
    @BeforeTest()
    public void setup(@Optional String browserName)
    {
        if (browserName != null) {
            browser = browserName;
        } else {
            browser = AppConstants.browserName;
        }

        ChromeOptions chromeOptions;
        FirefoxOptions firefoxOptions;

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                if (platform.equalsIgnoreCase("local")) {
                    chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    logger.info("BrowserName: "+chromeOptions.getBrowserName()+"BrowserVersion: "+chromeOptions.getBrowserVersion());
                    driver = new ChromeDriver(chromeOptions);


                } else if (platform.equalsIgnoreCase("remote")) {
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setPlatformName("linux");
                    logger.info("BrowserName: "+chromeOptions.getBrowserName()+"BrowserVersion: "+chromeOptions.getBrowserVersion());
                    //driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), chromeOptions); //standalone chrome
                   // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions); //grid chrome
                    driver = new RemoteWebDriver(new URL("http://172.20.0.4:5555/wd/hub"), chromeOptions); //grid chrome


                } else if (platform.equalsIgnoreCase("remote_git")) {
                    chromeOptions = BrowserOptions.getChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    logger.info("BrowserName: "+chromeOptions.getBrowserName()+"BrowserVersion: "+chromeOptions.getBrowserVersion());
                    driver = new ChromeDriver(chromeOptions);


                } else {
                    System.out.println("Invalid platform name");
                }

            } else if (browser.equalsIgnoreCase("firefox")) {
                if (platform.equalsIgnoreCase("local")) {
                    firefoxOptions = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    //firefoxOptions.addArguments("--remote-allow-origins");
                    driver = new FirefoxDriver(firefoxOptions);
                    logger.info("BrowserName: "+firefoxOptions.getBrowserName()+"BrowserVersion: "+firefoxOptions.getBrowserVersion());


                } else if (platform.equalsIgnoreCase("remote")) {
                    firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPlatformName("linux");
                    //driver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), firefoxOptions); //standalone firefox
                   // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions); //grid firefox
                    driver = new RemoteWebDriver(new URL("http://172.20.0.3:5555/wd/hub"), firefoxOptions); //grid firefox
                    logger.info("BrowserName: "+firefoxOptions.getBrowserName()+"BrowserVersion: "+firefoxOptions.getBrowserVersion());

                } else if (platform.equalsIgnoreCase("remote_git")) {
                    firefoxOptions = BrowserOptions.getFirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    logger.info("BrowserName: "+firefoxOptions.getBrowserName()+"BrowserVersion: "+firefoxOptions.getBrowserVersion());

                } else {
                    System.out.println("Invalid platform name");
                }

            } else {
                System.out.println("Invalid browser name provided");
                logger.info("Invalid browser name provided");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setupReport(ITestResult testResult)
    {
        ExtentTest test = reports.createTest(testResult.getMethod().getMethodName());
        testLogger.set(test);
        testLogger.get().log(Status.INFO, "Driver Start Time: "+LocalDateTime.now());
    }

    @AfterMethod
    public void tearDownReport(ITestResult testResult) throws IOException
    {
        if(testResult.isSuccess())
        {
            testLogger.get().log(Status.PASS, MarkupHelper.createLabel(testResult.getMethod().getMethodName()+" is successful!!", ExtentColor.GREEN));
        }

        else
        {
            testLogger.get().log(Status.FAIL, "test failed due to: " + testResult.getThrowable());
            String screenshotPath = BasePage.getScreenshot(testResult.getMethod().getMethodName()+".jpg"
                    , driver);
            testLogger.get().fail(MediaEntityBuilder
                    .createScreenCaptureFromBase64String(BasePage.convertImg_Base64(screenshotPath)).build());
            testLogger.get().log(Status.INFO, "Driver End Time: "+LocalDateTime.now());
        }


    }

    @AfterClass
    public void flushReport()
    {
        reports.flush();
    }

}


