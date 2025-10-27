package payment_processor_with_solid;

public interface PaymentGateway {
    void processPayment(double amount);
}

