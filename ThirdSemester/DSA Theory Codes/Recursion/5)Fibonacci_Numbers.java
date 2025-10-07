//Formula: F(n) = F(n-1) + F(n-2) with F(0)=0, F(1)=1
public class Fibonacci {

    public static int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fibonacci series up to " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
