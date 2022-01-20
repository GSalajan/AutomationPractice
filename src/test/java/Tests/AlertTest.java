package Tests;

import Base.Hooks;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class AlertTest extends Hooks
{
    private IndexPage indexPage;
    private RegisterPage registerPage;
    private AlertPage alertPage;

    @Test
    public void Test()
    {
        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());
        alertPage = new AlertPage(getDriver());

        //skipSignIn button
        indexPage.clickSkipSignIn();
        registerPage.goToAlertPage();
        alertPage.alertOkProcess();
        //a doua optiune alertWithOkAndCancel
        alertPage.alertOkCancelProcess();
        alertPage.alertTextBoxProcess(inputData.get("alertTextBox"));

        //refresh page
        //driver.navigate().refresh();
    }
}
