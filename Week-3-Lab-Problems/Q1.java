// Program: Bank Account Management System (without built-in collections)
import java.util.Scanner;

class BankAccount {
    // a. Private instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Static variables
    private static int totalAccounts = 0;
    private static int accountCounter = 1;

    // b. Constructor
    public BankAccount(String holderName, double initialDeposit) {
        this.accountHolderName = holderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // c. Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " successfully.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    // e. Display account info
    public void displayAccountInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
    }

    // d. Static methods
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", accountCounter++);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // f. Array of BankAccount objects
        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        BankAccount[] accounts = new BankAccount[n];

        // Create multiple accounts
        for (int i = 0; i < n; i++) {
            System.out.println("\nCreating Account " + (i + 1));
            System.out.print("Enter account holder name: ");
            String name = sc.nextLine();

            System.out.print("Enter initial deposit: ");
            double deposit = sc.nextDouble();
            sc.nextLine(); // consume newline

            accounts[i] = new BankAccount(name, deposit);
            accounts[i].displayAccountInfo();
        }

        // Demonstrate transactions
        System.out.println("\n--- Transactions ---");
        accounts[0].deposit(2000);
        accounts[0].withdraw(500);

        accounts[1].withdraw(1000);

        // Checking balances
        System.out.println("\n--- Checking Balances ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Balance of " + (i + 1) + " : " + accounts[i].checkBalance());
        }

        // Show static vs instance difference
        System.out.println("\nTotal Accounts Created (static variable): " + BankAccount.getTotalAccounts());

        sc.close();
    }
}
