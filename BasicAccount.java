public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance = 0;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        double actualAmount = 0;
        if (amount > withdrawalLimit) {
            actualAmount = withdrawalLimit;
            balance -= withdrawalLimit;
        } else {
            actualAmount = amount;
            balance -= amount;
        }
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

