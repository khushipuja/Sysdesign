package ATMMachine;

public interface Account {

    public  void dispenseCash(double amount);
    public  void depositCash(double amount);

    public double getBalance();
}
