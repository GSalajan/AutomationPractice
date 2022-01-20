//identificare elemente dupa locator: id, class, name, link, css, xpath
//xpath e mai precis decat css. css e mai rapid
package Tests;

import Base.Hooks;
import Pages.IndexPage;
import Pages.LoginPage;
import org.junit.Test;

public class LoginTest extends Hooks
{
    public IndexPage indexPage;
    public LoginPage loginPage;

    @Test
    public void Test()
    {
        indexPage = new IndexPage(getDriver());
        loginPage = new LoginPage(getDriver());

        indexPage.clickSignIn();
        loginPage.InvalidLogin(inputData);
    }
}
