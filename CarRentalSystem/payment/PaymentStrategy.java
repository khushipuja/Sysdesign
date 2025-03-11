package CarRentalSystem.payment;

public interface PaymentStrategy {
    public boolean makePayment(double amount);
}
