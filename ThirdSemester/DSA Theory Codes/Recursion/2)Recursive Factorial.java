public class FactorialRecursive {
    // Factorial with Recursion
    public int Factorial(int value){
        if(value == 0 || value == 1) {
            return 1; // base case
        }
        return value * Factorial(value - 1); // recursive call
    }

    // Main method for testing
    public static void main(String[] args) {
        FactorialRecursive obj = new FactorialRecursive();
        int result = obj.Factorial(5);
        System.out.println("Recursive Factorial of 5 = " + result);
    }
}
