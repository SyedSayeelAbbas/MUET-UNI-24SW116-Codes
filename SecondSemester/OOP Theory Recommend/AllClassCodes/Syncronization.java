class CapitalCity{
    synchronized public void display(){
        System.out.println("Capital of Pakistan:");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Islamabad");
        System.out.println("Capital Of Iran is :");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Tehran");
    }
}
class MyThread extends Thread{
    CapitalCity cc;
    public void setValue(CapitalCity cc){
        this.cc=cc;
    }
    public void run()
    {
        cc.display();
    }
}

public class Syncronization {
    public static void main(String[] args) {
        CapitalCity cc = new CapitalCity();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

            t1.setValue(cc);
            t2.setValue(cc);
            t1.start();
            t2.start();

    }
}
