class BankAccount { 
    // TODO: Create static variables: 
    // - bankName (String) - same for all accounts 
    // - totalAccounts (int) - count of all accounts created 
    // - interestRate (double) - same rate for all accounts 
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // TODO: Create instance variables: 
    // - accountNumber (String) - unique for each account 
    // - accountHolder (String) - unique for each account 
    // - balance (double) - unique for each account 
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // TODO: Create constructor that: 
    // - Initializes instance variables 
    // - Increments totalAccounts counter 
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; 
    }

    // TODO: Create static methods: 
    // - setBankName(String name) 
    // - setInterestRate(double rate) 
    // - getTotalAccounts() - returns count 
    // - displayBankInfo() - shows bank name and total accounts 
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // TODO: Create instance methods: 
    // - deposit(double amount) 
    // - withdraw(double amount) 
    // - calculateInterest() - uses static interestRate 
    // - displayAccountInfo() 
    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited " + amount + ". New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println(accountHolder + " has insufficient balance!");
        }
    }

    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println("Interest for " + accountHolder + ": " + interest);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------");
    }
}
    public class Q3 {
    public static void main(String[] args) { 
        // TODO: Set bank name and interest rate using static methods 
        BankAccount.setBankName("SBI Bank");
        BankAccount.setInterestRate(5.0);

        // TODO: Create multiple BankAccount objects 
        BankAccount acc1 = new BankAccount("123", "Ayush", 5000);
        BankAccount acc2 = new BankAccount("456", "Arpit", 10000);

        // TODO: Show that static members are shared across all objects 
        BankAccount.displayBankInfo();

        // TODO: Show that instance members are unique to each object
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        // TODO: Demonstrate calling static methods with and without objects 
        acc1.deposit(2000);
        acc2.withdraw(3000);

        acc1.calculateInterest();
        acc2.calculateInterest();

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());

        acc1.displayBankInfo(); // static method called using object (not recommended, but possible)
    } 
}
