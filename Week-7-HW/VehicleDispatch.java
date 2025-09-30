abstract class Vehicle {
    String vehicleName;

    Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    abstract void dispatch();
}

class Bus extends Vehicle {
    int capacity;
    String route;

    Bus(String vehicleName, int capacity, String route) {
        super(vehicleName);
        this.capacity = capacity;
        this.route = route;
    }

    void dispatch() {
        System.out.println("Bus " + vehicleName + " dispatched.");
        System.out.println("Route: " + route);
        System.out.println("Passenger Capacity: " + capacity + "\n");
    }
}

class Taxi extends Vehicle {
    double baseFare;
    double distance;

    Taxi(String vehicleName, double baseFare, double distance) {
        super(vehicleName);
        this.baseFare = baseFare;
        this.distance = distance;
    }

    void dispatch() {
        double fare = baseFare + (distance * 15);
        System.out.println("Taxi " + vehicleName + " dispatched.");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Estimated Fare: ₹" + fare + "\n");
    }
}

class Train extends Vehicle {
    int cars;
    String schedule;

    Train(String vehicleName, int cars, String schedule) {
        super(vehicleName);
        this.cars = cars;
        this.schedule = schedule;
    }

    void dispatch() {
        System.out.println("Train " + vehicleName + " dispatched.");
        System.out.println("Schedule: " + schedule);
        System.out.println("Number of Cars: " + cars + "\n");
    }
}

class Bike extends Vehicle {
    double ratePerHour;

    Bike(String vehicleName, double ratePerHour) {
        super(vehicleName);
        this.ratePerHour = ratePerHour;
    }

    void dispatch() {
        System.out.println("Bike " + vehicleName + " dispatched.");
        System.out.println("Eco-friendly ride, Rate: ₹" + ratePerHour + " per hour\n");
    }
}

public class VehicleDispatch {
    public static void main(String[] args) {
        Vehicle v1 = new Bus("CityLine-12", 50, "Route A to B");
        Vehicle v2 = new Taxi("Ola-102", 50, 12.5);
        Vehicle v3 = new Train("Metro-7", 8, "Every 15 mins");
        Vehicle v4 = new Bike("GreenBike-45", 30);

        v1.dispatch();
        v2.dispatch();
        v3.dispatch();
        v4.dispatch();
    }
}
