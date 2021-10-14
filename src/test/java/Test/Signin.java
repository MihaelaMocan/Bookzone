package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import HelpMethod.SigninMethod;
import Pages.RegisterPage;
import Pages.SigninPage;
import Property.PropertyFile;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class Signin extends Base {
    public SigninPage signinPage;
    public ElementMethod elementMethod;
    public PropertyFile propertyFile;
    public PageMethod pageMethod;

    @Before
    public void setUp(){
        signinPage = new SigninPage(driver);
        elementMethod = new ElementMethod(driver);
        propertyFile = new PropertyFile("InputData");
        pageMethod = new PageMethod(driver);
    }

    @Test
    public void SigninTest() {

        String expectedTitle = propertyFile.getValueByKey("librarieOnline");
        pageMethod.validateTitle(expectedTitle);
        pageMethod.validateUrl("https://bookzone.ro/");

        String emailValue = propertyFile.getValueByKey("LoginMail");
        String passwordValue = propertyFile.getValueByKey("LoginPassword");

        signinPage.stepsToSignin();
        signinPage.SigninProcess(emailValue, passwordValue);


    }

}
