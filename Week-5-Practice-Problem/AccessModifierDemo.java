public class AccessModifierDemo {
    // Fields with different access modifiers
    private int privatePoint;
    String defaultPoint;
    protected double protectedPoint;
    public boolean publicPoint;

    // Methods with matching access levels
    private void privateMethod() {
        System.out.println("Private method called");
    }
    void defaultMethod() {
        System.out.println("Default method called");
    }
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Constructor to initialize all fields
    public AccessModifierDemo(int privatePoint, String defaultPoint, double protectedPoint, boolean publicPoint) {
        this.privatePoint = privatePoint;
        this.defaultPoint = defaultPoint;
        this.protectedPoint = protectedPoint;
        this.publicPoint = publicPoint;
    }

    // Public method to test internal access
    public void testInternalAccess() {
        System.out.println("Private Point: " + privatePoint);
        System.out.println("Default Point: " + defaultPoint);
        System.out.println("Protected Point: " + protectedPoint);
        System.out.println("Public Point: " + publicPoint);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        // Create an AccessModifierDemo object
        AccessModifierDemo test = new AccessModifierDemo(1, "Default", 2.0, true);

        // Try to access each field and method

        System.out.println(test.defaultPoint);
        System.out.println(test.protectedPoint);
        System.out.println(test.publicPoint);

        test.defaultMethod();
        test.protectedMethod();
        test.publicMethod();

        // Call testInternalAccess() to show internal accessibility
        test.testInternalAccess();

        // Test access from another class in same package
        SamePackageTest.testAccess();
    }
}

// Second class in the SAME package
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo test = new AccessModifierDemo(10, "Hello", 3.14, false);

        System.out.println(test.defaultPoint);
        System.out.println(test.protectedPoint);
        System.out.println(test.publicPoint);

        test.defaultMethod();
        test.protectedMethod();
        test.publicMethod();
    }
}