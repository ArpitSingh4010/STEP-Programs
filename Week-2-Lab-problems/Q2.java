import java.util.Scanner;

public class Q2{

    // Convert a character to uppercase using ASCII
    public static char toUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char)(ch - 32);
        }
        return ch;
    }

    // Convert a character to lowercase using ASCII
    public static char toLower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char)(ch + 32);
        }
        return ch;
    }

    // Convert full string to uppercase
    public static String convertToUpper(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result += toUpper(text.charAt(i));
        }
        return result;
    }

    // Convert full string to lowercase
    public static String convertToLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result += toLower(text.charAt(i));
        }
        return result;
    }

    // Convert to Title Case
    public static String convertToTitle(String text) {
        String result = "";
        boolean newWord = true;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                result += ch;
                newWord = true;
            } else {
                if (newWord) {
                    result += toUpper(ch);
                    newWord = false;
                } else {
                    result += toLower(ch);
                }
            }
        }
        return result;
    }

    // Compare with built-in methods
    public static void compareResults(String manualUpper, String manualLower, String text) {
        String builtinUpper = text.toUpperCase();
        String builtinLower = text.toLowerCase();

        System.out.println("\nComparison with built-in methods:");
        System.out.println("Manual Upper == Built-in Upper? " + manualUpper.equals(builtinUpper));
        System.out.println("Manual Lower == Built-in Lower? " + manualLower.equals(builtinLower));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text: ");
        String text = sc.nextLine();

        String upper = convertToUpper(text);
        String lower = convertToLower(text);
        String title = convertToTitle(text);

        System.out.println("\nResult in Tabular Format:");
        System.out.println("------------------------------------------");
        System.out.println("Original Text     : " + text);
        System.out.println("Uppercase (ASCII) : " + upper);
        System.out.println("Lowercase (ASCII) : " + lower);
        System.out.println("Title Case (ASCII): " + title);
        System.out.println("------------------------------------------");

        compareResults(upper, lower, text);

        sc.close();
    }
}
