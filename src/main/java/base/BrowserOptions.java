package base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserOptions
{
    public static ChromeOptions getChromeOptions(DesiredCapabilities capabilities)
    {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless"); //for GitHub actions
        co.addArguments("--disable-gpu");
        co.addArguments("--no-sandbox");
        capabilities.setCapability(ChromeOptions.CAPABILITY, co);
        co.merge(capabilities);
        return co;
    }
}
