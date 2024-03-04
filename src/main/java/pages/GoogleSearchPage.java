package pages;

import generic_keywords.WebElementsInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends WebElementsInteraction
{
    private final By google_search_textBox = By.name("q");
    private final By google_search_btn = By.name("btnK");


    //constructor to accept driver object
    public GoogleSearchPage(WebDriver driver)
    {
        super(driver);
    }

    //KeyWord Driven Framework Strategy
    public void sendTextInSearch(String searchText) throws InterruptedException {
        sendText(google_search_textBox,searchText);
    }

    //KeyWord Driven Framework Strategy
    public void setGoogle_search_btn()
    {
        clickElement(google_search_btn);
    }

}
