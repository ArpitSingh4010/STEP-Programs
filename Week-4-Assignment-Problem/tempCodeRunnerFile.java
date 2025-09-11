class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;

    private static final double FIXED_RATE = 150.0; // default price per item

    // Default constructor → assigns "Unknown" order
    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // Constructor with food item only → quantity = 1, default price
    public FoodOrder(String foodItem) {
        this("Guest", foodItem, 1, FIXED_RATE);
    }

    // Constructor with food item and quantity → price = quantity × fixedRate
    public FoodOrder(String foodItem, int quantity) {
        this("Guest", foodItem, quantity, quantity * FIXED_RATE);
    }

    // Full constructor
    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    // Method to print bill
    public void printBill() {
        System.out.println("Food Order Bill:");
        System.out.println("Customer: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + price);
        System.out.println("-------------------------");
    }
}

// Main class
public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Create different orders using constructor overloading
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);
        FoodOrder o4 = new FoodOrder("Alice", "Pasta", 2, 400.0);

        // Print bills
        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
