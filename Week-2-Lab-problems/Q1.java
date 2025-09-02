import java.util.Scanner;

public class Q1{

    // Find all occurrences using indexOf
    public static int[] findOccurrences(String text, String find) {
        int count = 0, index = text.indexOf(find);
        while (index != -1) {
            count++;
            index = text.indexOf(find, index + find.length());
        }

        int[] positions = new int[count];
        int i = 0;
        index = text.indexOf(find);
        while (index != -1) {
            positions[i++] = index;
            index = text.indexOf(find, index + find.length());
        }
        return positions;
    }

    // Manual replacement using charAt
    public static String manualReplace(String text, String find, String replace) {
        String result = "";
        for (int i = 0; i < text.length();) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result += replace;
                i += find.length();
            } else {
                result += text.charAt(i);
                i++;
            }
        }
        return result;
    }

    // Compare with built-in replace
    public static boolean compareResults(String manual, String builtin) {
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main text: ");
        String text = sc.nextLine();

        System.out.println("Enter the substring to find: ");
        String find = sc.nextLine();

        System.out.println("Enter the substring to replace with: ");
        String replace = sc.nextLine();

        int[] positions = findOccurrences(text, find);
        System.out.print("Occurrences at positions: ");
        for (int pos : positions) {
            System.out.print(pos + " ");
        }

        String manual = manualReplace(text, find, replace);
        String builtin = text.replace(find, replace);

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Manual Result: " + manual);
        System.out.println("Built-in Result: " + builtin);
        System.out.println("Do they match? " + compareResults(manual, builtin));

        sc.close();
    }
}
