interface PaymentGateway {
// TODO: Declare method pay(double amount)
void pay(double amount);
// TODO: Declare method refund(double amount)
void refund(double amount);
}
// File: CreditCardPayment.java
class CreditCardPayment implements PaymentGateway {
// TODO: Implement pay() -> "Paid via Credit Card"
@Override
public void pay(double amount) {
    System.out.println("Paid via Credit Card");
}
@Override
public void refund(double amount) {
    System.out.println("Refund to Credit Card");
}
}
// File: UPIPayment.java
class UPIPayment implements PaymentGateway {

@Override
public void pay(double amount) {
    System.out.println("Paid via UPI");
}
@Override
public void refund(double amount) {
    System.out.println("Refund to UPI");
}
}
// File: PaymentTest.java
public class PaymentTest {
public static void main(String[] args) {
// TODO: Create PaymentGateway reference -> CreditCardPayment
// TODO: Call pay() and refund()
// TODO: Create PaymentGateway reference -> UPIPayment
// TODO: Call pay() and refund()
PaymentGateway creditCardPayment = new CreditCardPayment();
creditCardPayment.pay(100);
creditCardPayment.refund(50);
PaymentGateway upiPayment = new UPIPayment();
upiPayment.pay(75);
upiPayment.refund(25);
}
}