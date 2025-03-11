package ATMMachine;

public interface ATMTransaction {

    public void execute(ATMTransactionRequest transactionRequest);
}
