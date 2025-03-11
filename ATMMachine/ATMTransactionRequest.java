package ATMMachine;

public class ATMTransactionRequest {
    TransactionType transactionType;
    double amount;

    public ATMTransactionRequest(TransactionType transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
