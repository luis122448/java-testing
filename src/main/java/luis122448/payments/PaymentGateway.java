package luis122448.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
