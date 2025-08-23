// package FinalProject;
import java.util.ArrayList;
import java.util.List;

class ElectronicDevice {
    private String brandName;
    private boolean powerStatus;

    public ElectronicDevice(String brandName) {
        this.brandName = brandName;
        this.powerStatus = false;
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
}

class Processor {
    private String model;
    private double speedGHz;

    public Processor(String model, double speedGHz) {
        this.model = model;
        this.speedGHz = speedGHz;
    }

    public String getModel() {
        return model;
    }

    public double getSpeedGHz() {
        return speedGHz;
    }
}

class GPU {
    private String brand;
    private int memoryGB;

    public GPU(String brand, int memoryGB) {
        this.brand = brand;
        this.memoryGB = memoryGB;
    }

    public String getSpecs() {
        return brand + " GPU with " + memoryGB + "GB VRAM";
    }
}

class Battery {
    private int capacitymAh;

    public Battery(int capacitymAh) {
        this.capacitymAh = capacitymAh;
    }

    public int getCapacity() {
        return capacitymAh;
    }

    public String getBatteryStatus() {
        return "Battery Capacity: " + capacitymAh + " mAh";
    }
}

class OperatingSystem {
    private String name;
    private String version;

    public OperatingSystem(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getDetails() {
        return name + " " + version;
    }
}

class Computer extends ElectronicDevice {
    private Processor processor;
    private GPU gpu;
    private int ramGB;
    private int storageGB;
    private OperatingSystem operatingSystem;
    private List<String> installedSoftware;
    private Battery battery;

    public Computer(String brandName, Processor processor, GPU gpu, int ramGB, int storageGB,
                    OperatingSystem os, Battery battery) {
        super(brandName);
        this.processor = processor;
        this.gpu = gpu;
        this.ramGB = ramGB;
        this.storageGB = storageGB;
        this.operatingSystem = os;
        this.battery = battery;
        this.installedSoftware = new ArrayList<>();
    }

    public void upgradeRam(int additionalRam) {
        if (additionalRam > 0) {
            ramGB += additionalRam;
            System.out.println("RAM upgraded to " + ramGB + " GB");
        } else {
            System.out.println("Invalid RAM upgrade amount.");
        }
    }

    public void installSoftware(String softwareName) {
        installedSoftware.add(softwareName);
        System.out.println(softwareName + " installed successfully.");
    }

    public void uninstallSoftware(String softwareName) {
        if (installedSoftware.remove(softwareName)) {
            System.out.println(softwareName + " uninstalled successfully.");
        } else {
            System.out.println(softwareName + " not found.");
        }
    }

    public void formatComputer() {
        installedSoftware.clear();
        System.out.println("System formatted. All software removed.");
    }

    public void changeOperatingSystem(OperatingSystem newOS) {
        this.operatingSystem = newOS;
        System.out.println("OS changed to " + newOS.getDetails());
    }

    public void browseInternet(String url) {
        if (!isPoweredOn()) {
            System.out.println("Computer is OFF. Please turn it ON first.");
            return;
        }
        System.out.println("Opening browser and navigating to " + url + "...");
    }

    public void viewSystemSummary() {
        System.out.println("----- SYSTEM SUMMARY -----");
        System.out.println("Brand: " + getBrandName());
        System.out.println("Processor: " + processor.getModel() + " @ " + processor.getSpeedGHz() + "GHz");
        System.out.println("GPU: " + gpu.getSpecs());
        System.out.println("RAM: " + ramGB + " GB");
        System.out.println("Storage: " + storageGB + " GB");
        System.out.println("OS: " + operatingSystem.getDetails());
        System.out.println(battery.getBatteryStatus());
        System.out.println("Installed Software: " + (installedSoftware.isEmpty() ? "None" : installedSoftware));
        System.out.println("Power: " + (isPoweredOn() ? "ON" : "OFF"));
        System.out.println("--------------------------");
    }
}

abstract class Task extends Thread {
    protected String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public abstract void run();
}

class VirusScanTask extends Task {
    public VirusScanTask() {
        super("Virus Scan");
    }

    public void run() {
        System.out.println(taskName + " started...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted.");
        }
        System.out.println(taskName + " completed successfully.");
    }
}

class BackupTask extends Task {
    public BackupTask() {
        super("File Backup");
    }

    public void run() {
        System.out.println(taskName + " started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted.");
        }
        System.out.println(taskName + " completed.");
    }
}

public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor("Intel Core i7", 3.5);
        GPU gpu = new GPU("NVIDIA", 6);
        OperatingSystem os = new OperatingSystem("Windows", "11 Home");
        Battery battery = new Battery(5000);

        Computer laptop = new Computer("HP", processor, gpu, 16, 1024, os, battery);

        laptop.turnOn();
        laptop.installSoftware("Eclipse IDE");
        laptop.installSoftware("Spotify");
        laptop.viewSystemSummary();
        laptop.browseInternet("https://www.linkedin.com");

        laptop.upgradeRam(8);
        laptop.uninstallSoftware("Spotify");
        laptop.changeOperatingSystem(new OperatingSystem("Linux", "Fedora 39"));
        laptop.formatComputer();
        laptop.viewSystemSummary();

        // Polymorphic Task Execution
        Task scan = new VirusScanTask();
        Task backup = new BackupTask();

        scan.start();
        backup.start();
    }
}
