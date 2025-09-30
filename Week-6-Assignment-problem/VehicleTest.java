class Vehicle {
// TODO: Create protected fields for inheritance:
  protected String brand;
  protected String model;
  protected int year;
  protected String engineType;
// TODO: Create private fields that require getter/setter access:
  private String registrationNumber;
  private boolean isRunning;
// TODO: Create default constructor that:
// - Sets default values for all fields
// - Prints "Vehicle default constructor called"
  public Vehicle() {
    this.brand = "Unknown";
    this.model = "Unknown";
    this.year = 0;
    this.engineType = "Unknown";
    this.registrationNumber = "Unregistered";
    this.isRunning = false;
    System.out.println("Vehicle default constructor called");
  }
// TODO: Create parameterized constructor that:
// - Takes brand, model, year, engineType parameters
// - Initializes all fields
// - Prints "Vehicle parameterized constructor called"
// - Generates random registration number
  public Vehicle(String brand, String model, int year, String engineType) {
    this.brand = brand;
    this.model = model;
    this.year = year;
    this.engineType = engineType;
    this.registrationNumber = "REG" + (int)(Math.random() * 10000);
    this.isRunning = false;
    System.out.println("Vehicle parameterized constructor called");
  }
// TODO: Create methods for basic vehicle operations:
// - start() - sets isRunning to true, prints "Vehicle started"
// - stop() - sets isRunning to false, prints "Vehicle stopped"
// - getVehicleInfo() - returns formatted string with all vehicle details
  public void start() {
    this.isRunning = true;
    System.out.println("Vehicle started");
  }

  public void stop() {
    this.isRunning = false;
    System.out.println("Vehicle stopped");
  }

  public String getVehicleInfo() {
    return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Engine Type: " + engineType + ", Registration Number: " + registrationNumber + ", Is Running: " + isRunning;
  }



// - displaySpecs() - prints technical specifications
  public void displaySpecs() {
    System.out.println("Vehicle Specifications:");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Year: " + year);
    System.out.println("Engine Type: " + engineType);
    System.out.println("Registration Number: " + registrationNumber);
    System.out.println("Is Running: " + isRunning);
  }
// TODO: Create getter/setter methods for private fields:
// - getRegistrationNumber() / setRegistrationNumber()
// - isRunning() - no setter for this (controlled through start/stop)
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public boolean isRunning() {
    return isRunning;
  }
}
// TODO: Create Car class that extends Vehicle:
class Car extends Vehicle {
// TODO: Add car-specific fields:
// - numberOfDoors (int)
// - fuelType (String)
// - transmissionType (String)
  private int numberOfDoors;
  private String fuelType;
  private String transmissionType;
// TODO: Create default constructor that:
// - Calls super() explicitly
// - Sets car-specific default values
// - Prints "Car default constructor called"
  public Car() {
    super();
    this.numberOfDoors = 4;
    this.fuelType = "Petrol";
    this.transmissionType = "Automatic";
    System.out.println("Car default constructor called");
  }

// TODO: Create parameterized constructor that:
// - Takes all Vehicle parameters plus car-specific parameters
// - Calls super(brand, model, year, engineType) explicitly
// - Initializes car-specific fields
// - Prints "Car parameterized constructor called"
  public Car(String brand, String model, int year, String engineType, int numberOfDoors, String fuelType, String transmissionType) {
    super(brand, model, year, engineType);
    this.numberOfDoors = numberOfDoors;
    this.fuelType = fuelType;
    this.transmissionType = transmissionType;
    System.out.println("Car parameterized constructor called");
  }

// TODO: Override parent methods where appropriate:
// - Override start() to include car-specific startup sequence
// - Call super.start() first, then add car-specific operations
// - Override displaySpecs() to show both vehicle and car specifications
  @Override
  public void start() {
    super.start();
    System.out.println("Car-specific startup sequence initiated");
  }

  @Override
  public void displaySpecs() {
    super.displaySpecs();
    System.out.println("Car Specifications:");
    System.out.println("Number of Doors: " + numberOfDoors);
    System.out.println("Fuel Type: " + fuelType);
    System.out.println("Transmission Type: " + transmissionType);
  }
// TODO: Add car-specific methods:
// - openTrunk() - prints "Trunk opened"
// - playRadio() - prints "Radio playing music"
  public void openTrunk() {
    System.out.println("Trunk opened");
  }

  public void playRadio() {
    System.out.println("Radio playing music");
  }
}
public class VehicleTest {
  public static void main(String[] args) {
    // TODO: Test constructor chaining:
    // 1. Create Car using default constructor (observe constructor call order)
    Car defaultCar = new Car();
    System.out.println();

    // 2. Create Car using parameterized constructor
    Car paramCar = new Car("Toyota", "Camry", 2020, "Hybrid", 4, "Petrol", "Automatic");

    // Invoke inheritance tests
    VehicleTest tester = new VehicleTest();
    System.out.println();
    System.out.println("=== Inheritance & Override Tests ===");
    tester.testInheritance();

    // Polymorphism demo: Vehicle reference pointing to Car instance
    System.out.println();
    System.out.println("=== Polymorphism Demo ===");
    Vehicle polyRef = new Car("Ford", "Mustang", 2022, "V8", 2, "Petrol", "Manual");
    polyRef.start();      // Calls Car.start() because of dynamic dispatch
    polyRef.displaySpecs(); // Calls Car.displaySpecs() overriding Vehicle
    polyRef.stop();
  }


// TODO: Test inheritance of fields and methods:
// - Access protected fields from parent
// - Call inherited methods
// - Call overridden methods
  public void testInheritance() {
    Car myCar = new Car("Honda", "Civic", 2019, "Petrol", 4, "Petrol", "Manual");
    // Accessing protected fields
    System.out.println("Brand: " + myCar.brand);
    System.out.println("Model: " + myCar.model);
    // Calling inherited method
    myCar.displaySpecs();
    // Calling overridden method
    myCar.start();
    myCar.stop();
    myCar.openTrunk();
    myCar.playRadio();
// TODO: Test super keyword usage:
// - Show how overridden methods can call parent implementation
// - Demonstrate constructor chaining with super()
    myCar.start();
    myCar.displaySpecs(); 

// TODO: Test method resolution:
// - Call methods that exist only in Car
// - Call methods that exist in both Vehicle and Car
// - Show polymorphic behavior
    myCar.openTrunk();
    myCar.playRadio();
    myCar.start();
    myCar.stop();
    myCar.displaySpecs();
  }
}