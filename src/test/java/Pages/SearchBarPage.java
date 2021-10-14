package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBarPage {

    private WebDriver driver;
    private ElementMethod elementMethod;
    private PageMethod pageMethod;

    @FindBy(xpath = "//input[@id='autosuggest__input']")
    private WebElement searchElement;
    @FindBy(xpath = "//button[@class='nav__search-go']")
    private WebElement clickSearchElement;
    @FindBy(xpath = "//i[@class='icon-icon-search']")
    private WebElement buttonElement;


    public SearchBarPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }
    public SearchBarPage searchElement() {
        elementMethod.clickElement(searchElement);
        elementMethod.fillElement(searchElement, "Harry Potter");
        elementMethod.clickElement(buttonElement);
        return this;
    }
}
