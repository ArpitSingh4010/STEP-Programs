import java.util.Scanner;

public class Q2 {

    // analyze password
    public static int[] analyzePassword(String password) {
        int upper = 0, lower = 0, digits = 0, special = 0;
        for (int i = 0; i < password.length(); i++) {
            int ascii = (int) password.charAt(i);
            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digits++;
            else if (ascii >= 33 && ascii <= 126) special++;
        }
        return new int[]{upper, lower, digits, special};
    }

    // calculate score
    public static int calculateScore(String password, int[] counts) {
        int length = password.length();
        int score = 0;
        if (length > 8) score += (length - 8) * 2;
        if (counts[0] > 0) score += 10;
        if (counts[1] > 0) score += 10;
        if (counts[2] > 0) score += 10;
        if (counts[3] > 0) score += 10;
        String lowerPass = password.toLowerCase();
        if (lowerPass.contains("123") || lowerPass.contains("abc") || lowerPass.contains("qwerty")) score -= 10;
        return score;
    }

    // strength level
    public static String strengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    // generate password
    public static String generatePassword(int length) {
        if (length < 4) length = 4;
        StringBuilder sb = new StringBuilder();
        sb.append((char) (65 + (int) (Math.random() * 26)));
        sb.append((char) (97 + (int) (Math.random() * 26)));
        sb.append((char) (48 + (int) (Math.random() * 10)));
        sb.append((char) (33 + (int) (Math.random() * 15)));
        for (int i = 4; i < length; i++) sb.append((char) (33 + (int) (Math.random() * 94)));
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = (int) (Math.random() * chars.length);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    // display results
    public static void displayResults(String[] passwords) {
        System.out.println("\nPassword\tLength\tUpper\tLower\tDigits\tSpecial\tScore\tStrength");
        for (String pass : passwords) {
            int[] counts = analyzePassword(pass);
            int score = calculateScore(pass, counts);
            String level = strengthLevel(score);
            System.out.println(pass + "\t" + pass.length() + "\t" +
                    counts[0] + "\t" + counts[1] + "\t" + counts[2] + "\t" + counts[3] +
                    "\t" + score + "\t" + level);
        }
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of passwords to analyze: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords[i] = sc.nextLine();
        }
        displayResults(passwords);
        System.out.print("\nEnter desired length for new strong password: ");
        int length = sc.nextInt();
        String newPass = generatePassword(length);
        System.out.println("Generated Strong Password: " + newPass);
        sc.close();
    }
}
