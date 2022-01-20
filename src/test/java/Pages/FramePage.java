package Pages;

import HelpMethods.ElementHelper;
import HelpMethods.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage extends BasePage
{
    public FramePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "ul[class='nav nav-tabs '] li a")
    private List<WebElement> frameOptionsElements;
    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement inputSingleElement;
    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement inputMultipleElement;

    public void dealSingleFrame(String value)
    {
        elementHelper.clickElement(frameOptionsElements.get(0));
        //ne mutam pe un iframe
        frameHelper.switchFrameById("singleframe");
        elementHelper.fillElement(inputSingleElement, value);
        frameHelper.switchFrameDefault();
    }

    public void dealMultipleFrame(String value)
    {
        elementHelper.clickElement(frameOptionsElements.get(1));
        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@src= 'MultipleFrames.html']")));
        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@src= 'SingleFrame.html']")));
        elementHelper.fillElement(inputMultipleElement, value);
    }
}
