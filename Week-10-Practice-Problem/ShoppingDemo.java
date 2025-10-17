import java.util.*;

class Product {
    // Declare private attributes: name, price
    private String name;
    private double price;
    
    // Create a parameterized constructor to initialize all attributes
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // Create showDetails() to display product info
    public void showDetails() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }
    
    // Getter for product name
    public String getName() {
        return name;
    }
}

class Order {
    // Declare private attributes: orderId (String), products (List<Product>)
    private String orderId;
    private List<Product> products;
    
    // Constructor to initialize orderId and list
    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }
    
    // Add a product to order
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product '" + product.getName() + "' to Order " + orderId);
    }
    
    // Show order details
    public void showOrderDetails() {
        System.out.println("Order " + orderId + " contains:");
        for (Product product : products) {
            product.showDetails();
        }
    }
    
    // Getter for orderId
    public String getOrderId() {
        return orderId;
    }
}

class Customer {
    // Declare private attributes: name, email, orders (List<Order>)
    private String name;
    private String email;
    private List<Order> orders;
    
    // Constructor to initialize customer info
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
    
    // Place an order
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order " + order.getOrderId());
    }
    
    // Display all orders for this customer
    public void showCustomerOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println(); 
        }
    }
}

public class ShoppingDemo {
    public static void main(String[] args) {
        // Step 1 - Create Customer object
        Customer customer1 = new Customer("Amit", "amit@gmail.com");
        
        // Step 2 - Create Product objects
        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mobile", 25000);
        Product product3 = new Product("Mouse", 500);
        
        // Step 3 - Create 2 Order objects and add different products to each
        Order order1 = new Order("ORD001");
        order1.addProduct(product1);
        order1.addProduct(product2);
        
        Order order2 = new Order("ORD002");
        order2.addProduct(product3);
        
        System.out.println(); // Empty line for readability
        
        // Step 4 - Associate orders with customer using placeOrder()
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);
        
        System.out.println(); // Empty line for readability
        
        // Step 5 - Display all orders and their products using showCustomerOrders()
        customer1.showCustomerOrders();
        
       
    }
}
