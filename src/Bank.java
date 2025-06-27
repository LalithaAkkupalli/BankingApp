import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Account> Accounts = new HashMap<>(); // Keep this private for encapsulation.

    public void createAccount(int AccountNumber, String AccountHolder, double balance, int password) {
        if (Accounts.containsKey(AccountNumber)) {
            System.out.println("This account number already exists. Choose a different account number.");
        } else {
            Account newAccount = new Account(AccountNumber, AccountHolder, balance, password);
            Accounts.put(AccountNumber, newAccount);
            System.out.println("Account created successfully.");
        }
    }

    public void getDetails(int AccountNumber) {
        Account accountTemp = Accounts.get(AccountNumber);

        if (accountTemp != null) {
            System.out.println("Account Number: " + accountTemp.getAccountNumber());
            System.out.println("Account Holder: " + accountTemp.getAccountHolder());
            System.out.println("Account Balance: " + accountTemp.getBalance());
        } else {
            System.out.println("Account with account number " + AccountNumber + " is not found.");
        }
    }

    public HashMap<Integer, Account> getAccounts() {
        return Accounts;
    }
}
