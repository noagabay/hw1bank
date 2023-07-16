public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance = 0;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit < 0 ? creditLimit : 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        double actualAmount = 0;
        if (balance - amount < creditLimit) {
            actualAmount = balance - creditLimit;
            balance = creditLimit;
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

