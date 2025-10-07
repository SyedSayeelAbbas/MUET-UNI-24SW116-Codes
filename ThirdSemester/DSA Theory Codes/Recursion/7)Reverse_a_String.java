//Example: "hello" → "olleh"
public class ReverseString {

    public static String reverse(String str) {
        // Base case
        if (str.isEmpty())
            return str;

        // Recursive case
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Reversed string: " + reverse(str));
    }
}
