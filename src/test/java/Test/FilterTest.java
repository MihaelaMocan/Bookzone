package Test;

import Base.Base;
import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
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
        String lower = propertyFile.getValueByKey("priceLowerLimit");
        String upper = propertyFile.getValueByKey("priceUpperLimit");

        filterPage.goToFilter().selectPriceRange(lower, upper);
        elementMethod.threadSleep();
        filterPage.validatePriceRange(lower, upper);

    }

    @Test
    public void testEditura() {
        String editura = propertyFile.getValueByKey("editura");
        filterPage.goToFilter().cautaEditura(editura).clickCheckbox().clickOnBooksAndValidateEditura(editura,3);
        elementMethod.threadSleep();
    }





}
