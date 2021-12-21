package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{
    //webdriver = variabila care ne ajuta sa interactionam cu site-ul si elementele lui
    public WebDriver driver;

    @Test
    public void Test()
    {
        //specificam unde se afla driverul pt browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Azimut\\Kits\\Automation\\chromedriver.exe");
        //deschidem browserul
        driver = new ChromeDriver();
        //adaugam adresa web
        driver.get("http://demo.automationtesting.in/Index.html");
        //maximizam browserul
        driver.manage().window().maximize();

        //identificam elementul (butonul) "Sign in"
        WebElement signInElement = driver.findElement(By.id("btn1"));
        //click pe button
        signInElement.click();

        //identificare elemente dupa locator: id, class, name, link, css, xpath
        //css e mai rapid decat xpath
        //ex cu css
        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "gsalajan85@gmail.com";
        emailElement.sendKeys(emailValue);

        //ex cu xpath
        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        passwordElement.sendKeys("Pass");

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement messageElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        String actualError = messageElement.getText();

        //Assert.assertEquals(expectedError, actualError);
        Assert.assertEquals("Mesajul de login nu este corect", expectedError, actualError);
        //driver.quit();


    }
}
