package payment_processor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor("paypal");
        processor.process(100.0);
    }
}
