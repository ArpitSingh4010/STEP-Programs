class Instrument {
    protected String name;
    protected String material;

    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Material: " + material);
    }
}

class Piano extends Instrument {
    private int keys;

    Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }

    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Keys: " + keys);
    }
}

class Guitar extends Instrument {
    private int strings;

    Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }

    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Strings: " + strings);
    }
}

class Drum extends Instrument {
    private String type;

    Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }

    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Type: " + type);
    }
}

public class InstrumentTest {
    public static void main(String[] args) {
    Guitar guitar = new Guitar("Acoustic Guitar", "Wood", 6);
    Piano piano = new Piano("Grand Piano", "Wood", 88);
    Drum drum = new Drum("Bass Drum", "Metal", "Percussion");
    guitar.printDetails();
    piano.printDetails();
    drum.printDetails();
    
    }
}