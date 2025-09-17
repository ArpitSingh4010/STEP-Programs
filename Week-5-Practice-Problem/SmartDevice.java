import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class SmartDevice {

    // Read-only properties
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    // Write-only properties (stored as hash)
    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    // Read-write properties
    private String deviceName;
    private boolean enabled;

    // Internal state
    private final LocalDateTime startupTime;

    // Constructor
    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now().minusYears(1); // assume 1 yr old
        this.serialNumber = "SN-" + UUID.randomUUID().toString().substring(0, 8);
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.enabled = true;
    }

    // --- Read-only getters ---
    public String getDeviceId() { return deviceId; }
    public LocalDateTime getManufacturingDate() { return manufacturingDate; }
    public String getSerialNumber() { return serialNumber; }
    public long getUptime() { return ChronoUnit.SECONDS.between(startupTime, LocalDateTime.now()); }
    public int getDeviceAge() { return LocalDateTime.now().getYear() - manufacturingDate.getYear(); }

    // --- Write-only setters ---
    public void setEncryptionKey(String key) {
        if (key != null && key.length() >= 8) hashedEncryptionKey = key.hashCode();
        else System.out.println("Weak encryption key!");
    }
    public void setAdminPassword(String password) {
        if (password != null && password.length() >= 6) hashedAdminPassword = password.hashCode();
        else System.out.println("Weak password!");
    }
    public boolean validateEncryptionKey(String key) { return key.hashCode() == hashedEncryptionKey; }
    public boolean validateAdminPassword(String password) { return password.hashCode() == hashedAdminPassword; }

    // --- Read-write properties ---
    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String name) { this.deviceName = name; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    // Utility
    public void resetDevice() {
        hashedEncryptionKey = 0;
        hashedAdminPassword = 0;
        System.out.println("Device reset complete!");
    }

    public static void main(String[] args) {
        SmartDevice dev = new SmartDevice("Router");

        // Read-only
        System.out.println("Device ID: " + dev.getDeviceId());
        System.out.println("Serial: " + dev.getSerialNumber());
        System.out.println("Age: " + dev.getDeviceAge() + " years");

        // Write-only
        dev.setEncryptionKey("superSecureKey");
        dev.setAdminPassword("admin123");
        System.out.println("Encryption valid? " + dev.validateEncryptionKey("superSecureKey"));
        System.out.println("Password valid? " + dev.validateAdminPassword("admin123"));

        // Read-write
        System.out.println("Device Name: " + dev.getDeviceName());
        dev.setDeviceName("Smart Router");
        System.out.println("Updated Name: " + dev.getDeviceName());

        // Reset
        dev.resetDevice();
    }
}
