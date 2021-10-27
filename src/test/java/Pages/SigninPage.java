package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

    private WebDriver driver;
    private ElementMethod elementMethod;
    private PageMethod pageMethod;

    @FindBy(className = "nav__account__btn")
    private WebElement logInElement;
    @FindBy(xpath = "//a[contains(@href,'/login')]")
    private WebElement intraInContElement;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailElement;
    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement submitElement;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordElement;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButtonElement;
    @FindBy(css = "div.err-login")
    private WebElement errorMessageElement;


    public SigninPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }
    public SigninPage stepsToSignin() {
        elementMethod.clickElement(logInElement);
        elementMethod.clickElement(intraInContElement);
        return this;
    }
    public SigninPage signInEmailFill(String email) {
        elementMethod.fillElement(emailElement, email);
        elementMethod.clickElement(submitElement);
        return this;
    }

    public SigninPage signInPassword(String password) {
        elementMethod.fillElement(passwordElement,password);
        elementMethod.clickElement(loginButtonElement);
        return  this;
    }

    public void validateErrorMessage(String expected) {
       elementMethod.waitUntillElementVisible(errorMessageElement);
       String actual = errorMessageElement.getText();
        Assert.assertEquals(expected, actual);
    }
}
