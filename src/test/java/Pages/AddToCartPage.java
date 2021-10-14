package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCartPage {

    private WebDriver driver;
    private ElementMethod elementMethod;
    private PageMethod pageMethod;



    @FindBy(xpath = "//span[contains(text(), 'Toate cărțile')]")
    private WebElement allBooksElement;
    @FindBy(xpath = "//p[@class='btn-txt']")
    private WebElement oneBookElemenet;
    @FindBy(css = ".btn.btn-details")
    private WebElement finishOrderElemenet;
    @FindBy(xpath = "//a[@class='cart1__price__remove']")
    private WebElement deleteOrderElement;
    @FindBy(css = "div.cat-content__container div a p.btn-txt")
    private List<WebElement> moreBooksElemenets;
    @FindBy(xpath = "//a[@class='btn-details-back']")
    private WebElement continuaElements;
    @FindBy(xpath = "//a[@href='/cos/produse']")
    private WebElement cartElement;
    @FindBy(css = "div.cart1__details div.cart1__item div.cart1__price.cart1__price--mobile a.cart1__price__remove")
    private List<WebElement> removeAllBooks;
    @FindBy(css = "a.btn.btn-specs2")
    private WebElement continuaCumparaturile;


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }
    public AddToCartPage goToBooks(){
        elementMethod.clickElement(allBooksElement);
        return this;
    }
    public AddToCartPage goToCart(){
        elementMethod.clickElement(cartElement);
        return this;
    }

    public AddToCartPage stepsToAdd() {
        elementMethod.clickElement(oneBookElemenet);
        elementMethod.clickElement(continuaElements);
        return this;
    }
    public AddToCartPage addMultipleBooks(Integer numberOfBooks) {
       // List<WebElement> elements = driver.findElements(By.cssSelector("div.cat-content__container div a p.btn-txt"));
        elementMethod.waitUntillElementVisibleAllElements(moreBooksElemenets);
        for(int i =0;i<numberOfBooks; i++) {
            WebElement element = moreBooksElemenets.get(i);
            elementMethod.clickElement(element);
            elementMethod.clickElement(continuaElements);
        }
        return this;
    }
    public AddToCartPage removeAllSelectedBooks() {
        elementMethod.waitUntillElementVisibleAllElements(removeAllBooks);
        while (removeAllBooks.size() != 0) {
            WebElement deleteElement = removeAllBooks.get(0);
            elementMethod.clickElement(deleteElement);
        }
        return this;
    }
    public AddToCartPage continuaCumparaturi(){
        elementMethod.clickElement(continuaCumparaturile);
        return this;
    }
    public AddToCartPage deleteOrder() {
        elementMethod.clickElement(deleteOrderElement);
        return this;
    }
}


