package luis122448.payments;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentRequest request = new PaymentRequest(amount);
        PaymentResponse response = paymentGateway.requestPayment(request);
        return response.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

}
