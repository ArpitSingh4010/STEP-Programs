// Custom simple Map replacement
class SimpleMap {
    private String[] keys;
    private String[] values;
    private int size;

    public SimpleMap(int capacity) {
        keys = new String[capacity];
        values = new String[capacity];
        size = 0;
    }

    public void put(String key, String value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public String get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) return values[i];
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        String result = "{";
        for (int i = 0; i < size; i++) {
            result += keys[i] + "=" + values[i];
            if (i < size - 1) result += ", ";
        }
        result += "}";
        return result;
    }
}

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final SimpleMap resourceLimits;

    private KingdomConfig(String name, int year, String[] types, SimpleMap limits) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
        if (year <= 0) throw new IllegalArgumentException("Invalid year");
        if (types == null || types.length == 0) throw new IllegalArgumentException("Invalid types");
        if (limits == null || limits.getSize() == 0) throw new IllegalArgumentException("Invalid limits");
        this.kingdomName = name;
        this.foundingYear = year;
        this.allowedStructureTypes = copyArray(types);
        this.resourceLimits = limits;
    }

    public static KingdomConfig createDefaultKingdom() {
        String[] types = {"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"};
        SimpleMap limits = new SimpleMap(2);
        limits.put("Gold", "1000");
        limits.put("Wood", "500");
        return new KingdomConfig("DefaultKingdom", 1000, types, limits);
    }

    public static KingdomConfig createFromTemplate(String type) {
        if ("Royal".equals(type)) {
            String[] types = {"EnchantedCastle", "MysticLibrary"};
            SimpleMap limits = new SimpleMap(1);
            limits.put("Gold", "2000");
            return new KingdomConfig("RoyalKingdom", 1200, types, limits);
        }
        return createDefaultKingdom();
    }

    private String[] copyArray(String[] arr) {
        String[] copy = new String[arr.length];
        for (int i = 0; i < arr.length; i++) copy[i] = arr[i];
        return copy;
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return copyArray(allowedStructureTypes); }
    public SimpleMap getResourceLimits() { return resourceLimits; }

    public String toString() {
        return "KingdomConfig{name=" + kingdomName + ", year=" + foundingYear + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KingdomConfig)) return false;
        KingdomConfig k = (KingdomConfig) o;
        return kingdomName.equals(k.kingdomName) && foundingYear == k.foundingYear;
    }

    public int hashCode() {
        int h = 7;
        for (int i = 0; i < kingdomName.length(); i++) h = h * 31 + kingdomName.charAt(i);
        return h + foundingYear;
    }
}

class MagicalStructure {
    private static int counter = 1;
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;
    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    public MagicalStructure(String name, String location) {
        this(name, location, 100, true);
    }

    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }

    public MagicalStructure(String name, String location, int power, boolean active) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
        if (location == null || location.isEmpty()) throw new IllegalArgumentException("Invalid location");
        if (power < MIN_MAGIC_POWER || power > MAX_MAGIC_POWER) throw new IllegalArgumentException("Invalid power");
        this.structureName = name;
        this.location = location;
        this.magicPower = power;
        this.isActive = active;
        this.currentMaintainer = "Unknown";
        this.structureId = "S" + counter;
        this.constructionTimestamp = counter;
        counter++;
    }

    public String getStructureId() { return structureId; }
    public long getConstructionTimestamp() { return constructionTimestamp; }
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }
    public int getMagicPower() { return magicPower; }
    public boolean getIsActive() { return isActive; }
    public String getCurrentMaintainer() { return currentMaintainer; }

    public void setMagicPower(int power) {
        if (power >= MIN_MAGIC_POWER && power <= MAX_MAGIC_POWER) this.magicPower = power;
    }
    public void setIsActive(boolean active) { this.isActive = active; }
    public void setCurrentMaintainer(String maintainer) { this.currentMaintainer = maintainer; }

    public String toString() {
        return "Structure{name=" + structureName + ", location=" + location + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MagicalStructure)) return false;
        MagicalStructure m = (MagicalStructure) o;
        return structureId.equals(m.structureId);
    }

    public int hashCode() {
        int h = 5;
        for (int i = 0; i < structureId.length(); i++) h = h * 31 + structureId.charAt(i);
        return h;
    }
}

class WizardTower {
    private final int maxSpellCapacity;
    private String[] knownSpells;
    private String currentWizard;

    public WizardTower() {
        this.maxSpellCapacity = 10;
        this.knownSpells = new String[0];
        this.currentWizard = "None";
    }

