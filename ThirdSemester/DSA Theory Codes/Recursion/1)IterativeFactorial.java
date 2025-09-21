public class FactorialIterative {
    // Factorial Without Recursion (Iterative)
    public int Factorial(int value){
        int answer = 1;
        for(int i = value; i > 0; i--){
            answer *= i;
        }
        return answer;
    }

    // Main method for testing
    public static void main(String[] args) {
        FactorialIterative obj = new FactorialIterative();
        int result = obj.Factorial(5);
        System.out.println("Iterative Factorial of 5 = " + result);
    }
}
