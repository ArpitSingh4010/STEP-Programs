import java.util.Scanner;
public class Q3{
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// TODO: Ask user to enter a string
System.out.println("Enter a string:");
String input = scanner.nextLine();
// TODO: For each character in the string:
for (char character : input.toCharArray()) {

// 1. Display the character and its ASCII code
System.out.println("Character: " + character + ", ASCII: " + (int) character);
// 2. Determine if it's uppercase, lowercase, digit, or special
String charType = classifyCharacter(character);

// 3. If letter, show both upper and lower case versions with ASCII
if (Character.isLetter(character)) {
    char toggledCase = toggleCase(character);
    System.out.println("Toggled case: " + toggledCase + ", ASCII: " + (int) toggledCase);
}

// 4. Calculate the difference between upper and lower case ASCII
if (Character.isLetter(character)) {
    int difference = (int) character - (int) Character.toLowerCase(character);
    System.out.println("ASCII difference: " + difference);
}

// TODO: Create ASCII art using character codes
System.out.println("ASCII art for '" + character + "':");
for (int i = 0; i < (int) character; i++) {
    System.out.print("*");
}
// TODO: Implement a simple Caesar cipher using ASCII manipulation
System.out.println("\nCaesar cipher (shift 3): " + caesarCipher(input, 3));

scanner.close();
}
}



// TODO: Method to classify character type
public static String classifyCharacter(char ch) {
// Return "Uppercase Letter", "Lowercase Letter", "Digit", or "Special Character"
if (Character.isUpperCase(ch)) {
    return "Uppercase Letter";
} else if (Character.isLowerCase(ch)) {
    return "Lowercase Letter";
} else if (Character.isDigit(ch)) {
    return "Digit";
} else {
    return "Special Character";
}
// Your code here
}
// TODO: Method to convert case using ASCII manipulation
public static char toggleCase(char ch) {
// Convert upper to lower and lower to upper using ASCII values
if (Character.isUpperCase(ch)) {
    return (char) (ch + 32); // Convert to lowercase
} else if (Character.isLowerCase(ch)) {
    return (char) (ch - 32); // Convert to uppercase
}
return ch; // Return unchanged for non-letter characters
// Your code here
}
// TODO: Method to implement Caesar cipher
public static String caesarCipher(String text, int shift) {

// Shift each letter by 'shift' positions in ASCII
StringBuilder cipheredText = new StringBuilder();
for (char ch : text.toCharArray()) {
    if (Character.isLetter(ch)) {
        char base = Character.isUpperCase(ch) ? 'A' : 'a';
        char shiftedChar = (char) ((ch - base + shift) % 26 + base);
        cipheredText.append(shiftedChar);
    } else {
        cipheredText.append(ch); // Non-letter characters remain unchanged
    }
}
return cipheredText.toString();
// Your code here
}
// TODO: Method to create ASCII table for a range
public static void displayASCIITable(int start, int end) {
// Display ASCII codes and corresponding characters
System.out.println("ASCII Table from " + start + " to " + end + ":");
for (int i = start; i <= end; i++) {
    System.out.println("ASCII: " + i + ", Character: " + (char) i);
}
// Your code here
}
// TODO: Method to convert string to ASCII array
public static int[] stringToASCII(String text) {
// Convert each character to its ASCII value and store in an array
int[] asciiValues = new int[text.length()];
for (int i = 0; i < text.length(); i++) {
    asciiValues[i] = (int) text.charAt(i);
}
return asciiValues;
// Your code here
}
// TODO: Method to convert ASCII array back to string
public static String asciiToString(int[] asciiValues) {
// Convert each ASCII value back to its character
StringBuilder text = new StringBuilder();
for (int value : asciiValues) {
    text.append((char) value);
}
return text.toString();
// Your code here
}
}