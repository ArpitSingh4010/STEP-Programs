class Vehicle {
private String registrationNo;
private String type;
private double ratePerDay;
// TODO: Create constructor initializing all fields
public Vehicle(String registrationNo, String type, double ratePerDay) {
	this.registrationNo = registrationNo;
	this.type = type;
	this.ratePerDay = ratePerDay;
}

// TODO: Override toString() to print: "Vehicle:[registrationNo], Type: [type], Rate: $[ratePerDay]/day"
@Override
public String toString() {
	return "Vehicle:" + registrationNo + ", Type: " + type + ", Rate: $" + ratePerDay + "/day";
}

// TODO: Create getters for all fields
public String getRegistrationNo() {
	return registrationNo;
}

public String getType() {
	return type;
}

public double getRatePerDay() {
	return ratePerDay;
}

}
public class VehicleRental {
public static void main(String[] args) {
// 1. Create Vehicle("MH12AB1234", "Sedan", 1500)
Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);

// 2. Print the Vehicle object and observe output
System.out.println(v1);

// 3. Create another vehicle and compare
Vehicle v2 = new Vehicle("MH12AB5678", "SUV", 1800);
System.out.println(v2);

// Compare based on registration number to check if they represent the same vehicle
if (v1.getRegistrationNo().equals(v2.getRegistrationNo())) {
	System.out.println("Both references represent the same vehicle (same registration number).");
} else {
	System.out.println("Different vehicles (registration numbers differ).");
}
}
}