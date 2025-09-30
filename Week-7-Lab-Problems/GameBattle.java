class Character {
    String name;
    Character(String name) {
        this.name = name;
    }
    void attack() {
        System.out.println(name + " attacks!");
    }
}

class Warrior extends Character {
    Warrior(String name) {
        super(name);
    }
    void attack() {
        System.out.println(name + " swings a mighty sword with high defense!");
    }
}

class Mage extends Character {
    Mage(String name) {
        super(name);
    }
    void attack() {
        System.out.println(name + " casts a powerful spell using mana!");
    }
}

class Archer extends Character {
    Archer(String name) {
        super(name);
    }
    void attack() {
        System.out.println(name + " shoots a precise arrow from long range!");
    }
}

public class GameBattle{
    public static void main(String[] args) {
        Character[] army = {
            new Warrior("Thor"),
            new Mage("Merlin"),
            new Archer("Robin")
        };

        for(Character c : army) {
            c.attack();
        }
    }
}
