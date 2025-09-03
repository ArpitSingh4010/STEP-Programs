import java.util.Scanner;

public class Q3{

    // count character frequencies
    public static Object[] countFrequency(String text) {
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int unique = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int found = -1;
            for (int j = 0; j < unique; j++) {
                if (chars[j] == c) {
                    found = j;
                    break;
                }
            }
            if (found == -1) {
                chars[unique] = c;
                freq[unique] = 1;
                unique++;
            } else {
                freq[found]++;
            }
        }

        char[] finalChars = new char[unique];
        int[] finalFreq = new int[unique];
        for (int i = 0; i < unique; i++) {
            finalChars[i] = chars[i];
            finalFreq[i] = freq[i];
        }
        return new Object[]{finalChars, finalFreq};
    }

    // create compression codes
    public static String[][] createCodes(char[] chars, int[] freq) {
        int n = chars.length;
        String[][] mapping = new String[n][2];

        // Assign codes based on frequency (shorter for higher freq)
        for (int i = 0; i < n; i++) {
            mapping[i][0] = String.valueOf(chars[i]);
            StringBuilder code = new StringBuilder();
            for (int j = 0; j < (n - i); j++) {
                code.append((char) ('0' + (i % 10)));
            }
            mapping[i][1] = code.toString();
        }
        return mapping;
    }

    // compress text
    public static String compressText(String text, String[][] mapping) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < mapping.length; j++) {
                if (mapping[j][0].charAt(0) == c) {
                    sb.append(mapping[j][1]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    // decompress text
    public static String decompressText(String compressed, String[][] mapping) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < compressed.length()) {
            boolean matched = false;
            for (int j = 0; j < mapping.length; j++) {
                String code = mapping[j][1];
                if (compressed.startsWith(code, i)) {
                    sb.append(mapping[j][0]);
                    i += code.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                i++;
            }
        }
        return sb.toString();
    }

    // display analysis
    public static void displayAnalysis(String text, char[] chars, int[] freq,
                                       String[][] mapping, String compressed, String decompressed) {
        System.out.println("\nCharacter Frequency Table:");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " : " + freq[i]);
        }

        System.out.println("\nCompression Mapping:");
        for (int i = 0; i < mapping.length; i++) {
            System.out.println(mapping[i][0] + " -> " + mapping[i][1]);
        }

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);

        double ratio = ((double) compressed.length() / text.length()) * 100;
        System.out.println("Compression Efficiency: " + (100 - ratio) + "%");
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to compress: ");
        String text = sc.nextLine();

        Object[] freqData = countFrequency(text);
        char[] chars = (char[]) freqData[0];
        int[] freq = (int[]) freqData[1];

        String[][] mapping = createCodes(chars, freq);
        String compressed = compressText(text, mapping);
        String decompressed = decompressText(compressed, mapping);

        displayAnalysis(text, chars, freq, mapping, compressed, decompressed);
    }
}
