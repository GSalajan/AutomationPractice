package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper
{
    private WebDriver driver;

    public FrameHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void switchFrameById(String value)
    {
        driver.switchTo().frame(value);
    }

    public void switchFrameDefault()
    {
        //se intoarce pe frame = continutul principal = defaultContent)
        driver.switchTo().defaultContent();
    }

    public void switchFrameByElement(WebElement element)
    {
        driver.switchTo().frame(element);
    }
}
