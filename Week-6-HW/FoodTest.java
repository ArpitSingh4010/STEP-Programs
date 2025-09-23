abstract class Food {
    public final void prepare() {
        wash();
        cook();
        serve();
    }
    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}
class Pizza extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables for pizza...");
    }

    @Override
    protected void cook() {
        System.out.println("Baking the pizza in the oven...");
    }

    @Override
    protected void serve() {
        System.out.println("Serving pizza with extra cheese!");
    }
}
class Soup extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing ingredients for soup...");
    }

    @Override
    protected void cook() {
        System.out.println("Boiling ingredients to make soup...");
    }

    @Override
    protected void serve() {
        System.out.println("Serving hot soup in a bowl!");
    }
}
public class FoodTest {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        Food soup = new Soup();

        System.out.println("Preparing Pizza:");
        pizza.prepare();

        System.out.println("\nPreparing Soup:");
        soup.prepare();
    }
}
