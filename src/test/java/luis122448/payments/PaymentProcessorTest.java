package luis122448.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

//    @Test
//    public void payment_is_correct() {
//        // Arrange ( Preparar )
//        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
//        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
//        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
//        // Act ( Actuar )
//        boolean result = paymentProcessor.makePayment(1000);
//        // Assert ( Afirmar )
//        assertTrue(result);
//    }
//
//    @Test
//    public void payment_is_incorrect() {
//        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
//        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
//        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
//        assertFalse(paymentProcessor.makePayment(1000));
//    }

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_incorrect() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        assertFalse(paymentProcessor.makePayment(1000));
    }

}