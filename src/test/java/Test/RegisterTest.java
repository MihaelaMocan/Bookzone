package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import Pages.RegisterPage;
import Property.PropertyFile;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest extends Base {
    public PageMethod pageMethod;
    public ElementMethod elementMethod;
    public PropertyFile propertyFile;
    public RegisterPage registerPage;

    @Before
    public void setUp(){
        pageMethod = new PageMethod(driver);
        elementMethod = new ElementMethod(driver);
        registerPage = new RegisterPage(driver);
        propertyFile = new PropertyFile("InputData");
    }
    @Test
    public void testNewAccount() {
        String expectedTitle = propertyFile.getValueByKey("librarieOnline");
        pageMethod.validateTitle(expectedTitle);
        pageMethod.validateUrl("https://bookzone.ro/");

        String emailValue = propertyFile.getValueByKey("email");
        String lastNameValue = propertyFile.getValueByKey("lastName");
        String firstNameValue = propertyFile.getValueByKey("firstName");
        String passwordValue = "12345";
        String confirmPasswordValue ="12345";

        registerPage.moveToRegistrationForm(emailValue);
        registerPage.registerProcess(lastNameValue, firstNameValue, passwordValue, confirmPasswordValue);
        registerPage.completeTheProcess();
    }


    @Test
    public void invalidConfirmPasswordTest() {
        String emailValue = propertyFile.getValueByKey("email");
        String lastNameValue = propertyFile.getValueByKey("lastName");
        String firstNameValue = propertyFile.getValueByKey("firstName");
        String passwordValue = "12345";
        String confirmPasswordValue ="123";

        registerPage.moveToRegistrationForm(emailValue);
        registerPage.registerProcess(lastNameValue, firstNameValue, passwordValue, confirmPasswordValue);
        registerPage.completeTheProcess().clickContinueRegisterProcess();
        String expected = "Parola si confirmarea parolei nu coincid";
        registerPage.validateErrorMessage(expected);

    }

    @Test
    public void invalidTermsAndConditions() {
        String emailValue = propertyFile.getValueByKey("email");
        String lastNameValue = propertyFile.getValueByKey("lastName");
        String firstNameValue = propertyFile.getValueByKey("firstName");
        String passwordValue = "12345";
        String confirmPasswordValue ="12345";

        registerPage.moveToRegistrationForm(emailValue);
        registerPage.registerProcess(lastNameValue, firstNameValue, passwordValue, confirmPasswordValue);
        registerPage.clickContinueRegisterProcess();
        String expected = "Te rugam sa accepti termenii si conditiile";
        registerPage.validateErrorMessage(expected);

    }
}
