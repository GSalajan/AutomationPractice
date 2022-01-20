package Pages;

import HelpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "input[placeholder='E mail']")
    private WebElement emailElement;
    @FindBy(xpath = "//input[@placeholder = 'Password']")
    private WebElement passwordElement;
    @FindBy(id="enterbtn")
    private WebElement enterElement;
    @FindBy(id="errormsg")
    private WebElement errorMessageElement;

    public void InvalidLogin(HashMap<String, String> values)
    {
        elementHelper.fillElement(emailElement, values.get("email"));
        elementHelper.fillElement(passwordElement, values.get("password"));
        elementHelper.clickElement(enterElement);
        elementHelper.validateElementMessage(errorMessageElement, values.get("message"));
    }
}
