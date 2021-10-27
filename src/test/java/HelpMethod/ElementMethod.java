package HelpMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementMethod {

    public WebDriver driver;

    public ElementMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        waitUntillElementVisible(element);
        element.click();
    }
    public void fillElement(WebElement element, String value) {
        waitUntillElementVisible(element);
        element.sendKeys(value);
    }
    public void hoverElement(WebElement element){
        waitUntillElementVisible(element);
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }
    public  void waitUntillElementVisible(WebElement element){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
    }

    public  void waitUntillElementVisibleAllElements(List<WebElement> element){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public  void waitUntillElementVisibleAllElements(List<WebElement> element, int waitingSecond){
        new WebDriverWait(driver,waitingSecond).until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public void clickAcceptIfPresent(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.cookies_buton a"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (elements.size()!= 0){
            elements.get(0).click();
        }
    }


    public void threadSleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearInput(WebElement element) {
        waitUntillElementVisible(element);
        element.clear();
    }

    public void pageBack() {
        driver.navigate().back();
    }
}
