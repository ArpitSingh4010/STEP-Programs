abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    // Default constructor
    public MagicalStructure() {
        this("Unknown Structure", 10, "Unknown Land", true);
    }

    // Constructor with name
    public MagicalStructure(String structureName) {
        this(structureName, 20, "Central Kingdom", true);
    }

    // Constructor with name and power
    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Central Kingdom", true);
    }

    // Full constructor
    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();

    public void displayInfo() {
        System.out.println("Structure: " + structureName +
                " | Power: " + magicPower +
                " | Location: " + location +
                " | Active: " + isActive);
    }
}

// WizardTower class
class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower() {
        this("Wizard Tower", 50, "North Hill", true, 5, new String[]{"Fireball"});
    }

    public WizardTower(String structureName, int spellCapacity) {
        this(structureName, 70, "South Valley", true, spellCapacity, new String[]{"Lightning"});
    }

    public WizardTower(String structureName, int magicPower, String location, boolean isActive, int spellCapacity, String[] knownSpells) {
        super(structureName, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a powerful spell!");
    }
}

// EnchantedCastle class
class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Small Castle", 40, "Central Plains", true, 50, false);
    }

    public EnchantedCastle(String structureName, int defenseRating) {
        this(structureName, 60, "Royal Grounds", true, defenseRating, true);
    }

    public EnchantedCastle(String structureName, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(structureName, magicPower, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " raises a protective barrier!");
    }
}

// MysticLibrary class
class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary() {
        this("Basic Library", 30, "Eastern Woods", true, 100, "None");
    }

    public MysticLibrary(String structureName, int bookCount) {
        this(structureName, 45, "Northern Forest", true, bookCount, "Old Latin");
    }

    public MysticLibrary(String structureName, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(structureName, magicPower, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " reveals forgotten knowledge!");
    }
}

// DragonLair class
class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair() {
        this("Cave Lair", 80, "Volcano Region", true, "Fire Dragon", 1000);
    }

    public DragonLair(String structureName, String dragonType) {
        this(structureName, 90, "Mountain Peak", true, dragonType, 2000);
    }

    public DragonLair(String structureName, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(structureName, magicPower, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury!");
    }
}

// Main class
public class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            System.out.println(" Knowledge Boost Activated!");
            return true;
        }
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
            System.out.println(" Dragon Guard Activated!");
            return true;
        }
        return false;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins the battle!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " defends successfully!";
        } else {
            return "The battle is a draw!";
        }
    }

    public static void main(String[] args) {
        WizardTower tower = new WizardTower();
        EnchantedCastle castle = new EnchantedCastle("Royal Fortress", 100);
        MysticLibrary library = new MysticLibrary("Ancient Archives", 500);
        DragonLair lair = new DragonLair("Dragon's Peak", "Ice Dragon");

        tower.displayInfo();
        castle.displayInfo();
        library.displayInfo();
        lair.displayInfo();

        tower.castMagicSpell();
        castle.castMagicSpell();
        library.castMagicSpell();
        lair.castMagicSpell();

        canStructuresInteract(tower, library);
        canStructuresInteract(castle, lair);

        System.out.println(performMagicBattle(tower, castle));
    }
}