    public WizardTower(int capacity, String[] spells) {
        this.maxSpellCapacity = capacity;
        this.knownSpells = spells;
        this.currentWizard = "None";
    }

    public WizardTower(int capacity, String[] spells, String wizard) {
        this.maxSpellCapacity = capacity;
        this.knownSpells = spells;
        this.currentWizard = wizard;
    }
}

class EnchantedCastle {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String type) {
        this.castleType = type;
        this.defenseRating = 100;
        this.hasDrawbridge = false;
    }

    public EnchantedCastle(String type, int defense, boolean drawbridge) {
        this.castleType = type;
        this.defenseRating = defense;
        this.hasDrawbridge = drawbridge;
    }
}

class MysticLibrary {
    private final SimpleMap bookCollection;
    private int knowledgeLevel;

    public MysticLibrary() {
        this.bookCollection = new SimpleMap(10);
        this.knowledgeLevel = 10;
    }

    public MysticLibrary(SimpleMap books, int level) {
        this.bookCollection = books;
        this.knowledgeLevel = level;
    }
}

class DragonLair {
    private final String dragonType;
    private long treasureValue;
    private int territorialRadius;

    public DragonLair(String type) {
        this.dragonType = type;
        this.treasureValue = 1000;
        this.territorialRadius = 50;
    }

    public DragonLair(String type, long treasure, int radius) {
        this.dragonType = type;
        this.treasureValue = treasure;
        this.territorialRadius = radius;
    }
}

class KingdomManager {
    private final Object[] structures;
    private int count;
    private final KingdomConfig config;

    public KingdomManager(KingdomConfig c, int capacity) {
        this.config = c;
        this.structures = new Object[capacity];
        this.count = 0;
    }

    public void addStructure(Object s) {
        if (count < structures.length) {
            structures[count] = s;
            count++;
        }
    }

    public static boolean canStructuresInteract(Object s1, Object s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) return true;
        if (s1 instanceof DragonLair && s2 instanceof EnchantedCastle) return true;
        return false;
    }

    public static String performMagicBattle(Object attacker, Object defender) {
        if (attacker instanceof WizardTower && defender instanceof DragonLair)
            return "Wizard defeats Dragon";
        return "No clear winner";
    }

    public static int calculateKingdomPower(Object[] arr) {
        int total = 0;
        for (Object o : arr) {
            if (o instanceof MagicalStructure) {
                total += ((MagicalStructure) o).getMagicPower();
            }
        }
        return total;
    }

    private String determineStructureCategory(Object s) {
        if (s instanceof WizardTower) return "Wizard Tower";
        if (s instanceof EnchantedCastle) return "Castle";
        if (s instanceof MysticLibrary) return "Library";
        if (s instanceof DragonLair) return "Dragon Lair";
        return "Unknown";
    }
}

public class MainKingdom {
    public static void main(String[] args) {
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        MagicalStructure s1 = new MagicalStructure("Tower Alpha", "North", 500, true);
        MagicalStructure s2 = new MagicalStructure("Castle Beta", "East", 300);
        WizardTower wt = new WizardTower(5, new String[]{"Fireball", "Shield"}, "Merlin");
        DragonLair dl = new DragonLair("Red Dragon", 5000, 200);

        KingdomManager manager = new KingdomManager(config, 10);
        manager.addStructure(s1);
        manager.addStructure(s2);
        manager.addStructure(wt);
        manager.addStructure(dl);

        Object[] arr = {s1, s2};
        System.out.println("===== KINGDOM STATUS =====");
        System.out.println("Kingdom Name: " + config.getKingdomName());
        System.out.println("Founding Year: " + config.getFoundingYear());

        System.out.print("Allowed Structures: ");
        for (String t : config.getAllowedStructureTypes()) {
            System.out.print(t + " ");
        }
        System.out.println();

        System.out.println("Resource Limits: " + config.getResourceLimits());

        System.out.println("\n===== STRUCTURES =====");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n===== KINGDOM POWER =====");
        System.out.println("Total Power = " + KingdomManager.calculateKingdomPower(arr));

        System.out.println("\n===== INTERACTIONS =====");
        System.out.println("WizardTower & MysticLibrary can interact? " +
                KingdomManager.canStructuresInteract(wt, new MysticLibrary()));
        System.out.println("DragonLair & EnchantedCastle can interact? " +
                KingdomManager.canStructuresInteract(dl, new EnchantedCastle("Royal")));

        System.out.println("\n===== MAGIC BATTLE =====");
        System.out.println("Result: " + KingdomManager.performMagicBattle(wt, dl));

        System.out.println("\n===== END REPORT =====");
    }
}
