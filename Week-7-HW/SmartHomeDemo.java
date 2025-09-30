class SmartDevice {
    String deviceName;

    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    void deviceInfo() {
        System.out.println("Smart Device: " + deviceName);
    }
}

class SmartTV extends SmartDevice {
    int channel;
    int volume;

    SmartTV(String deviceName, int channel, int volume) {
        super(deviceName);
        this.channel = channel;
        this.volume = volume;
    }

    void controlTV() {
        System.out.println("TV " + deviceName + " set to channel " + channel + " at volume " + volume);
    }
}

class SmartThermostat extends SmartDevice {
    int temperature;
    int humidity;

    SmartThermostat(String deviceName, int temperature, int humidity) {
        super(deviceName);
        this.temperature = temperature;
        this.humidity = humidity;
    }

    void controlThermostat() {
        System.out.println("Thermostat " + deviceName + " set to " + temperature + "°C and " + humidity + "% humidity");
    }
}

class SmartSecurity extends SmartDevice {
    boolean alarmOn;

    SmartSecurity(String deviceName, boolean alarmOn) {
        super(deviceName);
        this.alarmOn = alarmOn;
    }

    void controlSecurity() {
        System.out.println("Security System " + deviceName + " alarm is " + (alarmOn ? "ON" : "OFF"));
    }
}

class SmartKitchen extends SmartDevice {
    String recipe;
    int cookingTime;

    SmartKitchen(String deviceName, String recipe, int cookingTime) {
        super(deviceName);
        this.recipe = recipe;
        this.cookingTime = cookingTime;
    }

    void controlKitchen() {
        System.out.println("Kitchen Appliance " + deviceName + " cooking " + recipe + " for " + cookingTime + " minutes");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice[] devices = new SmartDevice[4];

        devices[0] = new SmartTV("Living Room TV", 5, 20);
        devices[1] = new SmartThermostat("Bedroom Thermostat", 24, 40);
        devices[2] = new SmartSecurity("Main Gate Security", true);
        devices[3] = new SmartKitchen("Smart Oven", "Pizza", 15);

        for (SmartDevice device : devices) {
            device.deviceInfo();

            if (device instanceof SmartTV) {
                ((SmartTV) device).controlTV();
            } else if (device instanceof SmartThermostat) {
                ((SmartThermostat) device).controlThermostat();
            } else if (device instanceof SmartSecurity) {
                ((SmartSecurity) device).controlSecurity();
            } else if (device instanceof SmartKitchen) {
                ((SmartKitchen) device).controlKitchen();
            }

            System.out.println();
        }
    }
}
