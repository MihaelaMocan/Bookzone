package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import Pages.SearchBarPage;
import Pages.SigninPage;
import Property.PropertyFile;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchBarTest extends Base {
    public ElementMethod elementMethod;
    public PageMethod pageMethod;
    public PropertyFile propertyFile;
    public SearchBarPage searchBarPage;

    @Before
    public void setUp(){
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
        propertyFile = new PropertyFile("InputData");
        searchBarPage = new SearchBarPage(driver);
    }
    @Test
    public void testSearchBar()  {
        String expectedTitle = propertyFile.getValueByKey("librarieOnline");
        pageMethod.validateTitle(expectedTitle);
        pageMethod.validateUrl("https://bookzone.ro/");

        String bookValue = propertyFile.getValueByKey("book");
        searchBarPage.searchElement();
    }
}
