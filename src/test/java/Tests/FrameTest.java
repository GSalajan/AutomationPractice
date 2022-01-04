package Tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrameTest extends SharedData
{
    @Test
    public void Test() {
        //skipSignIn button
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        //interactiune cu meniul Switch to
        ////a[contains(text(), 'Switch')] -- cautarea elementului dupa text hardcoded
        WebElement switchElement = driver.findElement(By.xpath("//a[contains(text(), 'SwitchTo')]"));

        //simuleaza actiunea de mouse move
        Actions action = new Actions(driver);
        action.moveToElement(switchElement).build().perform();

        //identificare "Windows"
        WebElement windowsElement = driver.findElement(By.xpath("//a[contains(text(), 'Frames')]"));
        windowsElement.click();

        //"sarim" peste adds
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //get vs navigate
        //get acceseaza url si asteapta sa se incarce pagina
        //navigate doar acceseaza url

        List<WebElement> frameOptionsElements = driver.findElements(By.cssSelector("div[class = 'tabpane'] ul li a"));
        frameOptionsElements.get(0).click();

        //mai multe head/body indica prezenta unui iframe
        //ne mutam pe un iframe
        driver.switchTo().frame("singleframe");
        WebElement singleInputElement = driver.findElement(By.xpath("//input[@type = 'text']"));
        singleInputElement.sendKeys("cucurigu");
        //se intoarce pe frame = continutul principal = defaultContent)
        driver.switchTo().defaultContent();

        frameOptionsElements.get(1).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src= 'MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src= 'SingleFrame.html']")));
        WebElement multipleInputElement = driver.findElement(By.xpath("//input[@type = 'text']"));
        multipleInputElement.sendKeys("cucurigu cotcodac");
    }
}
