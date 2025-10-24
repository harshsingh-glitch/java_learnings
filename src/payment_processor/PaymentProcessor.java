package payment_processor;

public class PaymentProcessor {
    private String paymentType;

    public PaymentProcessor(String paymentType) {
        this.paymentType = paymentType;
    }

    public void process(double amount) {
        // Violation of SRP, OCP, DIP — all logic here
        if (paymentType.equals("paypal")) {
            System.out.println("Processing PayPal payment of $" + amount);
        } else if (paymentType.equals("stripe")) {
            System.out.println("Processing Stripe payment of $" + amount);
        } else {
            System.out.println("Unknown payment type");
        }

        // Violation of SRP — Notification logic mixed in
        System.out.println("Sending email notification...");

        // Violation of SRP — Logging logic mixed in
        System.out.println("Logging payment of $" + amount + " using " + paymentType);
    }
}
