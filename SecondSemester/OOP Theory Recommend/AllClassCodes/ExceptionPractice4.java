// Custom exception class
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message); // Pass the message to the superclass (RuntimeException)
    }
}

// Main class to test the custom exception
public class ExceptionPractice4 {
    public static void main(String[] args) {
        int age = 10;
        if (age < 11) {
            throw new InvalidAgeException("Age is too low! What's up?");
        }

        System.out.println("Age is valid.");
    }
}
