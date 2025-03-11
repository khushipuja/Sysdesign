package CarRentalSystem.payment;

public class CardPaymentStartegy implements PaymentStrategy {
    @Override
    public boolean makePayment(double amount) {
        return false;
    }
}
