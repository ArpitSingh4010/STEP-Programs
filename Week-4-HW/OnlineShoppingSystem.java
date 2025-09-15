
import java.util.*;

class Product {
    // Attributes
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    // Static variables
    private static int totalProducts = 0;
    private static String[] categories = {"Electronics", "Clothing", "Footwear", "Books", "Accessories"};

    // Constructor
    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    // Getters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    // Reduce stock
    public void reduceStock(int quantity) {
        this.stockQuantity -= quantity;
    }

    // Static methods
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p.productId.equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public static void getProductsByCategory(Product[] products, String category) {
        for (Product p : products) {
            if (p.category.equalsIgnoreCase(category)) {
                System.out.println(p.productId + " - " + p.productName + " (₹" + p.price + ")");
            }
        }
    }
}

class ShoppingCart {
    // Attributes
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int count;

    // Constructor
    public ShoppingCart(String cartId, String customerName, int size) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[size];
        this.quantities = new int[size];
        this.cartTotal = 0.0;
        this.count = 0;
    }

    // Methods
    public void addProduct(Product product, int quantity) {
        products[count] = product;
        quantities[count] = quantity;
        count++;
        product.reduceStock(quantity);
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId().equals(productId)) {
                // shift remaining elements
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                count--;
                System.out.println("Product removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0;
        for (int i = 0; i < count; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }

    public void displayCart() {
        System.out.println("\n--- Shopping Cart ---");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getProductName() + " x " + quantities[i] +
                    " = ₹" + (products[i].getPrice() * quantities[i]));
        }
        calculateTotal();
        System.out.println("Cart Total: ₹" + cartTotal);
        System.out.println("---------------------\n");
    }

    public void checkout() {
        calculateTotal();
        System.out.println("Checkout successful. Total bill = ₹" + cartTotal);
        count = 0; // empty cart
    }
}

public class OnlineShoppingSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 10 sample products
        Product[] products = {
            new Product("P101", "Laptop", 60000, "Electronics", 10),
            new Product("P102", "Phone", 25000, "Electronics", 15),
            new Product("P103", "Headphones", 2000, "Electronics", 20),
            new Product("P104", "T-shirt", 800, "Clothing", 50),
            new Product("P105", "Jeans", 1500, "Clothing", 40),
            new Product("P106", "Shoes", 3000, "Footwear", 30),
            new Product("P107", "Novel", 500, "Books", 25),
            new Product("P108", "Notebook", 60, "Books", 100),
            new Product("P109", "Watch", 5000, "Accessories", 12),
            new Product("P110", "Backpack", 1200, "Accessories", 35)
        };

        // Create cart
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        ShoppingCart cart = new ShoppingCart("C001", name, 20);

        int choice;
        do {
            System.out.println("\n===== Shopping Menu =====");
            System.out.println("1. View All Products");
            System.out.println("2. View Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Product p : products) {
                        System.out.println(p.getProductId() + " - " + p.getProductName() +
                                           " (₹" + p.getPrice() + ") | " + p.getCategory());
                    }
                    break;

                case 2:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    Product.getProductsByCategory(products, cat);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    String pid = sc.nextLine();
                    Product p = Product.findProductById(products, pid);
                    if (p != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        cart.addProduct(p, qty);
                    } else {
                        System.out.println("Invalid product ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    String rid = sc.nextLine();
                    cart.removeProduct(rid);
                    break;

                case 5:
                    cart.displayCart();
                    break;

                case 6:
                    cart.checkout();
                    break;

                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
