public class Account {
    private int AccountNumber;
    private String AccountHolder;
    private int password;
    private double balance;

    public Account(int AccountNumber, String AccountHolder, double balance, int password) {
        this.AccountNumber = AccountNumber;
        this.AccountHolder = AccountHolder;
        this.balance = balance;
        this.password = password;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void deposit(double amount, int password) {
        if (this.password == password) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful and Your current balance is : " + balance);
            }
            else {
                System.out.println("Deposit amount must be positive");
            }
        }
        else {
            System.out.println("Incorrect password. Deposit failed.");
        }
    }

    public void withdraw(double amount, int password) {
        if (this.password == password) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful Your balance is now: " + balance);
            }
            else {
                System.out.println("Insufficient funds for this withdrawal");
            }
        }
        else {
            System.out.println("Incorrect password. Withdrawal failed.");
        }
    }
}
