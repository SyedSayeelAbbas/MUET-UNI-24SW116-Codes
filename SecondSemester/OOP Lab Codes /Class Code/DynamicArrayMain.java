package SirNaveenTask;

public class DynamicArrayMain {
    public static void main(String[] args) {
        DynamicArray a1=new DynamicArray(2);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        a1.display();
        a1.delete(2);
        a1.display();
    }
}