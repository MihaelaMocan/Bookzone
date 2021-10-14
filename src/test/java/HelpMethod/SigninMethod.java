package HelpMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninMethod {

    WebDriver driver;

    private void clickAndSendTextToId(String id, String text) {
        WebElement emailElement = driver.findElement(By.id(id));
        emailElement.click();
        emailElement.sendKeys(text);
    }
}
