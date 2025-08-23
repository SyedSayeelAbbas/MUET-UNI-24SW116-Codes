public class PcMain {
    public static void main(String[] args) {
        PC p1=new PC("dell",16,228);
        PC p2=new PC("Hp",8,128);
        PC p3=new PC("Lenovo",32,512);

        Keyboard k1=new Keyboard("Dell");
        Keyboard k2=new Keyboard("Hp");
        Keyboard k3=new Keyboard("Lenovo");

        p1.addKey(k1);
        System.out.println(p1);
        p1.change(k2);
        System.out.println(p1);
    }
}
