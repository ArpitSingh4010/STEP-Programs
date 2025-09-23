class Light {
    Light() {
        System.out.println("Light()");
    }
    Light(int lumens) {
        this();
        System.out.println("Light(" + lumens + ")");
    }
    Light(int lumens, String color) {
        this(lumens);
        System.out.println("Light(" + lumens + ", " + color + ")");
    }
}

class LED extends Light {
    LED() {
        super();
        System.out.println("LED()");
    }
    LED(int lumens) {
        this();
        System.out.println("LED(" + lumens + ")");
    }
    LED(int lumens, String color) {
        super(lumens, color);
        System.out.println("LED(" + lumens + ", " + color + ")");
    }
}
public class LightLed {
    public static void main(String[] args) {
        new Light();
        new Light(800);
        new Light(800, "Warm");
        new LED();
        new LED(1200);
        new LED(1200, "Cool");
    }
}