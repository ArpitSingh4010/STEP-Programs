class BasicMath {
    int calculate(int a, int b) {
        return a + b;
    }

    double calculate(double a, double b) {
        return a * b;
    }
}

// Child class
class AdvancedMath extends BasicMath {
    int calculate(int a, int b, int c) {
        return a + b + c;
    }

    double calculate(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
}
public class MathTest {
    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();
        System.out.println("Addition: " + math.calculate(5, 3));
        System.out.println("Multiplication: " + math.calculate(2.5, 4.0));
        System.out.println("Sum of 3 ints: " + math.calculate(1, 2, 3));
        System.out.println("Average of 3 doubles: " + math.calculate(4.5, 5.5, 6.5));
    }
}
