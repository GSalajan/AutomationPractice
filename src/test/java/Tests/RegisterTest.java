package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//xpath e mai precis decat css. css e mai rapid

import java.util.List;

public class RegisterTest
{
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
        driver.manage().window().maximize();

        //skipSignIn button
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        //first name
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder = 'First Name']"));
        firstNameElement.sendKeys("Pic");

        //last name
        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder= 'Last Name']"));
        lastNameElement.sendKeys("Poc");

        //address
        WebElement addressElement = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        addressElement.sendKeys("Aurel Vlaicu 48");

        //email
        //WebElement emailElement = driver.findElement();
        //emailElement.sendKeys("");
        //phone

        //gender
        WebElement genderElement = driver.findElement(By.cssSelector("input[value = 'Male']"));
        genderElement.click();

        WebElement skillsElement = driver.findElement(By.cssSelector("select[id='Skills']"));
        Select skillsSelect = new Select(skillsElement);
        skillsSelect.selectByVisibleText("Android");

        WebElement yearElement = driver.findElement(By.cssSelector("select[placeholder='Year']"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("2000");

        WebElement languageElement = driver.findElement(By.cssSelector("div[id='msdd']"));
        languageElement.click();

        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0; i< languageElements.size(); i++)
        {
            if (languageElements.get(i).getText().equals("Catalan"))
            {
                languageElements.get(i).click();
            }
        }
        //pentru a inchide drop-down-ul "special" de languages
        genderElement.click();



    }
}
