//Forward: 1 → n
//Backward: n → 1
public class PrintNumbers {

    public static void printForward(int n) {
        if (n == 0)
            return;
        printForward(n - 1); // Go down
        System.out.print(n + " "); // Print while returning
    }

    public static void printBackward(int n) {
        if (n == 0)
            return;
        System.out.print(n + " "); // Print first
        printBackward(n - 1); // Then go down
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print("Forward: ");
        printForward(n);
        System.out.println();
        System.out.print("Backward: ");
        printBackward(n);
    }
}
