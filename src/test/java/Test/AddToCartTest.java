package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import Pages.AddToCartPage;
import Property.PropertyFile;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartTest extends Base {

    public ElementMethod elementMethod;
    public PageMethod pageMethod;
    public PropertyFile propertyFile;
    public AddToCartPage addToCartPage;

    @Before
    public void setUp(){
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
        propertyFile = new PropertyFile("InputData");
        addToCartPage = new AddToCartPage(driver);
        elementMethod.clickAcceptIfPresent();
    }
    @Test
    public void testAddToCartOneBook() {

        String expectedTitle = propertyFile.getValueByKey("librarieOnline");
        pageMethod.validateTitle(expectedTitle);
        pageMethod.validateUrl("https://bookzone.ro/");

        List<String> titles = addToCartPage.goToBooks().addMultipleBooks(1);
        addToCartPage.goToCart().validateTitlesExist(titles);
        addToCartPage.removeAllSelectedBooks();
        addToCartPage.continuaCumparaturi();
    }

    @Test
    public void testAddToCartMultipleBooks() {
        List<String> titles = addToCartPage.goToBooks().addMultipleBooks(3);
        addToCartPage.goToCart().validateTitlesExist(titles);
        addToCartPage.removeAllSelectedBooks();
        addToCartPage.continuaCumparaturi();
    }

    @Test
    public void testAddToCartRandomBooks() {
        List<String> title = addToCartPage.goToBooks().addToCartRandomBooks(2);
        addToCartPage.goToCart().validateTitlesExist(title);
    }

}
