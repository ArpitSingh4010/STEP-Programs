import java.util.Scanner;

public class CharFrequency {

    // Method to find frequency of characters
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // Array for ASCII characters

        // Count frequency using charAt()
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Create a 2D array for characters and their frequency
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        return result;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] frequencyTable = findFrequency(text);

        System.out.println("Character\tFrequency");
        for (String[] row : frequencyTable) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }

        sc.close();
    }
}
