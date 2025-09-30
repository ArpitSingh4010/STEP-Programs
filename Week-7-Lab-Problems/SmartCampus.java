class SmartDevice {
    String id;
    SmartDevice(String id) {
        this.id = id;
    }
    void status() {
        System.out.println("Device " + id + " is active.");
    }
}

class SmartClassroom extends SmartDevice {
    SmartClassroom(String id) {
        super(id);
    }
    void controlClassroom() {
        System.out.println("Classroom " + id + ": Lights, AC, and Projector controlled.");
    }
}

class SmartLab extends SmartDevice {
    SmartLab(String id) {
        super(id);
    }
    void manageLab() {
        System.out.println("Lab " + id + ": Equipment and Safety systems managed.");
    }
}

class SmartLibrary extends SmartDevice {
    SmartLibrary(String id) {
        super(id);
    }
    void monitorLibrary() {
        System.out.println("Library " + id + ": Occupancy and Book availability tracked.");
    }
}

public class SmartCampus{
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("CR101"),
            new SmartLab("LAB202"),
            new SmartLibrary("LIB303")
        };

        for(SmartDevice device : devices) {
            device.status();

            if(device instanceof SmartClassroom) {
                ((SmartClassroom) device).controlClassroom();
            } else if(device instanceof SmartLab) {
                ((SmartLab) device).manageLab();
            } else if(device instanceof SmartLibrary) {
                ((SmartLibrary) device).monitorLibrary();
            }
        }
    }
}
