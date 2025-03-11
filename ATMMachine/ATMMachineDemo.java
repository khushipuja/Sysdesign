package ATMMachine;

public class ATMMachineDemo {

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(100);
        BankAccount bankAccount2 = new BankAccount(100);


        ATMTransactionRequest atmTransactionRequest = new ATMTransactionRequest(TransactionType.CASH_WITHDRAWAL,30);

        BankAccountProxy bankAccountProxy1 = new BankAccountProxy(bankAccount1);
        BankAccountProxy bankAccountProxy2 = new BankAccountProxy(bankAccount2);

        ATMMachine atmMachine = new ATMMachine(bankAccountProxy1);

        Thread t1 = new Thread(()->{
            atmMachine.execute(atmTransactionRequest);
            atmMachine.displayBalance();
        },"Thread1");

        Thread t2 = new Thread(()->{
            atmMachine.execute(atmTransactionRequest);
            atmMachine.displayBalance();
        },"Thread2");

        t1.start();
        t2.start();


    }
}
