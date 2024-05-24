package UI.PageObject;

import UI.Abstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPageWB extends Abstract {
    public MainPageWB (WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);
    }
    public String wb = "https://www.wildberries.ru/";
    @FindBy(xpath = "//a[contains(@class, 'add-basket')]")
    public WebElement btnAddProduct;
    public By btnAddProductWait = By.xpath("//a[contains(@class, 'add-basket')]");
    @FindBy(xpath = "(//a[contains(@class, 'add-basket')])[2]")
    public WebElement btnAddProductSecond;
    public By btnAddProductSecondWait = By.xpath("(//a[contains(@class, 'add-basket')])[2]");
    @FindBy(xpath = "//label[contains(@class, 'sizes')]")
    public WebElement size;

    public By sizeWait = By.xpath("//li[contains(@class, 'sizes-list')]");
    @FindBy(xpath = "//span[@class='product-card__name']")
    public WebElement productCardName;
    public By productCardNameWait = By.xpath("//span[@class='product-card__name']");
    @FindBy(xpath = "//a[@data-wba-header-name='Cart']")
    public WebElement cart;
    public By cartWait = By.xpath("//a[@data-wba-header-name='Cart']");

    @FindBy(xpath = "//p[contains(@class, '__price')]//ins")
    public WebElement priceFirst;
    public By priceFirstWait = By.xpath("//p[contains(@class, '__price')]//ins");
    @FindBy(xpath = "(//p[contains(@class, '__price')]//ins)[2]")
    public WebElement priceSecond;
    public By priceSecondWait = By.xpath("(//p[contains(@class, '__price')]//ins)[2]");

}
