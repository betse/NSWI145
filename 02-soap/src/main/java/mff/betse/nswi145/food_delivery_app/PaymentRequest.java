package mff.betse.nswi145.food_delivery_app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentRequest {

    private String orderId;
    private String cardNumber;
    private String cardExpiration;
    private String cardCvc;
    private String amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }    

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }    

    public String getCardExpiration() {
        return cardExpiration;
    }    

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }    

    public String getCardCvc() {
        return cardCvc;
    }    

    public void setCardCvc(String cardCvc) {
        this.cardCvc = cardCvc;
    }    

    public String getAmount() {
        return amount;
    }    

    public void setAmount(String amount) {
        this.amount = amount;
    }   

}
