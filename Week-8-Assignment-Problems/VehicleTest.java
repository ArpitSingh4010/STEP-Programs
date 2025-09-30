abstract class Vehicle {
// TODO: Create abstract method start()
abstract void start();
// TODO: Create non-abstract method fuelType() -> print "Uses fuel"
public void fuelType() {
// ... (implementation)
System.out.println("Uses fuel");
}
}

class Car extends Vehicle {
// TODO: Implement start() -> "Car starts with key"
@Override
public void start() {
// ... (implementation)
System.out.println("Car starts with key");
}
}

class Bike extends Vehicle {
// TODO: Implement start() -> "Bike starts with kick"
@Override
public void start() {
// ... (implementation)
System.out.println("Bike starts with kick");
}
}
public class VehicleTest {
public static void main(String[] args) {
// TODO: Create Vehicle reference pointing to Car
// TODO: Call start() and fuelType()
// TODO: Create Vehicle reference pointing to Bike
// TODO: Call start() and fuelType()
Vehicle myCar = new Car();
myCar.start();
myCar.fuelType();
Vehicle myBike = new Bike();
myBike.start();
myBike.fuelType();

}
}