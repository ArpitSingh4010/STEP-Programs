class Fruit{
    protected String color;
    protected String taste;
    Fruit(String color, String taste){
        this.color = color;
        this.taste = taste;
    }
}
class Apple extends Fruit{
    private String variety;
    Apple(String color,String taste,String variety){
        super(color,taste);
        this.variety = variety;
    }
    void printDetails(){
        System.out.println("Color: "+color);
        System.out.println("Taste: "+taste);
        System.out.println("Variety: "+variety);
    }
}
public class FruitTest{
    public static void main(String[] args){
        Apple a1=new Apple("Orange","Sweet","Valencia");
        a1.printDetails();

    }
}