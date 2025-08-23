// package FinalExamPrograms;

class ElectronicDevice {
    private String brandName;
    private boolean powerStatus;
    private String voltageType;
    int volts;
    private String model;

    public ElectronicDevice(String brandName, boolean p, String voltageType, int volts, String model) {
        this.brandName = brandName;
        this.powerStatus = p;
        this.voltageType = voltageType;
        this.volts = volts;
        this.model = model;
    }

    public void turnOn() {
        powerStatus = true;
        System.out.println(brandName + " is now ON.");
    }

    public void turnOff() {
        powerStatus = false;
        System.out.println(brandName + " is now OFF.");
    }

    public boolean isPoweredOn() {
        return powerStatus;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getVoltageType() {
        return voltageType;
    }

    public void setVoltageType(String voltageType) {
        this.voltageType = voltageType;
    }
    public int getVoltage() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

class Computer extends ElectronicDevice { // Corrected: Added 'extends ElectronicDevice'
    private String operatingSystem;

    Computer(String b, boolean p, String vt, int v, String f, String os) {
        super(b, p, vt, v, f); // Corrected: Called superclass constructor
        this.operatingSystem = os;
    }

    public void display() {
        System.out.println("Model: " + super.getModel());
        System.out.println("Brand: " + super.getBrandName());
        System.out.println("Power Status: " + (super.isPoweredOn() ? "ON" : "OFF"));
        System.out.println("Voltage Type: " + super.getVoltageType()); // Added voltage type
        System.out.println("Volts: " + super.getVoltage());          // Added volts
        System.out.println("Operating System: " + operatingSystem);
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}

public class ComputerMain {
    public static void main(String[] args) {
        Computer myComputer = new Computer("Dell", false, "AC", 220, "XPS 15", "Windows 11");
        myComputer.turnOn();
        myComputer.display();
        myComputer.turnOff();
    }
}
