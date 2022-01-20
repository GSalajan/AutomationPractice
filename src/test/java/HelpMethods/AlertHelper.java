package HelpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper
{
    private WebDriver driver;

    public AlertHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void acceptAlert()
    {
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //wait explicit
        waitAlertPresence();

        //capteaza alerta
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();
    }

    public void waitAlertPresence(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    }

    public void cancelAlert()
    {
        waitAlertPresence();
        Alert alertCancel = driver.switchTo().alert();
        alertCancel.dismiss();
    }

    public void acceptFillAlert(String value)
    {
        waitAlertPresence();
        Alert alertOK = driver.switchTo().alert();
        alertOK.sendKeys(value);
        alertOK.accept();
    }

    public void cancelFillAlert(String value)
    {
        waitAlertPresence();
        Alert alertCancel = driver.switchTo().alert();
        alertCancel.sendKeys(value);
        alertCancel.dismiss();
    }
}
