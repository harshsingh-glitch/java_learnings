package payment_processor_with_solid;

public class PaymentProcessor {
    private final PaymentGateway paymentGateway;
    private final Notifier notifier;
    private final LoggerService logger;

    public PaymentProcessor(PaymentGateway paymentGateway, Notifier notifier, LoggerService logger) {
        this.paymentGateway = paymentGateway;
        this.notifier = notifier;
        this.logger = logger;
    }

    public void process(double amount) {
        paymentGateway.processPayment(amount);
        notifier.sendNotification("Payment of $" + amount + " successful.");
        logger.log("Processed payment of $" + amount);
    }
}
