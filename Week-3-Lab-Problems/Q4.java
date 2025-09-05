// Program: Vehicle Rental System (Static vs Instance Members)
import java.util.*;

class Vehicle {
    // a. Private instance variables
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalDaysRented;  // rental history (instance-specific)

    // b. Static variables (shared across all vehicles)
    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName = "Default Rentals";
    private static int rentalDays = 0; // total rental days across all vehicles
    private static int vehicleCounter = 1;

    // c. Constructor
    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalDaysRented = 0;
        totalVehicles++;
    }

    // Rent vehicle
    public double rentVehicle(int days) {
        if (isAvailable) {
            double amount = calculateRent(days);
            isAvailable = false;
            totalDaysRented += days;
            System.out.println("Vehicle " + vehicleId + " rented for " + days + " days. Amount: " + amount);
            return amount;
        } else {
            System.out.println("Vehicle " + vehicleId + " is not available!");
            return 0.0;
        }
    }

    // Return vehicle
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned successfully.");
        } else {
            System.out.println("Vehicle " + vehicleId + " was not rented.");
        }
    }

    // e. Calculate rent (instance + updates static)
    public double calculateRent(int days) {
        double amount = rentPerDay * days;
        totalRevenue += amount;
        rentalDays += days;
        return amount;
    }

    // f. Display vehicle info
    public void displayVehicleInfo() {
        System.out.println("\n--- Vehicle Info ---");
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Rent per Day : " + rentPerDay);
        System.out.println("Available    : " + (isAvailable ? "Yes" : "No"));
        System.out.println("Total Days Rented: " + totalDaysRented);
    }

    // d. Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        return (rentalDays > 0) ? (totalRevenue / rentalDays) : 0.0;
    }

    public static void displayCompanyStats() {
        System.out.println("\n--- Company Stats ---");
        System.out.println("Company Name   : " + companyName);
        System.out.println("Total Vehicles : " + totalVehicles);
        System.out.println("Total Revenue  : " + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Rent/Day: " + String.format("%.2f", getAverageRentPerDay()));
    }

    // Helper method for ID
    private static String generateVehicleId() {
        return "V" + String.format("%03d", vehicleCounter++);
    }
}

public class Q4{
    public static void main(String[] args) {
        // Set company name (static method affects all)
        Vehicle.setCompanyName("SuperRide Rentals");

        // Create multiple vehicle objects (instance members unique)
        Vehicle v1 = new Vehicle("Toyota", "Camry", 2000);
        Vehicle v2 = new Vehicle("Honda", "Civic", 1500);
        Vehicle v3 = new Vehicle("Ford", "Mustang", 3000);

        // Rent vehicles
        v1.rentVehicle(3);  // Toyota rented for 3 days
        v2.rentVehicle(2);  // Honda rented for 2 days

        // Try renting already rented vehicle
        v1.rentVehicle(1);  // Should show not available

        // Return a vehicle
        v1.returnVehicle();
        v1.rentVehicle(2); // Rent again after returning

        // Display individual vehicle info (instance-specific)
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        // Show static company stats (shared across all)
        Vehicle.displayCompanyStats();
    }
}
