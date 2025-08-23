class ThreadingPractice1 extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("Inside ThreadPractice1 Class i="+i);
            if(i%2!=0){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("The Thread is Interrupted");
                }
            }
        }
    }
}
class ThreadingPractice2 extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("Inside ThreadPractice2 Class i="+i);
            if(i%2==0){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("The Thread is Interrupted");
                }
            }
        }
    }
}
public class ThreadingPracticeMain {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();                     // Gets the main thread
        System.out.println(t.getClass());                      // Prints the class of the main thread (likely java.lang.Thread)
        System.out.println(t.getName());                       // Prints "main"

        ThreadingPractice1 t1 = new ThreadingPractice1();      // Create thread t1
        ThreadingPractice2 t2 = new ThreadingPractice2();      // Create thread t2
        try {
            t1.start();    // Start thread t1
            t1.join();     // Wait for t1 to finish before continuing
            t2.start();    // Start thread t2
            t2.join();     // Wait for t2 to finish
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

