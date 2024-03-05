package base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserOptions
{
    public static ChromeOptions getChromeOptions()
    {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless"); //for GitHub actions
        co.addArguments("--disable-gpu");
        co.addArguments("--no-sandbox");
        return co;
    }

    public static FirefoxOptions getFirefoxOptions ()
    {
        FirefoxOptions fo = new FirefoxOptions();
        fo.addArguments("--headless"); //for GitHub actions
        fo.addArguments("--disable-gpu");
        fo.addArguments("--no-sandbox");
        return fo;
    }
}
