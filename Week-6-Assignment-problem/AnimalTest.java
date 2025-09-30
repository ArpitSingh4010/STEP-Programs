// TODO: Create base class Animal:
class Animal {
// TODO: Create protected fields:
// - species (String)
// - habitat (String)
// - lifespan (int)
// - isWildlife (boolean)
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;   
// TODO: Create constructor that:
// - Takes all parameters
// - Prints "Animal constructor: Creating [species]"
     Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }
// TODO: Create methods:
// - eat() - prints "Animal is eating"
// - sleep() - prints "Animal is sleeping"


// - move() - prints "Animal is moving"
// - getAnimalInfo() - returns formatted animal details
    void eat() {
        System.out.println("Animal is eating");
    }

    void sleep() {
        System.out.println("Animal is sleeping");
    }

    void move() {
        System.out.println("Animal is moving");
    }

    void getAnimalInfo() {
        System.out.println("Species: " + species + ", Habitat: " + habitat + ", Lifespan: " + lifespan + " years, Is Wildlife: " + isWildlife);
    }
}

// Top-level Mammal class
class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    Mammal(String species, String habitat, int lifespan, boolean isWildlife, String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.gestationPeriod = gestationPeriod;
        this.hasWarmBlood = true;
        System.out.println("Mammal constructor");
    }

    @Override
    void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}
// TODO: Create specific class Dog extends Mammal:


class Dog extends Mammal {
// TODO: Add dog-specific fields:
// - breed (String)
// - isDomesticated (boolean)
// - loyaltyLevel (int) - 1-10 scale
// - favoriteActivity (String)
    String breed;
    boolean isDomesticated;
    int loyaltyLevel;
    String favoriteActivity;
// TODO: Create multiple constructors with different chaining patterns:
// Constructor 1: Basic dog with minimal parameters
// - Calls super() with default mammal/animal values

// - Sets dog-specific defaults
    Dog(String breed) {
        super("Dog", "Domestic", 12, false, "Various", 60);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }
// Constructor 2: Detailed dog with all parameters
    Dog(String species, String habitat, int lifespan, boolean isWildlife, String furColor, int gestationPeriod, String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

// - Calls super() with all mammal/animal parameters
// - Initializes all dog-specific fields
// - Prints "Dog constructor: Creating [breed] dog"
// Constructor 3: Copy constructor
// - Takes another Dog object as parameter
// - Calls this() with parameters from source dog
    Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife, other.furColor, other.gestationPeriod, other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog copy constructor: Creating copy of " + other.breed + " dog");
    }
// TODO: Override methods from the inheritance chain:
// - Override eat() to show dog eating behavior
// - Call super.eat() and add "wagging tail while eating"
// - Override move() to print "Dog is running and playing"
// - Override sleep() to print "Dog is sleeping in doghouse"
    @Override
    void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }
// TODO: Add dog-specific methods:
// - bark() - prints "Woof! Woof!"
// - fetch() - prints "Dog is fetching the ball"
// - showLoyalty() - prints loyalty level message
void bark() {
        System.out.println("Woof! Woof!");
    }

    void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    void showLoyalty() {
        System.out.println("Loyalty Level: " + loyaltyLevel + "/10");
    }   
// TODO: Create method that demonstrates calling up the chain:
// - demonstrateInheritance() - calls methods from all three levels
    void demonstrateInheritance() {
        System.out.println("Demonstrating inheritance:");
        eat(); 
        sleep();
        move();
        nurse();
        regulateTemperature();
        getAnimalInfo();
    }
}
public class AnimalTest {
public static void main(String[] args) {
// TODO: Test multilevel constructor chaining:
// 1. Create Dog object and observe all constructor calls in order
// 2. Test different constructor patterns
Dog basicDog = new Dog("Labrador");
System.out.println();
// TODO: Test method overriding across levels:
// - Call same method and see how it's handled at each level
// - Show how super calls propagate up the chain
basicDog.eat();
basicDog.sleep();
basicDog.move();
basicDog.nurse();
basicDog.regulateTemperature();
System.out.println();
// TODO: Test access to inherited members:
basicDog.demonstrateInheritance();
System.out.println();
// - Access fields from all levels in hierarchy
// - Call methods from all levels
// TODO: Demonstrate the chain of inheritance:
// - Show Dog IS-A Mammal IS-A Animal relationships
// - Test instanceof operator with all levels
System.out.println("Is basicDog an instance of Dog? " + (basicDog instanceof Dog));
System.out.println("Is basicDog an instance of Mammal? " + (basicDog instanceof Mammal));
System.out.println("Is basicDog an instance of Animal? " + (basicDog instanceof Animal));
System.out.println();
// TODO: Create multiple Dog objects with different constructor 5 patterns:
// - Show how constructor chaining works with different initialization paths
Dog detailedDog = new Dog("Wolf", "Forest", 15, true, "Gray", 63, "German Shepherd", false, 10, "Guarding");

}
}
