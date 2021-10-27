package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilterPage {

    private WebDriver driver;
    private ElementMethod elementMethod;
    private PageMethod pageMethod;

    @FindBy(xpath = "//div[@class='number-group']/input[@type='number']")
    private List<WebElement> priceRangeElements;
    @FindBy(xpath = "//input[@value='Aplică']")
    private WebElement applyPriceRange;
    @FindBy(css = "p.filters__item__price--new")
    private List<WebElement> priceElements;
    @FindBy(xpath = "//input[@id='search-auth']")
    private WebElement edituraElement;
    @FindBy(xpath = "//input[contains(@name,'attribute_undefined')]")
    private WebElement checkEdituraElement;
    @FindBy(css = "div.filters__item-img a")
    private List<WebElement> detailsPageLinks;
    @FindBy(xpath = "//div[@class='product_details_detail_bottom']")
    private  List<WebElement> valoareaSpecificatiilor;


    public FilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }


    public FilterPage goToFilter(){
        pageMethod.goToBooks();
        return this;
    }

    public void selectPriceRange(String lowerLimit, String upperLimit) {
        elementMethod.waitUntillElementVisibleAllElements(priceRangeElements);
        WebElement minimPriceRange = priceRangeElements.get(0);
        elementMethod.hoverElement(minimPriceRange);
        elementMethod.clearInput(minimPriceRange);
        elementMethod.fillElement(minimPriceRange, lowerLimit);
        WebElement maximPriceRange = priceRangeElements.get(1);
        elementMethod.clearInput(maximPriceRange);
        elementMethod.fillElement(maximPriceRange, upperLimit);
        elementMethod.clickElement(applyPriceRange);
    }

    public void validatePriceRange(String lowerLimit, String upperLimit) {
        elementMethod.waitUntillElementVisibleAllElements(priceElements);
        for (WebElement priceElement : priceElements) {
            String price = priceElement.getText().replace(" Lei","");
            double doublePrice = Double.valueOf(price);
            boolean priceIsNotBetweenMinMax = Double.valueOf(lowerLimit) > doublePrice || Double.valueOf(upperLimit) < doublePrice;
            Assert.assertFalse(priceIsNotBetweenMinMax);
        }
        System.out.println("Cartile se afla in intervalul: " + lowerLimit + " - " + upperLimit);
    }



    public FilterPage cautaEditura(String editura) {
        elementMethod.waitUntillElementVisible(edituraElement);
        elementMethod.fillElement(edituraElement, editura);
        return this;
    }
    public FilterPage clickCheckbox() {
        elementMethod.waitUntillElementVisible(checkEdituraElement);
        elementMethod.clickElement(checkEdituraElement);
        return this;
    }
    //div.product_details_detail_bottom::nth-child(4)
    public FilterPage clickOnBooksAndValidateEditura(String editura, Integer numarVerificari){
        elementMethod.waitUntillElementVisibleAllElements(detailsPageLinks);
        int bookIndex=0;
        int allBoxSize = detailsPageLinks.size();
        if (allBoxSize < numarVerificari){
            numarVerificari = allBoxSize;
        }
        while(bookIndex < numarVerificari){
            WebElement element = detailsPageLinks.get(bookIndex);
            bookIndex++;
            elementMethod.hoverElement(element);
            elementMethod.clickElement(element);
            elementMethod.threadSleep();
            elementMethod.waitUntillElementVisibleAllElements(valoareaSpecificatiilor);
            String valoareaEditurii = valoareaSpecificatiilor.get(2).getText();
            Assert.assertTrue("Valoarea editurii trebuie sa fie " + editura , editura.contains(valoareaEditurii));
            elementMethod.pageBack();
            elementMethod.waitUntillElementVisibleAllElements(detailsPageLinks);
        }
        System.out.println("Editura " + editura + " este prezenta la specificatii.");
        return this;
    }
}
