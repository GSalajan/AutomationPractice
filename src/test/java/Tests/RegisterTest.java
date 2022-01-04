package Tests;

import Base.SharedData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//xpath e mai precis decat css. css e mai rapid

import java.util.List;

public class RegisterTest extends SharedData
{
    @Test
    public void Test()
    {
        //skipSignIn button
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        //se valideaza accesarea paginii de Register
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register", actualRegister);

        //photo
        WebElement pictureElement = driver.findElement(By.id("imagesrc"));
        pictureElement.sendKeys("C:\\Users\\User\\Desktop\\azi\\LR (3x2)\\DSC_0252__LR__1.jpg");

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
        WebElement emailElement = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailElement.sendKeys("picpoc@test.com");

        //phone
        WebElement phoneElement = driver.findElement(By.cssSelector("input[type = 'tel']"));
        phoneElement.sendKeys("0745111222");

        //gender
        WebElement genderElement = driver.findElement(By.cssSelector("input[value = 'Male']"));
        genderElement.click();

        //hobbies
        WebElement hobbiesElement = driver.findElement(By.id("checkbox2"));
        hobbiesElement.click();

        //languages
        WebElement languageElement = driver.findElement(By.cssSelector("div[id='msdd']"));
        languageElement.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, 500);");

        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for (Integer i = 0; i< languageElements.size(); i++)
        {
            if (languageElements.get(i).getText().equals("Catalan"))
            {
                languageElements.get(i).click();
                break;
            }
        }
        //pentru a inchide drop-down-ul "special" de languages
        genderElement.click();

        //skills
        WebElement skillsElement = driver.findElement(By.cssSelector("select[id='Skills']"));
        Select skillsSelect = new Select(skillsElement);
        skillsSelect.selectByVisibleText("Android");

        //country
        /*List<WebElement> countryElements = driver.findElements(By.id("country"));
        for (Integer i = 0; i< countryElements.size(); i++)
        {
            if (countryElements.get(i).getText().equals("Australia"))
            {
                countryElements.get(i).click();
                break;
            }
        }
        genderElement.click();*/

        //year of birth
        WebElement yearElement = driver.findElement(By.cssSelector("select[placeholder='Year']"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("2000");

        //password
        WebElement passwordElement = driver.findElement(By.id("firstpassword"));
        passwordElement.sendKeys("pass");

        //confirm password
        WebElement confirmPasswordElement = driver.findElement(By.id("secondpassword"));
        confirmPasswordElement.sendKeys("pass");

        //hhh
    }
}
