package tasks;

import interaction.UIInteraction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userinterfaces.DemoBlazeBuyUI;
import utils.ReadJson;

import java.time.Duration;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class addProducts {

    public static Performable buyProduct() {
        return Task.where("{0} add products to the cart", actor -> {
            Map<String, String> data = ReadJson.getTestData("products");

            actor.attemptsTo(
                    Click.on(DemoBlazeBuyUI.PRODUCT.of(data.get("product1"))),
                    Click.on(DemoBlazeBuyUI.BUTTON_ADD_CART),
                    UIInteraction.acceptAlert(),
                    Click.on(DemoBlazeBuyUI.LINK_HOME),
                    Click.on(DemoBlazeBuyUI.PRODUCT.of(data.get("product2"))),
                    Click.on(DemoBlazeBuyUI.BUTTON_ADD_CART),
                    UIInteraction.acceptAlert()
            );
        });
    }

    public static Performable theShoppingCart() {
        return Task.where("{0} visible the cart buy", actor -> {
            Map<String, String> dataForm = ReadJson.getTestData("form");

            actor.attemptsTo(
                    Ensure.that(DemoBlazeBuyUI.LINK_CART).isDisplayed(),
                    Click.on(DemoBlazeBuyUI.LINK_CART),
                    Click.on(DemoBlazeBuyUI.BTN_PLACE_ORDER),
                    WaitUntil.the(DemoBlazeBuyUI.INPUT_NAME_BUY, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(dataForm.get("name")).into(DemoBlazeBuyUI.INPUT_NAME_BUY),
                    WaitUntil.the(DemoBlazeBuyUI.INPUT_COUNTRY_BUY, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(dataForm.get("country")).into(DemoBlazeBuyUI.INPUT_COUNTRY_BUY),
                    WaitUntil.the(DemoBlazeBuyUI.INPUT_CITY_BUY, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(dataForm.get("city")).into(DemoBlazeBuyUI.INPUT_CITY_BUY),
                    WaitUntil.the(DemoBlazeBuyUI.INPUT_CREDIT_CARD_BUY, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(dataForm.get("creditCard")).into(DemoBlazeBuyUI.INPUT_CREDIT_CARD_BUY),
                    WaitUntil.the(DemoBlazeBuyUI.INPUT_MONTH_BUY, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(dataForm.get("month")).into(DemoBlazeBuyUI.INPUT_MONTH_BUY),
                    WaitUntil.the(DemoBlazeBuyUI.INPUT_YEAR_BUY, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(dataForm.get("year")).into(DemoBlazeBuyUI.INPUT_YEAR_BUY),
                    Click.on(DemoBlazeBuyUI.BUTTON_PURCHASE)
            );
        });
    }
}
