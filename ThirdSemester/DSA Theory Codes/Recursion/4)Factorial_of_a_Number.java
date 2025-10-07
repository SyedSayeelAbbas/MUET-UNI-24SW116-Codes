//Formula: n! = n × (n-1)!, and 0! = 1
public class Factorial {

    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1)
            return 1;

        // Recursive case
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }
}
