public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance = 0;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        double actualAmount = amount;
        balance -= amount;
        return actualAmount;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
