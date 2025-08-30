import java.util.Scanner;

public class CharFrequencyFinder{

    // Method to find frequency of characters using charAt()
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // ASCII frequency array

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array for result
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Step 4: Fill result with unique characters and their frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0; // Set to 0 so it’s not counted again
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
