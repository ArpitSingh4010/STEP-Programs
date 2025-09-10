class Vehicle { 
// TODO: Create protected instance variables: 
// - make (String) 
String make;
// - model (String)
String model; 
// - year (int)
int year; 
// - fuelLevel (double) 
double fuelLevel;
// TODO: Create constructor
public Vehicle(String make, String model, int year, double fuelLevel){
    this.make=make;
    this.model=model;
    this.year=year;
    this.fuelLevel=fuelLevel;
} 
// TODO: Create common methods: 
// - startVehicle() 
void startVehicle(){
    System.out.println("Vehicle Started");
}
// - stopVehicle() 
void stopVehicle(){
    System.out.println("Vehicle Stopped");
}
// - refuel(double amount) 
void refuel(double amount){
    fuelLevel+=amount;
    System.out.println("Refueled: " + amount + " liters. Current fuel level: " + fuelLevel + " liters.");
}
// - displayVehicleInfo() 
void displayVehicleInfo(){
    System.out.println("Vehicle Info: ");
    System.out.println("Make: " + make);
    System.out.println("Model: " + model);
    System.out.println("Year: " + year);
    System.out.println("Fuel Level: " + fuelLevel + " liters.");
}
class Car extends Vehicle {
    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
    @Override
    void startVehicle() {
        System.out.println("Car " + make + " " + model + " is starting.");
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
    @Override
    void startVehicle() {
        System.out.println("Truck " + make + " " + model + " is starting.");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
    @Override
    void startVehicle() {
        System.out.println("Motorcycle " + make + " " + model + " is starting.");
    }
}
}
public class Q4 {
public static void main(String[] args) { 
// TODO: Create different types of vehicles (Car, Truck, Motorcycle) 
Vehicle car = new Vehicle("Toyota", "Camry", 2020, 50.0);
Vehicle truck = new Vehicle("Ford", "F-150", 2019, 80.0);
Vehicle motorcycle = new Vehicle("Harley-Davidson", "Street 750", 2021, 15.0);
// TODO: Show how the same Vehicle class can be reused // TODO: Create an array of Vehicle objects 
Vehicle[] vehicles = {car, truck, motorcycle};
car.displayVehicleInfo();
truck.displayVehicleInfo();
motorcycle.displayVehicleInfo();


// TODO: Demonstrate polymorphic behavior 

// TODO: In comments, explain: 
// - How does this show reusability? 
for (Vehicle v : vehicles) {
    v.startVehicle();
    v.stopVehicle();
}
// - How could this be extended for new vehicle types?

// - What are the benefits over writing separate classes? 
} 
}