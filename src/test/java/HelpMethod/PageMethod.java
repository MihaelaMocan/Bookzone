package HelpMethod;

import Pages.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMethod {

    public WebDriver driver;
    public PageMethod(WebDriver driver) {
        this.driver = driver;
    }

    public PageMethod validateTitle(String expectedTitle) {
        String actualPageName = driver.getTitle();
        Assert.assertTrue("Expected is not actual. ",actualPageName.contains(expectedTitle));
        return this;
    }
    public PageMethod validateUrl(String expectedUrl){
        Assert.assertEquals("Url nu este conform asteptarilor. ", expectedUrl ,driver.getCurrentUrl()  );
        return this;
}

    public void waitUntilElementVisible(By element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void continua() {
        WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn-details-back']"));
        continueButton.click();
    }
}
