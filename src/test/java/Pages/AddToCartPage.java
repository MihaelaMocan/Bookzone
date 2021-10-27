package Pages;

import HelpMethod.ElementMethod;
import HelpMethod.PageMethod;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddToCartPage {

    private WebDriver driver;
    private ElementMethod elementMethod;
    private PageMethod pageMethod;


    @FindBy(xpath = "//span[contains(text(), 'Toate cărțile')]")
    private WebElement allBooksElement;
    @FindBy(xpath = "//a[@href='/cos/produse']")
    private WebElement cartElement;
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
    @FindBy(css = "div.cart1__details div.cart1__item div.cart1__price.cart1__price--mobile a.cart1__price__remove")
    private List<WebElement> removeAllBooks;
    @FindBy(css = "a.btn.btn-specs2")
    private WebElement continuaCumparaturile;
    @FindBy(css = "p.filters__item__title")
    private List<WebElement> titleBooksInSearchPage;
    @FindBy(css = "p.cart1__book__title")
    private List<WebElement> titleBooksInCartPage;


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethod = new ElementMethod(driver);
        pageMethod = new PageMethod(driver);
    }

    public AddToCartPage goToBooks() {
        elementMethod.clickElement(allBooksElement);
        return this;
    }

    public AddToCartPage goToCart() {
        elementMethod.clickElement(cartElement);
        return this;
    }

    public AddToCartPage stepsToAdd() {
        elementMethod.waitUntillElementVisible(oneBookElemenet);
        elementMethod.clickElement(oneBookElemenet);
        elementMethod.clickElement(continuaElements);
        return this;
    }

    /**
     * iterate over the first numberOfBooks buttons and click add
     * Also produce a list of book title for which button was clicked and return it
     *
     * @param numberOfBooks to be added to cart
     * @return list of titles of books that were added to cart
     */
    public List<String> addMultipleBooks(Integer numberOfBooks) {
        elementMethod.waitUntillElementVisibleAllElements(moreBooksElemenets);
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < numberOfBooks; i++) {
            WebElement element = moreBooksElemenets.get(i);
            elementMethod.clickElement(element);
            elementMethod.clickElement(continuaElements);
            String titlu = titleBooksInSearchPage.get(i).getText();
            titles.add(titlu);
        }
        return titles;
    }

    public AddToCartPage removeAllSelectedBooks() {
        elementMethod.waitUntillElementVisibleAllElements(removeAllBooks);
        while (removeAllBooks.size() != 0) {
            WebElement deleteElement = removeAllBooks.get(0);
            elementMethod.clickElement(deleteElement);
        }
        return this;
    }

    public AddToCartPage continuaCumparaturi() {
        elementMethod.clickElement(continuaCumparaturile);
        return this;
    }

    public AddToCartPage deleteOrder() {
        elementMethod.clickElement(deleteOrderElement);
        return this;
    }

    public void validateTitlesExist(List<String> titles) {
        elementMethod.waitUntillElementVisibleAllElements(titleBooksInCartPage);
        for (WebElement element : titleBooksInCartPage) {
            String titlu = element.getText();
            Assert.assertTrue("Titlul nu a fost gasit!", titles.contains(titlu));
        }
    }

    public List<String> addToCartRandomBooks(Integer number) {
        elementMethod.waitUntillElementVisibleAllElements(moreBooksElemenets);
        List<String> titles = new ArrayList<>();

        Random rand = new Random();
        while (number > 0) {

            int int_random = rand.nextInt(moreBooksElemenets.size());
            WebElement element = moreBooksElemenets.get(int_random);
            elementMethod.hoverElement(element);
            element.click();

            elementMethod.threadSleep();
            elementMethod.clickElement(continuaElements);
            String title = titleBooksInSearchPage.get(int_random).getText();
            titles.add(title);
            number = number - 1;
        }


        return titles;

    }


}


