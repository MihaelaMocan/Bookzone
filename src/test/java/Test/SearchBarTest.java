package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import Pages.SearchBarPage;
import Property.PropertyFile;
import org.junit.Before;
import org.junit.Test;

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

        String bookTitle = propertyFile.getValueByKey("book");
        searchBarPage.searchBookName(bookTitle).validateBookTitleFound(bookTitle);
    }

    @Test
    public void invalidInputSearchbarTest() {
        String invalidBook=propertyFile.getValueByKey("invalidBook");
        searchBarPage.searchBookName(invalidBook).validateNoBookFound();
    }
}
