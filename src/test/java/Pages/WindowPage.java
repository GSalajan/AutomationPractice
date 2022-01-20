package Pages;

import HelpMethods.ElementHelper;
import HelpMethods.WindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowPage extends BasePage
{
    public WindowPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "ul[class = 'nav nav-tabs nav-stacked'] li a")
    private List<WebElement> windowOptionsElements;
    @FindBy(css = "#Tabbed a button")
    private WebElement clickButtonElement;
    @FindBy(css = "#Seperate button")
    private WebElement clickWindowElement;
    @FindBy(css = "#Multiple button")
    private WebElement clickTabsElement;

    public void tabProcess()
    {
        elementHelper.clickElement(windowOptionsElements.get(0));
        elementHelper.clickElement(clickButtonElement); //--->apare o alerta
        switchToWindow();
    }

    public void switchToWindow(){
        windowHelper.switchToSpecificWindow(1,2);
        windowHelper.closeCurrentWindow();
        windowHelper.switchToSpecificWindow(0, 1);
    }

    public void switchToWindows(){
        windowHelper.switchToSpecificWindow(2, 3);
        windowHelper.closeCurrentWindow();
        windowHelper.switchToSpecificWindow(1, 2);
        windowHelper.closeCurrentWindow();
        windowHelper.switchToSpecificWindow(0, 1);
    }

    public void seperateProcess()
    {
        elementHelper.clickElement(windowOptionsElements.get(1));
        elementHelper.clickElement(clickWindowElement);
        switchToWindow();
    }
    public void multipleProcess()
    {
        elementHelper.clickElement(windowOptionsElements.get(2));
        elementHelper.clickElement(clickTabsElement);
        switchToWindows();
    }
}
