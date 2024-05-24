package UI.PageObject;

import UI.Abstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CartPageWB extends Abstract {
    public CartPageWB (WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class, 'good-name')]")
    public WebElement goodInfoCart;
    public By goodInfoCartWait = By.xpath("//span[contains(@class, 'good-name')]");
    @FindBy(xpath = "//button[contains(@aria-label, 'Увеличить')]")
    public WebElement btnCountPlus;
    public By btnCountPlusWait = By.xpath("//button[contains(@aria-label, 'Увеличить')]");
    @FindBy(xpath = "//span[contains(@data-link, 'DeliveryPrice')]")
    public WebElement totalPriceCart;
    public By totalPriceCartWait = By.xpath("//span[contains(@data-link, 'DeliveryPrice')]");
    //public String nameGood = goodInfoCart.getText();

    @FindBy(xpath = "(//div[contains(@class, '-new wallet')])[1]")
    public WebElement priceFirstInCart;
    public By priceFirstInCartWait = By.xpath("(//div[contains(@class, '-new wallet')])[1]");
    @FindBy(xpath = "(//div[contains(@class, '-new wallet')])[2]")
    public WebElement priceSecondInCart;
    public By priceSecondInCartWait = By.xpath("(//div[contains(@class, '-new wallet')])[2]");

}
