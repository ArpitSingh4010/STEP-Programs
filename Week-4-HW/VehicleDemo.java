// Vehicle.java
class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus;

    // Static variables
    protected static int totalVehicles = 0;
    protected static double fleetValue = 0.0;
    protected static String companyName = "XYZ Transport";
    protected static double totalFuelConsumption = 0.0;

    // Constructor
    public Vehicle(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.currentStatus = currentStatus;
        totalVehicles++;
    }

    // Methods
    public void assignDriver(Driver driver) {
        driver.assignedVehicle = this;
        System.out.println("Driver " + driver.driverName + " assigned to vehicle " + vehicleId);
    }

    public void scheduleMaintenance() {
        currentStatus = "Under Maintenance";
        System.out.println("Vehicle " + vehicleId + " scheduled for maintenance.");
    }

    public void calculateRunningCost(double fuelConsumed, double fuelPrice) {
        double cost = fuelConsumed * fuelPrice;
        totalFuelConsumption += fuelConsumed;
        System.out.println("Running cost for " + vehicleId + " = " + cost);
    }

    public void updateMileage(double additionalMileage) {
        mileage += additionalMileage;
        System.out.println("Updated mileage for " + vehicleId + " = " + mileage);
    }

    public void checkServiceDue() {
        if (mileage > 10000) {
            System.out.println("Vehicle " + vehicleId + " is due for service.");
        } else {
            System.out.println("Vehicle " + vehicleId + " is in good condition.");
        }
    }

    // Static methods
    public static void getFleetUtilization() {
        System.out.println("Total Vehicles: " + totalVehicles);
    }

    public static void calculateTotalMaintenanceCost() {
        System.out.println("Total maintenance cost calculation not implemented (dummy).");
    }

    public static void getVehiclesByType(Vehicle[] vehicles, String type) {
        System.out.println("Vehicles of type " + type + ":");
        for (Vehicle v : vehicles) {
            if (type.equals("Car") && v instanceof Car) System.out.println(v.vehicleId);
            else if (type.equals("Bus") && v instanceof Bus) System.out.println(v.vehicleId);
            else if (type.equals("Truck") && v instanceof Truck) System.out.println(v.vehicleId);
        }
    }
}

// Car.java
class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus, int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, currentStatus);
        this.seatingCapacity = seatingCapacity;
    }
}

// Bus.java
class Bus extends Vehicle {
    private int seatingCapacity;

    public Bus(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus, int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, currentStatus);
        this.seatingCapacity = seatingCapacity;
    }
}

// Truck.java
class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus, double loadCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, currentStatus);
        this.loadCapacity = loadCapacity;
    }
}

// Driver.java
class Driver {
    String driverId;
    String driverName;
    String licenseType;
    Vehicle assignedVehicle;
    int totalTrips;

    public Driver(String driverId, String driverName, String licenseType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.licenseType = licenseType;
        this.totalTrips = 0;
    }
}

// Main.java
public class VehicleDemo{
    public static void main(String[] args) {
        // Create Vehicles
        Car car1 = new Car("C1", "Toyota", "Corolla", 2020, 8000, "Petrol", "Available", 5);
        Bus bus1 = new Bus("B1", "Volvo", "Luxury", 2019, 15000, "Diesel", "Available", 50);
        Truck truck1 = new Truck("T1", "Tata", "Cargo", 2021, 12000, "Diesel", "Available", 2000);

        // Create Drivers
        Driver d1 = new Driver("D1", "Arjun", "LMV");
        Driver d2 = new Driver("D2", "Ravi", "Heavy");
        
        // Assign drivers
        car1.assignDriver(d1);
        truck1.assignDriver(d2);

        // Use vehicle methods
        car1.updateMileage(500);
        bus1.checkServiceDue();
        truck1.scheduleMaintenance();

        // Running cost
        car1.calculateRunningCost(20, 100);

        // Static methods
        Vehicle.getFleetUtilization();
        Vehicle.getVehiclesByType(new Vehicle[]{car1, bus1, truck1}, "Bus");
    }
}
