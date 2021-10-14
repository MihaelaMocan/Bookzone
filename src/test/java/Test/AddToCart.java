package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import Pages.AddToCartPage;
import Property.PropertyFile;
import org.junit.Test;

public class AddToCart extends Base {

    public ElementMethod elementMethod;
    public PageMethod pageMethod;
    public PropertyFile propertyFile;
    public AddToCartPage addToCartPage;

    public void setUp(){
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
        propertyFile = new PropertyFile("InputData");
        addToCartPage = new AddToCartPage(driver);
    }
    @Test
    public void testAddToCart() {
        setUp();
        String expectedTitle = propertyFile.getValueByKey("librarieOnline");
        pageMethod.validateTitle(expectedTitle);
        pageMethod.validateUrl("https://bookzone.ro/");

        addToCartPage.goToBooks().stepsToAdd();
        addToCartPage.goToCart().deleteOrder();
    }

    @Test
    public void testAddToCartMultipleBooks() {
        setUp();
        addToCartPage.goToBooks().addMultipleBooks(2);
        addToCartPage.goToCart().removeAllSelectedBooks();
        addToCartPage.continuaCumparaturi();

    }

}
