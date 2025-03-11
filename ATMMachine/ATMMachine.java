package ATMMachine;

public class ATMMachine{

    BankAccountProxy bankAccountProxy;

    public ATMMachine(BankAccountProxy bankAccountProxy) {
        this.bankAccountProxy  = bankAccountProxy;
    }


    public void execute(ATMTransactionRequest atmTransactionRequest) {
        try{
            if(atmTransactionRequest.transactionType == TransactionType.CASH_WITHDRAWAL){
                if(atmTransactionRequest.amount > 0 && atmTransactionRequest.amount <= bankAccountProxy.getBalance()){
                    Thread.sleep(2000);
                    bankAccountProxy.dispenseCash(atmTransactionRequest.amount);
                }else{
                    System.out.println("ATM transaction failed with insufficient balance");
                }
            }else{
                System.out.println("ATM transaction failed with insufficient balance");
                bankAccountProxy.depositCash(atmTransactionRequest.amount);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void displayBalance() {
        System.out.println("Bank account balance: " + bankAccountProxy.getBalance());
    }
}
