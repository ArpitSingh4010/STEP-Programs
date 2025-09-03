import java.util.Scanner;

public class Q1{

    // (b) Split sentence into words manually
    public static String[] getWords(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
                count++;
            }
        }

        String[] words = new String[count + 1];
        int start = 0, index = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
                if (start < i) {
                    words[index++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words[index++] = text.substring(start);
        }

        // shrink to correct size
        String[] result = new String[index];
        for (int i = 0; i < index; i++) result[i] = words[i];
        return result;
    }

    // (c) String distance calculation
    public static int stringDistance(String w1, String w2) {
        int len1 = w1.length();
        int len2 = w2.length();
        int distance = 0;

        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (w1.charAt(i) != w2.charAt(i)) distance++;
            }
        } else {
            // difference in lengths counts as insertion/deletion
            int minLen = len1 < len2 ? len1 : len2;
            for (int i = 0; i < minLen; i++) {
                if (w1.charAt(i) != w2.charAt(i)) distance++;
            }
            distance += Math.abs(len1 - len2);
        }

        return distance;
    }

    // (d) Find closest matching word in dictionary
    public static String getSuggestion(String word, String[] dictionary) {
        int minDist = Integer.MAX_VALUE;
        String suggestion = word;

        for (int i = 0; i < dictionary.length; i++) {
            int dist = stringDistance(word.toLowerCase(), dictionary[i].toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                suggestion = dictionary[i];
            }
        }

        if (minDist <= 2) return suggestion;
        return word; // if no close match, return same word
    }

    // (e) Display results in tabular format
    public static void displayResults(String[] words, String[] dictionary) {
        System.out.println("\n--- Spell Check Report ---");
        System.out.println("Word\t\tSuggestion\t\tDistance\t\tStatus");

        for (int i = 0; i < words.length; i++) {
            String original = words[i];
            String suggestion = getSuggestion(original, dictionary);
            int dist = stringDistance(original.toLowerCase(), suggestion.toLowerCase());
            String status = (dist == 0) ? "Correct" : "Misspelled";

            System.out.println(original + "\t\t" + suggestion + "\t\t\t" + dist + "\t\t\t" + status);
        }
    }

    // (f) Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // dictionary of correct words
        String[] dictionary = {"hello", "world", "java", "program", "student", "spell", "checker"};

        // process sentence
        String[] words = getWords(sentence);
        displayResults(words, dictionary);

        sc.close();
    }
}
