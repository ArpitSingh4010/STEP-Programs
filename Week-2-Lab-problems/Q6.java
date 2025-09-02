import java.util.Scanner;

public class Q6 {

    // Split text into words manually using charAt() + substring()
    public static String[] getWords(String text) {
        int count = 0;
        // count words
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
        }
        String[] words = new String[count + 1];

        int start = 0, index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start < i) {
                    words[index++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words[index] = text.substring(start);
        }
        return words;
    }

    // Justify text using StringBuilder
    public static String[] justifyText(String[] words, int width) {
        String[] lines = new String[100]; // assume max 100 lines
        int lineCount = 0;

        int start = 0;
        int lineLen = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) break;
            String word = words[i];
            if (lineLen + word.length() + (i - start) <= width) {
                lineLen += word.length();
            } else {
                int spaces = width - lineLen;
                int gaps = i - start - 1;

                StringBuilder sb = new StringBuilder();
                if (gaps == 0) { // only one word in line
                    sb.append(words[start]);
                    for (int s = 0; s < spaces; s++) sb.append(" ");
                } else {
                    int even = spaces / gaps;
                    int extra = spaces % gaps;
                    for (int j = start; j < i - 1; j++) {
                        sb.append(words[j]);
                        for (int s = 0; s <= even; s++) sb.append(" ");
                        if (extra > 0) {
                            sb.append(" ");
                            extra--;
                        }
                    }
                    sb.append(words[i - 1]);
                }
                lines[lineCount++] = sb.toString();
                start = i;
                lineLen = word.length();
            }
        }

        // last line (left aligned)
        StringBuilder sb = new StringBuilder();
        for (int j = start; j < words.length; j++) {
            if (words[j] == null) break;
            if (j > start) sb.append(" ");
            sb.append(words[j]);
        }
        while (sb.length() < width) sb.append(" ");
        lines[lineCount++] = sb.toString();

        // shrink to exact size
        String[] result = new String[lineCount];
        for (int i = 0; i < lineCount; i++) result[i] = lines[i];
        return result;
    }

    // Center align text
    public static String[] centerAlign(String[] lines, int width) {
        String[] centered = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            int spaces = width - line.length();
            int left = spaces / 2;
            int right = spaces - left;
            StringBuilder sb = new StringBuilder();
            for (int s = 0; s < left; s++) sb.append(" ");
            sb.append(line);
            for (int s = 0; s < right; s++) sb.append(" ");
            centered[i] = sb.toString();
        }
        return centered;
    }

    // Performance comparison
    public static void performanceTest(String[] words, int width) {
        long start, end;

        start = System.nanoTime();
        String[] sbLines = justifyText(words, width);
        end = System.nanoTime();
        long sbTime = end - start;

        start = System.nanoTime();
        String text = "";
        int lineLen = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) break;
            if (lineLen + words[i].length() + 1 > width) {
                text = text + "\n";
                lineLen = 0;
            }
            text = text + words[i] + " ";
            lineLen += words[i].length() + 1;
        }
        end = System.nanoTime();
        long sTime = end - start;

        System.out.println("\n--- Performance Analysis ---");
        System.out.println("StringBuilder Time (ns): " + sbTime);
        System.out.println("String Concatenation Time (ns): " + sTime);
    }

    // Display lines with line number + character count
    public static void display(String label, String[] lines) {
        System.out.println("\n" + label + ":");
        for (int i = 0; i < lines.length; i++) {
            System.out.println((i + 1) + ": " + lines[i] + " (" + lines[i].length() + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter desired line width: ");
        int width = sc.nextInt();

        String[] words = getWords(text);
        String[] justified = justifyText(words, width);
        String[] centered = centerAlign(justified, width);

        System.out.println("\nOriginal Text:\n" + text);

        display("Left-Justified Text", justified);
        display("Center-Aligned Text", centered);

        performanceTest(words, width);

        sc.close();
    }
}
