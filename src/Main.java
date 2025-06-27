import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Create a new account");
            System.out.println("2. Get account details");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    System.out.println("Create your 4-digit password: ");
                    int password = sc.nextInt();
                    bank.createAccount(accountNumber, accountHolder, balance, password);
                    break;

                case 2:
                    System.out.print("Enter Account Number to get details: ");
                    int accountToSearch = sc.nextInt();
                    System.out.println("Enter your password: ");
                    int accpassword = sc.nextInt();
                    Account acctemp = bank.getAccounts().get(accountToSearch);
                    if (acctemp != null && acctemp.getPassword() == accpassword) {
                        bank.getDetails(accountToSearch);
                    } else {
                        System.out.println("Incorrect password or account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number to deposit money: ");
                    int depositAccountNumber = sc.nextInt();
                    System.out.print("Enter your password: ");
                    int depositPassword = sc.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();

                    Account depositAccount = bank.getAccounts().get(depositAccountNumber); // Use the getter
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount, depositPassword);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number to withdraw money: ");
                    int withdrawAccountNumber = sc.nextInt();
                    System.out.print("Enter your password: ");
                    int withdrawPassword = sc.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    Account withdrawAccount = bank.getAccounts().get(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount, withdrawPassword);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
