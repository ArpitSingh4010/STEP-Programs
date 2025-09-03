import java.util.Scanner;

public class Q6{

    static String[][] extractFileInfo(String[] files) {
        String[][] info = new String[files.length][2];
        for (int i = 0; i < files.length; i++) {
            String f = files[i];
            int dot = f.lastIndexOf('.');
            if (dot != -1) {
                info[i][0] = f.substring(0, dot); // name
                info[i][1] = f.substring(dot + 1); // extension
            } else {
                info[i][0] = f;
                info[i][1] = "";
            }
        }
        return info;
    }

    static String categorize(String ext) {
        if (ext.equalsIgnoreCase("txt") || ext.equalsIgnoreCase("doc"))
            return "Document";
        else if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png"))
            return "Image";
        else if (ext.equalsIgnoreCase("mp3"))
            return "Audio";
        else if (ext.equalsIgnoreCase("mp4"))
            return "Video";
        else
            return "Unknown";
    }

    static String generateNewName(String name, String ext, String category, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(category);
        sb.append("_");
        sb.append("2025");
        sb.append("_");
        sb.append(index);
        if (!ext.equals("")) {
            sb.append(".");
            sb.append(ext);
        }
        return sb.toString();
    }

    static void displayReport(String[] files, String[][] info, String[] categories, String[] newNames) {
        System.out.println("\nFile Organization Report:");
        System.out.println("Original Name\tCategory\tNew Name");
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i] + "\t" + categories[i] + "\t" + newNames[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of files:");
        int n = Integer.parseInt(sc.nextLine());
        String[] files = new String[n];

        System.out.println("Enter file names:");
        for (int i = 0; i < n; i++) {
            files[i] = sc.nextLine();
        }

        String[][] info = extractFileInfo(files);
        String[] categories = new String[n];
        String[] newNames = new String[n];

        for (int i = 0; i < n; i++) {
            categories[i] = categorize(info[i][1]);
            newNames[i] = generateNewName(info[i][0], info[i][1], categories[i], i + 1);
        }

        displayReport(files, info, categories, newNames);

        sc.close();
    }
}
