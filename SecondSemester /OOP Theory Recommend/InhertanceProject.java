package SirMoseenPrograms;

class Vehicle {
    private String model, brand;

    Vehicle(String m, String b) {
        this.model = m;
        this.brand = b;
    }

    public void start() {
        System.out.println("🚗 Vehicle starting...");
    }

    public void stop() {
        System.out.println("🛑 Vehicle stopping...");
    }

    public void displayInfo() {
        System.out.println("Model: " + model + "\nBrand: " + brand);
    }
}

class ElectricCar extends Vehicle {
    private int battery;

    ElectricCar(int b, String model, String brand) {
        super(model, brand);
        this.battery = b;
    }

    public void charge(int b) {
        if (battery + b > 100) {
            battery = 100;
        } else {
            battery += b;
        }
        System.out.println("🔋 Charging... Battery at " + battery + "%");
    }

    public void displayBatteryStatus() {
        System.out.println("Battery Status: " + battery + "%");
    }
}

public class InhertanceProject {
    public static void main(String[] args) {
        ElectricCar e1 = new ElectricCar(40, "Model S", "Tesla");
        e1.start();
        e1.displayInfo();
        e1.displayBatteryStatus();
        e1.charge(30);
        e1.displayBatteryStatus();
        e1.charge(50); // Will max out at 100%
        e1.displayBatteryStatus();
        e1.stop();
    }
}
