package ATMMachine;

class BankAccount implements Account{

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void dispenseCash(double amount)  {
        try{
            System.out.println("Dispensing " + amount + " cash" + "by Thread" + Thread.currentThread().getName());
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance -= amount;
    }

    public void depositCash(double amount) {
        System.out.println("Depositing " + amount + " cash" + "by Thread" + Thread.currentThread().getName());
        this.balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
