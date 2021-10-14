package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import HelpMethod.SigninMethod;
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
    public SigninPage SigninProcess(String email, String password) {
        elementMethod.fillElement(emailElement, email);
        elementMethod.clickElement(submitElement);
        elementMethod.fillElement(passwordElement,password);
        elementMethod.clickElement(loginButtonElement);
        return this;
    }
}
