package payment_processor_with_solid;

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}

