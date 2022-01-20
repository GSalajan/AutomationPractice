package Pages;

import HelpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage
{
    public IndexPage(WebDriver driver)
    {
        super(driver);
    }

    //elementele de pe pagina
    @FindBy(id="btn1")
    private WebElement signInElement;   //incapsularea datelor
    @FindBy(id = "btn2")
    private WebElement skipSignInElement;

    //metodele de pe pagina
    public void clickSignIn()
    {
        elementHelper.clickElement(signInElement);
    }
    public void clickSkipSignIn()
    {
        elementHelper.clickElement(skipSignInElement);
    }

}
