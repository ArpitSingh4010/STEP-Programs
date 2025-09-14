import java.util.*;

class VirtualPet {
    // Fields
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String stage;
    private boolean isGhost = false;

    // Constants
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;

    // Default constructor - mysterious egg with random species
    public VirtualPet() {
        this("Unknown Egg", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    // Constructor with name only - starts as Baby
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    // Constructor with name and species - starts as Child
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, EVOLUTION_STAGES[2]);
    }

    // Full constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        totalPetsCreated++;
    }

    // Static method to generate unique ID
    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    // Helper to choose random species
    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Slime", "Griffin"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    // Methods affecting pet state
    public void evolvePet() {
        if (!isGhost) {
            if (age < 2) stage = EVOLUTION_STAGES[0];
            else if (age < 4) stage = EVOLUTION_STAGES[1];
            else if (age < 7) stage = EVOLUTION_STAGES[2];
            else if (age < 10) stage = EVOLUTION_STAGES[3];
            else if (age < 15) stage = EVOLUTION_STAGES[4];
            else stage = EVOLUTION_STAGES[5];
        }
    }

    public void feedPet() {
        if (!isGhost) {
            health = Math.min(100, health + 10);
            happiness = Math.min(100, happiness + 5);
        }
    }

    public void playWithPet() {
        if (!isGhost) {
            happiness = Math.min(100, happiness + 10);
            health = Math.max(0, health - 5);
        }
    }

    public void healPet() {
        if (!isGhost) {
            health = Math.min(100, health + 20);
        }
    }

    public void simulateDay() {
        if (!isGhost) {
            age++;
            Random rand = new Random();
            health -= rand.nextInt(10);
            happiness -= rand.nextInt(8);

            if (health <= 0) {
                stage = "Ghost";
                isGhost = true;
                health = 0;
                happiness = 0;
            } else {
                evolvePet();
            }
        }
    }

    public void displayPetStatus() {
        System.out.printf(" ID: %s | Name: %s | Species: %s | Age: %d | Happiness: %d | Health: %d | Stage: %s%n",
                petId.substring(0, 8), petName, species, age, happiness, health, stage);
    }

    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
}

// Main class
public class VirtualPetSimulator {
    public static void main(String[] args) {
        // Create pets using all constructors
        VirtualPet pet1 = new VirtualPet(); // Default Egg
        VirtualPet pet2 = new VirtualPet("Fluffy"); // Name only -> Baby
        VirtualPet pet3 = new VirtualPet("Spark", "Dragon"); // Name + Species -> Child
        VirtualPet pet4 = new VirtualPet("Luna", "Phoenix", 5, 80, 90, "Child"); // Full constructor

        // Simulate 3 days
        for (int day = 1; day <= 3; day++) {
            System.out.println("\n Day " + day + ":");

            pet1.simulateDay();
            pet1.feedPet();
            pet1.displayPetStatus();

            pet2.simulateDay();
            pet2.playWithPet();
            pet2.displayPetStatus();

            pet3.simulateDay();
            pet3.healPet();
            pet3.displayPetStatus();

            pet4.simulateDay();
            pet4.feedPet();
            pet4.displayPetStatus();
        }

        System.out.println("\nTotal Pets Created: " + VirtualPet.getTotalPetsCreated());
    }
}
