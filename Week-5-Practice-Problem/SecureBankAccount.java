public class SecureBankAccount{
    //  Private fields 
    private final String accountNumber; 
    private double balance;              
    private int pin;                     
    private boolean isLocked;            
    private int failedAttempts;          

    // Private constants
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    // Constructor
    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE); 
        this.pin = 0;   
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account " + accountNumber + " is locked. Cannot view balance.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

   
    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN updated successfully.");
            return true;
        }
        System.out.println("Incorrect old PIN. PIN not updated.");
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked. PIN validation failed.");
            return false;
        }
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public boolean unlockAccount(int correctPin) {
        if (pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked successfully.");
            return true;
        }
        System.out.println("Incorrect PIN. Account remains locked.");
        return false;
    }

   
    public boolean deposit(double amount, int enteredPin) {
        if (!validatePin(enteredPin)) {
            System.out.println("Deposit failed. Invalid PIN.");
            return false;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
            return true;
        }
        System.out.println("Deposit failed. Amount must be positive.");
        return false;
    }

    public boolean withdraw(double amount, int enteredPin) {
        if (!validatePin(enteredPin)) {
            System.out.println("Withdrawal failed. Invalid PIN.");
            return false;
        }
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". New balance: " + balance);
            return true;
        }
        System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        return false;
    }

    public boolean transfer(SecureBankAccount target, double amount, int enteredPin) {
        if (!validatePin(enteredPin)) {
            System.out.println("Transfer failed. Invalid PIN.");
            return false;
        }
        if (withdraw(amount, enteredPin)) {
            target.balance += amount;
            System.out.println("Transferred " + amount + " to " + target.getAccountNumber());
            return true;
        }
        return false;
    }


    private void lockAccount() {
        isLocked = true;
        System.out.println("🔒 Account locked due to too many failed attempts.");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        } else {
            System.out.println("Wrong PIN. Attempt " + failedAttempts + "/" + MAX_FAILED_ATTEMPTS);
        }
    }

   
    public static void main(String[] args) {
        // Create accounts
        SecureBankAccount acc1 = new SecureBankAccount("ACC123", 5000);
        SecureBankAccount acc2 = new SecureBankAccount("ACC456", 3000);

       

        // Setting PINs
        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        // Transactions
        acc1.deposit(2000, 1234);
        acc1.withdraw(1000, 1234);

        // Wrong PIN attempts
        acc1.withdraw(500, 1111);
        acc1.withdraw(500, 1111);
        acc1.withdraw(500, 1111); // should lock account

        // Trying operations on locked account
        acc1.deposit(500, 1234);

        // Unlocking
        acc1.unlockAccount(1234);
        acc1.deposit(500, 1234);

        // Transfer money
        acc1.transfer(acc2, 2000, 1234);

        // Show balances
        System.out.println("Account 1 Balance: " + acc1.getBalance());
        System.out.println("Account 2 Balance: " + acc2.getBalance());
    }
}
