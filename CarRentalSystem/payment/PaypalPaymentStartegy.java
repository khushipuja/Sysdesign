package CarRentalSystem.payment;

public class PaypalPaymentStartegy implements PaymentStrategy {
    @Override
    public boolean makePayment(double amount) {
        return false;
    }
}
