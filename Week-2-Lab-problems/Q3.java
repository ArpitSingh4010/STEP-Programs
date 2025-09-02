import java.util.Scanner;

public class Q3{

    // String concatenation using +
    public static long stringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str = str + "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("Final String Length: " + str.length());
        return end - start;
    }

    // StringBuilder concatenation
    public static long stringBuilderConcat(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final StringBuilder Length: " + sb.length());
        return end - start;
    }

    // StringBuffer concatenation
    public static long stringBufferConcat(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final StringBuffer Length: " + sbuf.length());
        return end - start;
    }

    // Display performance comparison
    public static void displayResults(long timeString, long timeBuilder, long timeBuffer) {
        System.out.println("\nPerformance Comparison:");
        System.out.println("Method        Time (ms)       Memory Efficiency");
        System.out.println("String        " + timeString + "             Low (Immutable)");
        System.out.println("StringBuilder " + timeBuilder + "             High (Not Thread-Safe)");
        System.out.println("StringBuffer  " + timeBuffer + "             Medium (Thread-Safe)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of iterations (e.g. 1000, 10000, 100000): ");
        int iterations = sc.nextInt();

        long timeString = stringConcat(iterations);
        long timeBuilder = stringBuilderConcat(iterations);
        long timeBuffer = stringBufferConcat(iterations);

        displayResults(timeString, timeBuilder, timeBuffer);

        sc.close();
    }
}
