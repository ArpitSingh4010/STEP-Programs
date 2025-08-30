import java.util.Scanner;

public class WordLengthTable{

    public static String[] splitWords(String text) {
        String[] words = new String[100];
        int index = 0;
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (!word.equals("")) {
                    words[index++] = word;
                    word = "";
                }
            } else {
                word += c;
            }
        }
        if (!word.equals("")) {
            words[index++] = word;
        }
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static int findLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[][] createWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] table = createWordLengthTable(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }
        sc.close();
    }
}
