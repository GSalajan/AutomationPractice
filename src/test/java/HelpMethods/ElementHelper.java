package HelpMethods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper
{
    private WebDriver driver;

    public ElementHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void scrollByPixel(Integer x, Integer y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void clickElement(WebElement element)
    {
        waitElementVisible(element);
        element.click();
    }

    public void waitElementVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElement(WebElement element, String value)
    {
        waitElementVisible(element);
        element.sendKeys(value);
    }

    public void validateElementMessage(WebElement element, String message)
    {
        waitElementVisible(element);
        Assert.assertEquals("Mesajul nu este corect", message, element.getText());
    }

    public void selectByTextElement(WebElement element, String value)
    {
        waitElementVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectByValueElement(WebElement element, String value)
    {
        waitElementVisible(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void hoverElement(WebElement element)
    {
        //simuleaza actiunea de mouse move
        waitElementVisible(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
