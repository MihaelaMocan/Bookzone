package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import Pages.AddToCartPage;
import Pages.FilterPage;
import Property.PropertyFile;
import org.junit.Before;
import org.junit.Test;

public class FilterTest extends Base {
    public ElementMethod elementMethod;
    public PageMethod pageMethod;
    public PropertyFile propertyFile;
    public FilterPage filterPage;
    @Before
    public void setUp(){
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
        filterPage = new FilterPage(driver);
        propertyFile = new PropertyFile("InputData");
        elementMethod.clickAcceptIfPresent();

    }
    @Test
    public void testFilterPrice() {
        //todo upper si lower limit sa vina din fisieru de configurari
        int lowerLimit = 50;
        int upperLimit = 100;
        filterPage.goToFilter().selectPriceRange(lowerLimit, upperLimit);
        filterPage.validatePriceRange(lowerLimit, upperLimit);

    }
}
