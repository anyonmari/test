package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Abstract {
    public static EventFiringWebDriver driver;
    public static ChromeOptions options;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new EventFiringWebDriver(new ChromeDriver(options));
        wait = new WebDriverWait(driver,30);
        actions = new Actions(driver);
        driver.register(new Custom());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    public void waitElement (By locator) {
        wait.until(visibilityOfElementLocated(locator));
    }

    public void clickOnElement(By locator){
        waitElement(locator);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }
    public void moveToElement(By locator){
        waitElement(locator);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element);
        actions.perform();
    }
    public boolean isDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String getTextWebElement (By locator) {
        waitElement(locator);
        WebElement element = driver.findElement(locator);
        String text = element.getText();
        return text;
    }
    public int getPriceWithoutCurrency (By locator) {
        moveToElement(locator);
        return  Integer.parseInt(getTextWebElement(locator).chars()
                .filter(Character::isDigit)
                .mapToObj(Character::toString)
                .collect(Collectors.joining()));

    }
}
