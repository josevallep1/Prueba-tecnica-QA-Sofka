package questions;

import jxl.demo.Demo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.DemoBlazeBuyUI;
import utils.ReadJson;

import java.util.Map;

public class BuySuccessfulDemoBlaze implements Question<Boolean> {

    private final Map<String, String> dataJson;

    public BuySuccessfulDemoBlaze(Map<String, String> dataJson) {
        this.dataJson = dataJson;
    }

    public static BuySuccessfulDemoBlaze validateBuy(Map<String, String> dataJson) {
        return new BuySuccessfulDemoBlaze(dataJson);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String messageSucess = Text.of(DemoBlazeBuyUI.MESSAGE_SUCESSFULL).answeredBy(actor);
        String textoRecibo = Text.of(DemoBlazeBuyUI.LBL_CONFIRMATION_DETAILS).answeredBy(actor);
        System.out.println("TEXTO RECIBO: " + textoRecibo);
        String amount = Text.of(DemoBlazeBuyUI.VALUE_AMOUNT_PRODUCTS).answeredBy(actor).trim();
        String dayActual = String.valueOf(java.time.LocalDate.now().getDayOfMonth());
        String monthExpected = dataJson.get("month").trim();
        boolean messageOk = messageSucess.contains(ReadJson.getRootValue("message"));
        boolean id = textoRecibo.matches("(?s).*Id: \\d+.*");
        boolean amountOk = textoRecibo.contains("Amount") && textoRecibo.contains(amount);
        boolean nameOk = textoRecibo.contains("Name: " + dataJson.get("name"));
        boolean cardNumberOk = textoRecibo.contains("Card Number: " + dataJson.get("creditCard"));
        boolean date = textoRecibo.contains("Date: " + dayActual + "/" + monthExpected + "/" + dataJson.get("year"));
        return messageOk && id && amountOk && nameOk && cardNumberOk && date ;
    }
}
