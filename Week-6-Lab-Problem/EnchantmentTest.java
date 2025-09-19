class Box {
    void pack() {
        System.out.println("Packing the box.");
    }

    void unpack() {
        System.out.println("Unpacking the box.");
    }
}

class GiftBox extends Box {
    @Override
    void pack() {
        super.pack();
        System.out.println("Adding gift wrap and ribbon.");
    }

    @Override
    void unpack() {
        super.unpack();
        System.out.println("Removing gift wrap and ribbon.");
    }
}

public class EnchantmentTest {
    public static void main(String[] args) {
        GiftBox gift = new GiftBox();
        gift.pack();
        gift.unpack();
    }
}