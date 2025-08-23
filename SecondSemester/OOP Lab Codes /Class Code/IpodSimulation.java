package SirNaveenTask;

class Appliance {
    public void operate() {
        System.out.println("Appliance operating...");
    }
}

class Headphones {
    public void plugIn() {
        System.out.println("Headphones plugged in.");
    }
}

class Battery {
    private int level = 100;

    public synchronized int getLevel() {
        return level;
    }

    public synchronized void drain(int amount) {
        level = Math.max(0, level - amount);
    }

    public synchronized void charge(int amount) {
        level = Math.min(100, level + amount);
    }

    public synchronized boolean isLow() {
        return level <= 10;
    }
}

class Screen {
    public void display(String text) {
        System.out.println("[Screen] " + text);
    }
}

class Speaker {
    public void playSound(String song) {
        System.out.println("♪ Playing: " + song);
    }
}

class MusicPlayer extends Appliance {
    protected String[] playlist = {"Song A", "Song B", "Song C"};
    protected int currentSong = 0;
    protected boolean isPlaying = false;

    public void play() {
        isPlaying = true;
        System.out.println("Music started.");
    }

    public void pause() {
        isPlaying = false;
        System.out.println("Music paused.");
    }

    public String getCurrentSong() {
        return playlist[currentSong];
    }

    public void nextSong() {
        currentSong = (currentSong + 1) % playlist.length;
        System.out.println("Switched to: " + getCurrentSong());
    }

    @Override
    public void operate() {
        play();
    }
}

class IPod extends MusicPlayer {
    private Battery battery = new Battery();
    private Screen screen = new Screen();
    private Speaker speaker = new Speaker();
    private Headphones headphones = new Headphones();

    private boolean running = true;

    public void start() {
        headphones.plugIn();

        Thread playerThread = new Thread(() -> {
            while (running) {
                synchronized (this) {
                    if (isPlaying && battery.getLevel() > 0) {
                        speaker.playSound(getCurrentSong());
                        battery.drain(5);
                        try { Thread.sleep(2000); }
                        catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (battery.getLevel() == 0) {
                        screen.display("Battery dead. Pausing music.");
                        isPlaying = false;
                    }
                }
            }
        });

        Thread batteryMonitor = new Thread(() -> {
            while (running) {
                int level = battery.getLevel();
                if (battery.isLow()) {
                    screen.display("Battery low: " + level + "%");
                }
                try { Thread.sleep(3000); } catch (InterruptedException e) {}
            }
        });

        playerThread.start();
        batteryMonitor.start();

        menu();
        running = false;
    }

    private void menu() {
        String[] options = {
                "1. Play", "2. Pause", "3. Next Song", "4. Show Battery", "5. Charge", "6. Exit"
        };

        while (running) {
            for (String option : options) System.out.println(option);

            int choice = getUserInput();

            switch (choice) {
                case 1: operate(); break;
                case 2: pause(); break;
                case 3: nextSong(); break;
                case 4: System.out.println("Battery: " + battery.getLevel() + "%"); break;
                case 5: battery.charge(20); System.out.println("Charged 20%."); break;
                case 6: System.out.println("Shutting down..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private int getUserInput() {
        try {
            byte[] input = new byte[10];
            System.in.read(input);
            return input[0] - '0';
        } catch (Exception e) {
            return -1;
        }
    }
}

public class IpodSimulation {
    public static void main(String[] args) {
        IPod ipod = new IPod();
        ipod.start();
    }
}

