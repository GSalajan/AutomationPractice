package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelper
{
    WebDriver driver;
    public ElementHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void ClickElement(WebElement element)
    {
        element.click();
    }

    public void FillElement(WebElement element, String value)
    {
        element.sendKeys(value);
    }

    public void validateElementMessage(WebElement element, String message)
    {
        WebElement messageElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        String actualError = messageElement.getText();

        //Assert.assertEquals(expectedError, actualError);
        Assert.assertEquals("Mesajul de login nu este corect", expectedError, actualError);
    }
}
