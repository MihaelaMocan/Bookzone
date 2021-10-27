package HelpMethod;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageMethod {

    @FindBy(xpath = "//span[contains(text(), 'Toate cărțile')]")
    private WebElement allBooksElement;

    private WebDriver driver;
    private ElementMethod elementMethod;

    public PageMethod(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
    }


    public PageMethod validateTitle(String expectedTitle) {
        String actualPageName = driver.getTitle();
        Assert.assertTrue("Expected is not actual. ", actualPageName.contains(expectedTitle));
        return this;
    }

    public PageMethod validateUrl(String expectedUrl) {
        Assert.assertEquals("Url nu este conform asteptarilor. ", expectedUrl, driver.getCurrentUrl());
        return this;
    }

    public PageMethod goToBooks() {
        elementMethod.clickElement(allBooksElement);
        return this;
    }

}
