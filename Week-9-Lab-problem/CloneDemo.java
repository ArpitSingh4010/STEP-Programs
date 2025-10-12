class Address {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(address.city, address.state);
        return cloned;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}

public class CloneDemo{
    public static void main(String[] args) {
        try {
            Address addr = new Address("Chennai", "Tamil Nadu");
            Person p1 = new Person("Arpit", addr);

            Person p2 = p1.shallowClone();
            Person p3 = p1.deepClone();

            System.out.println("---- Before modification ----");
            System.out.println("Original: " + p1);
            System.out.println("Shallow Clone: " + p2);
            System.out.println("Deep Clone: " + p3);

            p1.address.city = "Delhi";

            System.out.println("\n---- After modifying original’s address ----");
            System.out.println("Original: " + p1);
            System.out.println("Shallow Clone: " + p2);
            System.out.println("Deep Clone: " + p3);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
