abstract class Vehicle {
    public abstract void start();

    public void stop() {
        System.out.println("Vehicle has stopped.");
    }
}

interface Fuel {
    void refuel();
}

class Car extends Vehicle implements Fuel {
    @Override
    public void start() {
        System.out.println("Car engine started.");
    }

    @Override
    public void refuel() {
        System.out.println("Car is being refueled.");
    }
}

public class VehicleTest{
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.refuel();
        myCar.stop();
    }
}
