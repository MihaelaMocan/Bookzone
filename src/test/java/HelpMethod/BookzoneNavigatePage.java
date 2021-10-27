package HelpMethod;

import Pages.AddToCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookzoneNavigatePage {

    private WebDriver driver;
    private ElementMethod elementMethod;

    public BookzoneNavigatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.elementMethod = new ElementMethod(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Toate cărțile')]")
    private WebElement allBooksElement;
    @FindBy(xpath = "//a[@href='/cos/produse']")
    private WebElement cartElement;



    public BookzoneNavigatePage goToBooks() {
        elementMethod.clickElement(allBooksElement);
        return this;
    }

    public BookzoneNavigatePage goToCart() {
        elementMethod.clickElement(cartElement);
        return this;
    }
}
