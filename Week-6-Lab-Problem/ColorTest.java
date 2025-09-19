class Color{
    String color;
    Color(String color){
        this.color = color;
    }
}
class PrimaryColor extends Color{
    String intensity;
    PrimaryColor(String color, String intensity){
        super(color);
        this.intensity = intensity;
    }
}
class RedColor extends PrimaryColor{
    String shade;
    RedColor(String color, String intensity, String shade){
        super(color, intensity);
        this.shade = shade;
    }
    void printDetails(){
        System.out.println("Color: "+color);
        System.out.println("Intensity: "+intensity);
        System.out.println("Shade: "+shade);
    }
}
public class ColorTest {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", "Bright", "Crimson");
        red.printDetails();
    }
}
