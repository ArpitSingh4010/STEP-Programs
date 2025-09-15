import java.util.*;

// PersonalAccount class
class PersonalAccount {
    // Instance variables (unique to each object)
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables (shared by all objects)
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Instance methods
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: " + description + " (+₹" + amount + ")");
        } else {
            System.out.println("Invalid income amount.");
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent on: " + description + " (-₹" + amount + ")");
        } else {
            System.out.println("Invalid expense or insufficient balance.");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + currentBalance);
        System.out.println("Total Income: ₹" + totalIncome);
        System.out.println("Total Expenses: ₹" + totalExpenses);
        System.out.println("Net Savings: ₹" + calculateSavings());
        System.out.println("------------------------\n");
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "AC" + (1000 + totalAccounts + 1);
    }
}

// Main class
public class PersonalFinanceManager {
    public static void main(String[] args) {
        // Set bank name (shared across all accounts)
        PersonalAccount.setBankName("SRM National Bank");

        // Create accounts
        PersonalAccount acc1 = new PersonalAccount("Arpit Singh");
        PersonalAccount acc2 = new PersonalAccount("Rohan Sharma");
        PersonalAccount acc3 = new PersonalAccount("Ananya Verma");

        // Perform transactions
        acc1.addIncome(20000, "Salary");
        acc1.addExpense(5000, "Rent");
        acc1.addExpense(2000, "Groceries");

        acc2.addIncome(15000, "Freelance Work");
        acc2.addExpense(4000, "Travel");

        acc3.addIncome(30000, "Business Profit");
        acc3.addExpense(10000, "Office Rent");
        acc3.addExpense(5000, "Supplies");

        // Display account summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        // Show static usage
        System.out.println("Total Accounts Created: " + PersonalAccount.getTotalAccounts());
    }
}
