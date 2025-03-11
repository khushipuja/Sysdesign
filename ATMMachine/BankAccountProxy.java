package ATMMachine;

public class BankAccountProxy implements Account{

    private BankAccount bankAccount;

    public BankAccountProxy(BankAccount atmMachine) {
        this.bankAccount = atmMachine;
    }

    @Override
    public void dispenseCash(double amount) {
        bankAccount.dispenseCash(amount);
    }

    @Override
    public void depositCash(double amount) {
        bankAccount.depositCash(amount);
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

}
