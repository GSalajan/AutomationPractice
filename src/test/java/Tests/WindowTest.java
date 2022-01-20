package Tests;

import Base.Hooks;
import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowPage;
import org.junit.Test;

public class WindowTest extends Hooks
{
    public IndexPage indexPage;
    public RegisterPage registerPage;
    public WindowPage windowPage;

    @Test
    public void Test()
    {
        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());
        windowPage = new WindowPage(getDriver());

        indexPage.clickSkipSignIn();
        registerPage.goToWindowPage();

        windowPage.tabProcess();
        windowPage.seperateProcess();
        windowPage.multipleProcess();
    }
}
