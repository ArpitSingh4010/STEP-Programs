class Car {
    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', price=" + price + "}";
    }
}

public class CarExample{
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 20000);

        System.out.println(car);
        System.out.println("Class Name: " + car.getClass().getName());
    }
}
