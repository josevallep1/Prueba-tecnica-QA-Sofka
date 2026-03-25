package interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIInteraction {
    public static Performable acceptAlert() {
        return Task.where("{0} accept alert of modal add product", actor -> {
            BrowseTheWeb.as(actor).waitFor(ExpectedConditions.alertIsPresent());
            BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        });
    }
}
