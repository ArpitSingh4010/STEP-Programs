import java.util.Scanner;

public class Q4{

    // Encrypt method
    public static String encrypt(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') { // Uppercase
                ch = (char) ((ch - 'A' + shift) % 26 + 'A');
            } else if (ch >= 'a' && ch <= 'z') { // Lowercase
                ch = (char) ((ch - 'a' + shift) % 26 + 'a');
            }
            // Non-alphabetic remains unchanged
            result += ch;
        }
        return result;
    }

    // Decrypt method
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // reverse shift
    }

    // Display ASCII values
    public static void displayAscii(String label, String text) {
        System.out.println(label + ": " + text);
        System.out.print("ASCII: ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print((int) text.charAt(i) + " ");
        }
        System.out.println();
    }

    // Validate decryption
    public static boolean validate(String original, String decrypted) {
        return original.equals(decrypted);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String text = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\n--- Caesar Cipher Result ---");
        displayAscii("Original Text", text);
        displayAscii("Encrypted Text", encrypted);
        displayAscii("Decrypted Text", decrypted);

        System.out.println("\nValidation: " + (validate(text, decrypted) ? "Successful ✅" : "Failed ❌"));

        sc.close();
    }
}
