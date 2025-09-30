abstract class BankAccount {
protected double balance;
// TODO: Create constructor to set balance
BankAccount(double balance) {
// ... (implementation)
this.balance = balance;

}
// TODO: Create abstract method calculateInterest()
 abstract void calculateInterest();

// TODO: Create non-abstract method displayBalance() -> print balance
void displayBalance() {
// ... (implementation)
System.out.println("Balance: " + balance);
}
}
// File: SavingsAccount.java
class SavingsAccount extends BankAccount {
SavingsAccount(double balance) {
super(balance);

}
// TODO: Implement calculateInterest() -> interest = balance * 0.04
@Override
void calculateInterest() {
// ... (implementation)
System.out.println("Interest: " + (balance * 0.04));

}
}
// File: CurrentAccount.java
class CurrentAccount extends BankAccount {
CurrentAccount(double balance) {
super(balance);
}
// TODO: Implement calculateInterest() -> interest = balance * 0.02
@Override
void calculateInterest() {
// ... (implementation)
System.out.println("Interest: " + (balance * 0.02));
}
}
public class BankTest {
public static void main(String[] args) {
// TODO: Create BankAccount reference -> SavingsAccount
BankAccount savingsAccount = new SavingsAccount(1000);
savingsAccount.displayBalance();
savingsAccount.calculateInterest();

// TODO: Create BankAccount reference -> CurrentAccount
BankAccount currentAccount = new CurrentAccount(2000);
currentAccount.displayBalance();
currentAccount.calculateInterest();
}
}