
class Game {
    String name;
    int players;

    Game(String name, int players) {
        this.name = name;
        this.players = players;
    }
    @Override
    public String toString() {
        return "Game[name=" + name + ", players=" + players + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game g = (Game) obj;
            return this.name.equals(g.name) && this.players == g.players;
        }
        return false;
    }
}
class CardGame extends Game {
    String cardType;

    CardGame(String name, int players, String cardType) {
        super(name, players);
        this.cardType = cardType;
    }
    @Override
    public String toString() {
        return super.toString() + ", CardGame[cardType=" + cardType + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CardGame) {
            CardGame cg = (CardGame) obj;
            return super.equals(cg) && this.cardType.equals(cg.cardType);
        }
        return false;
    }
}
public class GameTest{
    public static void main(String[] args) {
        Game g1 = new Game("Chess", 2);
        Game g2 = new Game("Chess", 2);
        CardGame c1 = new CardGame("Poker", 4, "Standard Deck");
        CardGame c2 = new CardGame("Poker", 4, "Standard Deck");
        System.out.println(g1);
        System.out.println(c1);
        System.out.println("g1 equals g2?: " + g1.equals(g2));
        System.out.println("c1 equals c2?: " + c1.equals(c2));
    }
}
