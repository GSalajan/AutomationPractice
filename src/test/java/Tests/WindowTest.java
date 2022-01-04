package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest
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

        //interactiune cu meniul Switch to
        ////a[contains(text(), 'Switch')] -- cautarea elementului dupa text hardcoded
        WebElement switchElement = driver.findElement(By.xpath("//a[contains(text(), 'SwitchTo')]"));

        //simuleaza actiunea de mouse move
        Actions action = new Actions(driver);
        action.moveToElement(switchElement).build().perform();

        //identificare "Windows"
        WebElement windowsElement = driver.findElement(By.xpath("//a[contains(text(), 'Windows')]"));
        windowsElement.click();

        //"sarim" peste adds
        driver.navigate().to("http://demo.automationtesting.in/Windows.html");
        //get vs navigate
        //get acceseaza url si asteapta sa se incarce pagina
        //navigate doar acceseaza url


        //ul[class='nav nav-tabs nav-stacked'] li a     ---> cu ' ' se coboara in ierarhie
        List<WebElement> windowOptions = driver.findElements(By.cssSelector("ul[class = 'nav nav-tabs nav-stacked'] li a"));
        windowOptions.get(0).click();

        WebElement clickButtonElement = driver.findElement(By.cssSelector("#Tabbed a button"));
        clickButtonElement.click();   //--->apare o alerta

        System.out.println("titlul paginii" + driver.getTitle());

        //interactionam cu taburile nou deschise
        //salvam taburile intr-o lista
        //getWindowHandles --> returneaza toate taburile si windows deschise
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //cu index 0 este tabul principal, de aceea folosim index 1
        //trebuie pozitionare explicita pe noul tab, deocarece chiar daca vizual focusul e pe noul tab, intern codul e pe tabul de pe care am pornnit
        driver.switchTo().window(tabs.get(1));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();
        //fortam intoarcerea pe tabul initial (el nu stie sa se miste intre taburi)
        driver.switchTo().window(tabs.get(0));

        //deschide un window now
        windowOptions.get(1).click();
        WebElement clickWindowElement = driver.findElement(By.cssSelector("#Seperate button"));
        clickWindowElement.click();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        //pozitionare in noua ferestra
        driver.switchTo().window(windows.get(1));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));

        windowOptions.get(2).click();
        WebElement clickTabsElement = driver.findElement(By.cssSelector("#Multiple button"));
        clickTabsElement.click();
        ArrayList<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        //pozitionare in noua ferestra
        driver.switchTo().window(multipleTabs.get(2));
        driver.close();
        driver.switchTo().window(multipleTabs.get(1));
        driver.close();
        driver.switchTo().window(multipleTabs.get(0));

        driver.quit();
    }
}
