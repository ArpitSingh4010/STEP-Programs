public class Q1 {
    // TODO: Method to count vowels in a string
    public static int countVowels(String text) {
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        if ("AEIOUaeiou".indexOf(c) != -1) {
            count++;
        }
    }
     return count;
    // Your code here
    }
    // TODO: Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        for (int i = 0; i < text.length(); i++) {
        if (text.charAt(i) == target) {
            System.out.println("Character '" + target + "' found at index: " + i);
        }
        }
    // Your code here
    }
public static void main(String[] args) {
String sampleText = " Java Programming is Fun and Challenging! ";
// TODO: Use built-in methods to perform the following operations:
// 1. Display original string length including spaces
System.out.println("Original string length: " + sampleText.length());
// 2. Remove leading and trailing spaces, show new length
System.out.println("Trimmed string length: " + sampleText.trim().length());
// 3. Find and display the character at index 5
System.out.println("Character at index 5: " + sampleText.charAt(5));
// 4. Extract substring "Programming" from the text
System.out.println("Substring from index 1 to 12: " + sampleText.substring(1, 12));
// 5. Find the index of the word "Fun"
System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));
// 6. Check if the string contains "Java" (case-sensitive)
System.out.println("Contains 'Java': " + sampleText.contains("Java"));
// 7. Check if the string starts with "Java" (after trimming)
System.out.println("Starts with 'Java': " + sampleText.trim().startsWith("Java"));
// 8. Check if the string ends with an exclamation mark
System.out.println("Ends with '!': " + sampleText.trim().endsWith("!"));
// 9. Convert the entire string to uppercase
System.out.println("Uppercase: " + sampleText.toUpperCase());
// 10. Convert the entire string to lowercase
System.out.println("Lowercase: " + sampleText.toLowerCase());
// TODO: Create a method that counts vowels using charAt()
System.out.println("Number of vowels: " + countVowels(sampleText));
// TODO: Create a method that finds all occurrences of a character
findAllOccurrences(sampleText, 'a');
// TODO: Display all results in a formatted manner

}
}