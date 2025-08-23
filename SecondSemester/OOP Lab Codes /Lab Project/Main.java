// package SirNaveenTask.FinalProject;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

abstract class Appliance
{
    private boolean isOn;

    public void turnOn() {
        isOn = true;
        log("Appliance turned ON");
    }

    public void turnOff() {
        isOn = false;
        log("Appliance turned OFF");
    }

    public boolean isOn() {
        return isOn;
    }

    public abstract void operate();

    public synchronized void log(String message)
    {
        String logMessage = "[" + LocalDateTime.now() + "] " + message;
        System.out.println("[LOG]: " + logMessage);
        try (FileWriter fw = new FileWriter("appliance_log.txt", true))
        {
            fw.write(logMessage + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }

}

class DetergentDispenser {
    public void releaseDetergent() {
        System.out.println("Detergent is being released...");
    }
}

class Motor {
    public void start() {
        System.out.println("Motor started.");
    }

    public void stop() {
        System.out.println("Motor stopped.");
    }

}

class SprayArm {
    public void rotate() {
    System.out.println("Spray arms are rotating to clean dishes.");
    }
}

class WaterHeater {
    private int temperature;

    public void heatWater(int temp) {
        this.temperature = temp;
        System.out.println("Water is heating to " + temperature + "°C...");
    }

    public int getTemperature() {
        return temperature;
    }

}

class Dishwasher extends Appliance {
    private Motor motor;
    private SprayArm sprayArm;
    private WaterHeater heater;
    private DetergentDispenser dispenser;
    private String mode;

    public Dishwasher() {
        this.motor = new Motor();
        this.sprayArm = new SprayArm();
        this.heater = new WaterHeater();
        this.dispenser = new DetergentDispenser();
        this.mode = "Normal";
    }

    @Override
    public synchronized void operate() {
        if (!isOn()) {
            System.out.println("Dishwasher is OFF. Please turn it on first.");
            return;
        }
        log("Starting wash cycle in mode: " + mode);
        dispenser.releaseDetergent();
        heater.heatWater(60);
        motor.start();
        sprayArm.rotate();
        motor.stop();
        log("Wash cycle completed.");
    }

    public synchronized void rinseDishes() {
        if (!isOn()) {
            System.out.println("Dishwasher is OFF. Please turn it on first.");
            return;
        }
        log("Rinsing dishes with clean water...");
        System.out.println("Rinsing dishes with clean water...");
    }

    public synchronized void dryDishes() {
        if (!isOn()) {
            System.out.println("Dishwasher is OFF. Please turn it on first.");
            return;
        }
        log("Drying dishes using heat...");
        System.out.println("Drying dishes using heat... Done.");
    }

    public void setWaterTemperature(int temp) {
        heater.heatWater(temp);
        log("Water temperature set to " + temp + "°C");
    }

    public int getWaterTemperature() {
        return heater.getTemperature();
    }

    public void setMode(String mode) {
        this.mode = mode;
        log("Dishwasher mode set to: " + mode);
    }

    public String getMode() {
        return this.mode;
    }

}

class WashCycleThread extends Thread {
    private Dishwasher dishwasher;

    public WashCycleThread(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void run() {
        dishwasher.operate();
    }

}

class StatusMonitorThread extends Thread {
    private Dishwasher dishwasher;

    public StatusMonitorThread(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("[Monitor] Dishwasher is " + (dishwasher.isOn() ? "ON" : "OFF"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Status Monitor interrupted.");
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {

        Dishwasher myDishwasher = new Dishwasher();
        myDishwasher.turnOn();
        myDishwasher.setMode("Intensive");
        myDishwasher.setWaterTemperature(70);

        Thread washThread = new WashCycleThread(myDishwasher);
        Thread monitorThread = new StatusMonitorThread(myDishwasher);

        washThread.start();
        monitorThread.start();

        try {
            washThread.join();
            monitorThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        myDishwasher.rinseDishes();
        myDishwasher.dryDishes();
        myDishwasher.turnOff();
    }

}
