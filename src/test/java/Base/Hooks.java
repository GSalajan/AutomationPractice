package Base;

import PropertyUtility.PropertyFile;
import org.junit.After;
import org.junit.Before;

import java.util.HashMap;

public class Hooks extends SharedData
{
    public HashMap<String, String> inputData;

    @Before
    public void prepareEnvironment()
    {
        initiateDriver();

        //obtin numele testului care ruleaza
        String testname = this.getClass().getSimpleName();
        //incarc fisierul corespunzator testului care ruleaza
        PropertyFile testData = new PropertyFile("TestData/" + testname + "Resource");
        //se pun toate valorile din fisier intr-un hashmap
        inputData = testData.getAllValues();
    }

    @After
    public void cleanEnvironment()
    {
        //quitBrowser();
    }


}
