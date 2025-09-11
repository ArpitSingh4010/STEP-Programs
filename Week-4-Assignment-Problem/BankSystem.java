import java.util.Random;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Default constructor
    public BankAccount() {
        this("Unknown", new Random().nextInt(9000) + 1000, 0.0);
    }

    // Constructor with name only
    public BankAccount(String accountHolder) {
        this(accountHolder, new Random().nextInt(9000) + 1000, 0.0);
    }

    // Constructor with name and initial balance
    public BankAccount(String accountHolder, double balance) {
        this(accountHolder, new Random().nextInt(9000) + 1000, balance);
    }

    // Full constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " into " + accountHolder + "'s account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " from " + accountHolder + "'s account.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("Bank Account Details:");
        System.out.println("Holder: " + accountHolder);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("-------------------------");
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        // Create accounts using different constructors
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Alice");
        BankAccount acc3 = new BankAccount("Bob", 5000);

        // Perform operations
        acc1.deposit(1000);
        acc2.deposit(2000);
        acc3.withdraw(1500);

        // Display all accounts
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
    }
}
