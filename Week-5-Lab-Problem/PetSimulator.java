import java.util.*;

final class PetSpecies {
    private final String speciesName;
    private final String[] stages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] stages, int maxLifespan, String habitat) {
        if (speciesName == null || speciesName.isEmpty() || stages == null || stages.length == 0 || maxLifespan <= 0 || habitat == null || habitat.isEmpty()) {
            throw new IllegalArgumentException("Invalid species data");
        }
        this.speciesName = speciesName;
        this.stages = stages.clone();
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getStages() { return stages.clone(); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }
}

class VirtualPet {
    private static int idCounter = 1;
    private final String petId;
    private final PetSpecies petSpecies;
    private final long birthTimestamp;
    private String name;
    private int age;
    private int happiness;
    private int health;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Child", "Adult", "Elder"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    public VirtualPet() {
        this("DefaultPet", new PetSpecies("DefaultSpecies", DEFAULT_EVOLUTION_STAGES, 100, "Forest"), 1, 50, 50);
    }

    public VirtualPet(String name) {
        this(name, new PetSpecies("DefaultSpecies", DEFAULT_EVOLUTION_STAGES, 100, "Forest"), 1, 50, 50);
    }

    public VirtualPet(String name, PetSpecies petSpecies) {
        this(name, petSpecies, 1, 50, 50);
    }

    public VirtualPet(String name, PetSpecies petSpecies, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.birthTimestamp = System.currentTimeMillis();
        this.name = name;
        this.petSpecies = petSpecies;
        this.age = age;
        this.happiness = validateStat(happiness);
        this.health = validateStat(health);
    }

    public String getPetId() { return petId; }
    public PetSpecies getPetSpecies() { return petSpecies; }
    public long getBirthTimestamp() { return birthTimestamp; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }

    public void setName(String name) { if (name != null && !name.isEmpty()) this.name = name; }
    public void setAge(int age) { if (age >= 0) this.age = age; }
    public void setHappiness(int happiness) { this.happiness = validateStat(happiness); }
    public void setHealth(int health) { this.health = validateStat(health); }

    public void feedPet(String foodType) { modifyHealth(calculateFoodBonus(foodType)); }
    public void playWithPet(String gameType) { modifyHappiness(calculateGameEffect(gameType)); }

    protected int calculateFoodBonus(String foodType) { return foodType.equalsIgnoreCase("fruit") ? 10 : 5; }
    protected int calculateGameEffect(String gameType) { return gameType.equalsIgnoreCase("chess") ? 15 : 10; }

    private void modifyHappiness(int delta) { happiness = validateStat(happiness + delta); checkEvolution(); }
    private void modifyHealth(int delta) { health = validateStat(health + delta); checkEvolution(); }
    private void updateEvolutionStage() {}
    private int validateStat(int value) { return Math.max(0, Math.min(100, value)); }
    private String generatePetId() { return "PET" + (idCounter++); }
    private void checkEvolution() { updateEvolutionStage(); }

    String getInternalState() { return name + "|" + age + "|" + happiness + "|" + health; }

    @Override
    public String toString() { return "VirtualPet{" + "id='" + petId + '\'' + ", name='" + name + '\'' + ", species=" + petSpecies.getSpeciesName() + ", age=" + age + ", happiness=" + happiness + ", health=" + health + '}'; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualPet)) return false;
        VirtualPet that = (VirtualPet) o;
        return this.petId.equals(that.petId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < petId.length(); i++) {
            hash = hash * 31 + petId.charAt(i);
        }
        return hash;
    }
}

class DragonPet {
    private final String dragonType;
    private final String breathPower;
    private final VirtualPet pet;

    public DragonPet(String dragonType, String breathPower, String name) {
        this.dragonType = dragonType;
        this.breathPower = breathPower;
        this.pet = new VirtualPet(name, new PetSpecies("Dragon", VirtualPet.DEFAULT_EVOLUTION_STAGES, 200, "Mountain"));
    }

    public String getDragonType() { return dragonType; }
    public String getBreathPower() { return breathPower; }
    public VirtualPet getPet() { return pet; }
}

class RobotPet {
    private boolean chargingNeeded;
    private int batteryLevel;
    private final VirtualPet pet;

    public RobotPet(String name) {
        this.chargingNeeded = false;
        this.batteryLevel = 100;
        this.pet = new VirtualPet(name, new PetSpecies("Robot", VirtualPet.DEFAULT_EVOLUTION_STAGES, 500, "Lab"));
    }

    public boolean isChargingNeeded() { return chargingNeeded; }
    public int getBatteryLevel() { return batteryLevel; }
    public void setChargingNeeded(boolean chargingNeeded) { this.chargingNeeded = chargingNeeded; }
    public void setBatteryLevel(int batteryLevel) { this.batteryLevel = Math.max(0, Math.min(100, batteryLevel)); }
    public VirtualPet getPet() { return pet; }
}

public class PetSimulator {
    public static void main(String[] args) {
        VirtualPet pet = new VirtualPet("Buddy");
        System.out.println(pet);
        pet.feedPet("fruit");
        pet.playWithPet("chess");
        System.out.println(pet);

        DragonPet dragon = new DragonPet("Fire", "Flame Breath", "Draco");
        System.out.println(dragon.getPet());
        dragon.getPet().feedPet("meat");
        System.out.println(dragon.getPet());

        RobotPet robot = new RobotPet("Robo");
        System.out.println(robot.getPet());
        robot.setBatteryLevel(50);
        System.out.println("Battery: " + robot.getBatteryLevel());
    }
}