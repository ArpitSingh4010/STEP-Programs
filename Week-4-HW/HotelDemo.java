// Room.java
 class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true; // initially available
        this.maxOccupancy = maxOccupancy;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}
// Guest.java
 class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory;

    public Guest(String guestId, String guestName, String phoneNumber, String email, int historySize) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[historySize];
    }

    public void addBookingHistory(String bookingId) {
        for (int i = 0; i < bookingHistory.length; i++) {
            if (bookingHistory[i] == null) {
                bookingHistory[i] = bookingId;
                break;
            }
        }
    }

    public String getGuestName() { return guestName; }
}
// Booking.java
 class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    private static int totalBookings = 0;
    private static double hotelRevenue = 0.0;
    private static String hotelName = "OOP Grand Hotel";

    public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateBill();

        totalBookings++;
        hotelRevenue += this.totalAmount;
        guest.addBookingHistory(bookingId);
        room.setAvailable(false);
    }

    // Reservation management methods
    public static Booking makeReservation(String bookingId, Guest guest, Room room,
                                          String checkInDate, String checkOutDate) {
        if (room.isAvailable()) {
            return new Booking(bookingId, guest, room, checkInDate, checkOutDate);
        } else {
            System.out.println("Room not available!");
            return null;
        }
    }

    public void cancelReservation() {
        if (!room.isAvailable()) {
            room.setAvailable(true);
            System.out.println("Booking " + bookingId + " cancelled.");
        }
    }

    public static boolean checkAvailability(Room room) {
        return room.isAvailable();
    }

    public double calculateBill() {
        // Simplified: assume 1 night stay
        return room.getPricePerNight();
    }

    // Reporting methods
    public static double getOccupancyRate(Room[] rooms) {
        int occupied = 0;
        for (Room r : rooms) {
            if (!r.isAvailable()) occupied++;
        }
        return (occupied * 100.0) / rooms.length;
    }

    public static double getTotalRevenue() {
        return hotelRevenue;
    }

    public static String getMostPopularRoomType(Booking[] bookings) {
        int single = 0, doubleR = 0, suite = 0;
        for (Booking b : bookings) {
            if (b != null) {
                if (b.room.getRoomType().equals("Single")) single++;
                else if (b.room.getRoomType().equals("Double")) doubleR++;
                else if (b.room.getRoomType().equals("Suite")) suite++;
            }
        }
        if (single >= doubleR && single >= suite) return "Single";
        else if (doubleR >= single && doubleR >= suite) return "Double";
        else return "Suite";
    }

    // Display booking summary
    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId + ", Guest: " + guest.getGuestName()
                + ", Room: " + room.getRoomNumber() + ", Total: " + totalAmount);
    }
}
// HotelDemo.java (Main Class)
public class HotelDemo {
    public static void main(String[] args) {
        // Create Rooms
        Room r1 = new Room("101", "Single", 2000, 1);
        Room r2 = new Room("102", "Double", 3500, 2);
        Room r3 = new Room("201", "Suite", 6000, 4);
        Room[] rooms = {r1, r2, r3};

        // Create Guests
        Guest g1 = new Guest("G1", "Arpit Singh", "9999999999", "arpit@email.com", 5);
        Guest g2 = new Guest("G2", "Ravi Kumar", "8888888888", "ravi@email.com", 5);

        // Make Reservations
        Booking b1 = Booking.makeReservation("B1", g1, r1, "2025-09-05", "2025-09-06");
        Booking b2 = Booking.makeReservation("B2", g2, r2, "2025-09-07", "2025-09-08");

        // Display Bookings
        if (b1 != null) b1.displayBooking();
        if (b2 != null) b2.displayBooking();

        // Cancel one reservation
        if (b1 != null) b1.cancelReservation();

        // Reports
        System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
        System.out.println("Total Revenue: " + Booking.getTotalRevenue());
        Booking[] allBookings = {b1, b2};
        System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType(allBookings));
    }
}
