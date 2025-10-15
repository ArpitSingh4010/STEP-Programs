interface Discount {
    double apply(double amount);
}

class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    void processTransaction() {
        class Validator {
            boolean isValid() {
                return amount > 0;
            }
        }

        Validator validator = new Validator();

        if (!validator.isValid()) {
            System.out.println("Invalid payment amount!");
            return;
        }
        Discount discount = new Discount() {
            @Override
            public double apply(double amount) {
                return amount * 0.9;
            }
        };

        double finalAmount = discount.apply(amount);
        System.out.println("Original Amount: " + amount);
        System.out.println("Final Amount after Discount: " + finalAmount);
    }
}

public class PaymentDetails {
    public static void main(String[] args) {
        Payment p1 = new Payment(1000);
        p1.processTransaction();

        System.out.println();

        Payment p2 = new Payment(-500);
        p2.processTransaction();
    }
}
