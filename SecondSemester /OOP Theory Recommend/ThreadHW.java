class EvenThread extends Thread {
    int[] evens = new int[2000];

    public void run() {
        int num = 0;
        for (int i = 1001; i < 2000; i++) {
            evens[i] = num;
            num += 2;
        }
    }

    public int[] getArray() {
        return evens;
    }
}

class OddThread extends Thread {
    int[] odds = new int[2000];

    public void run() {
        int num = 1;
        for (int i = 1001; i < 2000; i++) {
            odds[i] = num;
            num += 2;
        }
    }

    public int[] getArray() {
        return odds;
    }
}

public class ThreadHW {
    public static void main(String[] args) throws InterruptedException {
        OddThread t1 = new OddThread();
        EvenThread t2 = new EvenThread();

        t1.start();
        t2.start();

        t1.join(); // wait for thread 1 to finish
        t2.join(); // wait for thread 2 to finish

        // Print odd array first
        System.out.println("Odd Numbers:");
        for (int num : t1.getArray()) {
            System.out.print(num + " ");
        }

        // Print even array
        System.out.println("\nEven Numbers:");
        for (int num : t2.getArray()) {
            System.out.print(num + " ");
        }
    }
}