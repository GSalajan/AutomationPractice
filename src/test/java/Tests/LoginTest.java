package Tests;

import Base.SharedData;
import HelpMethods.ElementHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends SharedData
{
    public ElementHelper elementHelper = new ElementHelper(driver);
    @Test
    public void Test()
    {
        //identificam elementul (butonul) "Sign in"
        elementHelper.ClickElement(driver.findElement(By.id("btn1")));

        //identificare elemente dupa locator: id, class, name, link, css, xpath
        //css e mai rapid decat xpath
        //ex cu css
        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        elementHelper.FillElement(emailElement, "gsalajan85@gmail.com");

        //ex cu xpath
        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        passwordElement.sendKeys("Pass");

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement messageElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        elementHelper.validateElementMessage(messageElement, expectedError);
    }
}
