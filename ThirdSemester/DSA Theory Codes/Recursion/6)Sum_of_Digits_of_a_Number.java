//Example: sum(1234) = 1 + 2 + 3 + 4 = 10
public class SumOfDigits {

    public static int sumDigits(int n) {
        // Base case
        if (n == 0)
            return 0;

        // Recursive case
        return (n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println("Sum of digits of " + n + " = " + sumDigits(n));
    }
}
