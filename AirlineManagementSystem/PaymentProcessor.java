package AirlineManagementSystem;

public class PaymentProcessor {

    private static PaymentProcessor instance;

    private PaymentProcessor() {}

    public synchronized  static PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }
}
