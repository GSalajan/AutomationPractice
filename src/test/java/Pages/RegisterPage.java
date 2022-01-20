package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

public class RegisterPage extends BasePage
{
    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'SwitchTo')]")
    private WebElement switchToElement;
    @FindBy(xpath = "//a[contains(text(), 'Frames')]")
    private WebElement frameElement;
    @FindBy(xpath = "//a[contains(text(),'Alert')]")
    private WebElement alertElement;
    @FindBy(xpath = "//a[contains(text(), 'Windows')]")
    private WebElement windowElement;

    @FindBy(id = "imagesrc")
    private WebElement pictureElement;
    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;
    @FindBy(css = "textarea[ng-model='Adress']")
    private WebElement adresaElement;
    @FindBy(id = "imagesrc")
    private WebElement imageElement;
    @FindBy(css = "input[type='email']")
    private WebElement emailElement;
    @FindBy(css = "input[type='tel']")
    private WebElement telElement;
    @FindBy(css = "input[type='radio']")
    private List<WebElement> genderListElement;
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> hobbyListElement;
    @FindBy(id = "msdd")
    private WebElement languageElement;
    @FindBy(xpath = "//li[@class='ng-scope']/a")
    private List<WebElement> languageElements;
    @FindBy(id = "Skills")
    private WebElement skillsElement;
    @FindBy(css = "span[aria-labelledby='select2-country-container']")
    private WebElement countryElement;
    @FindBy(id = "yearbox")
    private WebElement yearElement;
    @FindBy(css = "select[placeholder='Month']")
    private WebElement monthElement;
    @FindBy(id = "daybox")
    private WebElement dayElement;
    @FindBy(id = "firstpassword")
    private WebElement parolaElement;
    @FindBy(id = "secondpassword")
    private WebElement confirmareParolaElement;
    @FindBy(id = "submitbtn")
    private WebElement submitElement;

    public void goToFramePage()
    {
        //interactiune cu meniul Switch to
        elementHelper.hoverElement(switchToElement);
        elementHelper.clickElement(frameElement);
        //"sarim" peste adds
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //get vs navigate : get acceseaza url si asteapta sa se incarce pagina; navigate doar acceseaza url
    }
    public void goToAlertPage(){
        //interactiune cu meniul Switch to
        elementHelper.hoverElement(switchToElement);
        //identificare "alerts"
        elementHelper.clickElement(alertElement);
        //"sarim" peste adds
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

    }
    public void goToWindowPage()
    {
        //interactiune cu meniul Switch to
        elementHelper.hoverElement(switchToElement);
        elementHelper.clickElement(windowElement);
        //"sarim" peste adds
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //get vs navigate : get acceseaza url si asteapta sa se incarce pagina; navigate doar acceseaza url
    }

    public void validRegisterProcess(HashMap<String, String> values){
        fillFirstName(values.get("firstName"));
        fillLastName(values.get("lastName"));
        fillEmail(values.get("email"));
        fillAdresa(values.get("address"));
        fillTelefon(values.get("phone"));
        clickGender(values.get("gender"));
        clickHobby(values.get("hobby"));
        //sendPicture(values.get("picture"));
        chooseLanguage(values.get("language"));
        selectSkill(values.get("skill"));
        elementHelper.scrollByPixel(0, 500);
        selectYear(values.get("year"));
        selectMonth(values.get("month"));
        selectDay(values.get("day"));
        fillPassword(values.get("password"));
        fillConfirmPassword(values.get("confirmPassword"));
    }

    public void fillFirstName(String value)
    {
        elementHelper.fillElement(firstNameElement,value);
    }

    public void fillLastName(String value)
    {
        elementHelper.fillElement(lastNameElement,value);
    }

    public void fillAdresa(String value)
    {
        elementHelper.fillElement(adresaElement,value);
    }

    public void sendPicture(String value)
    {
        imageElement.sendKeys(value);
    }

    public void fillEmail(String value)
    {
        elementHelper.fillElement(emailElement,value);
    }

    public void fillTelefon(String value)
    {
        elementHelper.fillElement(telElement,value);
    }

    public void clickGender(String gender)
    {
        switch (gender){
            case "Male":
                elementHelper.clickElement(genderListElement.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderListElement.get(1));
                break;
        }
    }

    public void clickHobby(String hobby)
    {
        switch (hobby){
            case "Cricket":
                elementHelper.clickElement(hobbyListElement.get(0));
                break;
            case "Movies":
                elementHelper.clickElement(hobbyListElement.get(1));
                break;
            case "Hockey":
                elementHelper.clickElement(hobbyListElement.get(2));
                break;
        }
    }

    public void chooseLanguage(String language)
    {
        elementHelper.scrollByPixel(0,500);
        elementHelper.clickElement(languageElement);
        for(WebElement element: languageElements){
            if(element.getText().equals(language)){
                element.click();
                break;
            }
        }

        //clic altundeva pe pagina pt a inchide dropdownul de la language
        elementHelper.clickElement(telElement);
    }

    public void selectSkill(String value)
    {
        elementHelper.selectByTextElement(skillsElement, value);
    }

    public void chooseCountry()
    {

    }
//    //country
//    WebElement countryElement = getDriver().findElement(By.cssSelector("span[aria-labelledby='select2-country-container']"));
//        elementMethods.clickElement(countryElement);
//    /*
//            //parcurgem lista de tari si selectam tara dorita
//            List<WebElement> countryElements = driver.findElements(By.xpath("//*[@id='country']/option"));
//            for (Integer i = 0;i < countryElements.size();i++){
//                if (countryElements.get(i).getText().equals("India")){
//                    countryElements.get(i).click();
//                }
//            }
//    */
    public void selectYear(String value)
    {
        elementHelper.selectByValueElement(yearElement, value);
    }
    public void selectMonth(String value)
    {
        elementHelper.selectByValueElement(monthElement, value);
    }
    public void selectDay(String value)
    {
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue(value);
    }
    public void fillPassword(String value)
    {
        elementHelper.fillElement(parolaElement, value);
    }
    public void fillConfirmPassword(String value)
    {
        elementHelper.fillElement(confirmareParolaElement, value);
    }
    public void clickSubmit()
    {
        elementHelper.clickElement(submitElement);
    }

//    //comparam url-ul curent cu url-ul paginii de register, daca nu s-a schimbat nu a trecut testul
//    String actualRegisterDoi = getDriver().getTitle();
//    String urlPagina = "http://demo.automationtesting.in/Register.html";
//        Assert.assertTrue("Testul NU a functionat",urlPagina.contains("Register"));
//
//
}
