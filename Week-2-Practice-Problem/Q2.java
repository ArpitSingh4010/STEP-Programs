import java.util.Scanner;
public class Q2 {
    public static String removePunctuation(String text) {
        // Your code here
        return text.replaceAll("[^a-zA-Z0-9\\s]", "");

    }

    // Your code here
    // TODO: Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder capitalizedText = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedText.append(Character.toUpperCase(word.charAt(0)))
                               .append(word.substring(1)).append(" ");
            }
        }
        return capitalizedText.toString().trim();
    // Your code here
    }
    // TODO: Method to reverse word order
    
    
    
    public static String reverseWordOrder(String text) {
        String[] words = text.split(" ");
        StringBuilder reversedText = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedText.append(words[i]).append(" ");
        }
        return reversedText.toString().trim();
    // Your code here
    }
    // TODO: Method to count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.split(" ");
        java.util.Map<String, Integer> wordCount = new java.util.HashMap<>();
        for (String word : words) {
            word = word.toLowerCase(); // Normalize to lowercase
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (java.util.Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Word: '" + entry.getKey() + "' Count: " + entry.getValue());
        }
    // Your code here
    }
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// TODO: Ask user to enter a sentence with mixed formatting
System.out.println("Enter a sentence with mixed formatting:");
String input = scanner.nextLine();
// TODO: Process the input using the following methods:
// 1. trim() - Remove extra spaces
String trimmedInput = input.trim();
// 2. replace() - Replace all spaces with underscores
String underscoredInput = trimmedInput.replace(" ", "_");
// 3. replaceAll() - Remove all digits using regex
String noDigitsInput = underscoredInput.replaceAll("\\d", "");
// 4. split() - Split sentence into words array
String[] words = noDigitsInput.split("_");
// 5. join() - Rejoin words with " | " separator
String joinedInput = String.join(" | ", words);
// TODO: Create additional processing methods:

// - Remove all punctuation
    String noPunctuationInput = removePunctuation(joinedInput);
// - Capitalize first letter of each word
    String capitalizedInput = capitalizeWords(noPunctuationInput);
// - Reverse the order of words
    String reversedInput = reverseWordOrder(capitalizedInput);
// - Count word frequency
    countWordFrequency(reversedInput);
scanner.close();
}

}