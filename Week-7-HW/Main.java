class HotelBooking {
    private double getRoomRate(String roomType) {
        switch (roomType.toLowerCase()) {
            case "deluxe": return 2000;
            case "suite": return 3500;
            case "standard": return 1200;
            default: return 1000;
        }
    }
    public void calculatePrice(String roomType, int nights) {
        double baseRate = getRoomRate(roomType);
        double total = baseRate * nights;
        System.out.println("Standard Booking:");
        System.out.println("Room Type: " + roomType + ", Nights: " + nights);
        System.out.println("Base Price: " + baseRate + " x " + nights + " = " + total);
        System.out.println("Total: " + total + "\n");
    }
    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double baseRate = getRoomRate(roomType);
        double subtotal = baseRate * nights;
        double total = subtotal * seasonalMultiplier;
        System.out.println("Seasonal Booking:");
        System.out.println("Room Type: " + roomType + ", Nights: " + nights);
        System.out.println("Base Price: " + subtotal);
        System.out.println("Seasonal Multiplier: x" + seasonalMultiplier);
        System.out.println("Total: " + total + "\n");
    }
    public void calculatePrice(String roomType, int nights, double discount, boolean mealPackage) {
        double baseRate = getRoomRate(roomType);
        double subtotal = baseRate * nights;
        double discountAmount = subtotal * discount;
        double total = subtotal - discountAmount;
        
        System.out.println("Corporate Booking:");
        System.out.println("Room Type: " + roomType + ", Nights: " + nights);
        System.out.println("Base Price: " + subtotal);
        System.out.println("Discount (" + (discount * 100) + "%): -" + discountAmount);
        
        if (mealPackage) {
            total += 500 * nights; 
            System.out.println("Meal Package: +" + (500 * nights));
        }
        
        System.out.println("Total: " + total + "\n");
    }
    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, double cateringCost) {
        double baseRate = getRoomRate(roomType);
        double roomCost = baseRate * nights;
        double cateringTotal = cateringCost * guestCount;
        double total = roomCost + decorationFee + cateringTotal;
        
        System.out.println("Wedding Booking:");
        System.out.println("Room Type: " + roomType + ", Nights: " + nights);
        System.out.println("Room Cost: " + roomCost);
        System.out.println("Decoration Fee: " + decorationFee);
        System.out.println("Catering (" + guestCount + " guests x " + cateringCost + "): " + cateringTotal);
        System.out.println("Total: " + total + "\n");
    }
}
public class Main {
    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        
        booking.calculatePrice("Deluxe", 3);
        booking.calculatePrice("Suite", 5, 1.2);
        booking.calculatePrice("Standard", 4, 0.15, true);
        booking.calculatePrice("Deluxe", 2, 100, 5000, 800);
    }
}
