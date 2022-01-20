package Pages;

import HelpMethods.AlertHelper;
import HelpMethods.ElementHelper;
import HelpMethods.FrameHelper;
import HelpMethods.WindowHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ElementHelper elementHelper;
    public AlertHelper alertHelper;
    public FrameHelper frameHelper;
    public WindowHelper windowHelper;

    public BasePage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
        frameHelper = new FrameHelper(driver);
        windowHelper = new WindowHelper(driver);
        PageFactory.initElements(driver, this);
    }
}