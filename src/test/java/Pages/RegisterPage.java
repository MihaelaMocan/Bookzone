package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;
    private ElementMethod elementMethod;
    private PageMethod pageMethod;

    @FindBy(className = "nav__account__btn")
    private WebElement contulMeuElement;
    @FindBy(xpath = "//a[contains(@href, '/login')]")
    private WebElement creeazaContElement;
    @FindBy(id = "email")
    private WebElement emailElement;
    @FindBy(xpath = "//input[contains(@type, 'submit')]")
    private WebElement submitElement;
    @FindBy(id = "last_name")
    private WebElement lastNameElement;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameElement;
    @FindBy(id = "new-password")
    private WebElement passwordElement;
    @FindBy(id = "confirm-password")
    private WebElement confirmPasswordElement;
    @FindBy(id = "terms")
    private WebElement termsElement;
    @FindBy(id = "confirmation")
    private WebElement confirmationElement;


    public RegisterPage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }
    public RegisterPage moveToRegistrationForm(String email){

        elementMethod.clickElement(contulMeuElement);
        elementMethod.clickElement(creeazaContElement);
        elementMethod.fillElement(emailElement,email);
        elementMethod.clickElement(submitElement);
        return this;
    }

    public RegisterPage registerProcess( String lastName, String firstName, String password,
                                        String confirmPassword) {
        elementMethod.fillElement(lastNameElement,lastName);
        elementMethod.fillElement(firstNameElement,firstName);
        elementMethod.fillElement(passwordElement,password);
        elementMethod.fillElement(confirmPasswordElement,confirmPassword);
        return this;
    }
    public RegisterPage completeTheProcess(){
        elementMethod.clickElement(termsElement);
        elementMethod.clickElement(confirmationElement);
        return this;
    }
}
