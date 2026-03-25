package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DemoBlazeBuyUI {

    public static final Target PRODUCT = Target.the("Add product")
            .locatedBy("//h4[@class='card-title']//a[text()='{0}']");

    public static final Target LINK_HOME = Target.the("Return to home")
            .locatedBy("//a[contains(text(),'Home')]");

    public static final Target BUTTON_ADD_CART = Target.the("Button add to cart")
            .locatedBy("//a[normalize-space()='Add to cart']");

    public static final Target LINK_CART = Target.the("Link cart")
            .locatedBy("//a[contains(text(),'Cart')]");

    public static final Target BTN_PLACE_ORDER = Target.the("Button open form buy")
            .locatedBy("//button[@data-target='#orderModal']");

    public static final Target INPUT_NAME_BUY = Target.the("Input name form buy")
            .locatedBy("//input[@id='name' and @class='form-control']");

    public static final Target INPUT_COUNTRY_BUY = Target.the("Input country form buy")
            .locatedBy("//*[@id='country']");

    public static final Target INPUT_CITY_BUY = Target.the("Input city form buy")
            .locatedBy("//*[@id='city']");

    public static final Target INPUT_CREDIT_CARD_BUY = Target.the("Input credit card form buy")
            .locatedBy("//*[@id='card']");

    public static final Target INPUT_MONTH_BUY = Target.the("Input month form buy")
            .locatedBy("//*[@id='month']");

    public static final Target INPUT_YEAR_BUY = Target.the("Input year form buy")
            .locatedBy("//*[@id='year']");

    public static final Target BUTTON_PURCHASE = Target.the("Button purchase form buy")
            .locatedBy("//button[text()='Purchase']");

    public static final Target MESSAGE_SUCESSFULL = Target.the("Message sucessfull purchase")
            .locatedBy("//h2[text()='Thank you for your purchase!']");

    public static final Target LBL_CONFIRMATION_DETAILS = Target.the("Details of purchase confirmation")
            .locatedBy("//p[contains(@class, 'text-muted')]");


    public static final Target VALUE_AMOUNT_PRODUCTS = Target.the("Details of purchase confirmation")
            .locatedBy("//p[contains(@class, 'text-muted')]");//label[@id='totalm']























}
