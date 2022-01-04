package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedData
{
    //webdriver = variabila care ne ajuta sa interactionam cu site-ul si elementele lui
    public WebDriver driver;

    @Before
    public void setup()
    {
        //specificam unde se afla driverul pt browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Azimut\\Kits\\Automation\\chromedriver.exe");
        //deschidem browserul
        driver = new ChromeDriver();

        //adaugam adresa web
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
