class Phone{
    String brand;
    String model;
    Phone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
}
class Smartphone extends Phone{
    String os;
    Smartphone(String brand, String model, String os){
        super(brand, model);
        this.os = os;
    }
    void printDetails(){
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("OS: "+os);
    }
}
public class PhoneTest {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("Apple", "iPhone 13", "iOS");
        s1.printDetails();
    }
}
