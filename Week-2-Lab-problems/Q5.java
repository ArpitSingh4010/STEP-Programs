import java.util.*;

public class Q5{

    // Validate email format
    public static boolean isValid(String email) {
        int atPos = email.indexOf('@');
        int lastAtPos = email.lastIndexOf('@');
        if (atPos == -1 || atPos != lastAtPos) return false; // must have exactly one '@'

        int dotPos = email.indexOf('.', atPos);
        if (dotPos == -1) return false; // must have '.' after '@'

        String username = email.substring(0, atPos);
        String domain = email.substring(atPos + 1);

        if (username.length() == 0 || domain.length() == 0) return false;

        return true;
    }

    // Extract components
    public static String[] extractParts(String email) {
        int atPos = email.indexOf('@');
        String username = email.substring(0, atPos);
        String domain = email.substring(atPos + 1);

        int dotPos = domain.lastIndexOf('.');
        String domainName = "";
        String extension = "";

        if (dotPos != -1) {
            domainName = domain.substring(0, dotPos);
            extension = domain.substring(dotPos + 1);
        }

        return new String[]{username, domain, domainName, extension};
    }

    // Analyze statistics
    public static void analyzeStats(List<String> emails) {
        int validCount = 0, invalidCount = 0;
        int totalUsernameLength = 0;
        Map<String, Integer> domainCount = new HashMap<>();

        for (String email : emails) {
            if (isValid(email)) {
                validCount++;
                String[] parts = extractParts(email);
                totalUsernameLength += parts[0].length();
                domainCount.put(parts[1], domainCount.getOrDefault(parts[1], 0) + 1);
            } else {
                invalidCount++;
            }
        }

        String mostCommonDomain = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonDomain = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        double avgUsernameLength = (validCount > 0) ? (double) totalUsernameLength / validCount : 0;

        System.out.println("\n--- Email Statistics ---");
        System.out.println("Total Valid Emails   : " + validCount);
        System.out.println("Total Invalid Emails : " + invalidCount);
        System.out.println("Most Common Domain   : " + (mostCommonDomain.equals("") ? "N/A" : mostCommonDomain));
        System.out.println("Average Username Length: " + avgUsernameLength);
    }

    // Display results in tabular format
    public static void displayResults(List<String> emails) {
        System.out.println("\nEmail Analysis Results:");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Email                      Username      Domain         DomainName     Extension   Valid?");
        System.out.println("---------------------------------------------------------------");

        for (String email : emails) {
            if (isValid(email)) {
                String[] parts = extractParts(email);
                System.out.printf("%-25s %-12s %-14s %-13s %-10s %-5s\n",
                        email, parts[0], parts[1], parts[2], parts[3], "Yes");
            } else {
                System.out.printf("%-25s %-12s %-14s %-13s %-10s %-5s\n",
                        email, "-", "-", "-", "-", "No");
            }
        }
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();

        System.out.println("Enter email addresses (type 'done' to finish): ");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("done")) break;
            emails.add(email);
        }

        displayResults(emails);
        analyzeStats(emails);

        sc.close();
    }
}
