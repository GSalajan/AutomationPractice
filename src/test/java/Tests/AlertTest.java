package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class AlertTest extends SharedData
{
    @Test
    public void Test()
    {
        //skipSignIn button
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        //interactiune cu meniul Switch to
        ////a[contains(text(), 'Switch')] -- cautarea elementului dupa text hardcoded
        WebElement switchElement = driver.findElement(By.xpath("//a[contains(text(), 'SwitchTo')]"));

        //simuleaza actiunea de mouse move
        Actions action = new Actions(driver);
        action.moveToElement(switchElement).build().perform();

        //identificare "alerts"
        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(), 'Alerts')]"));
        alertsElement.click();

        //"sarim" peste adds
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        //get vs navigate
        //get acceseaza url si asteapta sa se incarce pagina
        //navigate doar acceseaza url

        //
        //ul[class='nav nav-tabs nav-stacked'] li a     ---> cu ' ' se coboara in ierarhie
        List<WebElement> alertOptionsElements = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        alertOptionsElements.get(0).click();

        //#OKTab button ----> # este shortcut pt identificarea id-ului
        WebElement alertWithOkButtonElement = driver.findElement(By.cssSelector("#OKTab button"));
        alertWithOkButtonElement.click();   //--->apare o alerta
        //retine alerta de la pasul anterior
        Alert alertOK = driver.switchTo().alert();
        //dam ok de alerta
        alertOK.accept();

        //a doua optiune alertWithOkAndCancel
        alertOptionsElements.get(1).click();
        WebElement alertWithOkAndCancelButtonElement = driver.findElement(By.cssSelector("#CancelTab button"));
        alertWithOkAndCancelButtonElement.click();   //--->apare o alerta
        //retine alerta de la pasul anterior
        Alert alertOKCancel = driver.switchTo().alert();
        //dam cancel la alerta
        alertOKCancel.dismiss();
        //tema - de validat mesajul de dupa ok/cancel la alert


        alertOptionsElements.get(2).click();
        WebElement alertWithTextboxElement = driver.findElement(By.cssSelector("#Textbox button"));
        alertWithTextboxElement.click();   //--->apare o alerta
        //retine alerta de la pasul anterior
        Alert alertTextbox = driver.switchTo().alert();
        alertTextbox.sendKeys("Merry Christmas");
        alertTextbox.accept();

        //refresh page
        //driver.navigate().refresh();
    }
}
