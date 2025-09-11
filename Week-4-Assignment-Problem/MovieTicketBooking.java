class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;

    // Default constructor
    public MovieTicket() {
        this("Unknown", "Not Assigned", -1, 0.0);
    }

    // Constructor with movie name only
    public MovieTicket(String movieName) {
        this(movieName, "Not Assigned", -1, 200.0);
    }

    // Constructor with movie name and seat number
    public MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200.0);
    }

    // Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to print ticket details
    public void printTicket() {
        System.out.println(" Movie Ticket Details:");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("-------------------------");
    }
}

// Main class
public class MovieTicketBooking {
    public static void main(String[] args) {
        // Creating different tickets using constructor overloading
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Interstellar", 12);
        MovieTicket t4 = new MovieTicket("Avatar 2", "IMAX", 45, 500.0);

        // Print tickets
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
