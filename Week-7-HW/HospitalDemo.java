class MedicalStaff {
    String name;
    int staffId;

    MedicalStaff(String name, int staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    void scheduleShift() {
        System.out.println(name + " (ID: " + staffId + ") shift scheduled.");
    }

    void accessIDCard() {
        System.out.println(name + " accessed hospital facilities with ID card.");
    }

    void processPayroll() {
        System.out.println("Payroll processed for " + name + ".");
    }
}

class Doctor extends MedicalStaff {
    Doctor(String name, int staffId) {
        super(name, staffId);
    }

    void diagnose() {
        System.out.println(name + " is diagnosing a patient.");
    }

    void prescribeMedicine() {
        System.out.println(name + " prescribed medicine.");
    }

    void performSurgery() {
        System.out.println(name + " performed a surgery.");
    }
}

class Nurse extends MedicalStaff {
    Nurse(String name, int staffId) {
        super(name, staffId);
    }

    void administerMedicine() {
        System.out.println(name + " administered medicine.");
    }

    void monitorPatients() {
        System.out.println(name + " is monitoring patients.");
    }

    void assistProcedure() {
        System.out.println(name + " assisted in a medical procedure.");
    }
}

class Technician extends MedicalStaff {
    Technician(String name, int staffId) {
        super(name, staffId);
    }

    void operateEquipment() {
        System.out.println(name + " operated medical equipment.");
    }

    void runTests() {
        System.out.println(name + " ran diagnostic tests.");
    }

    void maintainInstruments() {
        System.out.println(name + " maintained instruments.");
    }
}

class Administrator extends MedicalStaff {
    Administrator(String name, int staffId) {
        super(name, staffId);
    }

    void scheduleAppointments() {
        System.out.println(name + " scheduled patient appointments.");
    }

    void manageRecords() {
        System.out.println(name + " managed hospital records.");
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        MedicalStaff staff1 = new Doctor("Dr. Shresth", 101);         
        MedicalStaff staff2 = new Nurse("Nurse Ramya", 202);
        MedicalStaff staff3 = new Technician("Tech Yatindra", 303);
        MedicalStaff staff4 = new Administrator("Admin Arpit", 404);
        staff1.scheduleShift();
        staff2.accessIDCard();
        staff3.processPayroll();
        staff4.scheduleShift();
        System.out.println();
        ((Doctor) staff1).diagnose();
        ((Doctor) staff1).performSurgery();
        ((Nurse) staff2).monitorPatients();
        ((Technician) staff3).runTests();
        ((Administrator) staff4).manageRecords();
    }
}
