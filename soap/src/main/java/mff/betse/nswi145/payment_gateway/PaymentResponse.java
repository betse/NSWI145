package mff.betse.nswi145.payment_gateway;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentResponse {
    private String transactionId;
    private String orderId;
    private String status;
    private String message;

    public PaymentResponse() {
    }

    public PaymentResponse(String transactionId, String orderId, String status, String message) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.status = status;
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
