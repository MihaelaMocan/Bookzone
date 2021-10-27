package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {


    protected final static String HOME_PAGE = "https://bookzone.ro/";
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(HOME_PAGE);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
