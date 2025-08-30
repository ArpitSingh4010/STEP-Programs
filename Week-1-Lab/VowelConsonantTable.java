import java.util.Scanner;

public class VowelConsonantTable{

    public static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] analyzeString(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            table[i][0] = String.valueOf(c);
            table[i][1] = checkChar(c);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.println("Character\tType");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();

        String[][] table = analyzeString(text);
        displayTable(table);

        sc.close();
    }
}
