package UI.Tests;

import UI.Abstract;
import UI.PageObject.CartPageWB;
import UI.PageObject.MainPageWB;
import UI.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
@Feature("Тесты связанные с провекрой добавления товара в корзину")
public class WBTests extends Abstract {
    MainPageWB mainPageWB;
    CartPageWB cartPageWB;

    @Owner("Марина")
    @DisplayName("Проверка на добавление товара в корзину")
    @Step("Добавляем товар в корзину")
    @Test
    public void cartTet1() {
        mainPageWB = new MainPageWB(driver);
        driver.get(mainPageWB.wb);
        int priceFirstItemMainPage = getPriceWithoutCurrency(mainPageWB.priceFirstWait);
        System.out.println(priceFirstItemMainPage);

        clickOnElement(mainPageWB.btnAddProductWait);

        if(mainPageWB.isDisplayed(mainPageWB.sizeWait)) {
            clickOnElement(mainPageWB.sizeWait);
        }

        clickOnElement(mainPageWB.btnAddProductSecondWait);

        if(mainPageWB.isDisplayed(mainPageWB.sizeWait)) {
                clickOnElement(mainPageWB.sizeWait);
        }
        int priceSecondItemMainPage = getPriceWithoutCurrency(mainPageWB.priceSecondWait);
        System.out.println(priceSecondItemMainPage);
        clickOnElement(mainPageWB.cartWait);
        cartPageWB = new CartPageWB(driver);
        //cartPageWB.clickOnElement(cartPageWB.btnCountPlusWait);
        int priceFirstItemCartPage = getPriceWithoutCurrency(cartPageWB.priceFirstInCartWait);
        System.out.println(priceFirstItemCartPage);
        int priceSecondItemCartPage = getPriceWithoutCurrency(cartPageWB.priceSecondInCartWait);
        System.out.println(priceSecondItemCartPage);

        Assertions.assertEquals(priceFirstItemMainPage, priceFirstItemCartPage, "Цена товара на главной странице не равна цене товара в корзине");
        Assertions.assertEquals(priceSecondItemMainPage, priceSecondItemCartPage, "Цена товара на главной странице не равна цене товара в корзине");
    }
}
