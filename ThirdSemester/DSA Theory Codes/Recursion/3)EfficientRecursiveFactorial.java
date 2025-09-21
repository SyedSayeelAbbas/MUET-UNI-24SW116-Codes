public class FactorialEfficient {
    // More Efficient Method of Factorial by Recursion
    public int Factorial(int value){
        if(value <= 1) {
            return 1; // base case
        }
        return value * Factorial(value - 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        FactorialEfficient obj = new FactorialEfficient();
        int result = obj.Factorial(5);
        System.out.println("Efficient Recursive Factorial of 5 = " + result);
    }
}
