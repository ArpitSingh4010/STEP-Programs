 class Payment {
 void pay() {
System.out.println("Generic payment");
}
}
 class CreditCardPayment extends Payment {
 @Override
 void pay() {
 System.out.println("Paying with Credit Card");
 }
 }
 class WalletPayment extends Payment {
 @Override
 void pay() {
 System.out.println("Paying with Wallet");
 }
 }
public class PaymentGateway {
public static void main(String[] args) {
// 1. Create array of Payment references with
// CreditCardPayment and WalletPayment
// 2. Loop, call getClass().getSimpleName(), and pay()
 Payment[] payments = new Payment[] {
 new CreditCardPayment(),
 new WalletPayment(),
 new CreditCardPayment(),
 new WalletPayment(),
 };

 for (Payment p : payments) {
 System.out.println(p.getClass().getSimpleName() + ":");
 p.pay();
 }
}
}