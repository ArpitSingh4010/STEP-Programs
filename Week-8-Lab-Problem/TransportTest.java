abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();

    public void showDetails() {
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

interface Maintainable {
    void serviceInfo();
}

class Car extends Vehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine has started.");
    }

    @Override
    public void serviceInfo() {
        System.out.println(model + " requires servicing every 10,000 km.");
    }
}

public class TransportTest {
    public static void main(String[] args) {
        Car myCar = new Car(180, "Petrol", "Honda Civic");
        myCar.showDetails();
        myCar.startEngine();
        myCar.serviceInfo();
    }
}
