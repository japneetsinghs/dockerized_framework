package generic_keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementsInteraction
{
   WebDriver driver;

    public WebElementsInteraction(WebDriver driver)
    {
       this.driver = driver;
    }

    protected void clickElement(By locator)
    {
        driver.findElement(locator).click();
    }

    protected void sendText(By locator, String text) throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(4000);
        driver.findElement(locator).sendKeys(text);
    }
}

