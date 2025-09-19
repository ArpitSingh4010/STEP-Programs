class Bird{
    void fly(){
        System.out.println("Many Birds can fly");
    }
}
class Penguin extends Bird{
    @Override
    void fly(){
        System.out.println("Penguins cannot fly");
    }
}
class Eagle extends Bird{
    @Override
    void fly(){
        System.out.println("Eagles can fly");
    }
}
public class BirdTest {
    public static void main(String[] args) {
        Bird b = new Bird();
        b.fly();

        Penguin p= new Penguin();
        p.fly();

        Eagle e= new Eagle();
        e.fly();
    }
}
