package pages;

import generic_keywords.WebElementsInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchImFeelingLucky extends WebElementsInteraction
{

    private final By iMFeelingLuckyBtn = By.name("btnI");
    private final By google_search_textBox = By.name("q");

    public GoogleSearchImFeelingLucky(WebDriver driver) {
        super(driver);
    }

    public void clickImFeelingLuckyBtn() throws InterruptedException
    {
        sendText(google_search_textBox, "i am feeling lucky");
        Thread.sleep(2000);
        clickElement(iMFeelingLuckyBtn);
    }



}
