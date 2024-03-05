package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;

import static base.AppConstants.*;

public class BaseTest
{
   protected WebDriver driver;
    private DesiredCapabilities capabilities;
    protected String browser;
    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;

    @Parameters({"browserName"})
    @BeforeTest
    public void setup(String browserName)
    {
            if (browserName != null) {
                browser = browserName;
            } else {
                browser = AppConstants.browserName;
            }

            capabilities = new DesiredCapabilities();
        chromeOptions = BrowserOptions.getChromeOptions();

            try {
                if (browser.equalsIgnoreCase("chrome"))
                {
                    if (enableBrowserOptions.equalsIgnoreCase("true"))
                    {
                        if (platform.equalsIgnoreCase("local"))
                        {
                            WebDriverManager.chromedriver().setup();
                            chromeOptions.addArguments("--remote-allow-origins=*");
                            driver = new ChromeDriver(chromeOptions);
                        }
                    }
                    else if (platform.equalsIgnoreCase("remote"))
                    {
                        capabilities.setBrowserName(browser);
                        capabilities.setPlatform(Platform.LINUX);  //required when containers are running on different OS
                        //driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), capabilities); //standalone chrome
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities); //grid chrome

                    }
                    else
                    {
                        System.out.println("Invalid platform name");
                    }

                } else if (browser.equalsIgnoreCase("firefox"))
                {
                    if (enableBrowserOptions.equalsIgnoreCase("true"))
                    {
                        firefoxOptions = BrowserOptions.getFirefoxOptions();

                        if (platform.equalsIgnoreCase("local")) {
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver(firefoxOptions);
                        }
                    }
                    else if (platform.equalsIgnoreCase("remote")) {
                        capabilities.setBrowserName(browser);
                        capabilities.setPlatform(Platform.LINUX);  //required when containers are running on different OS
                        //driver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), capabilities); //standalone firefox
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities); //grid firefox

                    } else {
                        System.out.println("Invalid platform name");
                    }
                } else {
                    System.out.println("Invalid browser name provided");
                }

                System.out.println(capabilities.getBrowserName());
                System.out.println(capabilities.getBrowserVersion());

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
