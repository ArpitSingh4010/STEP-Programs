// Patient.java
class Patient {
    String patientId;
    String patientName;
    int age;
    String gender;
    String contactInfo;
    String[] medicalHistory;
    String[] currentTreatments;

    public Patient(String patientId, String patientName, int age, String gender, String contactInfo, String[] medicalHistory) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = medicalHistory;
        this.currentTreatments = new String[5]; // fixed size for simplicity
        Hospital.totalPatients++;
    }

    public void updateTreatment(String treatment) {
        for (int i = 0; i < currentTreatments.length; i++) {
            if (currentTreatments[i] == null) {
                currentTreatments[i] = treatment;
                break;
            }
        }
        System.out.println("Treatment updated for patient " + patientName);
    }

    public void dischargePatient() {
        currentTreatments = new String[5]; // clear treatments
        System.out.println("Patient " + patientName + " discharged.");
    }
}

// Doctor.java
class Doctor {
    String doctorId;
    String doctorName;
    String specialization;
    String[] availableSlots;
    int patientsHandled;
    double consultationFee;

    public Doctor(String doctorId, String doctorName, String specialization, String[] availableSlots, double consultationFee) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.availableSlots = availableSlots;
        this.consultationFee = consultationFee;
        this.patientsHandled = 0;
    }
}

// Appointment.java
class Appointment {
    String appointmentId;
    Patient patient;
    Doctor doctor;
    String appointmentDate;
    String appointmentTime;
    String status;
    String type; // Consultation, Follow-up, Emergency

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String appointmentDate, String appointmentTime, String type) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.type = type;
        this.status = "Scheduled";
        doctor.patientsHandled++;
        Hospital.totalAppointments++;
    }

    public void cancelAppointment() {
        this.status = "Cancelled";
        System.out.println("Appointment " + appointmentId + " cancelled.");
    }

    public void generateBill() {
        double billAmount = doctor.consultationFee;
        if (type.equals("Follow-up")) {
            billAmount *= 0.5;
        } else if (type.equals("Emergency")) {
            billAmount *= 2;
        }
        Hospital.totalRevenue += billAmount;
        System.out.println("Bill for appointment " + appointmentId + ": " + billAmount);
    }
}

// Hospital.java
class Hospital {
    // Static variables
    static int totalPatients = 0;
    static int totalAppointments = 0;
    static String hospitalName = "CityCare Hospital";
    static double totalRevenue = 0.0;

    // Static methods
    public static void generateHospitalReport() {
        System.out.println("----- " + hospitalName + " Report -----");
        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Total Revenue: " + totalRevenue);
    }

    public static void getDoctorUtilization(Doctor[] doctors) {
        System.out.println("----- Doctor Utilization -----");
        for (Doctor d : doctors) {
            System.out.println(d.doctorName + " handled " + d.patientsHandled + " patients.");
        }
    }

    public static void getPatientStatistics(Patient[] patients) {
        System.out.println("----- Patient Statistics -----");
        for (Patient p : patients) {
            System.out.println(p.patientName + " | Age: " + p.age + " | Gender: " + p.gender);
        }
    }
}

// Main.java
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create Patients
        Patient p1 = new Patient("P1", "Arjun", 30, "Male", "9876543210", new String[]{"Diabetes"});
        Patient p2 = new Patient("P2", "Meera", 25, "Female", "9123456780", new String[]{"Asthma"});

        // Create Doctors
        Doctor d1 = new Doctor("D1", "Dr. Sharma", "Cardiology", new String[]{"10AM", "2PM"}, 500);
        Doctor d2 = new Doctor("D2", "Dr. Gupta", "Dermatology", new String[]{"11AM", "4PM"}, 300);

        // Schedule Appointments
        Appointment a1 = new Appointment("A1", p1, d1, "2025-09-05", "10AM", "Consultation");
        Appointment a2 = new Appointment("A2", p2, d2, "2025-09-06", "4PM", "Emergency");

        // Update Treatment
        p1.updateTreatment("Blood Test");
        p2.updateTreatment("Skin Therapy");

        // Billing
        a1.generateBill();
        a2.generateBill();

        // Discharge
        p1.dischargePatient();

        // Reports
        Hospital.generateHospitalReport();
        Hospital.getDoctorUtilization(new Doctor[]{d1, d2});
        Hospital.getPatientStatistics(new Patient[]{p1, p2});
    }
}
