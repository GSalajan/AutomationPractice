package Base;

import PropertyUtility.PropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SharedData
{
    //webdriver = variabila care ne ajuta sa interactionam cu site-ul si elementele lui
    private WebDriver driver;

    public void initiateDriver()
    {
        PropertyFile driverResource = new PropertyFile("DriverData/DriverResource");
        System.setProperty(driverResource.getValue("driverBrowser"), driverResource.getValue("location"));
        driver = new ChromeDriver();
        driver.get(driverResource.getValue("url"));
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitBrowser()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
