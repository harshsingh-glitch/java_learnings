package payment_processor_with_solid;

public class Main {
    public static void main(String[] args) {
        PaymentGateway gateway = new PayPalGateway(); // Could be StripeGateway, RazorPay, etc.
        Notifier notifier = new EmailNotifier();
        LoggerService logger = new LoggerService();

        PaymentProcessor processor = new PaymentProcessor(gateway, notifier, logger);
        processor.process(150.0);
    }
}
