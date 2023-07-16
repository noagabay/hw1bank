import java.util.*;
import java.util.stream.Collectors;

public class Bank implements IBank {
    private List<IAccount> accounts = new ArrayList<>();

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        IAccount account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);

        if (account != null) {
            if (account.getCurrentBalance() < 0) {
                System.out.println("Cant close account, in debt.");
            } else {
                accounts.remove(account);
            }
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        return accounts.stream()
                .filter(a -> a.getCurrentBalance() < 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balanceAbove) {
        return accounts.stream()
                .filter(a -> a.getCurrentBalance() > balanceAbove)
                .collect(Collectors.toList());
    }
}
