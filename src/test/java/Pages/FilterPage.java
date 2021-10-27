package Pages;

import HelpMethod.BookzoneNavigatePage;
import org.openqa.selenium.WebDriver;

public class FilterPage {

    private WebDriver driver;
    private BookzoneNavigatePage bookzoneNavigatePage;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        bookzoneNavigatePage = new BookzoneNavigatePage(driver);
    }


    public FilterPage goToFilter(){
        bookzoneNavigatePage.goToBooks();
        return this;
    }

    public void selectPriceRange(int lowerLimit, int upperLimit) {

    }

    public void validatePriceRange(int lowerLimit, int upperLimit) {

    }
}
