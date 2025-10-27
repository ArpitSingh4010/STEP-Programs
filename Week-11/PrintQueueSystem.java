import java.util.*;

public class PrintQueueSystem{
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();

            // Handle ADD command
            if (cmd.equalsIgnoreCase("ADD")) {
                String document = sc.next();
                printQueue.add(document);
                System.out.println("Added " + document + " to the print queue.");
            }
            else if (cmd.equalsIgnoreCase("PRINT")) {
                if (!printQueue.isEmpty()) {
                    String job = printQueue.poll();
                    System.out.println("Printing " + job);
                } else {
                    System.out.println("No jobs left!");
                }
            }
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting print system...");
                break;
            }
            else {
                System.out.println("Invalid command! Try again.");
            }
        }
        sc.close();
    }
}
