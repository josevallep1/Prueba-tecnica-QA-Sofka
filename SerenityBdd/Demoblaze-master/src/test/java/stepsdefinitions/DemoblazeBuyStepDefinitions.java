package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.NavigateTo;
import tasks.addProducts;
import utils.ReadJson;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeBuyStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario está en la página de inicio de Demoblaze")
    public void theUserIsOnTheDemoblazeHomepage() {
        theActorCalled("User").wasAbleTo(NavigateTo.navigatePageDemoBlaze());
    }

    @When("agrega productos al carrito")
    public void theyAddProductsToTheCart() {
        theActorInTheSpotlight().attemptsTo(
                addProducts.buyProduct(),
                addProducts.theShoppingCart()
        );
    }
    @Then("completa exitosamente la compra de los productos")
    public void theySuccessfullyCompleteThePurchaseOfTheProducts() {
        Map<String, String> allData = ReadJson.getTestData("form");

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("la compra fue exitosa", questions.BuySuccessfulDemoBlaze.validateBuy(allData),
                        org.hamcrest.Matchers.is(true))
        );

    }
}
