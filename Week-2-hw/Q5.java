import java.util.Scanner;

public class Q5{
    // Parse CSV data without split()
    public static String[][] parseCSV(String input, int rows, int cols) {
        String[][] data = new String[rows][cols];
        int r = 0, c = 0;
        int start = 0;
        boolean insideQuotes = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '\"') {
                insideQuotes = !insideQuotes;
            } else if ((ch == ',' && !insideQuotes) || ch == '\n') {
                data[r][c] = input.substring(start, i).trim();
                c++;
                start = i + 1;
                if (ch == '\n') {
                    r++;
                    c = 0;
                }
            }
        }
        if (start < input.length() && r < rows && c < cols) {
            data[r][c] = input.substring(start).trim();
        }
        return data;
    }

    // Validate and clean numeric fields
    public static boolean isNumeric(String s) {
        if (s == null || s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(ch >= '0' && ch <= '9')) return false;
        }
        return true;
    }

    // Data Analysis (min, max, avg for numeric columns)
    public static void analyzeData(String[][] data) {
        int rows = data.length;
        int cols = data[0].length;

        for (int c = 0; c < cols; c++) {
            boolean numeric = true;
            for (int r = 1; r < rows; r++) {
                if (!isNumeric(data[r][c])) {
                    numeric = false;
                    break;
                }
            }

            if (numeric) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0, count = 0;
                for (int r = 1; r < rows; r++) {
                    int val = Integer.parseInt(data[r][c]);
                    if (val < min) min = val;
                    if (val > max) max = val;
                    sum += val;
                    count++;
                }
                double avg = (count > 0) ? (sum * 1.0 / count) : 0;
                System.out.println("Column: " + data[0][c] + " | Min: " + min + " | Max: " + max + " | Avg: " + avg);
            }
        }
    }

    // Format table using StringBuilder
    public static void displayTable(String[][] data) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                sb.append(String.format("%-15s", data[r][c]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        System.out.println("Enter CSV data (end with empty line):");

        while (true) {
            String line = sc.nextLine();
            if (line.length() == 0) break;
            input.append(line).append("\n");
        }

        String csvData = input.toString();

        // Assume 4 rows, 3 cols for example
        String[][] parsed = parseCSV(csvData, 4, 3);

        System.out.println("\nFormatted Table:");
        displayTable(parsed);

        System.out.println("\nData Analysis:");
        analyzeData(parsed);
    }
}
