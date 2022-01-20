package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertPage extends BasePage
{
    public AlertPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "ul[class='nav nav-tabs nav-stacked'] li a")
    private List<WebElement> alertOptions;
    @FindBy(css = "#OKTab button")
    private WebElement okElement;
    @FindBy(css = "#CancelTab button")
    private WebElement okCancelElement;
    @FindBy(css = "#Textbox button")
    private WebElement textboxElement;

    public void alertOkProcess()
    {
        elementHelper.clickElement(alertOptions.get(0));
        elementHelper.clickElement(okElement); //--->apare o alerta
        alertHelper.acceptAlert();
    }
    public void alertOkCancelProcess(){
        elementHelper.clickElement(alertOptions.get(1));
        elementHelper.clickElement(okCancelElement);
        alertHelper.cancelAlert();
    }
    public void alertTextBoxProcess(String valoare){
        elementHelper.clickElement(alertOptions.get(2));
        elementHelper.clickElement(textboxElement);
        alertHelper.acceptFillAlert(valoare);
    }


}
