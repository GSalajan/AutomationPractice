package Tests;

import Base.Hooks;
import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class FrameTest extends Hooks
{
    public IndexPage indexPage;
    public RegisterPage registerPage;
    public FramePage framePage;

    @Test
    public void Test() {
        indexPage = new IndexPage(getDriver());
        registerPage = new RegisterPage(getDriver());
        framePage = new FramePage(getDriver());

        indexPage.clickSkipSignIn();
        registerPage.goToFramePage();
        framePage.dealSingleFrame(inputData.get("singleFrame"));
        framePage.dealMultipleFrame(inputData.get("multipleFrame"));
    }
}
