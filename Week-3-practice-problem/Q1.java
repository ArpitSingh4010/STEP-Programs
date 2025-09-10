 class Car { 
// TODO: Define instance variables (attributes): 
// - brand (String) 
String brand;
// - model (String)
String model; 
// - year (int) 
int year;
// - color (String)
String color; 
// - isRunning (boolean) 
boolean isRunning;
// TODO: Create a constructor that initializes all attributes 
 Car(String brand, String model, int year, String color) {
    this.brand = brand;
    this.model = model;
    this.year = year;
    this.color = color;
    this.isRunning = false; 
}
// TODO: Create instance methods: 

// - startEngine() - sets isRunning to true, prints message // - stopEngine() - sets isRunning to false, prints message // - displayInfo() - prints all car information 
void startEngine() {
    if (!isRunning) {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    } else {
        System.out.println(brand + " " + model + " engine is already running.");
    }
}
void stopEngine() {
    if (isRunning) {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    } else {
        System.out.println(brand + " " + model + " engine is already off.");
    }
}
// - getAge() - returns current year minus car year 
int getAge() {
    int currentYear = 2023;
    return currentYear - year;
}
void displayInfo() {
    System.out.println("Car Info: ");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Year: " + year);
    System.out.println("Color: " + color);
    System.out.println("Is Running: " + isRunning);
}

}
public class Q1 {
public static void main(String[] args) { 
// TODO: Create 3 different Car objects with different attributes // TODO: Demonstrate calling methods on each object 
Car car1 = new Car("Toyota", "Camry", 2018, "Red");
// TODO: Show how each object maintains its own state 

// TODO: Explain in comments: How is this similar to real-world cars? 

car1.startEngine();
car1.stopEngine();
System.out.println("Car Age: " + car1.getAge() + " years");
car1.displayInfo();
} 
}
