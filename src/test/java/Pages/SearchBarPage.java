package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(css = "p.filters__item__title")
    private List<WebElement> titleBooksInSearchPage;

    public SearchBarPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }

    public SearchBarPage searchBookName(String bookValue) {
        elementMethod.clickElement(searchElement);
        elementMethod.fillElement(searchElement, bookValue);
        elementMethod.clickElement(buttonElement);
        return this;
    }

    public void validateBookTitleFound(String bookTitle) {
        elementMethod.waitUntillElementVisibleAllElements(titleBooksInSearchPage);
        boolean titleFound = false;
        for(WebElement titleElement: titleBooksInSearchPage){
            if(titleElement.getText().contains(bookTitle)){
                titleFound = true;
                break;
            }
        }


        Assert.assertTrue("expected title not found in titles "+ bookTitle, titleFound);
        System.out.println("S-a gasit o carte cu titlu: "+ bookTitle);
    }

    public void validateNoBookFound() {
        Assert.assertTrue("Au fost gasite carti cand nu ne asteptam", titleBooksInSearchPage.size() == 0);
        System.out.println("Nu au fost gasite rezultate.");
    }
}
