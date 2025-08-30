import java.util.Scanner;

public class WordMinMax{

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

    public static int[] findShortestLongest(String[][] table) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            if (length < Integer.parseInt(table[minIndex][1])) {
                minIndex = i;
            }
            if (length > Integer.parseInt(table[maxIndex][1])) {
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] table = createWordLengthTable(words);
        int[] result = findShortestLongest(table);

        System.out.println("Word\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }

        System.out.println("\nShortest word: " + table[result[0]][0] + " (Length: " + table[result[0]][1] + ")");
        System.out.println("Longest word: " + table[result[1]][0] + " (Length: " + table[result[1]][1] + ")");

        sc.close();
    }
}
