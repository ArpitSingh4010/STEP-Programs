import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and Status
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // Convert cm to meters
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method to compute BMI table
    public static String[][] computeTable(double[][] hwData) {
        String[][] result = new String[hwData.length][4]; // Height, Weight, BMI, Status

        for (int i = 0; i < hwData.length; i++) {
            double weight = hwData[i][0];
            double height = hwData[i][1];

            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.format("%.2f", height);
            result[i][1] = String.format("%.2f", weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }
        return result;
    }

    // Method to display data in tabular format
    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (String[] row : table) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwData = new double[10][2]; // 10 rows, 2 columns (Weight, Height)

        // Taking input
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            hwData[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            hwData[i][1] = sc.nextDouble();
        }

        // Processing
        String[][] table = computeTable(hwData);

        // Displaying
        displayTable(table);
        
        sc.close();
    }
}
